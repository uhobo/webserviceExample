package il.co.migdal.endpoint;

import javax.servlet.Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

  @Bean
  public ServletRegistrationBean<Servlet> messageDispatcherServlet(
      ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet =
        new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);

    return new ServletRegistrationBean<>(servlet,
        "/service/*");
  }
  //http://localhost:8080/service/greetingService.wsdl
  @Bean(name = "greetingService")
  public Wsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
	  DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
      wsdl11Definition.setPortTypeName("GreetingServicePort");
      wsdl11Definition.setLocationUri("/service/greeting-details");
      wsdl11Definition.setTargetNamespace("https://www.migdal.co.il/xml/greeting");
      wsdl11Definition.setSchema(schema);
      return wsdl11Definition;
  }
  
  @Bean
  public XsdSchema countriesSchema()
  {
      return new SimpleXsdSchema(new ClassPathResource("greeting1.xsd"));
  }
}