package com.github.eltonsandre.sample.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.SocketUtils;

/**
 * @author eltonsandre
 */
@Slf4j
public class WireMockConfig {
    public static final WireMockServer wireMockServer;
    public static final int PORT;

    static {
        PORT = SocketUtils.findAvailableTcpPort(28000, 29999);
        System.setProperty("wiremock.server.port", String.valueOf(PORT));

        var wireMockConfiguration = WireMockConfiguration.wireMockConfig()
                .port(PORT)
                .notifier(new ConsoleNotifier(true));

        wireMockServer = new WireMockServer(wireMockConfiguration);
    }

    public static void start() {
        wireMockServer.start();
        log.info("wireMock stated in port={}", PORT);

        WireMock.configureFor("localhost", PORT);
        WireMock.reset();
    }

    public static void stop() {
        if (wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }

}
