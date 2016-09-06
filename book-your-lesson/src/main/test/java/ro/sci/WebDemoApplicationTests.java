package ro.sci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ro.bydl.WebDemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebDemoApplication.class)
@WebAppConfiguration
public class WebDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
