/**
 * Clase que representa un empleado.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio.Model;

import co.edu.uniquindio.uniquindio.Services.Contribuyente;

/**
 * La clase Empleado representa a un empleado en una organización.
 * Implementa la interfaz code Contribuyente para definir la manera en que
 * el empleado contribuye.
 */
public class Empleado implements Contribuyente {

    private String nombre;
    private String idEmpleado;
    private Departamento departamento;

    /**
     * Crea un nuevo objeto Empleado con el nombre, ID de empleado y departamento especificados.
     * @param nombre el nombre del empleado.
     * @param idEmpleado el ID único del empleado.
     * @param departamento el departamento al que pertenece el empleado.
     */
    public Empleado(String nombre, String idEmpleado, Departamento departamento) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
    }

    /**
     * Obtiene el nombre del empleado.
     * @return el nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre el nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del empleado.
     * @return el ID del empleado.
     */
    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Establece el ID del empleado.
     * @param idEmpleado el nuevo ID del empleado.
     */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Obtiene el departamento al que pertenece el empleado.
     * @return el departamento del empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento al que pertenece el empleado.
     * @param departamento el nuevo departamento del empleado.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Realiza una contribución general del empleado.
     * @return un String que describe la contribución del empleado.
     */
    @Override
    public String contribuir() {
        return "Contribución general del empleado " + nombre;
    }
}