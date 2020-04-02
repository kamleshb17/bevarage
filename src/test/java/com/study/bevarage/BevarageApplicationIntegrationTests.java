package com.study.bevarage;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Profiles;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BevarageApplicationTests.class} , initializers = ConfigFileApplicationContextInitializer.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class BevarageApplicationIntegrationTests {
}