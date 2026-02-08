package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import java.util.Base64;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class Base64Mapper {

    @Named("bytesToBase64")
    public String bytesToBase64(byte[] bytes) {
        if (bytes == null || bytes.length == 0) return null;
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Named("base64ToBytes")
    public byte[] base64ToBytes(String base64) {
        if (base64 == null || base64.isBlank()) return null;

        // soporta data:image/png;base64,....
        String b64 = base64;
        int comma = b64.indexOf(',');
        if (comma >= 0) b64 = b64.substring(comma + 1);

        return Base64.getDecoder().decode(b64);
    }
}