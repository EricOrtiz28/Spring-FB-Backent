package uni.pam.model;


import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  

    private String correo;
    private String contrasena;
    
    @CreationTimestamp
    private LocalDateTime creado_en;
    
    public Usuarios() {
    }
    
    public Usuarios(Integer id, String correo, String contraseña, LocalDateTime creado_en) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contraseña;
        this.creado_en = creado_en;
    }
}