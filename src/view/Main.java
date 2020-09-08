package view;

import javax.swing.JOptionPane;

import controller.Processos;

public class Main {

	public static void main(String[] args) {
		Processos processos = new Processos();
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(
"Menu\n1) Ver Processos \n2) Matar processos por PID\n3) Matar processos por nome\n4) Sair"));
		String nomeSO = processos.nomeSO();
		switch (opcao) {
		case 1:
			String os = System.getProperty("os.name");
			processos.ListaProcessos(nomeSO);
			break;
		case 2:
			String PID = JOptionPane.showInputDialog("Digite o PID do processo");
			processos.mataProcessoPID(nomeSO, PID);
		case 3:
			String nomeProcesso = JOptionPane.showInputDialog("Digite o PID do processo");
			processos.MataProcessoNome(nomeSO, nomeProcesso);
		case 4:
			System.exit(0);
			break;
		}
	}
}