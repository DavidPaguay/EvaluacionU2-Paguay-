package ups.edu.ec.examen.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.examen.model.Vehiculo;

@Stateless
public class VehiculoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo op) {
		
		em.persist(op);
	}
	
	public void update(Vehiculo op) {
		
		em.merge(op);
	}
	
	public Vehiculo read(int id) {
		
		Vehiculo op = em.find(Vehiculo.class, id);
		return op;
	}
	
	public void Delete(int id) {
		
		Vehiculo op = em.find(Vehiculo.class, id);
		em.remove(op);
	}
	
	public List<Vehiculo> getList(){
		 
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		
		String jpql = "SELECT op FROM Vehiculo op";
				
		
		Query query = em.createQuery(jpql,Vehiculo.class);
		listado=query.getResultList();
		
		return listado;
	}
	
	public Vehiculo buscar(String id) {
		
		System.out.println("Llegaste "+id);
		Vehiculo pro = new Vehiculo();
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		
		String jpql = "SELECT op FROM Vehiculo op"
		         + "     WHERE op.placa = ?1"; 
		
		Query query = em.createQuery(jpql,Vehiculo.class);
		query.setParameter(1, id);
		pro= (Vehiculo) query.getSingleResult();
		
		return pro;
	}

}
