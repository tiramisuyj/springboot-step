package com.cnc.springbootstep.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author yj 
* @date 2019-02-18 
*/
@ControllerAdvice//定义统一的异常处理类
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler({BusinessException.class})//用来定义函数针对的异常类型，可以传入多个需要捕获的异常类
	//如果返回的是json数据或者其它对象，就添加该注解
	@ResponseBody
	public ErrorInfo defaErrorHander(HttpServletRequest req,Exception e) throws Exception{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setMessage(e.getMessage());
		errorInfo.setUrl(req.getRequestURI());
		errorInfo.setCode(ErrorInfo.SUCCESS);
		return errorInfo;
	}
}
