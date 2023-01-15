
package com.portfolioweb.PortfolioNicoFrances.Interface;

import com.portfolioweb.PortfolioNicoFrances.Entity.Persona;
import java.util.List;

/**
 *
 * @author Nico
 */

public interface IPersonaService {
        //Trae la lista de persona
    public List<Persona> getPersona();
    
    //Guardar Objetos de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar Objetos de tipo persona, se busca por ID
    public void deletePersona(Long id);
    
    //Buscar Objeto dentro de persona x ID
    public Persona findPersona(Long id);

    public Persona findById(Long personId);
    
}
