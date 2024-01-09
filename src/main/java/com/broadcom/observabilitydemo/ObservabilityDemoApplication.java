package com.broadcom.observabilitydemo;

import com.broadcom.observabilitydemo.hub.observationhandler.HubObservationHandler;
import com.broadcom.observabilitydemo.post.JsonPlaceholderService;
import com.broadcom.observabilitydemo.post.Post;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class ObservabilityDemoApplication {
	private static Logger log = LoggerFactory.getLogger(ObservabilityDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ObservabilityDemoApplication.class, args);
	}

	@Bean
	JsonPlaceholderService jsonPlaceholderService(){
		ObservationRegistry registry = ObservationRegistry.create();
		registry.observationConfig().observationHandler(new HubObservationHandler());

		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build() ;
	    return  factory.createClient(JsonPlaceholderService.class);
	}

	@Bean
	@Observed(name = "posts.load-all-posts", contextualName = "post-service.find-all")
	CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, ObservationRegistry observationRegistry) {
		return args -> {
//			Observation.createNotStarted("posts.load-all-posts", observationRegistry).
//					lowCardinalityKeyValue("author","Manoj R")
//					.contextualName("post-service.find-all")
//					.observe(jsonPlaceholderService::findAll);
 				List<Post> posts = jsonPlaceholderService.findAll();
				 log.info("All posts: {}", posts);
		};
	}
}
