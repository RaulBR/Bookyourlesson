package ro.bydl.cfg;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class AplicationConfiguration {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		//dataSource.setDriverClassName("org.postgresql.Driver");

		String url = new StringBuilder().append("jdbc:").append("postgresql").append("://").append("ec2-54-228-189-38.eu-west-1.compute.amazonaws.com")
				.append(":").append("5432").append("/").append("d2bqaqj3ktrgeu").toString();

		dataSource.setUrl(url);
		dataSource.setUsername("eusarymvdtcbzu");
		dataSource.setPassword("pyXvv8ueit19S_m4aNbZzWuD7x");
		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());

	}



	
}

