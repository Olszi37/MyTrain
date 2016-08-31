package com.olszi.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentID")
    private Long paymentID;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "type")
    private PaymentType type;

    @Column(name = "status")
    private PaymentStatus status;

    public Payment(BigDecimal cost, PaymentType type, PaymentStatus status) {
        this.cost = cost;
        this.type = type;
        this.status = status;
    }

    public Payment() {
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
