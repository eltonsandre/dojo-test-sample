package com.github.eltonsandre.sample.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.eltonsandre.sample.config.WebClientTestConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @author eltonsandre
 */
@AutoConfigureMockMvc
@CucumberContextConfiguration
@AutoConfigureWireMock(port = 0)
@ActiveProfiles({"test", "cucumber"})
@SpringBootTest(webEnvironment = RANDOM_PORT,
        classes = {WebClientTestConfiguration.class})
public class SpringContextCucumber {

    @Autowired
    protected ObjectMapper jsonMapper;

    @Autowired
    protected WebTestClient webTestClient;

    protected ResultActions result;


}
