package com.example.salonapi.repository;

import com.example.salonapi.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query(value = "select * from slot inner join slot_available_services on slot.id = slot_available_services.slot_id " +
                    "where slot_available_services.available_services_id = ?1 AND slot.id in " +
                    "(select id from slot where CAST(slot_for as Date) = ?2 AND status = 0)", nativeQuery = true)
    List<Slot> findAvailableSlotByService(int serviceId, LocalDate formattedDate);
}
