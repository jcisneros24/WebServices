package com.cda.endpoint;

import javax.xml.ws.Endpoint;

import com.cda.service.HelloWorldImpl;

//Endpoint publisher
public class HelloWorldPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Endpoint.publish("http://10.51.0.200:1234/service/hello", new HelloWorldImpl());
	}

}