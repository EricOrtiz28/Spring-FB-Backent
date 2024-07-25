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

    private String ip;
    private String locacion;
    private String dispositivo;

    public Usuarios() {
    }

    public Usuarios(Integer id, String correo, String contrasena, LocalDateTime creado_en, String ip, String locacion, String dispositivo) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.creado_en = creado_en;
        this.ip = ip;
        this.locacion = locacion;
        this.dispositivo = dispositivo;
    }
}
