package com.yang;

//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * Created by CS on 2018/4/3.
// */
//public class MyWebAppInitializer implements WebApplicationInitializer {
//
//    /**
//     * Servlet容器启动时会自动运行该方法
//     */
//
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        servletContext.setInitParameter("contextConfigLocation", "classpath:config.xml");
//
//        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//        registration.setInitParameter("contextConfigLocation", "classpath:dispatcher-servlet.xml");
//
//        servletContext.addListener(new ContextLoaderListener());
//    }
//}