package modelo;

public class Logeo {
	private int cedulausu;
	private String email;
	private String Nombreusu;
	private String password;
	private String usuario;
	public Logeo(int cedulausu, String email, String nombreusu, String password, String usuario) {
		this.cedulausu = cedulausu;
		this.email = email;
		this.Nombreusu = nombreusu;
		this.password = password;
		this.usuario = usuario;
	}
	public int getCedulausu() {
		return cedulausu;
	}
	public void setCedulausu(int cedulausu) {
		this.cedulausu = cedulausu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreusu() {
		return Nombreusu;
	}
	public void setNombreusu(String nombreusu) {
		this.Nombreusu = nombreusu;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}