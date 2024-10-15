package com.davidrotabor.paymentsB.service;

import com.davidrotabor.paymentsB.entity.PaymentMethod;
import com.davidrotabor.paymentsB.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    public PaymentMethod addPaymentMethod(String methodName, String urlImage, Boolean active,  String referenceCode) {
        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setMethodName(methodName);
        paymentMethod.setUrlImage(urlImage);
        paymentMethod.setActive(active);
        paymentMethod.setReferenceCode(referenceCode);

        return paymentMethodRepository.save(paymentMethod);
    }

}
