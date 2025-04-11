package com.mikipmax.controlador;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequestMapping("/idiomas")
@RequiredArgsConstructor
public class IdiomaController {

    private final LocaleResolver localeResolver;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @GetMapping("/localizacion/{localizacion}")
    public ResponseEntity<Void> cambiarIdioma(@PathVariable String localizacion) {
        Locale usuarioLocalizacion = switch (localizacion) {
            case "en", "us" -> Locale.ENGLISH;
            case "fr" -> Locale.FRENCH;
            default -> Locale.ROOT;
        };

        localeResolver.setLocale(request, response, usuarioLocalizacion);
        return ResponseEntity.ok().build();
    }

}
