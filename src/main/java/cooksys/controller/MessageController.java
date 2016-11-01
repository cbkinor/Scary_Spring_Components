package cooksys.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.DataTransferObject;
import cooksys.calmDown.HalfBakedIdea;
import cooksys.calmDown.Message;

@RestController
@RequestMapping("message")
public class MessageController {

	private Map<String, Set<String>> messages = new HashMap<>();
	Message message;
	HalfBakedIdea halfBaked;

	public MessageController(Message msg, HalfBakedIdea halfBaked) {
		message = msg;
		this.halfBaked = halfBaked;
	}

	@GetMapping
	public Message getMessage() {
		return message;
	}

	
	/**
	 * Use a Map<String, String> to accept any arbitrary JSON object as key-value pairs
	 * @param incoming
	 * @return
	 */
	@PostMapping
	public String postMessage(@RequestBody Map<String, String> incoming) {

		StringBuffer b = new StringBuffer();

		incoming.entrySet().forEach(
				
				entry -> b.append(entry.getKey() + " HAS A VALUE OF " + entry.getValue() + "\n")
				
				);

		return b.toString();
	}
	
	/**
	 * Use a POJO to cause Spring to marshal the incoming JSON as a particular object
	 * @param incoming
	 * @return
	 */
	@PutMapping
	public String putMessage(@RequestBody DataTransferObject incoming) {

		 System.out.println(incoming.getValue());
		 return incoming.getValue();
	}

	@GetMapping("count")
	public Integer getCharacterCount() {
		return message.getMessage().length();
	}
	
	@GetMapping("/user/{username}")
	public Set<String> getMessages(@PathVariable String username ) {
		return messages.get(username);
	}
	
	@PutMapping("/user/{username}")
	public String UserData(@RequestBody Map<String, String> username) {
		messages.containsKey(username);
		Set<String> multipleMessages = new HashSet<>();
		multipleMessages.put(username, messages);
	}
	
	

	/**
	 * Add a new method here! This method will cause postman to respond with the
	 * total number of actions taken by the system (see @HalfBakedIdea) when a
	 * GET request is sent to "http://localhost:8080/message/actions"
	 */
	@GetMapping("actions")
	public Integer getNumberOfActions() {
		return halfBaked.getTotalActions();
	}

}
