package modelo;

public class proveedoresDTO {
	private int nitprov;
	private String nombreprov;
	private String direccionprov;
	private String telefonoprov;
	private String ciudadprov;
	
	public proveedoresDTO(int nitprov, String nombreprov, String direccionprov, String telefonoprov,
			String ciudadprov) {
		this.nitprov = nitprov;
		this.nombreprov = nombreprov;
		this.direccionprov = direccionprov;
		this.telefonoprov = telefonoprov;
		this.ciudadprov = ciudadprov;
	}
	
	public proveedoresDTO(int nitprov) {
		this.nitprov = nitprov;
	}

	public int getNitprov() {
		return nitprov;
	}

	public void setNitprov(int nitprov) {
		this.nitprov = nitprov;
	}

	public String getNombreprov() {
		return nombreprov;
	}

	public void setNombreprov(String nombreprov) {
		this.nombreprov = nombreprov;
	}

	public String getDireccionprov() {
		return direccionprov;
	}

	public void setDireccionprov(String direccionprov) {
		this.direccionprov = direccionprov;
	}

	public String getTelefonoprov() {
		return telefonoprov;
	}

	public void setTelefonoprov(String telefonoprov) {
		this.telefonoprov = telefonoprov;
	}

	public String getCiudadprov() {
		return ciudadprov;
	}

	public void setCiudadprov(String ciudadprov) {
		this.ciudadprov = ciudadprov;
	}

}