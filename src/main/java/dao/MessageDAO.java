package dao;

import java.util.List;

import org.joda.time.DateTime;

import model.Message;

/**
 * @author salamar
 *
 */
public interface MessageDAO {

	List<Message> listAllMessages(Integer groupId);

    public Boolean insertNewMessage(Message message, DateTime now);
}
