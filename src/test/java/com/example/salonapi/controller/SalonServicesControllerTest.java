package com.example.salonapi.controller;

import com.example.salonapi.entity.Slot;
import com.example.salonapi.service.SalonServicesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalonServicesControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private SalonServicesController salonServicesController;
    @Mock
    private SalonServicesService salonServicesService;

    @LocalServerPort
    private int port;

    @Test
    public void serviceSlotsShouldReturnBadRequest() {
        assertThat(this.restTemplate.getForEntity("http://localhost:" + port  + "/api/services/retrieveAvailableSalonSlots/23/asd",
                Slot.class).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void serviceSlots() {
        assertThat(this.restTemplate.getForEntity("http://localhost:" + port  +
                "/api/services/retrieveAvailableSalonSlots/23/2020-12-06", Iterable.class).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}