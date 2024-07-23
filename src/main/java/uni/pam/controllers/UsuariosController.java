package uni.pam.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.pam.model.Usuarios;
import uni.pam.services.UsuariosService;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UsuariosService usuariosService;

    @RequestMapping(value="/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> insertUsuarios(@RequestBody Usuarios usuarios) {
        Usuarios newusuarios;
        try {
            newusuarios = usuariosService.saveOrUpdateUsuarios(usuarios);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newusuarios, HttpStatus.OK);
    }

    @RequestMapping(value="/listar", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> getUsuarios(){
        List<Usuarios> listaUsuarios = null;
        try{
            listaUsuarios = usuariosService.getUsuarios();
        }catch(Exception e){
            logger.error("Error inesperado", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }
}
