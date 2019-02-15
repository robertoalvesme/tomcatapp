package br.com.rhfactor.tomcatapp;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="SPRING_SESSION", indexes = {
        @Index(name = "SPRING_SESSION_IX2", columnList = "EXPIRY_TIME"),
        @Index(name = "SPRING_SESSION_IX3", columnList = "PRINCIPAL_NAME")
})
public class SpringSession {
    @Id
    @Column(name="PRIMARY_ID",nullable = false)
    private String primaryId;

    @Column(name="SESSION_ID", unique = true , nullable = false)
    private String sessionId;

    @Column(name="CREATION_TIME",nullable = false)
    private Long createionTime;

    @Column(name="LAST_ACCESS_TIME",nullable = false)
    private Long lastAccessTime;

    @Column(name="MAX_INACTIVE_INTERVAL",nullable = false)
    private Integer maxInactiveInterval;

    @Column(name="EXPIRY_TIME",nullable = false)
    private String expiryTime;

    @Column(name="PRINCIPAL_NAME")
    private String principalName;

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getCreateionTime() {
        return createionTime;
    }

    public void setCreateionTime(Long createionTime) {
        this.createionTime = createionTime;
    }

    public Long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(Integer maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }
}


