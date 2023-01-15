
package com.portfolioweb.PortfolioNicoFrances.controller;

import com.portfolioweb.PortfolioNicoFrances.Dto.DtoExperiencia;
import com.portfolioweb.PortfolioNicoFrances.Entity.ExpLaboral;
import com.portfolioweb.PortfolioNicoFrances.Entity.Persona;
import com.portfolioweb.PortfolioNicoFrances.Interface.IPersonaService;
import com.portfolioweb.PortfolioNicoFrances.security.Controller.Mensaje;
import com.portfolioweb.PortfolioNicoFrances.service.ImpExpLaboralService;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nico
 */
@RestController
@RequestMapping("/explaboral")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolioweb-23eea.web.app/")
public class ExpLaboralController {
    @Autowired ImpExpLaboralService impExpLaboralService;
    
    @Autowired IPersonaService ipersonaService;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExpLaboral>> list(){
        List<ExpLaboral> list = impExpLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/traer/{explaboral_id}")
    public ResponseEntity<ExpLaboral> getById(@PathVariable("explaboral_id") Long explaboral_id){
        if(!impExpLaboralService.existsById(explaboral_id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExpLaboral expLaboral = impExpLaboralService.getOne(explaboral_id).get();
        return new ResponseEntity(expLaboral, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{explaboral_id}")
    public ResponseEntity<?> delete(@PathVariable("explaboral_id") Long explaboral_id) {
        if (!impExpLaboralService.existsById(explaboral_id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impExpLaboralService.delete(explaboral_id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){      
        if(StringUtils.isBlank(dtoExperiencia.getTipoEmpleo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impExpLaboralService.existsByTipoEmpleo(dtoExperiencia.getTipoEmpleo()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        ExpLaboral expLaboral = new ExpLaboral(dtoExperiencia.getTipoEmpleo(), dtoExperiencia.getDescripcion());
        impExpLaboralService.save(expLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{explaboral_id}")
    public ResponseEntity<?> update(@PathVariable("explaboral_id") Long explaboral_id, @RequestBody DtoExperiencia dtoExperiencia){
        //Validamos si existe el ID
        if(!impExpLaboralService.existsById(explaboral_id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impExpLaboralService.existsByTipoEmpleo(dtoExperiencia.getTipoEmpleo()) && impExpLaboralService.getByTipoEmpleo(dtoExperiencia.getTipoEmpleo()).get().getExplaboral_id() != explaboral_id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoExperiencia.getTipoEmpleo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExpLaboral expLaboral = impExpLaboralService.getOne(explaboral_id).get();
        expLaboral.setTipoEmpleo(dtoExperiencia.getTipoEmpleo());
        expLaboral.setDescripcion((dtoExperiencia.getDescripcion()));
        
        impExpLaboralService.save(expLaboral);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
   
 
}
