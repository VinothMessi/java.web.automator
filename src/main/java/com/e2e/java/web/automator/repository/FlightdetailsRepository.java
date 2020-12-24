package com.e2e.java.web.automator.repository;

import com.e2e.java.web.automator.entity.Flightdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightdetailsRepository extends JpaRepository<Flightdetails, Integer> {
}