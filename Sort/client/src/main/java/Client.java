
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
}
