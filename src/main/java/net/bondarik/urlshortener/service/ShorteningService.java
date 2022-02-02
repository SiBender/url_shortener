package net.bondarik.urlshortener.service;

import net.bondarik.urlshortener.codec.Codec;
import net.bondarik.urlshortener.dao.ShorteningDAO;
import net.bondarik.urlshortener.model.OriginalUrl;
import net.bondarik.urlshortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ShorteningService {
    private Codec codec;
    private ShorteningDAO shorteningDAO;

    @Autowired
    public ShorteningService(Codec codec, ShorteningDAO shorteningDAO) {
        this.codec = codec;
        this.shorteningDAO = shorteningDAO;
    }

    public ShortUrl createShortUrl(OriginalUrl request) {
        String encodedId = codec.encode(shorteningDAO.createNewUrl(request.getOriginalUrl()));
        return new ShortUrl(getServerRootUrl() + "/" + encodedId);
    }

    public OriginalUrl getOriginalUrl(String encodedId) {
        Long decodedId = codec.decode(encodedId);
        return new OriginalUrl(shorteningDAO.getOriginalUrl(decodedId));
    }

    private String getServerRootUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    }
}
