package com.onlyxiahui.extend.doc.spring.boot;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.onlyxiahui.general.doc.spring.boot.OnlyPathClassScanner;

/**
 * Description <br>
 * Date 2020-06-01 14:45:24<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class ScanningTest {

	public static void main(String[] args) {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false) {
			protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
//				for (TypeFilter tf : this.excludeFilters) {
//					if (tf.match(metadataReader, getMetadataReaderFactory())) {
//						return false;
//					}
//				}
//				for (TypeFilter tf : this.includeFilters) {
//					if (tf.match(metadataReader, getMetadataReaderFactory())) {
//						return isConditionMatch(metadataReader);
//					}
//				}
				return true;
			}
		};
		AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(Annotation.class);
		scanner.addIncludeFilter(annotationTypeFilter);
		Set<BeanDefinition> set = scanner.findCandidateComponents("ink.oim");
		for (BeanDefinition bd : set) {
			String className = "";
			className = bd.getBeanClassName();
			System.out.println(className);
		}
		OnlyPathClassScanner sc = new OnlyPathClassScanner();
		Set<Class<?>> classes = sc.doScan("ink.oim");
		for (Class<?> c : classes) {
			System.out.println(c.getName());
		}
	}
}
