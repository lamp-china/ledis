package com.lamp.ledis.spring;

import static org.springframework.util.Assert.notNull ;

import java.lang.annotation.Annotation ;

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

import com.lamp.ledis.annotation.Mapper;

public class MapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware, BeanNameAware{

	private String basePackage;
	
	private Class<? extends Annotation> annotationClass = Mapper.class;
	
	private Class<?> markerInterface;
	
	private String beanName;
	
	private ApplicationContext applicationContext;
	
	
	
	public String getBasePackage( ) {
		return basePackage;
	}

	public void setBasePackage( String basePackage ) {
		this.basePackage = basePackage;
	}

	public Class< ? extends Annotation > getAnnotationClass( ) {
		return annotationClass;
	}

	public void setAnnotationClass( Class< ? extends Annotation > annotationClass ) {
		this.annotationClass = annotationClass;
	}

	public Class< ? > getMarkerInterface( ) {
		return markerInterface;
	}

	public void setMarkerInterface( Class< ? > markerInterface ) {
		this.markerInterface = markerInterface;
	}

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
	    scanner.setAnnotationClass(this.annotationClass);
	    scanner.setMarkerInterface(this.markerInterface);
	    scanner.setResourceLoader(this.applicationContext);
	    scanner.registerFilters();
	    scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS));
		
	}

}
