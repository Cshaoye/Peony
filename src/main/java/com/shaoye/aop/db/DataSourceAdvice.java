package com.shaoye.aop.db;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 配置AOP切面类，动态切换读/写数据库。
 * @author hufan
 */
public class DataSourceAdvice {

	private static final Logger logger = LoggerFactory
			.getLogger(DataSourceAdvice.class);

	private String logInfo;

	// 需要切换到从库(读库)的方法名前缀
	private List<String> slaveMethods;

	/**
	 * service方法执行之前被调用.
	 */
	public void before(JoinPoint call) throws Throwable {
		String className = call.getTarget().getClass().getName();
		String methodName = call.getSignature().getName();
		logger.info("DB前置通知:" + className + "类的" + methodName + "方法开始了");
		boolean hasSwitchedSlave = false;
		logger.info("current methodName is: {}", methodName);
		logger.info("all slaveMethods is: {}",
				JSON.toJSONString(slaveMethods));
		for (String slaveMethod : slaveMethods) {
			if (methodName.startsWith(slaveMethod)) {
				hasSwitchedSlave = true;
				DataSourceSwitcher.setSlave();
				break;
			}
		}
		logger.info("current db is: {}", DataSourceSwitcher.getDataSource());
		if (!hasSwitchedSlave) {
			logger.info(logInfo + "切换到:"
					+ DataSourceSwitcher.MASTER_DATA_SOURCE);
			DataSourceSwitcher.setMaster();
		}
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

	/**
	 * 抛出Exception之后被调用。
	 * 
	 * @param method
	 * @param args
	 * @param target
	 * @param ex
	 * @throws Throwable
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable {
		logInfo = String.format("after throwing:%s类中%s方法,", target.getClass()
				.getName(), method.getName());
		logger.error(logInfo + "发生异常:" + ex.getMessage() + ",切换到:"
				+ DataSourceSwitcher.SLAVE_DATA_SOURCE);
		DataSourceSwitcher.setSlave();
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

	public List<String> getSlaveMethods() {
		return slaveMethods;
	}

	public void setSlaveMethods(List<String> slaveMethods) {
		this.slaveMethods = slaveMethods;
	}
}
