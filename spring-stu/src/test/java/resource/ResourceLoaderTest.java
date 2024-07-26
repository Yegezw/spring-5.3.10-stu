package resource;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.InputStream;

/**
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-resources/spring-resource-resourceLoader/README.md">ResourceLoader</a>
 */
public class ResourceLoaderTest
{

	@Test
	public void testDefaultResourceLoader() throws Exception
	{
		DefaultResourceLoader loader = new DefaultResourceLoader();

		// 加载类路径中的资源
		Resource resource1 = loader.getResource("classpath:application.properties");
		try (InputStream is = resource1.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}

		// 加载文件系统中的资源
		Resource resource2 = loader.getResource("file:D:/03-source-code/spring/spring-file/myfile1.txt");
		try (InputStream is = resource2.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}
	}
}
