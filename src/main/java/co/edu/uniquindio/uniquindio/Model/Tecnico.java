/**
 * Clase que representa un tecnico.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio.Model;

import co.edu.uniquindio.Departamento;
import co.edu.uniquindio.Empleado;

/**
 * La clase Tecnico extiende la clase Empleado y añade
 * funcionalidades específicas para un técnico, incluyendo una especialidad técnica.
 */
public class Tecnico extends Empleado {
    private String especialidad;

    /**
     * Crea un nuevo objeto Tecnico con el nombre, ID de empleado, departamento y especialidad especificados.
     * @param nombre el nombre del técnico.
     * @param idEmpleado el ID único del técnico.
     * @param departamento el departamento al que pertenece el técnico.
     * @param especialidad la especialidad técnica del técnico.
     */
    public Tecnico(String nombre, String idEmpleado, Departamento departamento, String especialidad) {
        super(nombre, idEmpleado, departamento);
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la especialidad técnica del técnico.
     * @return la especialidad del técnico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad técnica del técnico.
     * @param especialidad la nueva especialidad del técnico.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Realiza la contribución específica del técnico, que incluye realizar tareas técnicas
     * y resolver problemas.
     * @return un String que describe la contribución del técnico.
     */
    @Override
    public String contribuir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Técnico ").append(getNombre()).append(" (ID: ").append(getIdEmpleado()).append(") está contribuyendo con:\n");
        sb.append(realizarTareasTecnicas()).append("\n");
        sb.append(resolverProblemas()).append("\n");
        return sb.toString();
    }

    /**
     * Realiza tareas técnicas en la especialidad del técnico.
     * @return un String que describe las tareas técnicas realizadas.
     */
    private String realizarTareasTecnicas() {
        return "  ** Realizando tareas técnicas en la especialidad de " + especialidad;
    }

    /**
     * Resuelve problemas técnicos relacionados con la especialidad del técnico.
     * @return un String que describe la resolución de problemas.
     */
    private String resolverProblemas() {
        return "  ** Resolviendo problemas";
    }
}