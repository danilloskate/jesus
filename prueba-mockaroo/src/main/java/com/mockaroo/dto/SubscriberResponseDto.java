package com.mockaroo.dto;



import java.util.List;

public class SubscriberResponseDto {

	//private Response response;
	private String code;
	private String message;
	private List<Subscriber> subscribers = null;

	public SubscriberResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public SubscriberResponseDto(Response response, List<Subscriber> subscribers) {
//		super();
//		this.response = response;
//		this.subscribers = subscribers;
//	}
//
//	public Response getResponse() {
//		return response;
//	}
//
//	public void setResponse(Response response) {
//		this.response = response;
//	}
	
	public SubscriberResponseDto(String code, String message, List<Subscriber> subscribers) {
	super();
	this.code = code;
	this.message = message;
	this.subscribers = subscribers;
}

	public List<Subscriber> getSubscribers() {
		return subscribers;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSubscribers(List<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

}
