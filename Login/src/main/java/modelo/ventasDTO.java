package modelo;

public class ventasDTO {
	private int cod_venta;
	private int cedula_cli;
	private String nombrecli;
	private int cedula_usu;
	private double valorventa;
	private double ivaventa;
	private double totalventa;
	public ventasDTO(int cod_venta, int cedula_cli, String nombrecli, int cedula_usu, double valorventa, double ivaventa, 
			double totalventa) {
		this.cod_venta = cod_venta;
		this.cedula_cli = cedula_cli;
		this.nombrecli = nombrecli;
		this.cedula_usu = cedula_usu;
		this.valorventa = valorventa;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
	}

	public ventasDTO(int cedula_cli, String nombrecli, int cedula_usu, double valorventa, double ivaventa, double totalventa) {
		this.cedula_cli = cedula_cli;
		this.nombrecli = nombrecli;
		this.cedula_usu = cedula_usu;
		this.valorventa = valorventa;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
	}

	public ventasDTO(int cod_venta, int cedula_cli,String nombrecli, double totalventa) {
		this.cod_venta = cod_venta;
		this.cedula_cli = cedula_cli;
		this.nombrecli = nombrecli;
		this.totalventa = totalventa;
	}

	public ventasDTO(int cod_venta) {
		this.cod_venta = cod_venta;
	}

	public int getCod_venta() {
		return cod_venta;
	}
	public void setCod_venta(int cod_venta) {
		this.cod_venta = cod_venta;
	}
	public int getCedula_cli() {
		return cedula_cli;
	}
	public void setCedula_cli(int cedula_cli) {
		this.cedula_cli = cedula_cli;
	}
	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}
	public int getCedula_usu() {
		return cedula_usu;
	}
	public void setCedula_usu(int cedula_usu) {
		this.cedula_usu = cedula_usu;
	}
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotalventa() {
		return totalventa;
	}
	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}
	
	}