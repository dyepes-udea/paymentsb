package com.davidrotabor.paymentsB.controller;

import com.davidrotabor.paymentsB.entity.PaymentStatus;
import com.davidrotabor.paymentsB.service.PaymentStatusService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PaymentStatusController {

    private final PaymentStatusService paymentStatusService;

    public PaymentStatusController(PaymentStatusService paymentStatusService) {
        this.paymentStatusService = paymentStatusService;
    }

    @QueryMapping
    private List<PaymentStatus> allPaymentStatus() {
        return paymentStatusService.getAllPaymentStatus();
    }

    @QueryMapping
    private PaymentStatus paymentStatusById(@Argument Long paymentStatusId) {
        return paymentStatusService.getPaymentStatusById(paymentStatusId);
    }

    @MutationMapping
    private PaymentStatus addPaymentStatus(
            @Argument String statusName,
            @Argument String message) {

        return paymentStatusService.addPaymentStatus(statusName, message);
    }

}
