package com.gameif.common.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SimpleMailer {
	
	private final static Log logger = LogFactory.getLog(SimpleMailer.class);
	
	private JavaMailSender sender;
	private JavaMailSender juniorSender;
	private TaskExecutor taskExecutor;

	private String from;

	/**
	 * TEXTメールを即時に送信する。
	 * @param to 送信先アドレス
	 * @param from 送信者アドレス（NULLで省略した場合は、デフォルト設定を使う。）
	 * @param title メールタイトル
	 * @param content メール本文
	 * @param juniorFlg ジュニアメールサーバ判定(true:ジュニアサーバで送信(友達紹介送信用)、false:主なサーバで送信)
	 */
	public void sendMail(String to, String from, String title, String content, Boolean juniorFlg) {
		
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo(to);
		msg.setFrom(from == null ? this.from : from);
		msg.setSubject(title);
		msg.setText(content);
		
		if (juniorFlg) {
			juniorSender.send(msg);
		} else {
			sender.send(msg);
		}
	}

	/**
	 * TEXTメールを非同期で送信する。
	 * @param to 送信先アドレス
	 * @param from 送信者アドレス
	 * @param title メールタイトル
	 * @param content メール本文
	 * @param juniorFlg ジュニアメールサーバ判定(true:ジュニアサーバで送信(友達紹介送信用)、false:主なサーバで送信)
	 */
	public void sendAsyncMail(final String to, final String from, final String title, final String content, final Boolean juniorFlg) {
		
		taskExecutor.execute(new Runnable() {
			
			public void run() {
				
				try {
					
					sendMail(to, from, title, content, juniorFlg);
					
				} catch (Exception ex) {
					
					StringBuffer msgBuff = new StringBuffer();
					
					msgBuff.append("sendMail failed for {to='");
					msgBuff.append(to);
					msgBuff.append("', from='");
					msgBuff.append(from);
					msgBuff.append("', title='");
					msgBuff.append(title);
					msgBuff.append("'}.");
					
					logger.error(msgBuff, ex);
				}
			}
		});
	}

	public void setFrom(String from) {
		
		this.from = from;
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

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		
		this.taskExecutor = taskExecutor;
	}
}
