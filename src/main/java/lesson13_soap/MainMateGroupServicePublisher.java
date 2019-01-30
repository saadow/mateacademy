package lesson13_soap;

import javax.xml.ws.Endpoint;

public class MainMateGroupServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/mate", new MateGroupServiceImpl());
	}

}