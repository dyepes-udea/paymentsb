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

    public long getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @OneToMany(mappedBy = "paymentStatus", cascade = CascadeType.ALL)
    private List<Payment> payments;

}