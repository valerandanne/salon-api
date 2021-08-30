package com.example.salonapi.repository;

import com.example.salonapi.model.Slot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class SlotRepository implements CrudRepository<Slot, Long> {
}
