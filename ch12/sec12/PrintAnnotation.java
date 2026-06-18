package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
//@Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.CLASS)
//@Retention(RetentionPolicy.SOURCE)

public @interface PrintAnnotation {
	String value() default "-";
	int number() default 15;
}