package cambiosDivisas;

public class Divisa {
	private String moneda;
	private double valor;
	
	Divisa(){}
	Divisa(String _moneda,double _valor){
		moneda=_moneda;
		valor=_valor;
	}
	
	public String toString() {
		return moneda;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	}

