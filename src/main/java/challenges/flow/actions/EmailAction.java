package challenges.flow.actions;

import flow.ActionException;
import flow.IAction;

public class EmailAction implements IAction<String> {
	private static final String EMAIL_TYPE = "EMAIL";
	
	private String value;

	public EmailAction(String value) {
		this.value = value;
	}
	
	@Override
	public String execute() throws ActionException {
		return this.value;
	}

	@Override
	public String getType() {
		return EMAIL_TYPE;
	}

}
