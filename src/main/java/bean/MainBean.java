/**
 * 
 */
package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import model.Group;
import model.Message;
import service.GroupService;
import service.MessageService;

/**
 * @author HunterScorpio
 *
 */
public class MainBean implements java.io.Serializable {

	GroupService groupService;
	List<Group> groups;

	MessageService messageService;
	List<Message> messages;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3095593138292372749L;

	// TODO private static final Logger LOG =
	// LoggerFactory.getLogger(MainBean.class);

	public static final String MAIN_TITLE = "Main";
	public static final String GENERAL_TITLE_PREFIX = "Q-Q :: ";

	public MainBean() {

	}

	@PostConstruct
	public void init() {
	}

	public String getMainTitle() {
		return GENERAL_TITLE_PREFIX + MAIN_TITLE;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public List<Group> getGroups() {
		if (groups == null) {
			groups = new ArrayList<Group>();
		}
		groups = groupService.listAllGroups();
		return groups;
	}

	public List<Message> getMessages() {
		if (messages == null) {
			messages = new ArrayList<Message>();
		}
		messages = messageService.listAllMessages();
		return messages;
	}

}
