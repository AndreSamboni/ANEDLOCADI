package modelo;

public class usuariosDTO {
	private int cedusu;
	private String nombreusu;
	private String emailusu;
	private String user;
	private String password;
	
	public usuariosDTO(int cedusu, String nombreusu, String emailusu, String user, String password) {
		this.cedusu=cedusu;
		this.nombreusu=nombreusu;
		this.emailusu=emailusu;
		this.user=user;
		this.password=password;
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

