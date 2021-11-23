package com.example.salonapi.repository;

import com.example.salonapi.entity.SalonServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonServiceDetailsRepository extends JpaRepository<SalonServiceDetail, Long> {
}
