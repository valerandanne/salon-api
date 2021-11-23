package com.example.salonapi.entity;

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
    private Long Id;
    private String stylistName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<SalonServiceDetail> availableServices;


    @ManyToOne
    private SalonServiceDetail selectedService;
    private LocalDateTime slotFor;

    //private SlotStatus status;

    private LocalDateTime lockedAt;
    private LocalDateTime confirmedAt;
}
