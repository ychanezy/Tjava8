package dynamic.proxy; 

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ʵ���Լ���InvocationHandler
 * @author zyb
 * @since 2012-8-9
 *
 */
public class MyInvocationHandler implements InvocationHandler {
	
	// Ŀ����� 
	private Object target;
	
	/**
	 * ���췽��
	 * @param target Ŀ����� 
	 */
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}


	/**
	 * ִ��Ŀ�����ķ���
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		// ��Ŀ�����ķ���ִ��֮ǰ�򵥵Ĵ�ӡһ��
		System.out.println("------------------before------------------");
		
		// ִ��Ŀ�����ķ���
		Object result = method.invoke(target, args);
		
		// ��Ŀ�����ķ���ִ��֮��򵥵Ĵ�ӡһ��
		System.out.println("-------------------after------------------");
		
		return result;
	}

	/**
	 * ��ȡĿ�����Ĵ������
	 * @return �������
	 */
	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
}

