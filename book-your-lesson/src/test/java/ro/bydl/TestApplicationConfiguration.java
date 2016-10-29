package ro.bydl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ro.bydl.service.ScheduleServiceTest;
import ro.bydl.service.StudentService;


@Configuration
public class TestApplicationConfiguration {

	@Bean
	public ScheduleServiceTest scheduleService() {
		return new ScheduleServiceTest();
	}

	@Bean
	public StudentService studentService() {
		return new StudentService();
	}
	
	
}
