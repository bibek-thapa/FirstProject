package com.example.config;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class FirstProjWebAppInitializer implements WebApplicationInitializer {
private static final String DISPATCHER_SERVLET_NAME = "dispatcher1";

        
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(JPAConfig.class,WebConfig.class,RootConfig.class,SecurityConfig.class);
                
                servletContext.addListener(new ContextLoaderListener(ctx));
                
                FilterRegistration fr = servletContext.addFilter("springSecurityFilterChain",
				new DelegatingFilterProxy());
		fr.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,
				DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/*");

		ctx.setServletContext(servletContext);
                
                    
                

		ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
				new DispatcherServlet(ctx));
              
                servlet.setMultipartConfig(new MultipartConfigElement("D:/tmp/uploads", 2097152, 4194304, 0));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
                
                
                
	}
        
        

//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        // TODO Auto-generated method stub
//        return new Class<?>[]{WebConfig.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        // TODO Auto-generated method stub
//        return new Class<?>[]{RootConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        // TODO Auto-generated method stub
//        return new String[]{"/"};
//    }

   

}
