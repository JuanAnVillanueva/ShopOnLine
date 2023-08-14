package com.mycompany.poo_shop_on_line;



public class Accesorio extends Producto{
    private String metal;
    private int gramo;
    public Accesorio(String desc,double precio, String m, int g) {
        super(desc,precio);
        this.metal = m;
        this.gramo = g;
    } 

    public int getGramo() {
        return gramo;
    }

    public void setGramo(int gramo) {
        this.gramo = gramo;
    }
    
    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
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

    
        
    @Override
    public double getPrecio() {
        int gOro = 17300;
        int gPlata = 7000;
        int gMetal = 500;
        if (this.metal.equals("Acero")) {
            precio = precio + this.gramo * gMetal;
        }if (this.metal.equals("Plata")) {
            precio = precio + this.gramo * gPlata;
        }if (this.metal.equals("Oro")) {
            precio = precio + this.gramo * gOro;
        }
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Accesorio{ metal =" + metal + ", gramo= " + gramo + ", descripcion= "+ desc+'}';
    }
    
}


