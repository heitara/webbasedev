package com.gameif.portal.action.mixi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gameif.portal.businesslogic.IMemberInfoForMixiBusinessLogic;
import com.gameif.portal.entity.MemberInfoForMixi;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.util.ContextUtil;

public class MixiControlAction {

	private String memId;
	private Long memNum;
	private MemberInfoForMixi member;
	private String serverHtml;

	private IMemberInfoForMixiBusinessLogic memberInfoForMixiBusinessLogic;
	private final static Log logger = LogFactory.getLog(MixiControlAction.class);
	
	private final static String CERTIFICATE = "-----BEGIN CERTIFICATE-----\n"
		+ "MIICdzCCAeCgAwIBAgIJAOi/chE0MhufMA0GCSqGSIb3DQEBBQUAMDIxCzAJBgNV\n"
		+ "BAYTAkpQMREwDwYDVQQKEwhtaXhpIEluYzEQMA4GA1UEAxMHbWl4aS5qcDAeFw0w\n"
		+ "OTA0MjgwNzAyMTVaFw0xMDA0MjgwNzAyMTVaMDIxCzAJBgNVBAYTAkpQMREwDwYD\n"
		+ "VQQKEwhtaXhpIEluYzEQMA4GA1UEAxMHbWl4aS5qcDCBnzANBgkqhkiG9w0BAQEF\n"
		+ "AAOBjQAwgYkCgYEAwEj53VlQcv1WHvfWlTP+T1lXUg91W+bgJSuHAD89PdVf9Ujn\n"
		+ "i92EkbjqaLDzA43+U5ULlK/05jROnGwFBVdISxULgevSpiTfgbfCcKbRW7hXrTSm\n"
		+ "jFREp7YOvflT3rr7qqNvjm+3XE157zcU33SXMIGvX1uQH/Y4fNpEE1pmX+UCAwEA\n"
		+ "AaOBlDCBkTAdBgNVHQ4EFgQUn2ewbtnBTjv6CpeT37jrBNF/h6gwYgYDVR0jBFsw\n"
		+ "WYAUn2ewbtnBTjv6CpeT37jrBNF/h6ihNqQ0MDIxCzAJBgNVBAYTAkpQMREwDwYD\n"
		+ "VQQKEwhtaXhpIEluYzEQMA4GA1UEAxMHbWl4aS5qcIIJAOi/chE0MhufMAwGA1Ud\n"
		+ "EwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEAR7v8eaCaiB5xFVf9k9jOYPjCSQIJ\n"
		+ "58nLY869OeNXWWIQ17Tkprcf8ipxsoHj0Z7hJl/nVkSWgGj/bJLTVT9DrcEd6gLa\n"
		+ "H5TbGftATZCAJ8QJa3X2omCdB29qqyjz4F6QyTi930qekawPBLlWXuiP3oRNbiow\n"
		+ "nOLWEi16qH9WuBs=\n" + "-----END CERTIFICATE-----"; 
	
	public String authCertificate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		return "success";
	}
	
	public void selectServerList() {
		List<ServerMst> servers = memberInfoForMixiBusinessLogic.getServersListForMixi(1);
		StringBuilder html = new StringBuilder().append("<dl class='light_box tspace_n'>")
							.append("<dt></dt>")
							.append("<dd>")
							.append("<table class='games'>");
		
		for (int i=0; i<servers.size(); i++) {
			html.append("<tr>")
				.append("<td class='sidecell'>")
				.append("<a href='playGame.html?serverId=")
				.append(servers.get(i).getServerId())
				.append("&titleId=1' title='ゲームプレイ！'><img src='images/btn_c_play.gif' alt='ゲームプレイ'/></a>")
				.append("</td>")
				.append("</tr>");
		}
		html.append("</table>")
		.append("</dd>")
		.append("</dl>");
		
		serverHtml = html.toString();
		HttpServletResponse response = ServletActionContext.getResponse();  
		try {     
	        response.setCharacterEncoding("UTF-8"); 
	        response.getWriter().write(serverHtml);
		}
		catch (Exception ex) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + ex.getMessage());	
		}

	}

	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId
	 *            the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the member
	 */
	public MemberInfoForMixi getMember() {
		return member;
	}

	/**
	 * @param member
	 *            the member to set
	 */
	public void setMember(MemberInfoForMixi member) {
		this.member = member;
	}

	/**
	 * @return the serverHtml
	 */
	public String getServerHtml() {
		return serverHtml;
	}

	/**
	 * @param serverHtml the serverHtml to set
	 */
	public void setServerHtml(String serverHtml) {
		this.serverHtml = serverHtml;
	}

	/**
	 * @return the memberInfoForMixiBusinessLogic
	 */
	public IMemberInfoForMixiBusinessLogic getMemberInfoForMixiBusinessLogic() {
		return memberInfoForMixiBusinessLogic;
	}

	/**
	 * @param memberInfoForMixiBusinessLogic the memberInfoForMixiBusinessLogic to set
	 */
	public void setMemberInfoForMixiBusinessLogic(
			IMemberInfoForMixiBusinessLogic memberInfoForMixiBusinessLogic) {
		this.memberInfoForMixiBusinessLogic = memberInfoForMixiBusinessLogic;
	}

}
