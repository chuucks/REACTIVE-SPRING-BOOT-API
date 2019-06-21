package com.codesolt.springbootreactive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextLoadTest {

	@Test
	public void contextLoads() {}

}

