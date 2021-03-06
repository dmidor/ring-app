package com.ring.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ring {

    @Id
    private String ringId;

    private String ownerId;

    private String name;

    public String getRingId() {
        return ringId;
    }

    public void setRingId(String ringId) {
        this.ringId = ringId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
