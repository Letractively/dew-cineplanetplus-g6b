package com.mycompany.dewcineplanetplusg6b.model;

public class Carrito {
	private String usuario;
	private String producto;
	
	public Carrito(String usuario, String producto) {
		this.usuario = usuario;
		this.producto = producto;
	}
	
	public String getUsuario() {
		
		return usuario;
	}
	public void setUsuario (String val) {
        this.usuario = val;
    }
	
	public String getProducto() {
		
		return producto;
	}
	public void setProducto (String val) {
        this.producto = val;
    }
	
	

}
