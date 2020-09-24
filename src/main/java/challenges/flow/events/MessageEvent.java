package challenges.flow.events;

import flow.ActionException;
import flow.EventException;
import flow.IEvent;

public class MessageEvent implements IEvent<String> {
	private static final String MESSAGE_PREFIX = "MSG:";
	
	private String value;

	public MessageEvent(String value) {
		this.value = MESSAGE_PREFIX + value;
	}

	@Override
	public String trigger() throws EventException, ActionException {
		return this.value;
	}

}
