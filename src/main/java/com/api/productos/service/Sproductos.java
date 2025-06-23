/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.productos.service;

import com.api.productos.models.ModelProductos;
import com.api.productos.repository.Iproductos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Sproductos 
{
    @Autowired
    Iproductos iproductos;
    
    public ModelProductos BuscarNombreProducto(String nombreproducto)
    {
        return iproductos.findByNombre(nombreproducto);
    }
    
    public ModelProductos BuscarIdPorducto(Long idproducto)
    {
        return iproductos.findByIdproducto(idproducto);
    }
    
    public ModelProductos Guardar(ModelProductos mp)
    {
        return iproductos.save(mp);
    }
    
    public ModelProductos Actualizar(ModelProductos mp)
    {
        return iproductos.save(mp);
    }
    
    public void Eliminar(ModelProductos mp)
    {
        iproductos.delete(mp);
    }
    
    public List<ModelProductos> Listar()
    {
        return iproductos.findAll();
    }
    
}
