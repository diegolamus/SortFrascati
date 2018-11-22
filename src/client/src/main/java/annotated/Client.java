package annotated;

import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Reference;

import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Client implements Runnable {
	@Reference(name = "IDistSort")
	private IDistSort s;
	// he cambiado printservice por la interfece

	public Client() {
		System.out.println("CLIENT created");
	}

	@Init
	public final void init() {
		System.out.println("CLIENT initialized");
	}

	public final void run() {
		System.out.println("Call the service...");
		// Definir los tamanios ( corresponden a los generados con anterioridad )
		int[] tamanios = { 20000, 40000, 60000, 80000, 100000 };
		// leer las cadenas
		for (int tamanio : tamanios) {
			BufferedReader br = null;
			String[] cadenas = null;
			try {
				File file = new File("src/main/resources/cadenas" + tamanio + ".txt");
				br = new BufferedReader(new FileReader(file));
				cadenas = new String[tamanio];
				for (int i = 0; i < tamanio; i++) {
					cadenas[i] = br.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			long startTime = System.currentTimeMillis();
			// Lamamr servicio sorting
			String[] ordenado = s.sort(cadenas);
			long estimatedTime = System.currentTimeMillis() - startTime;
			System.out.println("Sorting for: " + tamanio + " completed. Elapsed time: " + estimatedTime);
			// Escribir resultados
			PrintWriter writer = null;
			try {
				writer = new PrintWriter("src/main/resources/cadenasOrdenadasShell" + tamanio + ".txt",
						"UTF-8");
				writer.println("Sorting for: " + tamanio + " completed. Elapsed time: " + estimatedTime);
				for (String string : ordenado) {
					writer.println(string);
				}
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
