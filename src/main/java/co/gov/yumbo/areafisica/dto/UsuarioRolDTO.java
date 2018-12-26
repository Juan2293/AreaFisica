package co.gov.yumbo.areafisica.dto;

public class UsuarioRolDTO {
	private long id;
	private String username;
	private String rol;
	private String correo;
	private String nombre;
	private String telefono;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public UsuarioRolDTO(long id, String username, String rol, String correo, String nombre, String telefono) {
		super();
		this.id = id;
		this.username = username;
		this.rol = rol;
		this.correo = correo;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
}
