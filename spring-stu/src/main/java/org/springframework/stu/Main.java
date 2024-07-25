package org.springframework.stu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stu.person.PersonService;

@ComponentScan("org.springframework.stu.**")
public class Main
{

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

		PersonService personService = context.getBean(PersonService.class);
		personService.speak();
	}
}
