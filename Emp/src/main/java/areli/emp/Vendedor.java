/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areli.emp;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author asortega
 */
public class Vendedor {
    int vId = 0;
    //int nuevoId = ultimoId + 1;
    int vActual;
    String vMensaje;
    String vCivil;

    String nombre;
    String apellidoP;
    String apellidoM;
    String direccion;
    int telefono;
    boolean estadoCivil;

    Set<Empleado> vendedores = new TreeSet<>();

    public void agregarDatos(int pId, String pNom, String pApp, String pApm, String pDir, int pTel, boolean pCiv) {
        Empleado agregarNuevo = new Empleado(pId, pNom, pApp, pApm, pDir, pTel, pCiv);
        vendedores.add(agregarNuevo);

    }

    public void mostrarListaEmpleados() {
        for (Empleado element : vendedores) {
            vId       = element.id_emp;
            nombre    = element.nombre;
            apellidoP = element.apellidoP;
            apellidoM = element.apellidoM;
            direccion = element.direccion;
            telefono  = element.telefonos;
            estadoCivil = element.estadoCivil;

            if (estadoCivil == true) {
                vCivil = " casado";
            } else {
                vCivil = " soltero";
            }

            vActual = element.id_emp;
            vMensaje = vMensaje + "\n" + "-------------------------------------"
                    + "\n" + vActual   + ". Nombre: " + nombre + "\n"
                    + "  Apellidos: "  + apellidoP    + " "    + apellidoM + "\n"
                    + "  Direccion: "  + direccion    + "\n"
                    + "  Telefono: "   + telefono     + "\n"
                    + "  Esta Civil: " + vCivil;
            System.out.println(vMensaje);
        }

        System.out.println("-------------Lista de Empleados por ID-----------");
        System.out.println(vMensaje);
    }

    public Vendedor() {
        //AGREGAMOS EMPLEADOS
        agregarDatos(vActual, "Pancho", "Lopez", "Juarez", "Direccion 1", 5554488, true);

        //MOSTRAMOS LA LISTA
        mostrarListaEmpleados();
    }

    public int compareTo(Empleado e) {
        if (vActual.equals(e.id_emp)) {//<--
            return 1;
        } else {
            return 0;
        }

    public static void main(String[] args) {
        new Vendedor();
    }

}
