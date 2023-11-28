package com.ajsw.barInventory.domain.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orderr", schema = "geobar", catalog = "")
public class OrderrEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "partialPrice")
    private Double partialPrice;
    @Basic
    @Column(name = "fechaAlta")
    private Timestamp fechaAlta;
    @Basic
    @Column(name = "idTable")
    private Integer idTable;
    @Basic
    @Column(name = "idPayment")
    private Integer idPayment;
    @Basic
    @Column(name = "idUsuario")
    private Integer idUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPartialPrice() {
        return partialPrice;
    }

    public void setPartialPrice(Double partialPrice) {
        this.partialPrice = partialPrice;
    }
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderrEntity that = (OrderrEntity) o;
        return id == that.id && Objects.equals(partialPrice, that.partialPrice) && Objects.equals(idTable, that.idTable) && Objects.equals(idPayment, that.idPayment) && Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partialPrice, fechaAlta, idTable, idPayment, idUsuario);
    }
}
