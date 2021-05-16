package de.tekup.white.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import de.tekup.white.test.endpoint.WhiteElegibilityEndPoint;
@EnableWs
@Configuration
public class whiteSoapConfig {
@Bean
public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
	
	//return null;
	MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	servlet.setApplicationContext(context);
	servlet.setTransformWsdlLocations(true);
	return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/ws/*");
	

}
@Bean(name="WhiteEligelibity")
public XsdSchema schema () {
	return new SimpleXsdSchema(new ClassPathResource("whiteTest.xsd"));
}
@Bean
 public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
	DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition ();
	defaultWsdl11Definition.setPortTypeName("whiteEligebilityIndecator");
	defaultWsdl11Definition.setLocationUri("/ws");
	defaultWsdl11Definition.setSchema(schema);
	defaultWsdl11Definition.setTargetNamespace(WhiteElegibilityEndPoint.nameSpace);
	//return null;
	return defaultWsdl11Definition ;
}
}

