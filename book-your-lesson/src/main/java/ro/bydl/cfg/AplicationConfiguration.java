package ro.bydl.cfg;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.dao.database.JdbcTemplateScheduleeDao;

@Configuration
public class AplicationConfiguration {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");

		String url = new StringBuilder().append("jdbc:").append("postgresql").append("://").append("ec2-54-228-189-38.eu-west-1.compute.amazonaws.com")
				.append(":").append("5432").append("/").append("d2bqaqj3ktrgeu").toString();

		dataSource.setUrl( "//eusarymvdtcbzu:pyXvv8ueit19S_m4aNbZzWuD7x@ec2-54-228-189-38.eu-west-1.compute.amazonaws.com:5432/d2bqaqj3ktrgeu");
		dataSource.setUsername("eusarymvdtcbzu");
		dataSource.setPassword("pyXvv8ueit19S_m4aNbZzWuD7x");
		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());

	}

	@Bean
	public ScheduleDAO scheduleDAO() {

		return new JdbcTemplateScheduleeDao();

	}
}
