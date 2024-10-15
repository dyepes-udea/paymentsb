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
@Table(name = "paymentMethod")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentMethodId;
    private String methodName;
    private String urlImage;
    private boolean active;
    private String referenceCode;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    private List<Payment> payments;

}