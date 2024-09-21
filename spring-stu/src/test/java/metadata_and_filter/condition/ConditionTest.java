package metadata_and_filter.condition;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Condition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

/**
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-metadata/spring-metadata-condition/README.md">condition</a>
 */

public class ConditionTest
{

	/**
	 * 注解 Conditional({MyOnClassCondition.class})
	 */
	@Test
	public void condition() throws Exception
	{
		// 创建支持使用 Ant 风格路径匹配的资源模式解析器
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 使用资源模式解析器，获取所有匹配指定路径的类文件
		Resource[] resources = resolver.getResources("classpath*:metadata_and_filter/condition/*.class");

		// 创建一个简单的元数据读取器工厂
		SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();

		// 创建自定义条件类的实例，用于条件匹配
		Condition condition = new MyOnClassCondition("metadata_and_filter.condition.Ignore");

		// 遍历每个资源，判断是否满足自定义条件
		for (Resource resource : resources)
		{
			// 获取元数据读取器
			MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);

			// 判断资源是否满足自定义条件
			if (condition.matches(null, metadataReader.getAnnotationMetadata()))
			{
				System.out.println(resource.getFile().getName() + " 满足条件");
			}
			else
			{
				System.out.println(resource.getFile().getName() + " 不满足条件");
			}
		}
	}
}
