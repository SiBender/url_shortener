package net.bondarik.urlshortener.controller;

import net.bondarik.urlshortener.model.OriginalUrl;
import net.bondarik.urlshortener.model.ShortUrl;
import net.bondarik.urlshortener.service.ShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UrlShortener {
    private ShorteningService shorteningService;

    @Autowired
    public UrlShortener(ShorteningService shorteningService) {
        this.shorteningService = shorteningService;
    }

    @GetMapping("/")
    public String sayHello () {
        return "hello, world!";
    }

    @GetMapping("/{shortURL}")
    public OriginalUrl getFullURL(@PathVariable String shortURL) {
        return shorteningService.getOriginalUrl(shortURL);
    }

    @PostMapping(value = "/")
    public ShortUrl getShortURL(@RequestBody @Valid OriginalUrl request) {
        return shorteningService.createShortUrl(request);
    }
}
