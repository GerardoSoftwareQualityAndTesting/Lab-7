package mx.tec.lab.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.dto.Greeting;

@RestController
public class GoodbyeRestController {
	private static final String template = "Goodbye, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/goodbye")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "see you later") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
