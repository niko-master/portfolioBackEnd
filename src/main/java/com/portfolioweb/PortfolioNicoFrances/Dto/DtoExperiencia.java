/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioweb.PortfolioNicoFrances.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Nico
 */
public class DtoExperiencia {
    //private String trabajoactual;
    //private Date fechainicio;
    //private String fechafin;
    @NotBlank
    private String tipoEmpleo;
    @NotBlank
    private String descripcion;
       

    /*public String getTrabajoactual() {
        return trabajoactual;
    }

    public void setTrabajoactual(String trabajoactual) {
        this.trabajoactual = trabajoactual;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
*/
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
    
    
    public DtoExperiencia() {
    }
    public DtoExperiencia(String descripcion, String tipoEmpleo) {
        //this.trabajoactual = trabajoactual;
        //this.fechainicio = fechainicio;
        //this.fechafin = fechafin;
        this.descripcion = descripcion;
        this.tipoEmpleo = tipoEmpleo;
    }

    
}
