package com.cuong.gettingstarted;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {
	
	MessageProvider messageProvider;
	
	public void render() {
		if(messageProvider == null) {
			throw new RuntimeErrorException(new Error("You must provide message provider first!"));
		} else {
			System.out.println(messageProvider.getMessage());
		}
	}

	@Autowired
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

}
