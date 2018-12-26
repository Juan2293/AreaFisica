package co.gov.yumbo.areafisica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.yumbo.areafisica.dto.UsuarioDTO;
import co.gov.yumbo.areafisica.dto.UsuarioRolDTO;
import co.gov.yumbo.areafisica.modelo.User;
import co.gov.yumbo.areafisica.service.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {"http://192.168.8.50:4200", "http://localhost:4200"})
public class UsuarioController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/crear")
	public String crearUsuario(@RequestBody UsuarioDTO userDto) {
		
		try {
			userService.createUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@GetMapping("/usuarios")
	public List<User> obtenerUsuarios(){
		return userService.getAllUsuarios();
	}
	
	@GetMapping("/usuarios-rol")
	public List<UsuarioRolDTO> obtenerLicencias(){
		return userService.getAllUsuariosRolDTO();
	}

	
}
