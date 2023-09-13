package eu.happycoders.virtualthread;

import java.util.concurrent.Executors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;

@SpringBootApplication
public class SpringVirtualThreadTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringVirtualThreadTestApplication.class, args);
  }

  //  Uncomment the following two methods to enable virtual threads

//  @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
//  public AsyncTaskExecutor asyncTaskExecutor() {
//    return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
//  }
//
//  @Bean
//  public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
//    return protocolHandler -> {
//      protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
//    };
//  }
}
