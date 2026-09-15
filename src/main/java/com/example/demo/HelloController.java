package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {

	private final Counter pageCounter;

	@Autowired
	public HelloController(MeterRegistry registry) {
		this.pageCounter = Counter.builder("page.visits.total")
				.description("Total number of page visits")
				.register(registry);
	}

	@GetMapping("/")
	public String index() {
		pageCounter.increment();
		return "Greetings from Spring Boot! Visit count: " + (long) pageCounter.count();
	}

}