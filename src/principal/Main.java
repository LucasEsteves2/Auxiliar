package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import progressBarr.Progress2;
import visual.Menu;

public class Main {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException

	{

		// Verifica se as pastas existem, caso contrario cria as pastas
		verificaPastas();

		boolean pastaExiste = verificador();

		// so vai instanciar se a pasta existir (evitando bugs)

		if (pastaExiste) {

			abreAplicativo();

		} else {

			JOptionPane.showMessageDialog(null,
					"'Precisamos do diretorio 'programador' para o funcionamento da aplicação!!", // mensagem
					"PROGRAMA FINALIZADO", // titulo da janela
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static ArrayList<String> ler() {

		String dir = System.getProperty("user.home");
		String pastaPai = Path.of(dir, "Desktop").toString();
		Scanner ler = new Scanner(System.in);

		String nome = pastaPai + "/PROGRAMADOR/pastas.txt";
		ArrayList<String> pastas = new ArrayList<String>();

		try {

			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha

			if (linha == null) {
				FileWriter escreve = new FileWriter(pastaPai + "/PROGRAMADOR/pastas.txt", true);
				escreve.append("FAETERJ ");
				escreve.append("\r\n");
				escreve.append("SERRATEC");
				escreve.append("\r\n");
				escreve.append("PROJETOS");
				escreve.close();

			}

			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto

			while (linha != null) {

				pastas.add(linha);

				linha = lerArq.readLine(); // lê da segunda até a última linha

			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		return pastas;

	}

//metodos

	public static void abreAplicativo() {

		ArrayList<String> pastas = new ArrayList<String>();

		// bloco de notas onde vai ficar o nome das pastas

		pastas = ler();
		Menu tela1 = new Menu(pastas);
		tela1.setLocationRelativeTo(null);
		tela1.setVisible(true);
	}

	public static void criaBlocoNotas(String pastaPai) {
		File file = new File(pastaPai + "/PROGRAMADOR/pastas.txt");

		try {
			// para criar o arquivo
			file.createNewFile();
			System.out.println("Bloco de notas criado");

		} catch (IOException io) {
			io.printStackTrace();

		}

	}

	// metodo que verifica se as pastas existem (se nao cria as pastas)

	public static void verificaPastas() {

		// pega o diretoria da area de trabalho
		String dir = System.getProperty("user.home");

		criaPastaPai(dir);
		criaDiretorioProjetos(dir);
		criaDiretorioFaculdade(dir);
		criaDiretorioSerratec(dir);
		criaDiretorioIde(dir);

	}

	private static boolean verificador() {

		String dir = System.getProperty("user.home");
		String pastaPai = Path.of(dir, "Desktop").toString();

		criaBlocoNotas(pastaPai);

		File f = new File(pastaPai + "/PROGRAMADOR");

		if (f.exists()) { // so vai instanciar se a pasta existir (evitando bugs)
			System.out.println("ARQUIVO JA EXISTE");
			return true;

		}

		return false;
	}

	static void criaPastaPai(String dir) {
		String pastaPai = Path.of(dir, "Desktop").toString();

		File f = new File(pastaPai + "/PROGRAMADOR");

		try {
			if (!f.exists()) {

				int i = JOptionPane.showConfirmDialog(null,
						"Não encontramos o diretorio 'programador' em seu computador\n\n"
								+ "                *Deseja criar o diretorio 'programador' ?",
						"ERROR 404!", JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.YES_OPTION) {

					System.out.println("Clicou em Sim");

					Progress2 barra = new Progress2();
					barra.setLocationRelativeTo(null);
					barra.setVisible(true);

					if (f.mkdir()) { // se a pasta nao existir

					}

					System.out.println("Directory Created");

				} else if (i == JOptionPane.CANCEL_OPTION) {

					JOptionPane.showMessageDialog(null,
							"'Precisamos do diretorio 'programador' para o funcionamento da aplicação!!", // mensagem
							"PROGRAMA FINALIZADO", // titulo da janela
							JOptionPane.ERROR_MESSAGE);

					System.out.println("Clicou em Não");
					// ENCERRA APP
					System.exit(0);

				}

			}

			else {
				System.out.println("Directory is not created,PASTA PAI JA EXISTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void criaDiretorioProjetos(String dir) {
		String pastaPai = Path.of(dir, "Desktop/PROGRAMADOR").toString();

		File f = new File(pastaPai + "/PROJETOS");

		try {
			if (f.mkdir()) {
				System.out.println("Directory Created");
			} else {
				System.out.println("Directory is not created, PROJETOS JA EXISTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void criaDiretorioFaculdade(String dir) {
		String pastaPai = Path.of(dir, "Desktop/PROGRAMADOR").toString();

		File f = new File(pastaPai + "/Faeterj.2");
		try {
			if (f.mkdir()) {
				System.out.println("Directory Created");
			} else {
				System.out.println("Directory is not created,FAETERJ JA EXISTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void criaDiretorioSerratec(String dir) {
		String pastaPai = Path.of(dir, "Desktop/PROGRAMADOR").toString();

		File f = new File(pastaPai + "/SERRATEC");

		try {
			if (f.mkdir()) {
				System.out.println("Directory Created");
			} else {
				System.out.println("Directory is not created, SERRATEC JA EXISTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void criaDiretorioIde(String dir) {
		String pastaPai = Path.of(dir, "Desktop/PROGRAMADOR").toString();

		File f = new File(pastaPai + "/IDE");

		try {
			if (f.mkdir()) {
				System.out.println("Directory Created");
			} else {
				System.out.println("Directory is not created, SERRATEC JA EXISTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
