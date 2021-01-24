package com.pritesh.userapp.util;

import java.io.Serializable;

public class CommonResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Boolean status;
	private Object data;
	private Integer respCode;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

	public Integer getRespCode() {
		return respCode;
	}

	public void setRespCode(Integer respCode) {
		this.respCode = respCode;
	}

	public CommonResponse() {
		super();
	}

	@Override
	public String toString() {
		return "CommonResponse [message=" + message + ", status=" + status + ", data=" + data + "]";
	}

}
