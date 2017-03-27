package com.lamp.ledis.spring ;

import java.io.IOException ;
import java.lang.annotation.Annotation ;
import java.util.Arrays ;
import java.util.LinkedHashSet ;
import java.util.Set ;

import org.springframework.beans.factory.config.BeanDefinitionHolder ;
import org.springframework.beans.factory.support.AbstractBeanDefinition ;
import org.springframework.beans.factory.support.BeanDefinitionRegistry ;
import org.springframework.beans.factory.support.GenericBeanDefinition ;
import org.springframework.context.annotation.AnnotationConfigUtils ;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner ;
import org.springframework.core.type.classreading.MetadataReader ;
import org.springframework.core.type.classreading.MetadataReaderFactory ;
import org.springframework.core.type.filter.AnnotationTypeFilter ;
import org.springframework.core.type.filter.AssignableTypeFilter ;
import org.springframework.core.type.filter.TypeFilter ;

import com.lamp.ledis.annotation.LedisAanntationCollection ;
import com.lamp.ledis.utils.AnniationUtils ;

public class ClassPathMapperScanner extends ClassPathBeanDefinitionScanner {

	public ClassPathMapperScanner(BeanDefinitionRegistry registry) {
		super( registry ) ;
	}

	public void registerFilters ( ) {
		boolean acceptAllInterfaces = true ;

		// if specified, use the given annotation and / or marker interface
		if ( this.annotationClass != null ) {
			addIncludeFilter( new AnnotationTypeFilter( this.annotationClass ) ) ;
			acceptAllInterfaces = false ;
		}

		// override AssignableTypeFilter to ignore matches on the actual marker
		// interface
		if ( this.markerInterface != null ) {
			addIncludeFilter( new AssignableTypeFilter( this.markerInterface ) {
				@Override
				protected boolean matchClassName ( String className ) {
					return false ;
				}
			} ) ;
			acceptAllInterfaces = false ;
		}

		if ( acceptAllInterfaces ) {
			// default include filter that accepts all classes
			addIncludeFilter( new TypeFilter( ) {
				@Override
				public boolean match ( MetadataReader metadataReader , MetadataReaderFactory metadataReaderFactory )
						throws IOException {
					return true ;
				}
			} ) ;
		}

		// exclude package-info.java
		addExcludeFilter( new TypeFilter( ) {
			@Override
			public boolean match ( MetadataReader metadataReader , MetadataReaderFactory metadataReaderFactory )
					throws IOException {
				String className = metadataReader.getClassMetadata( ).getClassName( ) ;
				return className.endsWith( "package-info" ) ;
			}
		} ) ;
	}

	/**
	 * Calls the parent search that will search and register all the candidates.
	 * Then the registered objects are post processed to set them as
	 * MapperFactoryBeans
	 */
	@Override
	public Set< BeanDefinitionHolder > doScan ( String... basePackages ) {
		Set< BeanDefinitionHolder > beanDefinitions = super.doScan( basePackages ) ;

		if ( beanDefinitions.isEmpty( ) ) {
			logger.warn( "No MyBatis mapper was found in '" + Arrays.toString( basePackages )
					+ "' package. Please check your configuration." ) ;
		} else {
			beanDefinitions =  processBeanDefinitions( beanDefinitions ) ;
		}

		return beanDefinitions ;
	}

	private Set< BeanDefinitionHolder > processBeanDefinitions(Set< BeanDefinitionHolder > beanDefinitions){
		GenericBeanDefinition definition = null;
		Class<?> clazz;
		LedisAanntationCollection lac;
		
	    for (BeanDefinitionHolder holder : beanDefinitions) {
	      definition = (GenericBeanDefinition) holder.getBeanDefinition();
	      clazz = definition.getBeanClass( );
	      lac = new LedisAanntationCollection( );
	      AnniationUtils.readAnniation( clazz , lac );
	      
	      this.getRegistry( ).registerBeanDefinition( null , null );
	    }
	    //registry.registerBeanDefinition(beanName, beanDefinition);
	    return null;
	}
}
