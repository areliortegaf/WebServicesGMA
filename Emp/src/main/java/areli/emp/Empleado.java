/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areli.emp;

/**
 *
 * @author asortega
 */
public class Empleado {
    //POJO
    //FIELDS
    int     id_emp;
    String  nombre;
    String  apellidoP;
    String  apellidoM;
    String  direccion;
    int     telefonos;
    boolean estadoCivil;
    
   
    public Empleado(int pId,String pNom, String pApp, String pApm, String pDir, int pTel, boolean pCiv){
        this.nombre = pNom;
        this.apellidoP = pApp;
        this.apellidoM = pApm;
        this.direccion = pDir;
        this.telefonos = pTel;
        this.estadoCivil = pCiv;
        this.id_emp = pId;
    }
    
    
    //GETTERS SETTERS
    
   /* public void cambiarId(int pId){
        this.id_emp = pId;
    }*/
    
    
    public void cambiarNombre(String pNombre){
        this.nombre = pNombre;
    }
    
    public void cambiarApellidoP(String pApellidoP){
        this.apellidoP = pApellidoP;
    }
    
    public void cambiarApellidoM(String pApellidoM){
        this.apellidoM = pApellidoM;
    }
    
    public void cambiarDireccion(String pDireccion){
        this.direccion = pDireccion;
    }
    
    public void cambiarTelefono(int ptelefono){
        this.telefonos = ptelefono;
    }
    
    public void cambiarEstadoCivil(boolean pestadocivil){
        this.estadoCivil = pestadocivil;
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }
    
    public String obtenerApellidoP(){
        return this.apellidoP;
    }
    
    public String obtenerApellidoM(){
        return this.apellidoM;
    }
    
    public String obtenerDireccion(){
        return this.direccion;
    }
    
    public int obtenerTelefono(){
        return this.telefonos;
    }
    
    public boolean obtenerEstadoCivil(){
        return this.estadoCivil;
    }
    
    public int obtenerId(){
        return this.id_emp;
    }
    
}
