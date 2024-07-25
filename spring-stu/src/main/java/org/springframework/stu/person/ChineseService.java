package org.springframework.stu.person;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ChineseService implements PersonService
{

    @Override
    public void speak()
    {
        System.out.println("我会说中文");
    }
}
