package com.portfolioweb.PortfolioNicoFrances.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Nico
 */
@Getter @Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String img;
    private Long telefono;
    private String email;
    
    @Column(name="sobremi", length=2048)
    private String sobremi;

    
    @OneToMany(mappedBy = "person")
    private List<ExpLaboral> explaboral;

    
    public Persona() {
    }
    public Persona(Long id, String nombre, String apellido, String img, Long telefono, String email, String sobremi, List<ExpLaboral> explaboral) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.telefono = telefono;
        this.email = email;
        this.sobremi = sobremi;
        this.explaboral = explaboral;
    }

    
    

    
    
}
