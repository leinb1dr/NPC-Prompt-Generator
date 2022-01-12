package com.dleinbach.npcprompt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@WebFluxTest(NpcPromptApplication.class)
class NpcPromptApplicationTests {

	@Autowired
	private WebTestClient client;

	@Test
	void healthCheck() {
//		client.get()
//				.uri("/actuator/health")
//				.exchange()
//				.expectStatus().is2xxSuccessful();
	}

}
