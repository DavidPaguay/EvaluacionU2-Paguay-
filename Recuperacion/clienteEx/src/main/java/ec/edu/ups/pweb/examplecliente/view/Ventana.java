package ec.edu.ups.pweb.examplecliente.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ups.edu.ec.examen.business.VehiculoONRemoto;
import ups.edu.ec.examen.model.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlacaB;
	private JTextField txtPlacaSet;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private VehiculoONRemoto vehiRemoto;
	JFrame jFrame = new JFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
					frame.conectar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRAR VEHICULOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(230, 21, 337, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PLACA: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(33, 78, 63, 25);
		panel.add(lblNewLabel_1);
		
		txtPlacaB = new JTextField();
		txtPlacaB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPlacaB.setBounds(94, 81, 118, 24);
		panel.add(txtPlacaB);
		txtPlacaB.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Vehiculo ve= vehiRemoto.buscar(txtPlacaB.getText());
				if (ve==null) {
					
					txtPlacaSet.setText(txtPlacaB.getText());
					txtMarca.setText("");
					txtModelo.setText("");
					txtPrecio.setText("");
					JOptionPane.showMessageDialog(jFrame, "Vehiculo no registrado, ingrese los datos");
				}else{
					
					txtPlacaSet.setText(txtPlacaB.getText());
					txtPlacaSet.setText(ve.getPlaca());
					txtMarca.setText(ve.getMarca());
					txtModelo.setText(ve.getModelo());
					txtPrecio.setText(ve.getPrecio()+"");}
					
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(220, 79, 85, 25);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLACA: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(33, 119, 63, 25);
		panel.add(lblNewLabel_1_1);
		
		txtPlacaSet = new JTextField();
		txtPlacaSet.setEditable(false);
		txtPlacaSet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPlacaSet.setBounds(94, 122, 118, 24);
		panel.add(txtPlacaSet);
		txtPlacaSet.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("MARCA:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(230, 124, 75, 25);
		panel.add(lblNewLabel_1_1_1);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMarca.setColumns(10);
		txtMarca.setBounds(294, 122, 118, 24);
		panel.add(txtMarca);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("MODELO: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(422, 119, 75, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModelo.setColumns(10);
		txtModelo.setBounds(492, 122, 118, 24);
		panel.add(txtModelo);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("PRECIO: ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(214, 174, 75, 25);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(294, 177, 118, 24);
		panel.add(txtPrecio);
		
		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				crearvehiculo(txtPlacaSet.getText(), txtMarca.getText(),txtModelo.getText(),Double.parseDouble(txtPrecio.getText()));
				
			}
		});
		btnNewButton.setBounds(184, 223, 105, 31);
		panel.add(btnNewButton);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				update(txtPlacaSet.getText(), txtMarca.getText(), txtModelo.getText(), Double.parseDouble(txtPrecio.getText()));
			}});
		btnActualizar.setBounds(307, 223, 105, 31);
		panel.add(btnActualizar);
	}
	
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
			JOptionPane.showMessageDialog(jFrame, "Vehiculo Guardado");
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
			JOptionPane.showMessageDialog(jFrame, "Vehiculo Actualizado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no me guarde");
			e.printStackTrace();
		}
	}
}
