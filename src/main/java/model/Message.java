package model;

import org.joda.time.DateTime;

public class Message {
	Integer msgId;
	Integer parentMsgId;
	Group group;
	String content;
	Integer likesCnt;
	Integer status;
	DateTime insertTimestamp;

	@SuppressWarnings("unused")
	private Message() {
	}

	public Message(Integer msgId) {
		this.msgId = msgId;
	}

	public Message(Integer parentMsgId, Group group, String content, Integer likesCnt, Integer status) {
		this.parentMsgId = parentMsgId;
		this.group = group;
		this.content = content;
		this.likesCnt = likesCnt;
		this.status = status;
	}

	public Message(Integer msgId, Integer parentMsgId, Group group, String content, Integer likesCnt, Integer status,
			DateTime insertTimestamp) {
		super();
		this.msgId = msgId;
		this.parentMsgId = parentMsgId;
		this.group = group;
		this.content = content;
		this.likesCnt = likesCnt;
		this.status = status;
		this.insertTimestamp = insertTimestamp;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getParentMsgId() {
		return parentMsgId;
	}

	public void setParentMsgId(Integer parentMsgId) {
		this.parentMsgId = parentMsgId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikesCnt() {
		return likesCnt;
	}

	public void setLikesCnt(Integer likesCnt) {
		this.likesCnt = likesCnt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public DateTime getInsertTimestamp() {
		return insertTimestamp;
	}

	public void setInsertTimestamp(DateTime insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}
}
