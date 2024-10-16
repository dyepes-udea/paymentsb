package com.davidrotabor.paymentsB.controller;

import com.davidrotabor.paymentsB.entity.Payment;
import com.davidrotabor.paymentsB.service.PaymentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @QueryMapping
    @CrossOrigin(origins = "http://localhost:3000")
    private List<Payment> allPayments() {
        return paymentService.getAllPayments();
    }

    @QueryMapping
    private Payment paymentById(@Argument Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @MutationMapping
    private Payment addPayment(
            @Argument Long cardId,
            @Argument Long paymentMethodId,
            @Argument Long paymentStatusId,
            @Argument String flightId,
            @Argument String paymentReference,
            @Argument Double amount
    ) {
        System.out.println("Llega acaaa 2");
        return paymentService.addPayment(cardId, paymentMethodId, paymentStatusId, flightId, paymentReference, amount);
    }
    
}
