package annotated;

import org.osoa.sca.annotations.Property;

public class ServerShell implements IDistSort
{
    public ServerShell()
    {
        System.out.println("SERVER created.");
    }

    public final String[] sort(final String[] cadena)
    {
        int salto, i;
        String aux;
        boolean cambios;
        for(salto=cadena.length/2; salto!=0; salto/=2){
            cambios=true;
            while(cambios){ // Mientras se intercambie algún elemento
              cambios=false;
              for(i=salto; i< cadena.length; i++) // se da una pasada
                if(cadena[i-salto].compareTo(cadena[i])>0){ // y si están desordenados
                    aux=cadena[i]; // se reordenan
                    cadena[i]=cadena[i-salto];
                    cadena[i-salto]=aux;
                    cambios=true; // y se marca como cambio.
                }
            }
        }
        return cadena;
    }
}
