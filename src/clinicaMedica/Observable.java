package clinicaMedica;

public interface Observable {
	void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String mensaje);
}
