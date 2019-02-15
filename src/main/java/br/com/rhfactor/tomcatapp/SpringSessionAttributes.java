package br.com.rhfactor.tomcatapp;

import javax.persistence.*;

@Entity
@Table(name="SPRING_SESSION_ATTRIBUTES")
public class SpringSessionAttributes {

    @EmbeddedId
    private SpringSessionAttributesPK id;

    @Lob
    @Column(name="ATTRIBUTE_BYTES", columnDefinition="BLOB")
    private byte[] attributeBytes;

    public SpringSessionAttributesPK getId() {
        return id;
    }

    public void setId(SpringSessionAttributesPK id) {
        this.id = id;
    }

    public byte[] getAttributeBytes() {
        return attributeBytes;
    }

    public void setAttributeBytes(byte[] attributeBytes) {
        this.attributeBytes = attributeBytes;
    }
}
