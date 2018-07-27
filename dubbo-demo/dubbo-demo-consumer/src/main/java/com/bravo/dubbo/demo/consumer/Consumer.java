package com.bravo.dubbo.demo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bravo.dubbo.demo.DemoService;

public class Consumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();

        // Obtaining a remote service proxy
        DemoService service = (DemoService)context.getBean("demoService");
        String hello = service.sayHello("world");
        System.out.println(hello);
	}

}
