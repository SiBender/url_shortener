package net.bondarik.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.URL;

public class OriginalUrl {
    @JsonProperty("originalUrl")
    @URL(message = "Please enter correct URL")
    private String originalUrl;

    public OriginalUrl() {
    }

    public OriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
