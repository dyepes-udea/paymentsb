package com.davidrotabor.paymentsB.service;

import com.davidrotabor.paymentsB.entity.PaymentStatus;
import com.davidrotabor.paymentsB.repository.PaymentStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentStatusService {

    private final PaymentStatusRepository paymentStatusRepository;

    public PaymentStatusService(PaymentStatusRepository paymentStatusRepository) {
        this.paymentStatusRepository = paymentStatusRepository;
    }

    public List<PaymentStatus> getAllPaymentStatus() {
        return paymentStatusRepository.findAll();
    }

    public PaymentStatus getPaymentStatusById(Long id) {
        return paymentStatusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    public PaymentStatus addPaymentStatus(String StatusName, String message) {
        PaymentStatus paymentStatus = new PaymentStatus();

        paymentStatus.setStatusName(StatusName);
        paymentStatus.setMessage(message);

        return paymentStatusRepository.save(paymentStatus);
    }

}
