package annotated;

import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Reference;

import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Client implements Runnable {

	@Reference(name = "Merger")
	private IDistSort s;

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
		int[] tamanios = { 3000000, 5000000, 7000000, 9000000, 11000000 };
		// leer las cadenas
		for (int tamanio : tamanios) {
			BufferedReader br = null;
			String[] cadenas = null;
			try {
				File file = new File("src/main/resources/cadena" + tamanio );
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
				writer = new PrintWriter("src/main/resources/cadenasOrdenadas" + tamanio + ".txt",
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
