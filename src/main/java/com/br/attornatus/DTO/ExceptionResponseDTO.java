package com.br.attornatus.DTO;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ExceptionResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String timestamp;

	private String message;

	private String details;

	private HttpStatus status;

	private Integer statusCode;

	public ExceptionResponseDTO() {
	}

	public ExceptionResponseDTO(String timestamp, String message, String details, HttpStatus status,
			Integer statusCode) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status = status;
		this.statusCode = statusCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
