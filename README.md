# SortFrascati

### Integrantes

Eileen Guerrero
Diego Lamus

### Sort RMI

Esta implementación contiene tres tipos de elementos de software. Contiene un componente sorter, que implementa la interfaz IDistSort, el cual ordena un arreglo de strings en orden lexicográfico; un componente merger, que tambien implementa la interfas IDistSort, que ordena un arreglo de strings distribuyendolo en 1, 4 o 14 sorters (merger,merger4,merger12), y luego uniendo los resultados; finalmente, un componente cliente que carga arreglos de diferente tamaño a memoria y los ordena utilizando el componente merger, a traves de la interfaz IDistSort.

### Ejecucion con Frascati:

**1. Correr Sorter:**

* Navegar hasta carpeta SortFrascati desde la terminal
* cd src
* cd sorterN | N corresponde al numero de sorter (1 - 12)
* frascati compile src sorter
* frascati run sorter -libpath sorter.jar


**2. Correr Merger:**

* Navegar hasta carpeta SortFrascati desde la terminal
* cd src
* cd mergerN | N corresponde al numero de sorters que utiliza el merger (,4,12)
* frascati compile src merger
* frascati run merger -libpath merger.jar
* Nota: Si se instancia merger, se debe correr antes sorter1. Si se instancia merger4 se debe correr antes sorter1 a sorter4, etc. En el composite de cada merger hay que configurar la ip de los sorters.

**3. Correr cliente**

* Navegar hasta carpeta SortFrascati desde la terminal
* cd Sort
* cd client
* frascati compile src client
* frascati run client -libpath client.jar -s r -m run
* Nota: Antes de ejecutar el cliente es necesario que el merger esté corriendo. El cliente se corre en el mismo dispositivo que el merger.
