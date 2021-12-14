package ups.edu.ec.examen.business;

import java.util.List;

import javax.ejb.Remote;

import ups.edu.ec.examen.model.Vehiculo;

@Remote
public interface VehiculoONRemoto {

	public void insertar(Vehiculo p) throws Exception;
	
	public void actualizar (Vehiculo p) throws Exception ;
	
	public List<Vehiculo>getVehiculo();
	
	public Vehiculo buscar(String id);
}
