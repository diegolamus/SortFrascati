import org.osoa.sca.annotations.Property;

public class ServerBubble implements Sort
{
    public Server()
    {
        System.out.println("SERVER created.");
    }

    public final String[] sort(final String[] strings)
    {
    	int n = arr.length;  
        String temp = "";  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){
                	 
                          if( arr[j-1].compareTo(arr[j]) > 1){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  }
    }

}
