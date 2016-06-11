package service.impl;

import java.util.List;

import dao.GroupDAO;
import model.Group;
import service.GroupService;

public class GroupServiceImpl implements GroupService {

	private GroupDAO dao;

	public GroupServiceImpl(GroupDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Group> listAllGroups() {
		return dao.listAllGroups();
	}

}
