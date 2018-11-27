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
	
	@Reference(name = "sorter5")
	private IDistSort sorter5;
	
	@Reference(name = "sorter6")
	private IDistSort sorter6;
	
	@Reference(name = "sorter7")
	private IDistSort sorter7;
	
	@Reference(name = "sorter8")
	private IDistSort sorter8;
	
	@Reference(name = "sorter9")
	private IDistSort sorter9;
	
	@Reference(name = "sorter10")
	private IDistSort sorter10;
	
	@Reference(name = "sorter11")
	private IDistSort sorter11;
	
	@Reference(name = "sorter12")
	private IDistSort sorter12;

	// estrategia merging
	private int partialArraySise = 0;
	private boolean isEven = false;
	private String[] array1;
	private String[] array2;
	private String[] array3;
	private String[] array4;
	private String[] array5;
	private String[] array6;
	private String[] array7;
	private String[] array8;
	private String[] array9;
	private String[] array10;
	private String[] array11;
	private String[] array12;


	// estrategia distribucion
    	private CyclicBarrier barrera = new CyclicBarrier(13);
	
    	public Merger()
    	{
        	System.out.println("MERGER created.");
    	}

    	public final String[] sort(final String[] cadenas)
    	{
		System.out.println("MERGER called.");
		// estrategia de merging
		partialArraySise = 	(int) (cadenas.length/12);
		isEven = ((cadenas.length)%2==0) ? true : false;
		array1 = new String[partialArraySise];
		array2 = new String[partialArraySise];
		array3 = new String[partialArraySise];
		array4 = new String[partialArraySise];
		array5 = new String[partialArraySise];
		array6 = new String[partialArraySise];
		array7 = new String[partialArraySise];
		array8 = new String[partialArraySise];
		array9 = new String[partialArraySise];
		array10 = new String[partialArraySise];
		array11 = new String[partialArraySise];
		if(isEven)
			array12 = new String[partialArraySise];
		else
			array12 = new String[partialArraySise+1];
		// llenar arreglos
		for (int i = 0; i < cadenas.length; i++){
			int arrayNumber = (int)(i/partialArraySise);
			if ( arrayNumber == 0)
				array1[i] = cadenas[i];
			else if ( arrayNumber == 1)
				array2[i-partialArraySise] = cadenas[i];
			else if ( arrayNumber == 2)
				array3[i-(2*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 3)
				array4[i-(3*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 4)
				array5[i-(4*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 5)
				array6[i-(5*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 6)
				array7[i-(6*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 7)
				array8[i-(7*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 8)
				array9[i-(8*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 9)
				array10[i-(9*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 10)
				array11[i-(10*partialArraySise)] = cadenas[i];
			else if ( arrayNumber == 11)
				array12[i-(11*partialArraySise)] = cadenas[i];
			
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
		Thread thread5 = new Thread(){
			public void run() {
				System.out.println("Sorter5 running");
				array5 = sorter5.sort(array5);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread6 = new Thread(){
			public void run() {
				System.out.println("Sorter6 running");
				array6 = sorter6.sort(array6);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread7 = new Thread(){
			public void run() {
				System.out.println("Sorter7 running");
				array7 = sorter7.sort(array7);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread8 = new Thread(){
			public void run() {
				System.out.println("Sorter8 running");
				array8 = sorter8.sort(array8);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread9 = new Thread(){
			public void run() {
				System.out.println("Sorter9 running");
				array9 = sorter9.sort(array9);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread10 = new Thread(){
			public void run() {
				System.out.println("Sorter10 running");
				array10 = sorter10.sort(array10);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread11 = new Thread(){
			public void run() {
				System.out.println("Sorter11 running");
				array11 = sorter11.sort(array11);
				try {
					barrera.await();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		Thread thread12 = new Thread(){
			public void run() {
				System.out.println("Sorter12 running");
				array12 = sorter12.sort(array12);
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

		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();

		thread9.start();
		thread10.start();
		thread11.start();
		thread12.start();

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
		int i5 = 0;
		int i6 = 0;
		int i7 = 0;
		int i8 = 0;
		int i9 = 0;
		int i10 = 0;
		int i11 = 0;
		int i12 = 0;
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
			if(i4<partialArraySise && lower.compareTo(array4[i4])<0){
				min = 4;
				lower = array4[i4];
			}
			if(i5<partialArraySise && lower.compareTo(array5[i5])<0){
				min = 5;
				lower = array5[i5];
			}
			if(i6<partialArraySise && lower.compareTo(array6[i6])<0){
				min = 6;
				lower = array6[i6];
			}
			if(i7<partialArraySise && lower.compareTo(array7[i7])<0){
				min = 7;
				lower = array7[i7];
			}
			if(i8<partialArraySise && lower.compareTo(array8[i8])<0){
				min = 8;
				lower = array8[i8];
			}
			if(i9<partialArraySise && lower.compareTo(array9[i9])<0){
				min = 9;
				lower = array9[i9];
			}
			if(i10<partialArraySise && lower.compareTo(array10[i10])<0){
				min = 10;
				lower = array10[i10];
			}
			if(i11<partialArraySise && lower.compareTo(array11[i11])<0){
				min = 11;
				lower = array11[i11];
			}
			if( (i12<partialArraySise && lower.compareTo(array12[i12])<0) ||
			(!isEven && i12<=partialArraySise && lower.compareTo(array12[i12])<0)){
				min = 12;
				lower = array12[i12];
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
			} else if (min==5){
				i5++;
				cadenas[i] = lower;
			} else if (min==6){
				i6++;
				cadenas[i] = lower;
			} else if (min==7){
				i7++;
				cadenas[i] = lower;
			} else if (min==8){
				i8++;
				cadenas[i] = lower;
			} else if (min==9){
				i9++;
				cadenas[i] = lower;
			} else if (min==10){
				i10++;
				cadenas[i] = lower;
			} else if (min==11){
				i11++;
				cadenas[i] = lower;
			} else if (min==12){
				i12++;
				cadenas[i] = lower;
			}
		}
	}

}
