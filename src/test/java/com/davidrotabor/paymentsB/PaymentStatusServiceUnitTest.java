package com.davidrotabor.paymentsB;

import com.davidrotabor.paymentsB.entity.PaymentStatus;
import com.davidrotabor.paymentsB.repository.PaymentStatusRepository;
import com.davidrotabor.paymentsB.service.PaymentStatusService;

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
public class PaymentStatusServiceUnitTest {

    @Mock
    private PaymentStatusRepository paymentStatusRepository;

    @InjectMocks
    private PaymentStatusService paymentStatusService;

    @Test
    public void testGetAllPaymentStatus() {
        // Simulamos una lista de estados de pago
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setStatusName("Completed");
        when(paymentStatusRepository.findAll()).thenReturn(List.of(paymentStatus));

        // Ejecutamos el método del servicio
        List<PaymentStatus> result = paymentStatusService.getAllPaymentStatus();

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Completed", result.get(0).getStatusName());
    }

    @Test
    public void testGetPaymentStatusById() {
        // Simulamos la búsqueda de un estado de pago por ID
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setStatusName("Completed");
        when(paymentStatusRepository.findById(1L)).thenReturn(Optional.of(paymentStatus));

        // Ejecutamos el método del servicio
        PaymentStatus result = paymentStatusService.getPaymentStatusById(1L);

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals("Completed", result.getStatusName());
    }
}
