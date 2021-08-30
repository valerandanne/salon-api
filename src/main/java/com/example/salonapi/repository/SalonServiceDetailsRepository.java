package com.example.salonapi.repository;

import com.example.salonapi.model.SalonServiceDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class SalonServiceDetailsRepository implements CrudRepository<SalonServiceDetail, Long> {
}
