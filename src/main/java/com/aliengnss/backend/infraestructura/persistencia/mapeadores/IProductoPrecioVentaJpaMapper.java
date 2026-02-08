package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoPrecioVentaJpa;

@Mapper(componentModel = "spring")
public interface IProductoPrecioVentaJpaMapper {
	@Mapping(source = "producto.idProducto", target = "idProducto")
    ProductoPrecioVenta toDomain(ProductoPrecioVentaJpa entity);

    @Mapping(target = "producto", expression = "java(productoFromId(domain.getIdProducto()))")
    ProductoPrecioVentaJpa toEntity(ProductoPrecioVenta domain);

    default ProductoJpa productoFromId(Long idProducto) {
        if (idProducto == null) return null;
        ProductoJpa p = new ProductoJpa();
        p.setIdProducto(idProducto);
        return p;
    }
}
