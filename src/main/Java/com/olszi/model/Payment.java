package com.olszi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by MOlszi on 2016-08-31.
 */

@Entity(name = "payment")
@Table(name = "payment")
public class Payment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentID", nullable = false)
    private Long paymentID;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "type", nullable = false)
    private PaymentType type;

    @Column(name = "status", nullable = false)
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
