package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Principal {
	public static String os, version;

	private static String Sistema(String OS, String Version) {
		OS = System.getProperty("os.name");
		Version = System.getProperty("os.version");
		return OS + "\nVersão: " + Version;
	}

	public static void main(String[] args) {
		RedesController Controller = new RedesController();
		String process = null;
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- System \n 2-IP \n 3-Ping \n 9- Fechar "));
			switch (opc) {
			case 1:
				os = Sistema(os, version);
				System.out.println("Sistema: " + os);
				break;
			case 2:
				if (os.contains("Windows")) {
					process = "ipconfig";
				} else {
					process = "ifconfig";
				}
				Controller.ProcessRead(process, os, opc);
				break;
			case 3:
				if (os.contains("Windows")) {
					process = "ping -4 -n 10 www.uol.com.br";
				} else {
					process = "ping -4 -c 10 www.uol.com.br";
				}
				Controller.ProcessRead(process, os, opc);
				break;
			case 9:
				System.exit(0); 
				break;
			default: 
				System.err.println("Erro");
				break;
			}
		}
	}
}