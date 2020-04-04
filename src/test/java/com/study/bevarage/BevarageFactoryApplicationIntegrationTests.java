package com.study.bevarage;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {BevarageApplication.class} , initializers = ConfigFileApplicationContextInitializer.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class BevarageFactoryApplicationIntegrationTests {

    @Test
    public void contextLoads() {
    }
}
