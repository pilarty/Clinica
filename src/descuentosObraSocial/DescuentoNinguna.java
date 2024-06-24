package descuentosObraSocial;

public class DescuentoNinguna implements CalculoDescuento {

	@Override
	public double calcularDescuento() {
		return 0;
	}

	@Override
	public String obtenerDescuento() {
		return "0%";
	}

}
