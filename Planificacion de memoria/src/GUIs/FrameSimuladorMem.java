package GUIs;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import algoritmos.*;

import java.awt.Choice;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrameSimuladorMem extends JFrame {

	private JPanel contentPane;
	private JTextField cantF;
	private JTextArea txtrProce;
	private JProgressBar barra;
	private JButton btnIniciar;
	private Choice choiceAlg;
	private JTextArea txtrLote;
	private JCheckBox chckbxDA;
	private JCheckBox chckbxMultProce;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrameSimuladorMem frame = new FrameSimuladorMem();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public FrameSimuladorMem() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconoSimulador.jpg")));
		setTitle("RadGear - Simulador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		this.setMinimumSize(new Dimension(450, 320));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel = new JLabel("Lote de requerimientos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_4.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1, BorderLayout.CENTER);

		txtrLote = new JTextArea();
		txtrLote.setText("1c 1a 2a 3c 1b 1a M1c 2b 5b 7a 5c M2b M2a 2b 1b 2a 4b 5b 1c 4c 2c 7a 3a 2a 3c");
		txtrLote.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtrLote.setLineWrap(true);
		scrollPane_1.setViewportView(txtrLote);

		JLabel lblNewLabel_1 = new JLabel("Procesos y duracion");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 3;
		panel_4.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);

		txtrProce = new JTextArea();
		txtrProce.setText("25a 22b 25c");
		txtrProce.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtrProce.setLineWrap(true);
		scrollPane.setViewportView(txtrProce);

		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10, BorderLayout.EAST);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] { 0, 0 };
		gbl_panel_10.rowHeights = new int[] { 0, 0 };
		gbl_panel_10.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_10.rowWeights = new double[] { 0.0, 1.0 };
		panel_10.setLayout(gbl_panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		panel_10.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 0, 0 };
		gbl_panel_11.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_11.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_11.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 95, 14, 0 };
		gbl_panel_3.rowHeights = new int[] { 20, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblCantidadDeMarcos = new JLabel("Cantidad de marcos");
		GridBagConstraints gbc_lblCantidadDeMarcos = new GridBagConstraints();
		gbc_lblCantidadDeMarcos.anchor = GridBagConstraints.WEST;
		gbc_lblCantidadDeMarcos.insets = new Insets(0, 0, 0, 5);
		gbc_lblCantidadDeMarcos.gridx = 0;
		gbc_lblCantidadDeMarcos.gridy = 0;
		panel_3.add(lblCantidadDeMarcos, gbc_lblCantidadDeMarcos);

		cantF = new JTextField();
		cantF.setText("7");
		GridBagConstraints gbc_cantF = new GridBagConstraints();
		gbc_cantF.anchor = GridBagConstraints.NORTHWEST;
		gbc_cantF.gridx = 1;
		gbc_cantF.gridy = 0;
		panel_3.add(cantF, gbc_cantF);
		cantF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!Character.isDigit(arg0.getKeyChar())) {
					arg0.consume();
				}
				if (cantF.getText().length() == 2
						&& !(arg0.getKeyChar() == KeyEvent.VK_DELETE || arg0.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		cantF.setHorizontalAlignment(SwingConstants.CENTER);
		cantF.setColumns(2);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel_11.add(panel_1, gbc_panel_1);

		chckbxDA = new JCheckBox("Descarga asincronica");
		GridBagConstraints gbc_chckbxDA = new GridBagConstraints();
		gbc_chckbxDA.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDA.gridx = 0;
		gbc_chckbxDA.gridy = 2;
		panel_11.add(chckbxDA, gbc_chckbxDA);
		chckbxDA.setSelected(true);

		chckbxMultProce = new JCheckBox("Multiples procesos");
		chckbxMultProce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractButton abs = (AbstractButton) arg0.getSource();
				if (!abs.isSelected()) {
					txtrProce.setEnabled(false);
					txtrProce.setText("");
				} else
					txtrProce.setEnabled(true);
			}
		});
		chckbxMultProce.setSelected(true);
		GridBagConstraints gbc_chckbxMultProce = new GridBagConstraints();
		gbc_chckbxMultProce.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxMultProce.gridx = 0;
		gbc_chckbxMultProce.gridy = 3;
		panel_11.add(chckbxMultProce, gbc_chckbxMultProce);

		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 4;
		panel_11.add(panel_7, gbc_panel_7);

		JLabel lblAlgoritmo = new JLabel("Algoritmo:");
		GridBagConstraints gbc_lblAlgoritmo = new GridBagConstraints();
		gbc_lblAlgoritmo.insets = new Insets(0, 0, 5, 0);
		gbc_lblAlgoritmo.gridx = 0;
		gbc_lblAlgoritmo.gridy = 5;
		panel_11.add(lblAlgoritmo, gbc_lblAlgoritmo);

		choiceAlg = new Choice();
		GridBagConstraints gbc_choiceAlg = new GridBagConstraints();
		gbc_choiceAlg.insets = new Insets(0, 0, 5, 0);
		gbc_choiceAlg.gridx = 0;
		gbc_choiceAlg.gridy = 6;
		panel_11.add(choiceAlg, gbc_choiceAlg);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		panel_11.add(panel, gbc_panel);
		choiceAlg.add("FIFO");
		choiceAlg.add("LRU");
		choiceAlg.add("SEG.CHANCE");

		JPanel panel_12_1 = new JPanel();
		panel_12_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_12_1 = new GridBagConstraints();
		gbc_panel_12_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12_1.fill = GridBagConstraints.BOTH;
		gbc_panel_12_1.gridx = 0;
		gbc_panel_12_1.gridy = 1;
		panel_10.add(panel_12_1, gbc_panel_12_1);
		GridBagLayout gbl_panel_12_1 = new GridBagLayout();
		gbl_panel_12_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_12_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_12_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_12_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_12_1.setLayout(gbl_panel_12_1);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnIniciar.setEnabled(false);
				int frames;
				String tmp1 = cantF.getText();
				String tmp2 = txtrProce.getText();
				String tmp3 = txtrLote.getText();
				boolean multP = chckbxMultProce.isSelected();
				boolean DA = chckbxDA.isSelected();
				if (tmp1.isEmpty() || (tmp2.isEmpty() && multP) || tmp3.isEmpty() || (DA && tmp1.equals("1")))
					frames = 0;
				else
					frames = Integer.parseInt(tmp1);
				if (frames > 0) {
					// Se recuperan los datos
					String alg = choiceAlg.getSelectedItem();
					// Se generan las estructuras
					String[] lote = tmp3.split(" ");
					ArrayList<String> proce = null;
					if (multP) {
						String[] proc = tmp2.split(" ");
						proce = new ArrayList<String>();
						for (String s : proc) {
							proce.add(s);
						}
						Collections.sort(proce);
					}
					// Se crea el hilo de procesamiento
					if (alg.equals("SEG.CHANCE"))
						new Thread(new SegChance(lote, frames, DA, proce, barra, btnIniciar)).start();
					else
						new Thread(new FIFOyLRU(lote, frames, DA, proce, barra, alg, btnIniciar)).start();
				} else {
					btnIniciar.setEnabled(true);
					getToolkit().beep();
				}
			}
		});
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.insets = new Insets(0, 0, 5, 0);
		gbc_btnIniciar.gridx = 0;
		gbc_btnIniciar.gridy = 0;
		panel_12_1.add(btnIniciar, gbc_btnIniciar);

		barra = new JProgressBar();
		barra.setStringPainted(true);
		GridBagConstraints gbc_barra = new GridBagConstraints();
		gbc_barra.gridx = 0;
		gbc_barra.gridy = 1;
		panel_12_1.add(barra, gbc_barra);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		panel_2.add(panel_8, gbc_panel_8);

		JLabel lblNewLabel_2 = new JLabel("Version 1.0, 28/12/2020 - Barral, Adrian Daniel");
		lblNewLabel_2.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
	}

}
