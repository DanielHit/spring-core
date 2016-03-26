package hello;

/**
 * Created by Daniel on 3/26/16.
 */

import Bean.ConstantBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    // spring framework
    public static void main(String[] args) {
        ApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = annotationContext.getBean(MessagePrinter.class);
        printer.printMessage();

        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        FuckMessage fuckMessage = context.getBean("message", FuckMessage.class);

        // construct inject into this bean
        ConstantBean user = context.getBean("user", ConstantBean.class);
        fuckMessage.fuck();
        System.out.println(user);

    }
}

