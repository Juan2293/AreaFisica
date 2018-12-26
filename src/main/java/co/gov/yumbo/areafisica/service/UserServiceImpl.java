package co.gov.yumbo.areafisica.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.gov.yumbo.areafisica.dao.IRolDAO;
import co.gov.yumbo.areafisica.dao.UserDao;
import co.gov.yumbo.areafisica.dto.UsuarioDTO;
import co.gov.yumbo.areafisica.dto.UsuarioRolDTO;
import co.gov.yumbo.areafisica.modelo.User;


@Service(value = "userService")
public class UserServiceImpl implements   UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IRolDAO rolDAO;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUsuarioByUsername(username);
		
		
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
//		System.out.println(user.getUsername());
//
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private List<SimpleGrantedAuthority> getAuthority(User user) {

		//se agreg la información de los roles en el TOKEN

		//		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		SimpleGrantedAuthority authorities = new SimpleGrantedAuthority("ROLE_"+user.getRol().getName().trim());
		//		user.getRoles().forEach(role -> {
		//			//authorities.add(new SimpleGrantedAuthority(role.getName()));
		//			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		//		});
		//		return authorities;
		//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return Arrays.asList(authorities);
	}

	@Override
	public User createUser(UsuarioDTO usuario) throws Exception {
		if(userDao.getUsuarioByUsername(usuario.getUsername().trim())!=null) {
			throw new Exception("El usuario ingresado ya existe");
		}
		if (usuario.getPassword()==null || usuario.getPassword().trim().equals("")  ) {
			throw new Exception("Ingrese un valor para el password");
		}
		
		
		User newUser = new User();
		newUser.setUsername(usuario.getUsername());
		newUser.setPassword(bcryptEncoder.encode(usuario.getPassword()));
		newUser.setCorreo(usuario.getCorreo());
		newUser.setTelefono(usuario.getTelefono());
		newUser.setNombre(usuario.getNombre());
		newUser.setRol(rolDAO.getRolById(new Long(usuario.getRolId())));


		return userDao.createUser(newUser);
	}

	@Override
	public List<User> getAllUsuarios() {
		List<User> list = new ArrayList<>();
		userDao.getAllUsuarios().iterator().forEachRemaining(list::add);
		return list;	
	}

	@Override
	public void deleteUsuario(long id) {
		userDao.deleteUsuario(id);
	}

	@Override
	public void updateUsuario(UsuarioDTO usuarioDTO) throws Exception {
		
	}

	@Override
	public User getUsuarioByUsername(String username) {
		return userDao.getUsuarioByUsername(username);
	}

	@Override
	public User getUsuarioById(Long id) {
		 return userDao.getUsuarioById(id);
	}

	@Override
	public List<UsuarioRolDTO> getAllUsuariosRolDTO() {
		return userDao.getAllUsuariosRolDTO()	;
	}



}
