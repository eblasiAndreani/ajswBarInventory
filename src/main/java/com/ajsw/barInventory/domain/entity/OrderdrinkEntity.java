package com.ajsw.barInventory.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orderdrink", schema = "geobar", catalog = "")
public class OrderdrinkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "idOrder")
    private Integer idOrder;
    @Basic
    @Column(name = "idDrink")
    private Integer idDrink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(Integer idDrink) {
        this.idDrink = idDrink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdrinkEntity that = (OrderdrinkEntity) o;
        return id == that.id && Objects.equals(amount, that.amount) && Objects.equals(idOrder, that.idOrder) && Objects.equals(idDrink, that.idDrink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, idOrder, idDrink);
    }
}
