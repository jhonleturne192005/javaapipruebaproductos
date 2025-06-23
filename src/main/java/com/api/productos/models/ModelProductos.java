/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.productos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author USUARIO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="producto")
public class ModelProductos 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idproducto;
    
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    String nombre;
    
    @Column(name = "precio", nullable = false, unique = false)
    float precio=0f;
    
    @Column(name = "cantidad", nullable = false, unique = false)
    int cantidad=0;
    
}
