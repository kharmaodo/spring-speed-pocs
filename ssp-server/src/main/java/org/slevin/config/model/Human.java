package org.slevin.config.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Human {

	public String name;

	public Human() {

	}

	public Human(String name) {
		this.name = name;
	}
}
