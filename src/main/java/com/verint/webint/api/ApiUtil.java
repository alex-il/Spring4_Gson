package com.verint.webint.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.verint.webint.api.impl.MessageProcessor;

//WildFly annotation
//@Startup
@Configuration
@ComponentScan("com.verint.webint.api")
public class ApiUtil {
 
  private static ApplicationContext context = new AnnotationConfigApplicationContext(ApiUtil.class);

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

	public static IMessageProcessor newMessageProcessor() {
		return context.getBean( MessageProcessor.class);
	}
}
