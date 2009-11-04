package com.gameif.common.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gameif.common.exception.SystemException;

import freemarker.template.Template;

public class TemplateMailer {
	
	private final static Log logger = LogFactory.getLog(TemplateMailer.class);
	
	private JavaMailSender sender;
	private JavaMailSender juniorSender;
	private FreeMarkerConfigurer freeMarkerConfigurer = null;
	private TaskExecutor taskExecutor;
	
	private String from;
	private String replyTo;
	private String encoding;
	private Map<String, Map<String, String>> templates;

	/**
	 * TEXTメールを即時に送信する。
	 * @param to　送信先アドレス
	 * @param templateKey　メールテンプレートキー
	 * @param props　送信先アドレスとメール送信時テンプレートの変数を書き換える変数Map
	 * @param juniorFlg ジュニアメールサーバ判定(true:ジュニアサーバで送信(友達紹介送信用)、false:主なサーバで送信)<br/>
	 * <blockquote><strong>propsに設定する項目：</strong><br/>
	 * <ul>
	 * 	<li>KEY="memNum",VALUE=[会員番号]（任意、テンプレートによる）</li>
	 * 	<li>KEY="memId",VALUE=[アカウントＩＤ]（任意、テンプレートによる）</li>
	 * 	<li>KEY="nickName",VALUE=[ニックネーム]（任意、テンプレートによる）</li>
	 * 	<li>KEY="serialCd",VALUE=[シリアルコード]（任意、テンプレートによる）</li>
	 * 	<li>KEY="title",VALUE=[ゲームタイトル名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="server",VALUE=[サーバ名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="item",VALUE=[アイテム名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="point",VALUE=[購入ポイント数]（任意、テンプレートによる）</li>
	 * 	<li>その他（必要に応じて追加）</li>
	 * <ul></blockquote>
	 */
	public void sendTextMail(String to, String templateKey, Map<String, String> props, Boolean juniorFlg) {
				
		try {
		
			SimpleMailMessage msg = new SimpleMailMessage();

			if (props == null) props = new HashMap<String, String>();

			msg.setTo(to);
			msg.setFrom(from);
			msg.setReplyTo(replyTo);
			
			getMailText(templateKey, props);
					
			msg.setSubject(getMailTitle(templateKey));
			msg.setText(getMailText(templateKey, props));
			
			if (juniorFlg) {
				juniorSender.send(msg);
			} else {
				sender.send(msg);
			}
			
		} catch (Exception ex) {
			
			logger.error(getErroMsg(templateKey, props), ex);
		}
	}

	/**
	 * HTMLメールを即時に送信する。
	 * @param to　送信先アドレス
	 * @param templateKey　メールテンプレートキー
	 * @param props　送信先アドレスとメール送信時テンプレートの変数を書き換える変数Map
	 * @param juniorFlg ジュニアメールサーバ判定(true:ジュニアサーバで送信(友達紹介送信用)、false:主なサーバで送信)<br/>
	 * <blockquote><strong>propsに設定する項目：</strong><br/>
	 * <ul>
	 * 	<li>KEY="memNum",VALUE=[会員番号]（任意、テンプレートによる）</li>
	 * 	<li>KEY="memId",VALUE=[アカウントＩＤ]（任意、テンプレートによる）</li>
	 * 	<li>KEY="nickName",VALUE=[ニックネーム]（任意、テンプレートによる）</li>
	 * 	<li>KEY="serialCd",VALUE=[シリアルコード]（任意、テンプレートによる）</li>
	 * 	<li>KEY="title",VALUE=[ゲームタイトル名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="server",VALUE=[サーバ名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="item",VALUE=[アイテム名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="point",VALUE=[購入ポイント数]（任意、テンプレートによる）</li>
	 * 	<li>その他（必要に応じて追加）</li>
	 * <ul></blockquote>
	 */
	public void sendHtmlMail(String to, String templateKey, Map<String, String> props, Boolean juniorFlg) {
				
		try {

			MimeMessage msg = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, false, encoding);

			if (props == null) props = new HashMap<String, String>();
			
			helper.setFrom(from);
			helper.setReplyTo(replyTo);
			helper.setTo(to);
			
			helper.setSubject(getMailTitle(templateKey));
			helper.setText(getMailText(templateKey, props), true);
			
			if (juniorFlg) {
				juniorSender.send(msg);
			} else {
				sender.send(msg);
			}
			
		} catch (Exception ex) {
			
			logger.error(getErroMsg(templateKey, props), ex);
		}
	}
	
	/**
	 * メールを即時に送信する。
	 * @param to　送信先アドレス
	 * @param templateKey　メールテンプレートキー
	 * @param props　送信先アドレスとメール送信時テンプレートの変数を書き換える変数Map
	 * @param juniorFlg ジュニアメールサーバ判定(true:ジュニアサーバで送信(友達紹介送信用)、false:主なサーバで送信)<br/>
	 * <blockquote><strong>propsに設定する項目：</strong><br/>
	 * <ul>
	 * 	<li>KEY="memNum",VALUE=[会員番号]（任意、テンプレートによる）</li>
	 * 	<li>KEY="memId",VALUE=[アカウントＩＤ]（任意、テンプレートによる）</li>
	 * 	<li>KEY="nickName",VALUE=[ニックネーム]（任意、テンプレートによる）</li>
	 * 	<li>KEY="serialCd",VALUE=[シリアルコード]（任意、テンプレートによる）</li>
	 * 	<li>KEY="title",VALUE=[ゲームタイトル名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="server",VALUE=[サーバ名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="item",VALUE=[アイテム名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="point",VALUE=[購入ポイント数]（任意、テンプレートによる）</li>
	 * 	<li>その他（必要に応じて追加）</li>
	 * <ul></blockquote>
	 */
	public void sendMail(String to, String templateKey, Map<String, String> props, Boolean juniorFlg) {
		
		try {

			if (isHtmlMail(templateKey)) {
				
				sendHtmlMail(to, templateKey, props, juniorFlg);
				
			} else {
				
				sendTextMail(to, templateKey, props, juniorFlg);
			}
			
		} catch (Exception ex) {
			
			logger.error(getErroMsg(templateKey, props), ex);
		}
	}
	
	/**
	 * 非同期でメールを送信する(デフォルトに主なサーバで送信)。
	 * @param to　送信先アドレス
	 * @param templateKey　メールテンプレートキー
	 * @param props　送信先アドレスとメール送信時テンプレートの変数を書き換える変数Map<br/>
	 * <blockquote><strong>propsに設定する項目：</strong><br/>
	 * <ul>
	 * 	<li>KEY="memNum",VALUE=[会員番号]（任意、テンプレートによる）</li>
	 * 	<li>KEY="memId",VALUE=[アカウントＩＤ]（任意、テンプレートによる）</li>
	 * 	<li>KEY="nickName",VALUE=[ニックネーム]（任意、テンプレートによる）</li>
	 * 	<li>KEY="serialCd",VALUE=[シリアルコード]（任意、テンプレートによる）</li>
	 * 	<li>KEY="title",VALUE=[ゲームタイトル名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="server",VALUE=[サーバ名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="item",VALUE=[アイテム名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="point",VALUE=[購入ポイント数]（任意、テンプレートによる）</li>
	 * 	<li>その他（必要に応じて追加）</li>
	 * <ul></blockquote>
	 */
	public void sendAsyncMail(final String to, final String templateKey, final Map<String, String> props) {
		
		sendAsyncMail(to, templateKey, props, false);
	}
	
	/**
	 * 非同期でメールを送信する。
	 * @param to　送信先アドレス
	 * @param templateKey　メールテンプレートキー
	 * @param props　送信先アドレスとメール送信時テンプレートの変数を書き換える変数Map<br/>
	 * @param juniorFlg ジュニアメールサーバ判定(true:ジュニアサーバで送信(友達紹介送信用)、false:主なサーバで送信)
	 * <blockquote><strong>propsに設定する項目：</strong><br/>
	 * <ul>
	 * 	<li>KEY="memNum",VALUE=[会員番号]（任意、テンプレートによる）</li>
	 * 	<li>KEY="memId",VALUE=[アカウントＩＤ]（任意、テンプレートによる）</li>
	 * 	<li>KEY="nickName",VALUE=[ニックネーム]（任意、テンプレートによる）</li>
	 * 	<li>KEY="serialCd",VALUE=[シリアルコード]（任意、テンプレートによる）</li>
	 * 	<li>KEY="title",VALUE=[ゲームタイトル名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="server",VALUE=[サーバ名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="item",VALUE=[アイテム名]（任意、テンプレートによる）</li>
	 * 	<li>KEY="point",VALUE=[購入ポイント数]（任意、テンプレートによる）</li>
	 * 	<li>その他（必要に応じて追加）</li>
	 * <ul></blockquote>
	 */
	public void sendAsyncMail(final String to, final String templateKey, final Map<String, String> props, final Boolean juniorFlg) {
		
		taskExecutor.execute(new Runnable() {
			
			public void run() {
				
				try {
					
					sendMail(to, templateKey, props, juniorFlg);
					
				} catch (Exception ex) {
					
					logger.error(getErroMsg(templateKey, props), ex);
				}
			}
		});
	}
	
	private String getErroMsg(String templateKey, Map<String, String> props) {

		StringBuffer msgBuff = new StringBuffer();
		
		msgBuff.append("sendMail failed for {template=");
		msgBuff.append(templateKey);
		
		for (Entry<String, String> entry : props.entrySet()) {

			msgBuff.append(", ");
			msgBuff.append(entry.getKey());
			msgBuff.append("='");
			msgBuff.append(entry.getValue());
			msgBuff.append("'");
		}
		
		msgBuff.append("}.");
		
		return msgBuff.toString();
	}
		
	private String getMailTitle(String templateKey) {
		
		return templates.get(templateKey).get("title");		
	}
	
	private String getTemplateFileName(String templateKey) {
		
		return templates.get(templateKey).get("template");		
	}
	
	private String getMailText(String templateKey, Map<String, String> props) {
		
		String result = null;

		try {
			
			Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(getTemplateFileName(templateKey));
			result = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, props);
			
		} catch (Exception ex) {
			
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return result;
	}
	
	private String getMailFormat(String templateKey) {
		
		return templates.get(templateKey).get("format");		
	}
	
	private boolean isHtmlMail(String templateKey) {
		
		return "html".equalsIgnoreCase(getMailFormat(templateKey));
	}

	public void setSender(JavaMailSender sender) {
		
		this.sender = sender;
	}
	
	/**
	 * @param juniorSender the juniorSender to set
	 */
	public void setJuniorSender(JavaMailSender juniorSender) {
		this.juniorSender = juniorSender;
	}

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}
	
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		
		this.taskExecutor = taskExecutor;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setTemplates(Map<String, Map<String, String>> templets) {
		this.templates = templets;
	}
}
