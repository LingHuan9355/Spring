package com.hr.spring.tx.exception;

/**
 * 
 * @Name  : UserAccountException
 * @Author : LH
 * @Date : 2018年6月28日 下午10:57:43
 * @Version : V1.0
 * 
 * @Description :
 */
public class UserAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
