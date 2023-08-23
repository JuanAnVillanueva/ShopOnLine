package com.mycompany.poo_shop_on_line;


public abstract class Producto {
    protected String desc;
    protected int codigo;
    protected double precio;

    public Producto(String desc,double precio) {
        this.desc = desc;
        this.codigo =(int) (Math.random() * 10000000) + 1; 
        this.precio = precio;
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

    public abstract double getPrecio();

    public abstract void setPrecio(double precio);

    
    
    @Override
    public String toString() {
        return "Producto{" + "desc=" + desc + ", codigo=" + codigo + ", precio=" + precio + '}';
    }
    
}
