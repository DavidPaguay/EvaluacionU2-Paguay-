package ec.edu.ups.pweb.examplecliente.view;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.sshd.common.SyspropsMapWrapper;

import ups.edu.ec.examen.business.VehiculoONRemoto;
import ups.edu.ec.examen.model.Vehiculo;





public class VentanaCalculadora {
	
	private VehiculoONRemoto vehiRemoto;
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "David");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "David");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/examen/VehiculoON!ups.edu.ec.examen.business.VehiculoONRemoto"; 
            
            this.vehiRemoto = (VehiculoONRemoto) context.lookup(lookupName);  
            

              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void crearvehiculo(String placa, String marca, String modelo, Double precio) {
		
		Vehiculo vehi = new Vehiculo();
		
		vehi.setPlaca(placa);
		vehi.setMarca(marca);
		vehi.setModelo(modelo);
		vehi.setPrecio(precio);
		try {
			vehiRemoto.insertar(vehi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no me guarde");
			e.printStackTrace();
		}
	}
	public void update(String placa, String marca, String modelo, Double precio) {
		
		Vehiculo vehi = new Vehiculo();
		
		vehi.setPlaca(placa);
		vehi.setMarca(marca);
		vehi.setModelo(modelo);
		vehi.setPrecio(precio);
		try {
			vehiRemoto.actualizar(vehi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no me guarde");
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VentanaCalculadora vtnCalc = new VentanaCalculadora();
		
		try {
			vtnCalc.conectar();
			//vtnCalc.crearvehiculo("AHD-134", "Toyota", "Yaris", 1283.0);
			vtnCalc.update("AHD-134", "Ford", "4x4", 18983.0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
