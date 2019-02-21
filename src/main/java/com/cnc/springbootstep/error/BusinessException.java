package com.cnc.springbootstep.error;
/** 
* @author yj 
* @date 2019-02-18 
*/
public class BusinessException extends RuntimeException{

	public BusinessException() {};
	
	public BusinessException(String message) {
		super(message);
	}
}
