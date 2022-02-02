package net.bondarik.urlshortener.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShorteningDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShorteningDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long createNewUrl(String originalUrl) {
        return jdbcTemplate.queryForObject("INSERT INTO urls (url) VALUES (?) RETURNING id", Long.class, originalUrl);
    }

    public String getOriginalUrl(long id) {
        String originalUrl = null;
        try {
            originalUrl = jdbcTemplate.queryForObject("SELECT url FROM urls WHERE id = ?", String.class, id);
        } catch (EmptyResultDataAccessException e) {
            //do nothing
        }
        return originalUrl;
    }
}
