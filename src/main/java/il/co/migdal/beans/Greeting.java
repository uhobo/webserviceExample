package il.co.migdal.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "greeting")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Greeting implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String greeting;
	
	public String getGreeting() {
		
		return greeting;
		
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		
	}

}
