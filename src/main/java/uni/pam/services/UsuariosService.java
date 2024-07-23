package uni.pam.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.pam.model.Usuarios;
import uni.pam.repositories.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public Usuarios saveOrUpdateUsuarios(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public List<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }
}
