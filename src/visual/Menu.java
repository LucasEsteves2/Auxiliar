package visual;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private String dir = System.getProperty("user.home");
	private String pastaPai = Path.of(dir, "Desktop/PROGRAMADOR").toString();
	private String faculdade = pastaPai + "\\Faeterj.2";
	private String projetos = pastaPai + "\\PROJETOS";
	private String serratec = pastaPai + "\\SERRATEC";

	private String pasta1;
	private String pasta2;
	private String pasta3;
	
	
	private String git = pastaPai + "\\git.pdf";
	private String ide = pastaPai + "\\IDE";
	
	
	public Menu(ArrayList<String> pastas) {
		
		
		//pegando nome das pastas no bloco de notas
		pasta1=pastas.get(0);
		pasta2=pastas.get(1);
		pasta3=pastas.get(2);
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imgs/projeto.png")));

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Esteves");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ScrollPane scrollPane2_1 = new ScrollPane();
		scrollPane2_1.setBounds(-7, 0, 526, 14);
		contentPane.add(scrollPane2_1);

		JLabel lblIde = new JLabel("");
		

		lblIde.setIcon(new ImageIcon(Menu.class.getResource("/imgs/exe (1).png")));
		lblIde.setBounds(209, 264, 24, 24);
		contentPane.add(lblIde);

		JLabel lblGit = new JLabel("");

		lblGit.setIcon(new ImageIcon(Menu.class.getResource("/imgs/github (1).png")));
		lblGit.setBounds(13, 259, 32, 32);
		contentPane.add(lblGit);

		JLabel lblClickXml = new JLabel("");

		lblClickXml.setBounds(6, 121, 230, 54);
		contentPane.add(lblClickXml);

		JLabel lblClickNovoAluno = new JLabel("");

		lblClickNovoAluno.setBounds(6, 11, 230, 56);
		contentPane.add(lblClickNovoAluno);

		JLabel lblClickView = new JLabel("");

		lblClickView.setBounds(8, 64, 228, 54);
		contentPane.add(lblClickView);

		JLabel lblFaculdade = new JLabel(pasta1);
		lblFaculdade.setIconTextGap(11);
		lblFaculdade.setIcon(new ImageIcon(Menu.class.getResource("/imgs/estude.png")));
		lblFaculdade.setFont(new Font("Arial", Font.BOLD, 14));
		lblFaculdade.setBounds(41, 26, 184, 32);
		contentPane.add(lblFaculdade);

		JLabel lblSerratec = new JLabel(pasta2);
		lblSerratec.setIconTextGap(11);
		lblSerratec.setIcon(new ImageIcon(Menu.class.getResource("/imgs/pilha-de-livros.png")));
		lblSerratec.setFont(new Font("Arial", Font.BOLD, 14));
		lblSerratec.setBounds(42, 78, 169, 32);
		contentPane.add(lblSerratec);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(6, 121, 230, 2);
		contentPane.add(separator_2_1);

		JLabel lblProjetos = new JLabel(pasta3);
		lblProjetos.setIconTextGap(11);
		lblProjetos.setIcon(new ImageIcon(Menu.class.getResource("/imgs/circuito-eletronico.png")));
		lblProjetos.setFont(new Font("Arial", Font.BOLD, 14));
		lblProjetos.setBounds(41, 133, 184, 32);
		contentPane.add(lblProjetos);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 66, 230, 11);
		contentPane.add(separator_2);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(-26, 0, 32, 177);
		contentPane.add(scrollPane);

		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(3, -6, 236, 183);
		contentPane.add(scrollPane_1);

		JLabel lblFundo = new JLabel("");
		lblFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFundo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFundo.setIcon(new ImageIcon(Menu.class.getResource("/imgs/foi.png")));
		lblFundo.setBounds(-3, 172, 263, 136);
		contentPane.add(lblFundo);

		ScrollPane scrollPane2_2 = new ScrollPane();
		scrollPane2_2.setBounds(-79, 0, 519, 11);
		contentPane.add(scrollPane2_2);

		JLabel lblclickPassageiro = new JLabel("");
		lblclickPassageiro.setBounds(6, 122, 223, 53);
		contentPane.add(lblclickPassageiro);

		// Abre pasta da faculdade
		lblFaculdade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					java.awt.Desktop.getDesktop().open(new File(faculdade));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// Abre meus projetos
		lblProjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					java.awt.Desktop.getDesktop().open(new File(projetos));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		lblSerratec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					java.awt.Desktop.getDesktop().open(new File(serratec));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		lblGit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "Deseja abrir o manual do git??", "COMO USAR O GIT.PDF",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");

					try {

						java.awt.Desktop.getDesktop().open(new File(git));
					} catch (IOException e1)

					{
						System.out.println("NAO EXISTE");
						e1.printStackTrace();

						JOptionPane.showMessageDialog(null,
								"Por favor, certifique se o arquivo git.pdf esteja dentro da pasta PROGRAMADOR'"
										+ "'Por favor,adicione o arquivo git.pdf para a pasta que foi aberta '", // mensagem
								"Erro 404", // titulo da janela
								JOptionPane.ERROR_MESSAGE);

						try {
							java.awt.Desktop.getDesktop().open(new File(pastaPai));
						} catch (IOException e2) {

							e2.printStackTrace();
						}

					}

				} else if (i == JOptionPane.CANCEL_OPTION) {

					System.out.println("Clicou em Não");

				}

			}
		});

		
		//abre pasta de ide
		lblIde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					java.awt.Desktop.getDesktop().open(new File(ide));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		
		/*
		lblPs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "Deseja abrir o PHOTOSHOP?", "ABRIR PHOTHOSOP",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");

					try {

						java.awt.Desktop.getDesktop()
								.open(new File("C:\\Users\\Lucas-Gosotsão\\Documents\\PHOTOSHOP\\PSCS6.exe"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (i == JOptionPane.CANCEL_OPTION) {

					System.out.println("Clicou em Não");

				}

			}
		});
*/
	}
}