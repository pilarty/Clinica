package descuentosObraSocial;

public class DescuentoBasico implements CalculoDescuento{
	@Override
	public double calcularDescuento() {
		return 0.85;
	}

	@Override
	public String obtenerDescuento() {
		return "15%";
	}

}
