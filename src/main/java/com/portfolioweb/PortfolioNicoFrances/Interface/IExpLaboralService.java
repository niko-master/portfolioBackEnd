
package com.portfolioweb.PortfolioNicoFrances.Interface;

import com.portfolioweb.PortfolioNicoFrances.Entity.ExpLaboral;
import java.util.List;

/**
 *
 * @author Nico
 */

public interface IExpLaboralService {
    //Traer la lista de exp laboral
    public List<ExpLaboral> getExpLaboral();
    
    //Guardar Objetos de tipo ExpLaboral
    public void saveExpLaboral(ExpLaboral explaboral);
    
    //Eliminar Objetos de tipo ExpLaboral, se busca por ID
    public void deleteExpLaboral(Long explabora_id);
    
    //Buscar Objeto dentro de ExpLaboral x ID
    public ExpLaboral findExpLaboral(Long explabora_id);
    
    
}
