/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Josue
 */
public class ingredientes {
    private String ingredientes;
    private float precio;
    
    public ingredientes(){
        
    }
    public ingredientes(String ingrediente, float precio){
        this.ingredientes = ingrediente;
        this.precio = precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
//To change body of generated methods, choose Tools | Templates.
    return this.getIngredientes() + " ";
    }
    
}
