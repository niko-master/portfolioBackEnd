
package com.portfolioweb.PortfolioNicoFrances.service;

import com.portfolioweb.PortfolioNicoFrances.Entity.ExpLaboral;
import com.portfolioweb.PortfolioNicoFrances.repository.IExpLaboralRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nico
 */

@Service
@Transactional
public class ImpExpLaboralService{
    @Autowired IExpLaboralRepository iexplaboralRepository;

      public List<ExpLaboral> list(){
         return iexplaboralRepository.findAll();
     }
     
     public Optional<ExpLaboral> getOne(Long explaboral_id){
         return iexplaboralRepository.findById(explaboral_id);
     }
     
     public Optional<ExpLaboral> getByTipoEmpleo(String expLaboral){
         return iexplaboralRepository.findByTipoEmpleo(expLaboral);
     }
     
     public void save(ExpLaboral expLaboral){
         iexplaboralRepository.save(expLaboral);
     }
     
     public void delete(Long explaboral_id){
         iexplaboralRepository.deleteById(explaboral_id);
     }
     
     public boolean existsById(Long explaboral_id){
         return iexplaboralRepository.existsById(explaboral_id);
     }
     
     public boolean existsByTipoEmpleo(String expLaboral){
         return iexplaboralRepository.existsByTipoEmpleo(expLaboral);
     }
    
}
