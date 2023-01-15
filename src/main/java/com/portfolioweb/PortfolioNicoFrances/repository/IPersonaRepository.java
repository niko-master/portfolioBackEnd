
package com.portfolioweb.PortfolioNicoFrances.repository;

import com.portfolioweb.PortfolioNicoFrances.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nico
 */
@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long>{
    
    
    
}
