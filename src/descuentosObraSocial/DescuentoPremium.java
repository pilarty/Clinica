package descuentosObraSocial;

public class DescuentoPremium implements CalculoDescuento{

	@Override
	public double calcularDescuento() {
		return 0.50;
	}

	@Override
	public String obtenerDescuento() {
		return "50%";
	}

}
