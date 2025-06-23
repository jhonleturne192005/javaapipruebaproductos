/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.productos.repository;

import com.api.productos.models.ModelProductos;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public interface Iproductos extends JpaRepository<ModelProductos,Serializable>
{
    public ModelProductos findByIdproducto(Long idproducto);    
    public ModelProductos findByNombre(String nombreproducto);    
}
