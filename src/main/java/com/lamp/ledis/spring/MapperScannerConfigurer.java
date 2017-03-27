package com.lamp.ledis.spring;

import static org.springframework.util.Assert.notNull ;

import java.lang.annotation.Annotation ;

import org.mybatis.spring.mapper.ClassPathMapperScanner ;
import org.springframework.beans.BeansException ;
import org.springframework.beans.factory.BeanNameAware ;
import org.springframework.beans.factory.InitializingBean ;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory ;
import org.springframework.beans.factory.support.BeanDefinitionRegistry ;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor ;
import org.springframework.context.ApplicationContext ;
import org.springframework.context.ApplicationContextAware ;
import org.springframework.context.ConfigurableApplicationContext ;
import org.springframework.util.StringUtils ;

public class MapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware, BeanNameAware{

	private String basePackage;
	
	private Class<? extends Annotation> annotationClass;
	
	private String beanName;
	
	private ApplicationContext applicationContext;
	
	
	
	@Override
	public void postProcessBeanFactory ( ConfigurableListableBeanFactory beanFactory ) throws BeansException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setBeanName ( String name ) {
		this.beanName = name;	
	}

	@Override
	public void setApplicationContext ( ApplicationContext applicationContext ) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

	@Override
	public void afterPropertiesSet ( ) throws Exception {
		notNull(this.basePackage, "Property 'basePackage' is required");
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry ( BeanDefinitionRegistry registry ) throws BeansException {
	    ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
	    scanner.setAddToConfig(this.addToConfig);
	    scanner.setAnnotationClass(this.annotationClass);
	    scanner.setMarkerInterface(this.markerInterface);
	    scanner.setSqlSessionFactory(this.sqlSessionFactory);
	    scanner.setSqlSessionTemplate(this.sqlSessionTemplate);
	    scanner.setSqlSessionFactoryBeanName(this.sqlSessionFactoryBeanName);
	    scanner.setSqlSessionTemplateBeanName(this.sqlSessionTemplateBeanName);
	    scanner.setResourceLoader(this.applicationContext);
	    scanner.setBeanNameGenerator(this.nameGenerator);
	    scanner.registerFilters();
	    scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS));
		
	}

}
