package GUIs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPasswordField;

public class LogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsr;
	private JPasswordField textFieldPass;
	private final String NOMBRE = "Adrian Daniel Barral";
	private final String CLAVE = "38917108";
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogIn dialog = new LogIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogIn() {
		setTitle("Iniciar sesion");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
		}
		{
			JLabel lblUsr = new JLabel("Usuario");
			GridBagConstraints gbc_lblUsr = new GridBagConstraints();
			gbc_lblUsr.insets = new Insets(0, 0, 5, 0);
			gbc_lblUsr.gridx = 0;
			gbc_lblUsr.gridy = 1;
			contentPanel.add(lblUsr, gbc_lblUsr);
		}
		{
			textFieldUsr = new JTextField();
			textFieldUsr.setText(this.NOMBRE);
			textFieldUsr.setEditable(false);
			textFieldUsr.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textFieldUsr = new GridBagConstraints();
			gbc_textFieldUsr.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUsr.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUsr.gridx = 0;
			gbc_textFieldUsr.gridy = 2;
			contentPanel.add(textFieldUsr, gbc_textFieldUsr);
			textFieldUsr.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
		}
		{
			JLabel lblPass = new JLabel("Contrase\u00F1a");
			GridBagConstraints gbc_lblPass = new GridBagConstraints();
			gbc_lblPass.insets = new Insets(0, 0, 5, 0);
			gbc_lblPass.gridx = 0;
			gbc_lblPass.gridy = 4;
			contentPanel.add(lblPass, gbc_lblPass);
		}
		{
			textFieldPass = new JPasswordField();
			textFieldPass.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_textFieldPass = new GridBagConstraints();
			gbc_textFieldPass.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPass.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPass.gridx = 0;
			gbc_textFieldPass.gridy = 5;
			contentPanel.add(textFieldPass, gbc_textFieldPass);
			textFieldPass.setColumns(10);
		}
		{
			lblError = new JLabel("Credenciales invalidas!");
			lblError.setVisible(false);
			lblError.setForeground(Color.RED);
			GridBagConstraints gbc_lblError = new GridBagConstraints();
			gbc_lblError.gridx = 0;
			gbc_lblError.gridy = 6;
			contentPanel.add(lblError, gbc_lblError);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String str = String.copyValueOf(textFieldPass.getPassword());
						if (str != null && str.equals(CLAVE)) {
							/**
							 * Launch the application.
							 */
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										FrameSimuladorMem frame = new FrameSimuladorMem();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							terminar();
						}
						else {
							lblError.setVisible(true);
							getToolkit().beep();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	private void terminar() {
		this.dispose();
	}
}
