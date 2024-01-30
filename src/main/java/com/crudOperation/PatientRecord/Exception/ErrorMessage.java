package com.crudOperation.PatientRecord.Exception;

import java.util.Date;

public class ErrorMessage {
	private int statusCode;
	  private Date timestamp;
	  private String message;
	  private String description;

	  public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
	    this.statusCode = statusCode;
	    this.timestamp = timestamp;
	    this.message = message;
	    this.description = description;
	  }

	  public ErrorMessage(String string, boolean b) {
		  this.message = message;
		  
		
	}

	public int getStatusCode() {
	    return statusCode;
	  }

	  public Date getTimestamp() {
	    return timestamp;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public String getDescription() {
	    return description;
	  }
}
