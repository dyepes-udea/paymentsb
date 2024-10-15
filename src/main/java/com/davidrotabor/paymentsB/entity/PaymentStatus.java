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
@Table(name = "paymentStatus")
public class PaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentStatusId;
    private String statusName;
    private String message;

    @OneToMany(mappedBy = "paymentStatus", cascade = CascadeType.ALL)
    private List<Payment> payments;

}