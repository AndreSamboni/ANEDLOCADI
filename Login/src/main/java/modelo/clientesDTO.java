package modelo;

public class clientesDTO {
	private int cedcli;
	private String nombrecli;
	private String dircli;
	private String telcli;
	private String emailcli;
	
	public clientesDTO(int cedcli, String nombrecli, String dircli, String telcli, String emailcli) {
		this.cedcli=cedcli;
		this.nombrecli=nombrecli;
		this.dircli=dircli;
		this.telcli=telcli;
		this.emailcli=emailcli;
	}
	
	public clientesDTO(int cedcli) {
		this.cedcli = cedcli;
	}
	public int getCedcli() {
		return cedcli;
	}
	public void setCedcli(int cedcli) {
		this.cedcli = cedcli;
	}
	public String getNombrecli() {
		return nombrecli;
	}
	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}
	public String getDircli() {
		return dircli;
	}
	public void setDircli(String dircli) {
		this.dircli = dircli;
	}
	public String getEmailcli() {
		return emailcli;
	}
	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}
	public String getTelcli() {
		return telcli;
	}
	public void setTelcli(String telcli) {
		this.telcli = telcli;
	}
}
