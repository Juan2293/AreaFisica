package co.gov.yumbo.areafisica.dao;

import java.util.List;

import co.gov.yumbo.areafisica.dto.UsuarioRolDTO;
import co.gov.yumbo.areafisica.modelo.User;


public interface UserDao {
    
	List<User> getAllUsuarios();
	User createUser(User user);
    void deleteUsuario(Long id);
    void updateUsuario(User user);
    User getUsuarioByUsername(String username);
    User getUsuarioById(Long id);
	List<UsuarioRolDTO> getAllUsuariosRolDTO();
}
