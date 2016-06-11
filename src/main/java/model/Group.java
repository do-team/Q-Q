package model;

import org.joda.time.DateTime;

public class Group {
	Integer groupId;
	String name;
	String description;
	Integer status;
	DateTime insertTimeStamp;

	@SuppressWarnings("unused")
	private Group() {
	}

	public Group(Integer groupId, String name, String description, Integer status, DateTime insertTimeStamp) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.insertTimeStamp = insertTimeStamp;
	}

	public Group(String name, String description, Integer status) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public DateTime getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(DateTime insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}
}
