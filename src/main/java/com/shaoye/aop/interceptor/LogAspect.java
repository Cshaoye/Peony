package com.shaoye.aop.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志切面类
 * 
 * @author hufan
 */
public class LogAspect {

	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	// 任何通知方法都可以将第一个参数定义为 org.aspectj.lang.JoinPoint类型
	public void before(JoinPoint call) {
		// 获取目标对象对应的类名
		String className = call.getTarget().getClass().getName();
		// 获取目标对象上正在执行的方法名
		String methodName = call.getSignature().getName();
		logger.info("前置通知:" + className + "类的" + methodName + "方法开始了");
	}

	public void afterReturn() {
		logger.info("后置通知:方法正常结束了");
	}

	public void after() {
		logger.info("最终通知:不管方法有没有正常执行完成，一定会返回的");
	}

	public void afterThrowing() {
		logger.info("异常抛出后通知:方法执行时出异常了");
	}

	// 用来做环绕通知的方法可以第一个参数定义为org.aspectj.lang.ProceedingJoinPoint类型
	public Object doAround(ProceedingJoinPoint call) throws Throwable {
		Object result = null;
		this.before(call);// 相当于前置通知
		try {
			result = call.proceed();
			this.afterReturn(); // 相当于后置通知
		} catch (Throwable e) {
			this.afterThrowing(); // 相当于异常抛出后通知
			e.printStackTrace();
		} finally {
			this.after(); // 相当于最终通知
		}
		return result;
	}
}