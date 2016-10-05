/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jpargav.a09;

/**
 *
 * @author JESUS PARGA VELA
 */
public class nodeClass <T>{
    //Atributos
    public nodeClass next;
    private T data;
    
    //Constructor con dato
    public nodeClass(T data){
        this.data = data;
        this.next = null;
    }
    //Constructor nulo
    public nodeClass(){
        this.data = null;
        this.next = null;
    }
    //Getters y Setters
    public T getData(){
        return this.data;
    }
    public void setData(T d){
        this.data = d;
    }
}
