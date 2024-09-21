package metadata_and_filter.metadata.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation
{

	String value() default "";
}
