package service;

import java.util.List;

import model.Message;

public interface MessageService {

	List<Message> listAllMessages();

	List<Message> listAllMessages(Integer groupId);
}
