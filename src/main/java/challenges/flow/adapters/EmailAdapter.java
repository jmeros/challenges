package challenges.flow.adapters;

import challenges.flow.actions.EmailAction;
import challenges.flow.events.MessageEvent;
import flow.ActionException;
import flow.AdapterException;
import flow.IAdapter;
import flow.IEvent;

public class EmailAdapter implements IAdapter<EmailAction> {

	@Override
	public IEvent<String> adapt(EmailAction action) throws AdapterException, ActionException {
		String value = action.execute();
		return new MessageEvent(value);
	}

}
