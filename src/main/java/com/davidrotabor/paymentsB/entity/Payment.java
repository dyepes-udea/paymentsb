package com.davidrotabor.paymentsB.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private String flightId;
    private String paymentReference;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "paymentMethodId")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "paymentStatusId")
    private PaymentStatus paymentStatus;

}
