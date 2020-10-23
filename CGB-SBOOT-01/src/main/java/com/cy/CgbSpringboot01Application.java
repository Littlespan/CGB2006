package com.cy;
import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
  *   任何一个项目都有一个启动入口,在springboot中的启动类需要有
 * @SpringBootApplication 注解进行描述,并且在类中会定义一个main
  *   方法,main方法在运行时会读取配置文件,并加载指定资源,然后进行初始化操作.
  FAQ?
   1)SpringBoot项目中配置文件来源?
   a)SpringBoot官方定义(一般为一些基础配置),例如spring.factories(在springboot自动配置依赖中)
   b)第三方定义(例如日志系统-log4j.xml,.....)
   c)我们自己定义(application.properties,.....)
   
   2)SpringBoot项目中的资源加载?(资源可以理解为我们的class文件)
   a)JDK类文件(Object,....)
   b)Spring类文件,第三方法类文件,...
   c)自己定义的类文件
   
   3)Spring中的项目资源初始化?
   a)构建实例对象
   b)基于对象存储数据(例如配置信息,默认值)
   
 */
//JVM参数(了解): 
//跟踪类加载:-XX:+TraceClassLoading
//CommandLineRunner 此接口定义了一种规范，可以在spring框架初始化以后执行一些逻辑。
@SpringBootApplication
public class CgbSpringboot01Application implements CommandLineRunner {

	/**
	 * main方法由jvm调用
	 * @param args JVM运行时给main方法传入值
	 */
	public static void main(String[] args) {
		System.out.println("mains.args="+Arrays.toString(args));
		SpringApplication.run(CgbSpringboot01Application.class, args);
	}
	//@Autowired 用于告诉spring框架，为这个属性注入一个值。
	@Autowired
	private BeanFactory beanFactory;
    /**在此方法可以获取spring容器中的一些初始化资源
     * @param args 与main方法中的参数是一样的
     * */
	@Override
	public void run(String... args) throws Exception {
	   System.out.println("run.args="+Arrays.toString(args));
	   System.out.println("beanFactory="+beanFactory);//DefaultListableBeanFactory
	}

}





