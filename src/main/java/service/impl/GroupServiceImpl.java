package service.impl;

import java.util.List;

import org.joda.time.DateTime;

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

    @Override
    public Boolean insertNewGroup(Group group) {
        return dao.insertNewGroup(group, new DateTime());
    }

}
