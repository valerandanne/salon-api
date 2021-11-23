package com.example.salonapi.service;

import com.example.salonapi.entity.SalonServiceDetail;
import com.example.salonapi.entity.Slot;
import com.example.salonapi.repository.SalonServiceDetailsRepository;
import com.example.salonapi.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SalonServicesService {

    private final SalonServiceDetailsRepository salonServiceDetailsRepository;
    private final SlotRepository slotRepository;

    public SalonServicesService(SalonServiceDetailsRepository salonServiceDetailsRepository, SlotRepository slotRepository) {
        this.salonServiceDetailsRepository = salonServiceDetailsRepository;
        this.slotRepository = slotRepository;
    }

    public Iterable<SalonServiceDetail> fetchAllSalonServices() {
        return salonServiceDetailsRepository.findAll();
    }

    public Iterable<Slot> fetchSlotsForService(int serviceId, LocalDate formattedDate) {
        return slotRepository.findAvailableSlotByService(serviceId, formattedDate);
    }
}
