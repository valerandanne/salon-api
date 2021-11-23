package com.example.salonapi.controller;


import com.example.salonapi.entity.SalonServiceDetail;
import com.example.salonapi.entity.Slot;
import com.example.salonapi.service.SalonServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping(path = "/api/services", produces = "application/json")
@CrossOrigin(origins = "*")
public class SalonServicesController {

    private final SalonServicesService salonServicesService;

    @Autowired
    SalonServicesController(SalonServicesService salonServicesService) {
        this.salonServicesService = salonServicesService;
    }

    @GetMapping("/retrieveAvailableSalonServices")
    public Iterable<SalonServiceDetail> salonServices() {
        return salonServicesService.fetchAllSalonServices();
    }

    @GetMapping("/retrieveAvailableSalonSlots/{salonServiceId}/{formattedDate}")
    public ResponseEntity<Iterable<Slot>> serviceSlots(@PathVariable int salonServiceId, @PathVariable String formattedDate) {
        try {
            LocalDate date = LocalDate.parse(formattedDate);
            Iterable<Slot> availableSlotsForService = salonServicesService.fetchSlotsForService(salonServiceId, date);
            return new ResponseEntity<>(availableSlotsForService, HttpStatus.OK);
        } catch (DateTimeParseException dateTimeParseException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
