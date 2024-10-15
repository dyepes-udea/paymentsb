package com.davidrotabor.paymentsB.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;
    private String cardNumber;
    private String cardCvc;
    private String cardType;
    private String cardHolderId;
    private String cardHolderName;
    private String expiryDate;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Payment> payments;

}
