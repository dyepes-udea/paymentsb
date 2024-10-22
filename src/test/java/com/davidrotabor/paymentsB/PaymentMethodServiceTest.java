package com.davidrotabor.paymentsB;

import com.davidrotabor.paymentsB.entity.PaymentMethod;
import com.davidrotabor.paymentsB.repository.PaymentMethodRepository;
import com.davidrotabor.paymentsB.service.PaymentMethodService;

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
public class PaymentMethodServiceTest {

    @Mock
    private PaymentMethodRepository paymentMethodRepository;

    @InjectMocks
    private PaymentMethodService paymentMethodService;

    @Test
    public void testGetAllPaymentMethods() {
        // Simulamos una lista de métodos de pago
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setMethodName("Visa");
        when(paymentMethodRepository.findAll()).thenReturn(List.of(paymentMethod));

        // Ejecutamos el método del servicio
        List<PaymentMethod> result = paymentMethodService.getAllPaymentMethods();

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Visa", result.get(0).getMethodName());
    }

    @Test
    public void testGetPaymentMethodById() {
        // Simulamos la búsqueda de un método de pago por ID
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setMethodName("MasterCard");
        when(paymentMethodRepository.findById(1L)).thenReturn(Optional.of(paymentMethod));

        // Ejecutamos el método del servicio
        PaymentMethod result = paymentMethodService.getPaymentMethodById(1L);

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals("MasterCard", result.getMethodName());
    }
}
