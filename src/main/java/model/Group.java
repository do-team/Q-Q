package model;

import org.joda.time.DateTime;

public class Group implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 695845765639030411L;

    Integer groupId;
	String name;
	String description;
    Status status;
	DateTime insertTimeStamp;

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
	private Group() {
	}

	public Group(Integer groupId) {
		this.groupId = groupId;
	}

    public Group(Integer groupId, String name, String description, Status status, DateTime insertTimeStamp) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.insertTimeStamp = insertTimeStamp;
	}

    public Group(String name, String description, Status status) {
		this.name = name;
		this.description = description;
		this.status = status;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public Status getStatus() {
		return status;
	}

    public void setStatus(Status status) {
		this.status = status;
	}

	public DateTime getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(DateTime insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}
}
