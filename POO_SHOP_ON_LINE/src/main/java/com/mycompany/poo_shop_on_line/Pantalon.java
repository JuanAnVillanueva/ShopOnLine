package com.mycompany.poo_shop_on_line;


public class Pantalon extends Producto{
    private int talle;
    private String modelo;
    
    public Pantalon(String desc, double precio, int t, String m) {
        super(desc, precio);
        this.talle = t;
        this.modelo =  m;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public double getPrecio() {
        double precio = this.precio;
        if (this.modelo.equals("Oxford")) {
            precio = precio + (0.15 * precio);
        }if (this.modelo.equals("Skinny")) {
            precio = precio + (0.25 * precio);
        }if (this.modelo.equals("Recto")) {
            precio = precio - (0.15 * precio);
        }
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    @Override
    public String toString() {
        return "Pantalon{" + "talle= " + talle + ", modelo= " + modelo + " descripcion= "+ desc+'}';
    }
}
