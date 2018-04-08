package com.xjst.skysweety.util.proxy;

public interface EnhancerInterface {
	
	public void setMethodInterceptor$Enhancer$(MethodInterceptor methodInterceptor);
	
	@SuppressWarnings("rawtypes")
    Object executeSuperMethod$Enhancer$(String methodName, Class[] argsType, Object[] argsValue);

	/**
	 *
     */
	void setCallBacksMethod$Enhancer$(MethodInterceptor[] methodInterceptor);

	/**
	 * filter
     */
	void setCallBackFilterMethod$Enhancer$(MethodFilter methodFilter);

}
