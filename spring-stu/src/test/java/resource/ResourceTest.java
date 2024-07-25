package resource;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-resources/spring-resource/README.md">Resource</a>
 */
public class ResourceTest
{

	@Test
	public void testClassPathResource() throws Exception
	{
		String   path     = "application.properties";
		Resource resource = new ClassPathResource(path);
		try (InputStream is = resource.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}
	}

	@Test
	public void testFileSystemResource() throws Exception
	{
		String   path     = "D:/03-source-code/spring/spring-file/myfile.txt";
		Resource resource = new FileSystemResource(path);
		try (InputStream is = resource.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}
	}

	@Test
	public void testUrlResource() throws Exception
	{
		String   path     = "https://dist.apache.org/repos/dist/test/test.txt";
		Resource resource = new UrlResource(path);
		try (InputStream is = resource.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}
	}

	@Test
	public void testByteArrayResource() throws Exception
	{
		byte[]   data     = "hello world".getBytes();
		Resource resource = new ByteArrayResource(data);
		try (InputStream is = resource.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}
	}

	@Test
	public void testInputStreamResource() throws Exception
	{
		InputStream in       = new ByteArrayInputStream("hello world".getBytes());
		Resource    resource = new InputStreamResource(in);
		try (InputStream is = resource.getInputStream())
		{
			System.out.println(new String(is.readAllBytes()));
		}
	}
}
