package com.davidrotabor.paymentsB;
import com.davidrotabor.paymentsB.entity.Card;
import com.davidrotabor.paymentsB.repository.CardRepository;
import com.davidrotabor.paymentsB.service.CardService;

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
public class CardServiceUnitTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    public void testGetAllCards() {
        // Simulamos el comportamiento del repositorio
        Card card = new Card();
        card.setCardNumber("1234-5678-9123-4567");
        when(cardRepository.findAll()).thenReturn(List.of(card));

        // Ejecutamos el método del servicio
        List<Card> result = cardService.getAllCards();

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("1234-5678-9123-4567", result.get(0).getCardNumber());
    }

    @Test
    public void testGetCardById() {
        // Simulamos el comportamiento del repositorio
        Card card = new Card();
        card.setCardNumber("1234-5678-9123-4567");
        when(cardRepository.findById(1L)).thenReturn(Optional.of(card));

        // Ejecutamos el método del servicio
        Card result = cardService.getCardById(1L);

        // Verificamos el resultado
        assertNotNull(result);
        assertEquals("1234-5678-9123-4567", result.getCardNumber());
    }
}
