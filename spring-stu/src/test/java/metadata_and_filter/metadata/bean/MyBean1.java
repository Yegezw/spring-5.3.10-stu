package metadata_and_filter.metadata.bean;

import metadata_and_filter.metadata.annotation.MyClassAnnotation;
import metadata_and_filter.metadata.annotation.MyMethodAnnotation;

import java.io.Serial;
import java.io.Serializable;

@MyClassAnnotation
public final class MyBean1 extends MyAbstract implements Serializable
{

	@Serial
	private static final long serialVersionUID = 1L;

	public String key;

	public String value;

	@MyMethodAnnotation("1")
	public static void myMethod1()
	{
		System.out.println("myMethod1");
	}

	@MyMethodAnnotation("2")
	public String myMethod2()
	{
		return "myMethod2";
	}

	public void myMethod3()
	{
		System.out.println("myMethod3");
	}

	/**
	 * 静态内部类
	 */
	public static class MyInnerClass
	{
	}
}
