package challenges.flow.agents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import challenges.flow.actions.EmailAction;
import flow.AgentException;
import flow.IAction;
import flow.IAgent;

public class UserAgent implements IAgent {
	
	private List<String> messages;

	public UserAgent() {
		this(Arrays.asList("hello"));
	}
	
	public UserAgent(List<String> messages) {
		this.messages = new ArrayList<String>(messages);
	}

	@Override
	public List<IAction> act() throws AgentException {
		return this.messages.stream()
				.map(message -> new EmailAction(message))
				.collect(Collectors.toList());
	}

}
