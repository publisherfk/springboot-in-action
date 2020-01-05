package com.heshi.auto.configuration.support;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kun
 */
@ConfigurationProperties(prefix = "hystrix.propagate.request-attribute")
public class HystrixRequestAttributeProperties {
    private Boolean enabled = Boolean.TRUE;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
