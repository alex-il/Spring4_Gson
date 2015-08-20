package com.verint.probe.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.verint.probe.api.impl.MessageProcessor;



@Configuration
@ComponentScan("com.verint.probe.api")
public class ApiUtil {
 
  private static ApplicationContext context;

	public static Object getBean(String bean) {
		return context.getBean(bean);
	}

	public static ApplicationContext getContext() {
		return context;
	}
	
	public static void setContext(ApplicationContext context) {
		ApiUtil.context = context;
	}

	public static void main(String[] args) {
      context = new AnnotationConfigApplicationContext(ApiUtil.class);
//      this is same to next line
//      CustomerService cs = (CustomerService) context.getBean("customerService");
//      CustomerService cs = context.getBean(CustomerService.class);
//      System.out.println(cs);
//  
//      HelloWorld obj = (HelloWorld) context.getBean("aaa");
//  		obj.printHello();
      IMessageProcessor mp = newMessageProcessor();
      String messages[] = {"createVA","processWF", "New_Type"};
      for (String m : messages) {
      	System.out.println("Start processing the: "+ m);
				mp.process(new Object(), m);
			}
  }

	private static MessageProcessor newMessageProcessor() {
		return context.getBean( MessageProcessor.class);
	}
}
