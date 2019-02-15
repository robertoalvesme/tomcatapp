package br.com.rhfactor.tomcatapp;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SpringSessionAttributesPK implements Serializable {

    //@Column(name="SESSION_PRIMARY_ID", nullable = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "SESSION_PRIMARY_ID")
    private SpringSession springSession;

    @Column(name="ATTRIBUTE_NAME")
    private String attributeName;

    public SpringSession getSpringSession() {
        return springSession;
    }

    public void setSpringSession(SpringSession springSession) {
        this.springSession = springSession;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
