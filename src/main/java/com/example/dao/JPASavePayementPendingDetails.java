package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.PaymentPendingDetails;

public interface JPASavePayementPendingDetails  extends JpaRepository<PaymentPendingDetails, Integer>{

}
