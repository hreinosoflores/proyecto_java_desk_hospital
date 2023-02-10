package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField jpassContrasenia;
	private JLabel imglogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Ingreso del sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Source Code Pro", Font.PLAIN, 20));
		lblLogin.setBounds(243, 13, 78, 26);
		contentPane.add(lblLogin);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Source Code Pro", Font.PLAIN, 20));
		lblUsuario.setBounds(205, 100, 116, 26);
		contentPane.add(lblUsuario);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Source Code Pro", Font.PLAIN, 20));
		lblContrasea.setBounds(203, 166, 132, 26);
		contentPane.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(365, 102, 185, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);

		btnIngresar.setIcon(new ImageIcon(
				"F:\\CIBERTEC 2017 - 2\\algoritmo y estructura de datos\\proyecto\\Proyecto Final AED\\Proyecto 2017-2\\Imagenes\\ingresar.png"));
		btnIngresar.setFont(new Font("Source Code Pro", Font.PLAIN, 20));
		btnIngresar.setBounds(205, 248, 185, 57);
		contentPane.add(btnIngresar);

		jpassContrasenia = new JPasswordField();
		jpassContrasenia.setBounds(365, 168, 185, 26);
		contentPane.add(jpassContrasenia);

		imglogo = new JLabel("");

		imglogo.setIcon(new ImageIcon(
				"F:\\CIBERTEC 2017 - 2\\algoritmo y estructura de datos\\proyecto\\Proyecto Final AED\\Proyecto 2017-2\\Imagenes\\paciente internado.jpg"));
		imglogo.setBounds(32, 60, 141, 163);
		contentPane.add(imglogo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		char[] clave = jpassContrasenia.getPassword();
		String claveFinal = new String(clave);
		if (txtUsuario.getText().equals("123456") && claveFinal.equals("123456")) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "INGRESASTE", JOptionPane.INFORMATION_MESSAGE);
			Principal_Proyecto2017_2 p = new Principal_Proyecto2017_2();
			p.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			jpassContrasenia.setText("");
			txtUsuario.requestFocus();
		}

	}
}
