package com.aliengnss.backend.aplicacion.casosuso.entrada;

import com.aliengnss.backend.dominio.entidades.Usuario;

public interface ILoginUseCase {

	Usuario autenticar(String correoElectronico, String clave);
}
