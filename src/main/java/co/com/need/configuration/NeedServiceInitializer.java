package co.com.need.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NeedServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { NeedServiceConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
