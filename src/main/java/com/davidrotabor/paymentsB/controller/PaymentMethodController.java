package com.davidrotabor.paymentsB.controller;

import com.davidrotabor.paymentsB.entity.PaymentMethod;
import com.davidrotabor.paymentsB.service.PaymentMethodService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @QueryMapping
    private List<PaymentMethod> allPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @QueryMapping
    private PaymentMethod PaymentMethodById(@Argument Long paymentMethodId) {
        return paymentMethodService.getPaymentMethodById(paymentMethodId);
    }

    @MutationMapping
    private PaymentMethod addPaymentMethod(
                                           @Argument String methodName,
                                           @Argument String urlImage,
                                           @Argument Boolean active,
                                           @Argument String referenceCode) {

        return paymentMethodService.addPaymentMethod(methodName, urlImage, active, referenceCode);
    }

}
