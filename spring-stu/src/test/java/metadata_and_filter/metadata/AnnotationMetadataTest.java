package metadata_and_filter.metadata;

import metadata_and_filter.metadata.bean.MyBean2;
import org.junit.jupiter.api.Test;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-metadata/spring-metadata-annotationMetadata/README.md">annotationMetadata</a>
 */
public class AnnotationMetadataTest
{

	@Test
	public void testASM() throws Exception
	{
		// 创建 Metadata Reader Factory
		MetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory();
		// 获取 Metadata Reader
		MetadataReader metadataReader = readerFactory.getMetadataReader("metadata_and_filter.metadata.bean.MyBean2");

		// 获取 Annotation Metadata
		// Simple Annotation Metadata
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		testAnnotationMetadata(annotationMetadata);
	}

	@Test
	public void testReflection()
	{
		// Standard Annotation Metadata
		AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(MyBean2.class);
		testAnnotationMetadata(annotationMetadata);
	}

	private static void testAnnotationMetadata(AnnotationMetadata annotationMetadata)
	{
		System.out.println("AnnotationMetadata impl class is " + annotationMetadata.getClass());

		// 检查 MyBean2 类是否被 @Component 注解标记
		boolean isComponent = annotationMetadata.hasAnnotation(Component.class.getName());
		System.out.println("MyBean2 is a @Component: " + isComponent);

		// 获取 MyBean2 类上的注解属性
		if (isComponent)
		{
			Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(Component.class.getName());
			if (annotationAttributes != null)
			{
				annotationAttributes.forEach((k, v) -> System.out.println(k + " : " + v));
			}
		}
	}
}
