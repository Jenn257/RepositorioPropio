/**
 * Clase interface contribuyente.
 * @author Mateo Garrido Rios y Jennifer Andrea Cortés Chavarro.
 * @since 2024.
 */

package co.edu.uniquindio.uniquindio.Services;

/**
 * La interfaz Contribuyente define el contrato para las clases
 * que implementan la funcionalidad de contribuir de alguna manera.
 */
public interface Contribuyente {
    /**
     * Realiza una contribución específica.
     * @return un String que describe la contribución realizada.
     */
    String contribuir();
}