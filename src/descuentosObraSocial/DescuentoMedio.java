package descuentosObraSocial;

public class DescuentoMedio implements CalculoDescuento{

	@Override
	public double calcularDescuento() {
		return 0.75;
	}

	@Override
	public String obtenerDescuento() {
		return "25%";
	}

}
