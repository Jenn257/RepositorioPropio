/**
 * Clase que representa un gerente.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio.Model;

import co.edu.uniquindio.Empleado;
import co.edu.uniquindio.Proyecto;

import java.util.LinkedList;

/**
 * La clase Gerente extiende la clase Empleado y añade funcionalidades específicas
 * para un rol de gerente, como la gestión de proyectos y equipos.
 */
public class Gerente extends Empleado {
    private int nivelGerencia;
    private LinkedList<Empleado> equipoBajoGestion;
    private LinkedList<Proyecto> proyectosGestionados;

    /**
     * Crea un nuevo objeto Gerente con el nombre, ID de empleado, departamento y nivel de gerencia especificados.
     * @param nombre el nombre del gerente.
     * @param idEmpleado el ID único del gerente.
     * @param departamento el departamento al que pertenece el gerente.
     * @param nivelGerencia el nivel de gerencia del gerente.
     */
    public Gerente(String nombre, String idEmpleado, Departamento departamento, int nivelGerencia) {
        super(nombre, idEmpleado, departamento);
        this.nivelGerencia = nivelGerencia;
        this.equipoBajoGestion = new LinkedList<>();
        this.proyectosGestionados = new LinkedList<>();
    }

    /**
     * Obtiene el nivel de gerencia del gerente.
     * @return el nivel de gerencia del gerente.
     */
    public int getNivelGerencia() {
        return nivelGerencia;
    }

    /**
     * Establece el nivel de gerencia del gerente.
     * @param nivelGerencia el nuevo nivel de gerencia del gerente.
     */
    public void setNivelGerencia(int nivelGerencia) {
        this.nivelGerencia = nivelGerencia;
    }

    /**
     * Agrega un proyecto a la lista de proyectos gestionados por el gerente.
     * @param proyecto el proyecto a agregar.
     */
    public void agregarProyecto(Proyecto proyecto) {
        proyectosGestionados.add(proyecto);
    }

    /**
     * Elimina un proyecto de la lista de proyectos gestionados por el gerente.
     * @param proyecto el proyecto a eliminar.
     */
    public void eliminarProyecto(Proyecto proyecto) {
        proyectosGestionados.remove(proyecto);
    }

    /**
     * Obtiene la lista de proyectos gestionados por el gerente.
     * @return una lista de proyectos gestionados por el gerente.
     */
    public LinkedList<Proyecto> getProyectosGestionados() {
        return proyectosGestionados;
    }

    /**
     * Establece la lista de proyectos gestionados por el gerente.
     * @param proyectosGestionados la nueva lista de proyectos gestionados.
     */
    public void setProyectosGestionados(LinkedList<Proyecto> proyectosGestionados) {
        this.proyectosGestionados = proyectosGestionados;
    }

    /**
     * Agrega un empleado al equipo bajo la gestión del gerente.
     * @param empleado el empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        equipoBajoGestion.add(empleado);
    }

    /**
     * Elimina un empleado del equipo bajo la gestión del gerente.
     * @param empleado el empleado a eliminar.
     */
    public void eliminarEmpleado(Empleado empleado) {
        equipoBajoGestion.remove(empleado);
    }

    /**
     * Obtiene la lista de empleados bajo la gestión del gerente.
     * @return una lista de empleados bajo la gestión del gerente.
     */
    public LinkedList<Empleado> getEquipoBajoGestion() {
        return equipoBajoGestion;
    }

    /**
     * Establece la lista de empleados bajo la gestión del gerente.
     * @param empleados la nueva lista de empleados bajo la gestión del gerente.
     */
    public void setEquipoBajoGestion(LinkedList<Empleado> empleados) {
        equipoBajoGestion = empleados;
    }

    /**
     * Realiza la contribución específica del gerente, que incluye la gestión de proyectos y el liderazgo de equipos.
     * @return un String que describe la contribución del gerente.
     */
    @Override
    public String contribuir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gerente ").append(getNombre()).append(" (ID: ").append(getIdEmpleado()).append(") está contribuyendo con:\n");
        sb.append(gestionarProyectos()).append("\n");
        sb.append(liderarEquipo()).append("\n");
        return sb.toString();
    }

    /**
     * Gestiona los proyectos bajo la responsabilidad del gerente.
     * @return un String que describe los proyectos gestionados.
     */
    private String gestionarProyectos() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ** Gestionando proyectos:\n");
        for (Proyecto proyecto : proyectosGestionados) {
            sb.append("       - Proyecto: ").append(proyecto.getNombre()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Lidera el equipo de empleados bajo la responsabilidad del gerente.
     * @return un String que describe el equipo liderado.
     */
    private String liderarEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ** Liderando equipos técnicos:\n");
        for (Empleado empleado : equipoBajoGestion) {
            sb.append("  - ").append(empleado.getNombre()).append(" (ID: ").append(empleado.getIdEmpleado()).append(")\n");
        }
        return sb.toString();
    }
}