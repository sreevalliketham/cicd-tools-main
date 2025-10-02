package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "aid")
    private String aid;

    @Column(name = "street")
    private String street;

    @Column(name = "citi")
    private String citi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "onetoone", "addresses" }, allowSetters = true)
    private Address onetoone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "onetoone")
    @JsonIgnoreProperties(value = { "onetoone", "addresses" }, allowSetters = true)
    private Set<Address> addresses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Address id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAid() {
        return this.aid;
    }

    public Address aid(String aid) {
        this.setAid(aid);
        return this;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getStreet() {
        return this.street;
    }

    public Address street(String street) {
        this.setStreet(street);
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCiti() {
        return this.citi;
    }

    public Address citi(String citi) {
        this.setCiti(citi);
        return this;
    }

    public void setCiti(String citi) {
        this.citi = citi;
    }

    public Address getOnetoone() {
        return this.onetoone;
    }

    public void setOnetoone(Address address) {
        this.onetoone = address;
    }

    public Address onetoone(Address address) {
        this.setOnetoone(address);
        return this;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        if (this.addresses != null) {
            this.addresses.forEach(i -> i.setOnetoone(null));
        }
        if (addresses != null) {
            addresses.forEach(i -> i.setOnetoone(this));
        }
        this.addresses = addresses;
    }

    public Address addresses(Set<Address> addresses) {
        this.setAddresses(addresses);
        return this;
    }

    public Address addAddress(Address address) {
        this.addresses.add(address);
        address.setOnetoone(this);
        return this;
    }

    public Address removeAddress(Address address) {
        this.addresses.remove(address);
        address.setOnetoone(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        return getId() != null && getId().equals(((Address) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Address{" +
            "id=" + getId() +
            ", aid='" + getAid() + "'" +
            ", street='" + getStreet() + "'" +
            ", citi='" + getCiti() + "'" +
            "}";
    }
}
