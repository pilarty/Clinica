package descuentosObraSocial;

public class DescuentoJubilado implements CalculoDescuento {

	@Override
	public double calcularDescuento() {
		return 0.15;
	}

	@Override
	public String obtenerDescuento() {
		return "75%";
	}

}
