package metadata_and_filter.metadata;

import org.junit.jupiter.api.Test;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.util.Arrays;
import java.util.Set;

/**
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-metadata/spring-metadata-metadataReader/README.md">MetadataReader</a>
 */
public class MetadataReaderTest
{

	@Test
	public void testMetadataReader() throws Exception
	{
		String beanPath         = "metadata_and_filter.metadata.bean.MyBean1";
		String methodAnnotation = "metadata_and_filter.metadata.annotation.MyMethodAnnotation";

		// 创建 MetadataReader Factory
		MetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory();
		// 获取 MetadataReader，通常由 Spring 容器自动创建
		MetadataReader reader = readerFactory.getMetadataReader(beanPath);

		System.out.println("------------------------------------------------");

		// 获取类的基本信息 ClassMetadata
		ClassMetadata classMetadata = reader.getClassMetadata();
		System.out.println("Class Name = " + classMetadata.getClassName());
		System.out.println("Class IsInterface = " + classMetadata.isInterface());
		System.out.println("Class IsAnnotation = " + classMetadata.isAnnotation());
		System.out.println("Class IsAbstract = " + classMetadata.isAbstract());
		System.out.println("Class IsConcrete = " + classMetadata.isConcrete());
		System.out.println("Class IsFinal = " + classMetadata.isFinal());
		System.out.println("Class IsIndependent = " + classMetadata.isIndependent());
		System.out.println("Class HasEnclosingClass = " + classMetadata.hasEnclosingClass());
		System.out.println("Class EnclosingClassName = " + classMetadata.getEnclosingClassName());
		System.out.println("Class HasSuperClass = " + classMetadata.hasSuperClass());
		System.out.println("Class SuperClassName = " + classMetadata.getSuperClassName());
		System.out.println("Class InterfaceNames = " + Arrays.toString(classMetadata.getInterfaceNames()));
		System.out.println("Class MemberClassNames = " + Arrays.toString(classMetadata.getMemberClassNames()));
		System.out.println("Class Annotations: " + reader.getAnnotationMetadata().getAnnotationTypes());

		System.out.println("------------------------------------------------");

		// 获取类的注解信息 AnnotationMetadata
		AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
		// 1、获取类的注解
		System.out.println(annotationMetadata.getAnnotationTypes());
		// 2、获取类的方法注解
		Set<MethodMetadata> annotatedMethods = annotationMetadata.getAnnotatedMethods(methodAnnotation);
		for (MethodMetadata methodMetadata : annotatedMethods)
		{
			System.out.println("Method Name: " + methodMetadata.getMethodName());
			System.out.println("Method DeclaringClassName: " + methodMetadata.getDeclaringClassName());
			System.out.println("Method ReturnTypeName: " + methodMetadata.getReturnTypeName());
			System.out.println("Method IsAbstract: " + methodMetadata.isAbstract());
			System.out.println("Method IsStatic: " + methodMetadata.isStatic());
			System.out.println("Method IsFinal: " + methodMetadata.isFinal());
			System.out.println("Method IsOverridable: " + methodMetadata.isOverridable());
			System.out.println();
		}
	}
}
