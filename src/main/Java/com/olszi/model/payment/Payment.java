package com.olszi.model.payment;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by MOlszi on 2016-08-24.
 */

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentID")
    private Long paymentID;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "type")
    private PaymentType type;

    @Column(name = "status")
    private PaymentStatus status;

    public Payment(LocalDateTime time, PaymentType type, PaymentStatus status) {
        this.time = time;
        this.type = type;
        this.status = status;
    }

    public Payment() {
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
