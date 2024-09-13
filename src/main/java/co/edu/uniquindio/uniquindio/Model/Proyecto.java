/**
 * Clase que representa un proyecto.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio.Model;

import co.edu.uniquindio.Empleado;

import java.util.LinkedList;

/**
 * La clase Proyecto representa un proyecto en el que se asignan empleados
 * para trabajar en conjunto.
 */
public class Proyecto {
    private String nombre;
    private String codigo;
    private LinkedList<Empleado> empleadosAsignados;

    /**
     * Crea un nuevo objeto Proyecto con el nombre y código especificados.
     * @param nombre el nombre del proyecto.
     * @param codigo el código único del proyecto.
     */
    public Proyecto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        empleadosAsignados = new LinkedList<>();
    }

    /**
     * Obtiene el nombre del proyecto.
     * @return el nombre del proyecto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proyecto.
     * @param nombre el nuevo nombre del proyecto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el código del proyecto.
     * @return el código del proyecto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del proyecto.
     * @param codigo el nuevo código del proyecto.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Asigna un empleado al proyecto.
     * @param empleado el empleado a asignar al proyecto.
     */
    public void asignarEmpleado(Empleado empleado) {
        empleadosAsignados.add(empleado);
    }

    /**
     * Elimina un empleado del proyecto.
     * @param empleado el empleado a eliminar del proyecto.
     */
    public void eliminarEmpleado(Empleado empleado) {
        empleadosAsignados.remove(empleado);
    }

    /**
     * Obtiene la lista de empleados asignados al proyecto.
     * @return una lista de empleados asignados al proyecto.
     */
    public LinkedList<Empleado> getEmpleadosAsignados() {
        return empleadosAsignados;
    }

    /**
     * Establece la lista de empleados asignados al proyecto.
     * @param empleados la nueva lista de empleados asignados al proyecto.
     */
    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleadosAsignados = empleados;
    }
}