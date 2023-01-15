
package com.portfolioweb.PortfolioNicoFrances.service;

import com.portfolioweb.PortfolioNicoFrances.Entity.Persona;
import com.portfolioweb.PortfolioNicoFrances.Interface.IPersonaService;
import com.portfolioweb.PortfolioNicoFrances.repository.IPersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nico
 */

@Service
@Transactional
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
        
    }

    @Override
    public Persona findById(Long personId) {
         Persona persona = ipersonaRepository.findById(personId).orElse(null);
        return persona;
    }
    
}
