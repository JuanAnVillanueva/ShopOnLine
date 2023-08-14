/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_shop_on_line;

/**
 *
 * @author CS09
 */
public class Remera extends Producto {
    private String talle;
    
    public Remera(String desc, double precio, String t) {
        super(desc, precio);
        this.talle = t;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }
    public double getPrecio() {
        if (this.talle.equals("S")) {
            precio = precio;
        }if (this.talle.equals("M")) {
            precio = precio +0.05* precio;
        }if (this.talle.equals("L")) {
            precio = precio + 0.10 * precio;
        }if (this.talle.equals("XL")) {
            precio = precio + 0.15 * precio;
        }
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Remera{" + " talle= " + talle + " descripcion= "+ desc +'}';
    }
}
