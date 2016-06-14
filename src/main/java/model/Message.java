package model;

import org.joda.time.DateTime;

public class Message implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7093588172630963344L;

    Integer msgId;
	Integer parentMsgId;
	Group group;
	String content;
	Integer likesCnt;
    Status status;
	DateTime insertTimestamp;

    public enum Status {
        NEW("New", 0), CLOSED("Closed", 1);

        private String name;
        private int value;

        private Status(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public static Status getStatus(int value) {
            switch (value) {
            case 0:
                return NEW;
            case 1:
                return CLOSED;
            }
            return NEW;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

	@SuppressWarnings("unused")
	private Message() {
	}

	public Message(Integer msgId) {
		this.msgId = msgId;
	}

    public Message(Integer parentMsgId, Group group, String content, Integer likesCnt, Status status) {
		this.parentMsgId = parentMsgId;
		this.group = group;
		this.content = content;
		this.likesCnt = likesCnt;
		this.status = status;
	}

    public Message(Integer msgId, Integer parentMsgId, Group group, String content, Integer likesCnt, Status status,
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

    public Status getStatus() {
		return status;
	}

    public void setStatus(Status status) {
		this.status = status;
	}

	public DateTime getInsertTimestamp() {
		return insertTimestamp;
	}

	public void setInsertTimestamp(DateTime insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}
}
