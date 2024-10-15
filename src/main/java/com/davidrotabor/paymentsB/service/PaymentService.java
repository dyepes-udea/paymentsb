package com.davidrotabor.paymentsB.service;
import com.davidrotabor.paymentsB.entity.Card;
import com.davidrotabor.paymentsB.entity.Payment;
import com.davidrotabor.paymentsB.entity.PaymentMethod;
import com.davidrotabor.paymentsB.entity.PaymentStatus;
import com.davidrotabor.paymentsB.repository.CardRepository;
import com.davidrotabor.paymentsB.repository.PaymentMethodRepository;
import com.davidrotabor.paymentsB.repository.PaymentRepository;
import com.davidrotabor.paymentsB.repository.PaymentStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private final PaymentRepository paymentRepository;
    private final CardRepository cardRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentStatusRepository paymentStatusRepository;

    public PaymentService(PaymentRepository PaymentRepository, CardRepository cardRepository, PaymentMethodRepository paymentMethodRepository, PaymentStatusRepository paymentStatusRepository) {
        this.paymentRepository = PaymentRepository;
        this.cardRepository = cardRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentStatusRepository = paymentStatusRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    public Payment addPayment(Long cardId, Long paymentMethodId, Long paymentStatusId, String flightId, String paymentReference, Double amount) {

        Card card = cardRepository.findById(cardId).orElseThrow(() -> new IllegalArgumentException("Card not found"));
        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId).orElseThrow(() -> new IllegalArgumentException("PaymentMethod not found"));
        PaymentStatus paymentStatus = paymentStatusRepository.findById(paymentStatusId).orElseThrow(() -> new IllegalArgumentException("PaymentStatus not found"));



        Payment payment = new Payment();
        payment.setCard(card);
        payment.setPaymentMethod(paymentMethod);
        payment.setPaymentStatus(paymentStatus);
        payment.setFlightId(flightId);
        payment.setPaymentReference(paymentReference);
        payment.setAmount(amount);

        return paymentRepository.save(payment);

    }


}
