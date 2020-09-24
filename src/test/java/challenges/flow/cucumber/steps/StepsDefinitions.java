package challenges.flow.cucumber.steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import challenges.flow.EmailApp;
import challenges.flow.adapters.EmailAdapter;
import challenges.flow.agents.UserAgent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import flow.Engine;
import flow.IAdapter;
import flow.IAgent;

public class StepsDefinitions {

	private IAgent user;
	private EmailApp app = new EmailApp();
	
	@Given("^A User sends an \"([^\"]*)\" message$")
	public void a_User_sends_an_message(String message) throws Throwable {
		user = new UserAgent(Arrays.asList(message));
	}

	@When("^The message is converted by the Adapter$")
	public void the_message_is_converted_by_the_Adapter() throws Throwable {
		Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
	    adapters.put("EMAIL", new EmailAdapter());
	    
	    Engine engine = new Engine(user, adapters, app);
	    engine.run();
	}

	@Then("^The Message server should contain the \"([^\"]*)\" message in the queue$")
	public void the_Message_server_should_contain_the_message_in_the_queue(String message) throws Throwable {
	    Assert.assertEquals(message, app.popMessage());
	}
}
