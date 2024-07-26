package resource;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.Arrays;

/**
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-resources/spring-resource-resourcePatternResolver/README.md">ResourcePatternResolver</a>
 */
public class ResourcePatternResolverTest
{

	@Test
	public void testResourcePatternResolver() throws Exception
	{
		// 支持使用 Ant 风格的路径模式
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		// 加载所有匹配的类路径资源
		Resource[] resources = resolver.getResources("classpath*:*.properties");
		Arrays.stream(resources).forEach((resource) -> System.out.println(resource.getFilename()));

		System.out.println("------------------------------------------------");

		// 加载文件系统中的所有匹配资源
		Resource[] fileResources = resolver.getResources("file:D:/03-source-code/spring/spring-file/*.txt");
		Arrays.stream(fileResources).forEach((resource) -> System.out.println(resource.getFilename()));
	}
}
