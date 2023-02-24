package com.adesh.payment.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.payment.service.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
