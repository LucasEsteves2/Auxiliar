package progressBarr;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class Progress2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JProgressBar progressBar;
	private final JLabel lblNewLabel_1 = new JLabel("Loading....");

	private final JLabel lblNewLabel_2 = new JLabel("");

	public Progress2() {

		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 344, 142);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			progressBar = new JProgressBar();
			progressBar.setForeground(new Color(50, 200, 50));
			progressBar.setMaximum(1000);
			progressBar.setStringPainted(true);
			progressBar.setBounds(26, 43, 285, 27);
			contentPanel.add(progressBar);

			JLabel lblNewLabel = new JLabel("          Criando Diretorios!!");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(68, 76, 210, 19);
			contentPanel.add(lblNewLabel);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(134, 13, 120, 19);

			contentPanel.add(lblNewLabel_1);
			lblNewLabel_2.setIcon(new ImageIcon(Progress2.class.getResource("/imgs/s2.jpg")));
			lblNewLabel_2.setBounds(0, -1, 368, 114);

			contentPanel.add(lblNewLabel_2);
			new Temporizador().start();

		}
	}

	public class Temporizador extends Thread {

		public void run() {

			while (progressBar.getValue() < 1000) {

				try {
					sleep(20);
					progressBar.setValue(progressBar.getValue() + 10);
					System.out.println();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			JOptionPane.showMessageDialog(null, "'Diretorio criado com sucesso!!", // mensagem
					"Sucess", // titulo da janela
					JOptionPane.INFORMATION_MESSAGE);

			dispose();
		}
	}

}
