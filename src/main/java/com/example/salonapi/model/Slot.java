package com.example.salonapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String stylistName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    Set<SalonServiceDetail> availableServices;


    @ManyToOne
    private SalonServiceDetail selectedService;
    LocalDateTime slotFor;

    //private SlotStatus status;

    LocalDateTime lockedAt;
    LocalDateTime confirmedAt;
}
