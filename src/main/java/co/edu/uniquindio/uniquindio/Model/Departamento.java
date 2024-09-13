/**
 * Clase que representa un departamento.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio.Model;

import co.edu.uniquindio.Empleado;

import java.util.LinkedList;

/**
 * La clase Departamento representa un departamento dentro de una organización,
 * que contiene una lista de empleados.
 */
public class Departamento {
    private String nombre;
    private String codigo;
    private LinkedList <Empleado> empleados;

    /**
     * Crea un nuevo objeto Departamento con el nombre y código especificados.
     * @param nombre el nombre del departamento.
     * @param codigo el código único del departamento.
     */
    public Departamento (String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        empleados = new LinkedList<>();
    }

    /**
     * Obtiene el nombre del departamento.
     * @return el nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     * @param nombre el nuevo nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el código del departamento.
     * @return el código del departamento.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del departamento.
     * @param codigo el nuevo código del departamento.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Agrega un empleado al departamento.
     * @param empleado el empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Elimina un empleado del departamento.
     * @param empleado el empleado a eliminar.
     */
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    /**
     * Obtiene la lista de empleados en el departamento.
     * @return una lista de empleados en el departamento.
     */
    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados en el departamento.
     * @param empleados la nueva lista de empleados en el departamento.
     */
    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }
}