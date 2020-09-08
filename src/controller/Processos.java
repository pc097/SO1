package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Processos {
	public Processos() {
		super();
	}

	public String nomeSO() {
		String nome = System.getProperty("os.name");
		return nome;
	}

	public void ListaProcessos(String nomeSO) {
		try {
			if (nomeSO.contains("Windows")) {
				Process processo = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				fluxo.close();
				leitor.close();
			} else if (nomeSO.contains("Linux")) {
				Process processo = Runtime.getRuntime().exec("ps");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}

				buffer.close();
				fluxo.close();
				leitor.close();
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

	public void mataProcessoPID(String nomeSO, String PID) {
		if(nomeSO.contains("Windows")){
		String cmdPID = "TASKKILL /PID";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		pid = Integer.parseInt(PID);
		buffer.append(cmdPID);
		buffer.append(" ");
		buffer.append(PID);
	}else if (nomeSO.contains("Linux")){
		String cmdPID = "KILL";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		pid = Integer.parseInt(PID);
		buffer.append(cmdPID);
		buffer.append(" ");
		buffer.append(PID);
		}
	}

	public void MataProcessoNome(String nomeSO, String nomeProcesso) {
		if(nomeSO.contains("Windows")){
			String cmdPID = "TASKKILL /PID";
			String pid = "";
			StringBuffer buffer = new StringBuffer();
			pid = nomeProcesso;
			buffer.append(cmdPID);
			buffer.append(" ");
			buffer.append(nomeProcesso);
		}else if (nomeSO.contains("Linux")){
			String cmdPID = "KILL";
			String pid = "";
			StringBuffer buffer = new StringBuffer();
			buffer.append(cmdPID);
			buffer.append(" ");
			buffer.append(nomeProcesso);
			}
	}
}
