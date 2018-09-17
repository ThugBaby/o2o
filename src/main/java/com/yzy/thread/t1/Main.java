package com.yzy.thread.t1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext as=new AnnotationConfigApplicationContext(Config.class);
		DemoService ds=as.getBean(DemoService.class);
		ds.a();
		ds.b();
	}
}
