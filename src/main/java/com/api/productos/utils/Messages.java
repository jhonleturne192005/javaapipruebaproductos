/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.productos.utils;

/**
 *
 * @author USUARIO
 */
public class Messages 
{
    public static String ERROR_REGISTRO_NOEXISTE="El producto no existe";
    public static String ERROR_DATOS_INCOMPLETOS="Datos incompletos";
    public static String DATOS_GUARDADOS="Los datos se han guardado correctamente";
    public static String DATOS_ACTUALIZADOS="Los datos se han actualizado correctamente";
    public static String DATOS_ELIMINADOS="Los datos se han eliminado correctamente";
    public static String ERROR_SISTEMA="Ha ocurrido un error en el sistema";
    public static String ERROR_KEY="error";
    public static String SUCCESSFUL_KEY="successful";
    public static String DATA="data";
    
    
    public static String NOMBRE_PRODUCTO_EXISTENTE="El nombre de producto ya existe";
    
    private static final String EX_MESSAGE_UNIQUE="could not execute statement [ERROR: llave duplicada viola restricción de unicidad «producto_%s_key»";
    public static String EX_PRODUCTO_EXISTENTE=String.format(EX_MESSAGE_UNIQUE, "nombre");

}
