package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}

	public void ProcessRead(String process, String OS, int option) {
		try {
			Process read = Runtime.getRuntime().exec(process); 
			InputStream flow = read.getInputStream(); 
			InputStreamReader reading = new InputStreamReader(flow); 
			BufferedReader buffer = new BufferedReader(reading); 
			String line = buffer.readLine(); 

			while (line != null) {
				if (option == 2) { 
					if (OS.contains("Windows")) { 
						if (line.contains("IPv4")) {
							String vet[] = line.trim().split(":");
							System.out.println("IPv4: " + vet[1]);
							
						}
					} else {
						if (line.contains("inet")) {
							String vet[] = line.trim().split(" "); 
							if (vet[0].equals("inet")) {
								System.out.println("Inet: " + vet[1]);
							}
						}
					}
				}
				if (option == 3) {
					if (OS.contains("Windows")) {
						if (line.contains("dia")) {
							String vet[] = line.split("dia =");
							System.out.println("Média: " + vet[1]);
						}
					} else {
						if (line.contains("mdev")) {
							String vet[] = line.trim().split("=");
							String vett[] = vet[1].trim().split("/");
							System.out.println("Média: " + vett[1]);
						}
					}
				}
				line = buffer.readLine();
			}
			buffer.close(); 
			reading.close();
			flow.close();
		} catch (Exception e) {
			 e.getMessage();
			
		}
	}
}
