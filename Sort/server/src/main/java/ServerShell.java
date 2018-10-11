import org.osoa.sca.annotations.Property;

public class ServerShell implements Sort
{
    public Server()
    {
        System.out.println("SERVER created.");
    }

    public final String[] sort(final String[] strings)
    {
        int salto, aux, i;
        boolean cambios;
        for(salto=A.length/2; salto!=0; salto/=2){
            cambios=true;
            while(cambios){ // Mientras se intercambie algún elemento
              cambios=false;
              for(i=salto; i< A.length; i++) // se da una pasada
                if(A[i-salto].compareTo(A[i])>0){ // y si están desordenados
                    aux=A[i]; // se reordenan
                    A[i]=A[i-salto];
                    A[i-salto]=aux;
                    cambios=true; // y se marca como cambio.
                }
            }
        }
    }
}
