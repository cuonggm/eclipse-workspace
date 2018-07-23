package com.cuong.beans;

import java.io.PrintStream;

public class SayHelloWorld {
	PrintStream stream;
	
	public SayHelloWorld(PrintStream stream) {
		this.stream = stream;
	}
	
	public void sayHello(String string) {
		stream.println(string);
	}
}
