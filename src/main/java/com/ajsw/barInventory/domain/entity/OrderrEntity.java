package com.ajsw.barInventory.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orderr", schema = "geobar", catalog = "")
public class OrderrEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "PartialPrice")
    private Integer partialPrice;
    @Basic
    @Column(name = "observation")
    private String observation;
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

    public Integer getPartialPrice() {
        return partialPrice;
    }

    public void setPartialPrice(Integer partialPrice) {
        this.partialPrice = partialPrice;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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
        return id == that.id && Objects.equals(partialPrice, that.partialPrice) && Objects.equals(observation, that.observation) && Objects.equals(idTable, that.idTable) && Objects.equals(idPayment, that.idPayment) && Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partialPrice, observation, idTable, idPayment, idUsuario);
    }
}
