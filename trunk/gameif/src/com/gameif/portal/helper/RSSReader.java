package com.gameif.portal.helper;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSReader {
	
    private final static Log logger = LogFactory.getLog(RSSReader.class);
	
	private int newsSize;
	private int cacheTime;
	private List<String> rssUrls;

	private long lastDate;
	private List<RSSNews> rssNews;

	public List<RSSNews> getRssByCache() {
		
		if (rssNews == null || lastDate == 0 || System.currentTimeMillis() > lastDate + cacheTime) {
			
			try {

				rssNews = getRss();
				
			} catch (Exception ex) {
				
				logger.error(ex.getMessage(), ex);
			}
		}
		
		return rssNews;
	}
	
	public List<RSSNews> getRss() throws Exception {
		
		List<RSSNews> newsList = new ArrayList<RSSNews>();
		
		for (String url : rssUrls) {
			
			newsList.addAll(getNewsList(url));
		}
		
		Collections.sort(newsList);
		
		newsList = newsList.subList(0, newsList.size() > newsSize ? newsSize : newsList.size());
		
		return newsList;
    }
	
	@SuppressWarnings("unchecked")
	private List<RSSNews> getNewsList(String rssUrl) throws Exception {
		
		List<RSSNews> newsList = new ArrayList<RSSNews>();
			
		URL url = new URL(rssUrl);
		
		XmlReader reader = new XmlReader(url);
		
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(reader);
		   
		List<SyndEntry> entries = feed.getEntries();
		
		for (SyndEntry entry : entries) {

			RSSNews rssNews = new RSSNews();
			
			rssNews.setTitle(entry.getTitle());
			rssNews.setLink(entry.getLink());
			rssNews.setCreateDate(entry.getPublishedDate());
			
			newsList.add(rssNews);
        }
		
		return newsList;
	}

	public int getNewsSize() {
		return newsSize;
	}

	public void setNewsSize(int newsSize) {
		this.newsSize = newsSize;
	}

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}

	public List<String> getRssUrls() {
		return rssUrls;
	}

	public void setRssUrls(List<String> rssUrls) {
		this.rssUrls = rssUrls;
	}
}
