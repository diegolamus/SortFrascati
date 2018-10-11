
import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Reference;

public class Sort implements Runnable
{
  private Sort s;

  @Reference
  public final void setPrintService(PrintService service)
  {
    this.s = service;
  }

  public ClientImpl()
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
    // TODO create strings
    s.sort(null);
  }
  static String [] generarCadenas (int tamanio) {
		String [] respuesta = new String [tamanio];
		
		for (int i = 0; i < tamanio; i++) {
			String cadena ="";
			for (int j = 0; j < 60; j++) {
				int aleatorioGenerador =(int)(Math.random()*(122-97+1)+97);
				cadena=cadena+(char)(aleatorioGenerador);
			}
			respuesta[i]=cadena;
		}
		
		
		return respuesta;
	}
}
