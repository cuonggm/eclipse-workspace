package com.cuong.gettingstarted;

public interface MessageRenderer {

	void render();
	void setMessageProvider(MessageProvider messageProvider);
	MessageProvider getMessageProvider();
	
}
