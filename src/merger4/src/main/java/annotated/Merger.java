package annotated;

import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Merger implements IDistSort
{

	@Reference(name = "sorter1")
	private IDistSort sorter1;

	@Reference(name = "sorter2")
	private IDistSort sorter2;

	@Reference(name = "sorter3")
	private IDistSort sorter3;

	@Reference(name = "sorter4")
	private IDistSort sorter4;

	// estrategia merging
	private int partialArraySise = 0;
	private boolean isEven = false;
	private String[] array1;
	private String[] array2;
	private String[] array3;
	private String[] array4;

	// estrategia distribucion
    	private CyclicBarrier barrera = new CyclicBarrier(5);

  	public Merger()
  	{
		System.out.println("MERGER created.");
	}

  	public final String[] sort(final String[] cadenas)
  	{
		System.out.println("MERGER called.");
		// estrategia de merging
		partialArraySise = 	(int) (cadenas.length/4);
		isEven = (cadenas.length%2==0) ? true : false;
		array1 = new String[partialArraySise];
		array2 = new String[partialArraySise];
		array3 = new String[partialArraySise];
		if(isEven)
			array4 = new String[partialArraySise];
		else
			array4 = new String[partialArraySise+1];
		// llenar arreglos
		for (int i = 0; i < cadenas.length; i++){
			int arrayNumber = (int)(i/partialArraySise);
			if ( arrayNumber == 0)
				array1[i] = cadenas[i];
			else if ( arrayNumber == 1)
				array2[i-partialArraySise] = cadenas[i];
			else if ( arrayNumber == 2)
				array3[i-(2*partialArraySise)] = cadenas[i];
			else if ( arrayNumber >= 3)
				array4[i-(3*partialArraySise)] = cadenas[i];
		}
		//Estrategia de distribucion
		Thread thread1 = new Thread(){
			public void run() {
				System.out.println("Sorter1 running");
				array1 = sorter1.sort(array1);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println("Sorter2 running");
				array2 = sorter2.sort(array2);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println("Sorter3 running");
				array3 = sorter3.sort(array3);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread4 = new Thread(){
			public void run() {
				System.out.println("Sorter4 running");
				array4 = sorter4.sort(array4);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
			barrera.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Merge
		merge(cadenas);
		return cadenas;
  	}

	public void merge(String[] cadenas)
	{
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		for (int i = 0; i<cadenas.length;i++){
			int min = 0;
			String lower = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
			if(i1<partialArraySise && lower.compareTo(array1[i1])<0){
				min = 1;
				lower = array1[i1];
			}
			if(i2<partialArraySise && lower.compareTo(array2[i2])<0){
				min = 2;
				lower = array2[i2];
			}
			if(i3<partialArraySise && lower.compareTo(array3[i3])<0){
				min = 3;
				lower = array3[i3];
			}
			if( (i4<partialArraySise && lower.compareTo(array4[i4])<0) ||
			(!isEven && i4<=partialArraySise && lower.compareTo(array4[i4])<0)){
				min = 4;
				lower = array4[i4];
			}
			if (min==1){
				i1++;
				cadenas[i] = lower;
			} else if (min==2){
				i2++;
				cadenas[i] = lower;
			} else if (min==3){
				i3++;
				cadenas[i] = lower;
			} else if (min==4){
				i4++;
				cadenas[i] = lower;
			}
		}
	}

}
