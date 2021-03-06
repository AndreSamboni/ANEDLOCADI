package modelo;

public class usuariosDTO {
	private int cedusu;
	private String nombreusu;
	private String emailusu;
	private String user;
	private String password;
	private String ciudad;
	private String rol;
	
	public usuariosDTO(int cedusu, String nombreusu, String emailusu, String user, String password, String ciudad, String rol) {
		this.cedusu=cedusu;
		this.nombreusu=nombreusu;
		this.emailusu=emailusu;
		this.user=user;
		this.password=password;
		this.ciudad=ciudad;
		this.rol=rol;
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public usuariosDTO(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public usuariosDTO(int cedusu) {
		this.cedusu = cedusu;
	}


	public int getCedusu() {
		return cedusu;
	}

	public void setCedusu(int cedusu) {
		this.cedusu = cedusu;
	}

	public String getNombreusu() {
		return nombreusu;
	}

	public void setNombreusu(String nombreusu) {
		this.nombreusu = nombreusu;
	}

	public String getEmailusu() {
		return emailusu;
	}

	public void setEmailusu(String emailusu) {
		this.emailusu = emailusu;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

