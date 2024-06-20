package Utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.ITestAnnotation;

//public class RetryListener implements IAnnotationTransformer {
//
//	public void tranform(ITestAnnotation testAnnotation, Class testClass, Constructor testconstructor,
//			Method testMethod) {
//
//		testAnnotation.setRetryAnalyzer(RetryAnalyser.class);
//
//	}
//
//}


public class RetryListener implements IAnnotationTransformer {

@Override
public void transform(ITestAnnotation itestannotation, Class testClass, Constructor testConstructor, Method testMethod) {
        itestannotation.setRetryAnalyzer(RetryAnalyser.class); 
    }
}