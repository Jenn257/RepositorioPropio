/**
 * Clase que representa el Main.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio;

import co.edu.uniquindio.uniquindio.Model.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase Main contiene el punto de entrada del programa y métodos para gestionar departamentos,
 * proyectos y empleados. Incluye funciones para mostrar empleados, contar proyectos por empleados, y eliminar empleados.
 */
public class Main {
    /**
     * El método principal que sirve como punto de entrada del programa.
     * @param args los argumentos.
     */

    public static void main(String[] args) {
        // Crear departamentos
        Departamento deptoIT = new Departamento("Tecnologías de la Información", "D01");
        Departamento deptoHR = new Departamento("Recursos Humanos", "D02");

        // Crear proyectos
        Proyecto proyectoDesarrollo = new Proyecto("Desarrollo de Aplicación", "P001");
        Proyecto proyectoInfraestructura = new Proyecto("Infraestructura de Red", "P002");
        Proyecto proyectoMantenimiento = new Proyecto("Mantenimiento de Sistemas", "P003");

        // Crear empleados (Gerente y Técnico)
        Gerente gerenteIT = new Gerente("Juan Pérez", "G01", deptoIT, 5);
        Tecnico tecnicoDev = new Tecnico("Ana López", "T01", deptoIT, "Desarrolladora");
        Tecnico tecnicoAdmin = new Tecnico("Luis Gómez", "T02", deptoHR, "Administrador de Sistemas");

        // Asignar empleados a los departamentos
        deptoIT.agregarEmpleado(gerenteIT);
        deptoIT.agregarEmpleado(tecnicoDev);
        deptoHR.agregarEmpleado(tecnicoAdmin);

        // Asignar empleados a los proyectos
        proyectoDesarrollo.asignarEmpleado(gerenteIT);
        proyectoDesarrollo.asignarEmpleado(tecnicoDev);

        proyectoInfraestructura.asignarEmpleado(gerenteIT);
        proyectoInfraestructura.asignarEmpleado(tecnicoAdmin);

        proyectoMantenimiento.asignarEmpleado(tecnicoDev);

        // Agregar proyectos gestionados por el gerente
        gerenteIT.agregarProyecto(proyectoDesarrollo);
        gerenteIT.agregarProyecto(proyectoInfraestructura);

        // Mostrar los departamentos y sus empleados
        mostrarEmpleados("Departamento Tecnologías de la Información:", deptoIT);
        mostrarEmpleados("Departamento Recursos Humanos:", deptoHR);

        // Ejercicio 1: Determinar en cuántos proyectos están involucrados todos los empleados
        Map<String, Integer> empleadoProyectosCount = contarProyectosPorEmpleados(
                proyectoDesarrollo, proyectoInfraestructura, proyectoMantenimiento);
        StringBuilder sbEmpleadoProyectos = new StringBuilder("Número de proyectos en los que están involucrados los empleados:\n");
        for (Map.Entry<String, Integer> entry : empleadoProyectosCount.entrySet()) {
            sbEmpleadoProyectos.append(entry.getKey()).append(" está involucrado en ").append(entry.getValue()).append(" proyectos.\n");
        }
        JOptionPane.showMessageDialog(null, sbEmpleadoProyectos.toString());

        // Ejercicio 2: Generar reporte de contribuciones
        StringBuilder sbContribuciones = new StringBuilder("Reporte de Contribuciones:\n");
        for (Proyecto proyecto : new Proyecto[]{proyectoDesarrollo, proyectoInfraestructura, proyectoMantenimiento}) {
            for (Empleado emp : proyecto.getEmpleadosAsignados()) {
                sbContribuciones.append("    Contribución: ").append(emp.contribuir()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sbContribuciones.toString());

        // Ejercicio 3: Seleccionar un departamento y eliminar un empleado
        String[] opciones = {"Tecnologías de la Información", "Recursos Humanos"};
        String departamentoSeleccionado = (String) JOptionPane.showInputDialog(null, "Selecciona el departamento del cual deseas eliminar un empleado:",
                "Eliminar Empleado", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        Departamento departamentoAEliminar = departamentoSeleccionado.equals("IT") ? deptoIT : deptoHR;
        String empleadoAEliminar = JOptionPane.showInputDialog("Ingrese el nombre del empleado a eliminar del departamento " + departamentoSeleccionado + ":");

        if (empleadoAEliminar != null && !empleadoAEliminar.isEmpty()) {
            eliminarEmpleado(departamentoAEliminar, empleadoAEliminar);
            mostrarEmpleados("Departamento Tecnologías de la Información después de la remoción:", deptoIT);
            mostrarEmpleados("Departamento Recursos Humanos después de la remoción:", deptoHR);
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de empleado no válido.");
        }
    }

    /**
     * Muestra los empleados de un departamento específico en un cuadro de diálogo.
     * @param mensaje el mensaje que describe el departamento.
     * @param departamento el departamento del cual se mostrarán los empleados.
     */
    private static void mostrarEmpleados(String mensaje, Departamento departamento) {
        StringBuilder sb = new StringBuilder(mensaje + "\n");
        for (Empleado emp : departamento.getEmpleados()) {
            sb.append(emp.getNombre()).append(" (ID: ").append(emp.getIdEmpleado()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    /**
     * Cuenta el número de proyectos en los que cada empleado está involucrado.
     * @param proyectos una lista de proyectos a evaluar.
     * @return un mapa que asocia el nombre de cada empleado con el número de proyectos en los que está involucrado.
     */
    private static Map<String, Integer> contarProyectosPorEmpleados(Proyecto... proyectos) {
        Map<String, Integer> empleadoProyectosCount = new HashMap<>();

        for (Proyecto proyecto : proyectos) {
            for (Empleado empleado : proyecto.getEmpleadosAsignados()) {
                empleadoProyectosCount.put(empleado.getNombre(),
                        empleadoProyectosCount.getOrDefault(empleado.getNombre(), 0) + 1);
            }
        }

        return empleadoProyectosCount;
    }

    /**
     * Elimina un empleado de un departamento específico si se encuentra en él.
     * @param departamento el departamento del cual se eliminará el empleado.
     * @param nombre el nombre del empleado a eliminar.
     */
    private static void eliminarEmpleado(Departamento departamento, String nombre) {
        Empleado empleadoAEliminar = null;
        for (Empleado emp : departamento.getEmpleados()) {
            if (emp.getNombre().equalsIgnoreCase(nombre)) {
                empleadoAEliminar = emp;
                break;
            }
        }

        if (empleadoAEliminar != null) {
            // Eliminar el empleado del departamento
            departamento.eliminarEmpleado(empleadoAEliminar);

            JOptionPane.showMessageDialog(null, "Empleado " + nombre + " eliminado exitosamente del departamento.");
        } else {
            JOptionPane.showMessageDialog(null, "Empleado " + nombre + " no encontrado en el departamento.");
        }
    }
}