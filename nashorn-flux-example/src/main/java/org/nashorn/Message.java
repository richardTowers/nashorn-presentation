package org.nashornExample;

public class Message
{
	public String id;
	public String threadID;
	public String threadName;
	public String authorName;
	public String text;
	public String timestamp;

	public Message (String id, String threadID, String threadName, String authorName, String text, String timestamp) {
		this.id         = id;
		this.threadID   = threadID;
		this.threadName = threadName;
		this.authorName = authorName;
		this.text       = text;
		this.timestamp  = timestamp;
	}

}