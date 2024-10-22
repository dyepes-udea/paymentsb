package com.davidrotabor.paymentsB;

import com.davidrotabor.paymentsB.entity.Payment;

import com.davidrotabor.paymentsB.repository.CardRepository;
import com.davidrotabor.paymentsB.repository.PaymentMethodRepository;
import com.davidrotabor.paymentsB.repository.PaymentRepository;
import com.davidrotabor.paymentsB.repository.PaymentStatusRepository;
import com.davidrotabor.paymentsB.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceUnitTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private PaymentMethodRepository paymentMethodRepository;

    @Mock
    private PaymentStatusRepository paymentStatusRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testGetAllPayments() {
        // Simulamos una lista de pagos
        Payment payment = new Payment();
        payment.setPaymentReference("REF123");
        when(paymentRepository.findAll()).thenReturn(List.of(payment));

        // Ejecutamos el método del servicio
        List<Payment> result = paymentService.getAllPayments();

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("REF123", result.get(0).getPaymentReference());
    }

    @Test
    public void testGetPaymentById() {
        // Simulamos la búsqueda de un pago por ID
        Payment payment = new Payment();
        payment.setPaymentReference("REF123");
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        // Ejecutamos el método del servicio
        Payment result = paymentService.getPaymentById(1L);

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals("REF123", result.getPaymentReference());
    }
}
