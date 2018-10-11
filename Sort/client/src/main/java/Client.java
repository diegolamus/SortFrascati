
import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Reference;

public class Client implements Runnable
{
  private IDistSort s;

  @Reference
  public final void setPrintService(PrintService service)
  {
    this.s = service;
  }

  public Client()
  {
    System.out.println("CLIENT created");
  }

  @Init
  public final void init()
  {
    System.out.println("CLIENT initialized");
  }

  public final void run()
  {
    System.out.println("Call the service...");
    // Definir los tamanios ( corresponden a los generados con anterioridad )
    int[] tamanios = { 200000, 400000, 600000, 800000, 1000000 };
    // leer las cadenas
    for(int tamanio: tamanios) {	
    	File file = new File("sort-rmi-client/src/main/resources/cadenas"+tamanio".txt"); 
    	BufferedReader br = new BufferedReader(new FileReader(file)); 
    	String[] cadenas = new String[tamanio];
        for(int i = 0; i<tamanio; i++) {
        	cadenas[i] = br.readLine();
        }
        long startTime = System.currentTimeMillis()
        // llamar el servicio de sort
        s.sort(cadenas);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Sorting for: "+ tamanio + " completed. Elapsed time: "+estimatedTime);
  }
}
