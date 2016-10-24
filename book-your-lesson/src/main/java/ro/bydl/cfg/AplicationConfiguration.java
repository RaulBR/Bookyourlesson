package ro.bydl.cfg;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import ro.bydl.dao.ScheduleDAO;
import ro.bydl.dao.database.JdbcTemplateScheduleDAO;

@Configuration
public class AplicationConfiguration {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");

		String url = new StringBuilder().append("jdbc:").append("postgresql").append("://").append("localhost")
				.append(":").append("5432").append("/").append("bydl").toString();

		dataSource.setUrl(url);
		dataSource.setUsername("postgres");
		dataSource.setPassword("serpentina");
		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());

	}

	@Bean
	public ScheduleDAO scheduleDAO() {

		return new JdbcTemplateScheduleDAO();

	}
}
