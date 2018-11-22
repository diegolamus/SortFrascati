package annotated;

import org.osoa.sca.annotations.Property;

public class ServerBubble implements IDistSort
{
    public ServerBubble()
    {
        System.out.println("SERVER created.");
    }

    public final String[] sort(final String[] cadena)
    {
    	int n = cadena.length;
      String temp = "";
      for(int i=0; i < n; i++){
             for(int j=1; j < (n-i); j++)
                      if( cadena[j-1].compareTo(cadena[j]) > 0){
                             //swap elements
                             temp = cadena[j-1];
                             cadena[j-1] = cadena[j];
                             cadena[j] = temp;
                       }
      }
      return cadena;
    }

}
