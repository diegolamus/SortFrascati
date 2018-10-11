
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
    //TODO crear experimento
    s.sort(null);
  }

  static String[] generarCadenas (int tamanio) {
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
