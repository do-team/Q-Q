package dao;

import java.util.List;

import model.Message;

/**
 * @author salamar
 *
 */
public interface MessageDAO {

	List<Message> listAllMessages(Integer groupId);
}
