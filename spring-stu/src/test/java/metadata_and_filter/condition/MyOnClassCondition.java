package metadata_and_filter.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 当 className 存在时则加载，否则不加载
 */
public class MyOnClassCondition implements Condition
{

	private final String className;

	public MyOnClassCondition(String className)
	{
		this.className = className;
	}

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
	{
		try
		{
			// 尝试加载类
			getClass().getClassLoader().loadClass(className);
			// 类存在，条件匹配
			return true;
		}
		catch (ClassNotFoundException e)
		{
			// 类不存在，条件不匹配
			return false;
		}
	}
}
