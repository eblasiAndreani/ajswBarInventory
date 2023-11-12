package com.ajsw.barInventory.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tablee", schema = "geobar", catalog = "")
public class TableeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "dispose")
    private Byte dispose;
    @Basic
    @Column(name = "idBar")
    private Integer idBar;
    @Basic
    @Column(name = "chair")
    private int chair;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getDispose() {
        return dispose;
    }

    public void setDispose(Byte dispose) {
        this.dispose = dispose;
    }

    public Integer getIdBar() {
        return idBar;
    }

    public void setIdBar(Integer idBar) {
        this.idBar = idBar;
    }

    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableeEntity that = (TableeEntity) o;
        return id == that.id && chair == that.chair && Objects.equals(dispose, that.dispose) && Objects.equals(idBar, that.idBar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dispose, idBar, chair);
    }
}
