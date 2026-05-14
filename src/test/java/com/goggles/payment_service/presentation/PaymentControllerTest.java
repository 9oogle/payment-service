package com.goggles.payment_service.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles({"kafka", "topics", "local"})
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void loggedUserTest() throws Exception{
        mockMvc.perform(get("/test")
                .header("X-User-Id", "d63613a0-3aa1-4545-b0cc-a9a45519b77e")
                .header("X-User-Name", "Test")
                .header("X-User-Email", "test@test.com")
                .header("X-User-Role", "MASTER")
        ).andDo(print());
    }
}
