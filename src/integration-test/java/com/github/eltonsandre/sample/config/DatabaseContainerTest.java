package com.github.eltonsandre.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.util.SocketUtils;
import org.testcontainers.containers.MongoDBContainer;

import java.util.List;

/**
 * @author eltonsandre
 */
@Slf4j
public class DatabaseContainerTest {

    public static final MongoDBContainer CONTAINER;

    public static final String DOCKER_IMAGE_NAME = "mongo:latest"; //"mongo:4.0.10";
    public static final int INTERNAL_PORT = 27017;
    public static final int PORT;

    public static final String MONGO_INITDB_ROOT_USERNAME = "MONGO_INITDB_ROOT_USERNAME";
    public static final String MONGO_INITDB_ROOT_PASSWORD = "MONGO_INITDB_ROOT_PASSWORD";

    static {
        PORT = SocketUtils.findAvailableTcpPort(28000, 29999);
        System.setProperty("testcontainer.container.port-binding", String.valueOf(PORT));

        CONTAINER = new MongoDBContainer(DOCKER_IMAGE_NAME);
        CONTAINER.addEnv(MONGO_INITDB_ROOT_USERNAME, "root");
        CONTAINER.addEnv(MONGO_INITDB_ROOT_PASSWORD, "root");
        CONTAINER.setPortBindings(List.of(PORT + ":" + INTERNAL_PORT));

        log.info("Container {} created", DOCKER_IMAGE_NAME);
    }

    //@DynamicPropertySource
    public static void regitryProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", DatabaseContainerTest.CONTAINER::getReplicaSetUrl);
        registry.add("spring.data.mongodb.username", () -> DatabaseContainerTest.MONGO_INITDB_ROOT_USERNAME);
        registry.add("spring.data.mongodb.password", () -> DatabaseContainerTest.MONGO_INITDB_ROOT_USERNAME);
    }


    public static void start() {
        CONTAINER.start();
        log.info("Container {} running", DOCKER_IMAGE_NAME);
    }

    public static boolean stop() {
        CONTAINER.stop();
        log.info("Container {} stopped", DOCKER_IMAGE_NAME);
        return CONTAINER.isRunning();
    }

}
