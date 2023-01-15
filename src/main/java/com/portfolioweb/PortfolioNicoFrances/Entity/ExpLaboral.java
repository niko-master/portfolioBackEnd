
package com.portfolioweb.PortfolioNicoFrances.Entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Nico
 */

@Entity
@Table(name = "explaboral")
public class ExpLaboral {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long explaboral_id;
    //private String trabajoactual;
    //private Date fechainicio;
    //private String fechafin;
    private String tipoEmpleo;   
    @Size(min = 1, max = 2048, message = "Mensaje muy largo, máximo 300 caracteres")
    private String descripcion;
     

  
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id", referencedColumnName ="id")
    private Persona person;

     public ExpLaboral() {
    }

  public ExpLaboral(String descripcion, String tipoEmpleo) {
        this.explaboral_id = explaboral_id;
        //this.trabajoactual = trabajoactual;
        //this.fechainicio = fechainicio;
        //this.fechafin = fechafin;
        this.tipoEmpleo = tipoEmpleo;
        this.descripcion = descripcion;
        //this.person = person;
    }

    public Long getExplaboral_id() {
        return explaboral_id;
    }

    public void setExplaboral_id(Long explaboral_id) {
        this.explaboral_id = explaboral_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoEmpleo() {
        return tipoEmpleo;
    }

    public void setTipoEmpleo(String tipoEmpleo) {
        this.tipoEmpleo = tipoEmpleo;
    }

  
}
