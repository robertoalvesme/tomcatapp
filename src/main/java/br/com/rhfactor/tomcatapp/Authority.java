package br.com.rhfactor.tomcatapp;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {

    YES("yes");

    private final String description;

    Authority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getAuthority() {
        return this.getDescription();
    }
}
