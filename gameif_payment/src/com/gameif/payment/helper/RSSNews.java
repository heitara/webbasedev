package com.gameif.payment.helper;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RSSNews implements Comparable<RSSNews> {
	
	private String title;
	private String link;
	private Date createDate;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getCreateDateStr() {
		
		String dateStr = null;
		
		if (createDate != null) {
			
			dateStr = new SimpleDateFormat("yyyy-MM-dd").format(createDate);
			
		} else {
			
			dateStr = "";
		}
		
		return dateStr;
	}
	
	@Override
	public int compareTo(RSSNews o) {

		int result = 0;
		
		if (this.createDate != null && o != null && o.getCreateDate() != null) {

			if (this.createDate.before(o.getCreateDate())) {
				
				result = 1;
				
			} else if (this.createDate.before(o.getCreateDate())) {

				result = -1;
			}
		}
		
		return result;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}