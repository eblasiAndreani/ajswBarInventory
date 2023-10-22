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
    @Column(name = "reference")
    private String reference;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "dispose")
    private Byte dispose;
    @Basic
    @Column(name = "idBar")
    private Integer idBar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableeEntity that = (TableeEntity) o;
        return id == that.id && Objects.equals(reference, that.reference) && Objects.equals(image, that.image) && Objects.equals(dispose, that.dispose) && Objects.equals(idBar, that.idBar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, image, dispose, idBar);
    }
}
