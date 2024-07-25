package org.springframework.stu.person;

import org.springframework.stereotype.Service;

@Service
public class AmericanService implements PersonService
{

	@Override
	public void speak()
	{
		System.out.println("I can speak English");
	}
}
