package modelo;

public class detalleventasDTO {
	private int cod_venta;
	private int cant_producto;
	private int cod_producto;
	private double valor_venta;
	private double valor_iva;
	private double valor_total;
	
	
	public detalleventasDTO(int cod_venta, int cant_producto, int cod_producto, double valor_venta,
			double valor_iva, double valor_total) {
		this.cod_venta = cod_venta;
		this.cant_producto = cant_producto;
		this.cod_producto = cod_producto;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
		this.valor_total = valor_total;
	}

	public int getCant_producto() {
		return cant_producto;
	}

	public void setCant_producto(int cant_producto) {
		this.cant_producto = cant_producto;
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public int getCod_venta() {
		return cod_venta;
	}

	public void setCod_venta(int cod_venta) {
		this.cod_venta = cod_venta;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}

}