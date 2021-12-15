package ups.edu.ec.examen.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.examen.dao.VehiculoDAO;
import ups.edu.ec.examen.model.Vehiculo;


@Stateless
public class VehiculoON implements VehiculoONRemoto {
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	public void insertar(Vehiculo p) throws Exception{
		daoVehiculo.insert(p);
	}
	
	public void actualizar (Vehiculo p)  throws Exception{
		daoVehiculo.update(p);;
	}
	
	public List<Vehiculo>getVehiculo(){
		
		return daoVehiculo.getList();
	}
	
	public Vehiculo buscar(String id){
		
		return daoVehiculo.buscar(id);
	}
	
	
}
