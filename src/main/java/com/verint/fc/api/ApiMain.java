package com.verint.fc.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.verint.fc.api.json.MessageProcessor;



@Configuration
@ComponentScan("com.verint.fc.api")
public class ApiMain {
 
  private static ApplicationContext context;

	public static Object getBean(String bean) {
		return context.getBean(bean);
	}

	public static ApplicationContext getContext() {
		return context;
	}
	
	public static void setContext(ApplicationContext context) {
		ApiMain.context = context;
	}

	public static void main(String[] args) {
      context = new AnnotationConfigApplicationContext(ApiMain.class);
//      this is same to next line
//      CustomerService cs = (CustomerService) context.getBean("customerService");
//      CustomerService cs = context.getBean(CustomerService.class);
//      System.out.println(cs);
//  
//      HelloWorld obj = (HelloWorld) context.getBean("aaa");
//  		obj.printHello();
      MessageProcessor mp = context.getBean( MessageProcessor.class);
      String messages[] = {"createVA","processWF", "New_Type"};
      for (String m : messages) {
      	System.out.println("Start processing the: "+ m);
				mp.process(m);
			}
  }
}
