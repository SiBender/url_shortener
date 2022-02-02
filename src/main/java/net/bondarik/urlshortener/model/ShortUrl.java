package net.bondarik.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortUrl {
    @JsonProperty("shortUrl")
    private String shortUrl;

    public ShortUrl() {
    }

    public ShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
