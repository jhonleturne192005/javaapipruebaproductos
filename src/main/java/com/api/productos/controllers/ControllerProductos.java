/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.productos.controllers;

import com.api.productos.models.ModelProductos;
import com.api.productos.service.Sproductos;
import com.api.productos.utils.Messages;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ControllerProductos
{

    
    @Autowired
    Sproductos sproductos;
    
    @GetMapping("/")
    public ResponseEntity<?> ListarPorductos()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            response.put(Messages.DATA, sproductos.Listar());
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, Messages.ERROR_SISTEMA);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK); 
    }
    
    
    @PostMapping("/save")
    public ResponseEntity<?> guardarProducto(@RequestBody ModelProductos modelproducto)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(modelproducto.getNombre()!="" && modelproducto.getPrecio()!=0f && modelproducto.getCantidad()!=0)
            {
                sproductos.Guardar(modelproducto);
                response.put(Messages.SUCCESSFUL_KEY, Messages.DATOS_GUARDADOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK); 
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.ERROR_DATOS_INCOMPLETOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
            }
        }     
        catch(Exception ex)
        {
            System.out.println("ERROR= "+ex.getMessage());
            String error=ex.getMessage();
            
            if(error.contains(Messages.EX_PRODUCTO_EXISTENTE))
                response.put(Messages.ERROR_KEY, Messages.NOMBRE_PRODUCTO_EXISTENTE);
            else
                response.put(Messages.ERROR_KEY, Messages.ERROR_SISTEMA);
            
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    
    
    @GetMapping("/buscarid/{id}")
    public ResponseEntity<?> buscarProductoId(@PathVariable Long id)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(id!=null && id!=0)
            {
                response.put(Messages.DATA, sproductos.BuscarIdPorducto(id));
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK); 
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.ERROR_DATOS_INCOMPLETOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
            }
        }     
        catch(Exception ex)
        {
            System.out.println("ERROR= "+ex.getMessage());
            String error=ex.getMessage();
            response.put(Messages.ERROR_KEY, Messages.ERROR_SISTEMA);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/buscarname/{name}")
    public ResponseEntity<?> buscarProductoName(@PathVariable String name)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(name!="")
            {
                response.put(Messages.DATA, sproductos.BuscarNombreProducto(name));
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK); 
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.ERROR_DATOS_INCOMPLETOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
            }
        }     
        catch(Exception ex)
        {
            System.out.println("ERROR= "+ex.getMessage());
            String error=ex.getMessage();
            response.put(Messages.ERROR_KEY, Messages.ERROR_SISTEMA);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    
    
    
    
    
    
    
    
    @PutMapping ("/actualizar")
    public ResponseEntity<?> actualizarProducto(@RequestBody ModelProductos modelproducto)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(modelproducto.getIdproducto()!=0L && modelproducto.getNombre()!="" && modelproducto.getPrecio()!=0f && modelproducto.getCantidad()!=0)
            {
                ModelProductos fn=sproductos.BuscarIdPorducto(modelproducto.getIdproducto());
                fn.setNombre(modelproducto.getNombre());
                fn.setCantidad(modelproducto.getCantidad());
                fn.setPrecio(modelproducto.getPrecio());
                sproductos.Actualizar(fn);
                response.put(Messages.SUCCESSFUL_KEY, Messages.DATOS_ACTUALIZADOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK); 
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.ERROR_DATOS_INCOMPLETOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
            }
        }     
        catch(Exception ex)
        {
            System.out.println("ERROR= "+ex.getMessage());
            String error=ex.getMessage();
            
            if(error.contains(Messages.EX_PRODUCTO_EXISTENTE))
                response.put(Messages.ERROR_KEY, Messages.NOMBRE_PRODUCTO_EXISTENTE);
            else
                response.put(Messages.ERROR_KEY, Messages.ERROR_SISTEMA);
            
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
    }

    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(id!=0L && id!=null)
            {
                ModelProductos fn=sproductos.BuscarIdPorducto(id);
                sproductos.Eliminar(fn);
                response.put(Messages.SUCCESSFUL_KEY, Messages.DATOS_ELIMINADOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK); 
            }
            else
            {
                response.put(Messages.ERROR_KEY, Messages.ERROR_DATOS_INCOMPLETOS);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
            }
        }     
        catch(Exception ex)
        {
            System.out.println("ERROR= "+ex.getMessage());
            String error=ex.getMessage();
            response.put(Messages.ERROR_KEY, Messages.ERROR_SISTEMA);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
}
