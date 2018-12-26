package co.gov.yumbo.areafisica.service;

import java.util.List;

import co.gov.yumbo.areafisica.dto.UsuarioDTO;
import co.gov.yumbo.areafisica.dto.UsuarioRolDTO;
import co.gov.yumbo.areafisica.modelo.User;

public interface UserService {

    User createUser(UsuarioDTO usuario) throws Exception;
    List<User> getAllUsuarios();
    void deleteUsuario(long id);
    void updateUsuario(UsuarioDTO usuarioDTO) throws Exception;
    User getUsuarioByUsername(String username);
    User getUsuarioById(Long id);
    List<UsuarioRolDTO> getAllUsuariosRolDTO();
}
