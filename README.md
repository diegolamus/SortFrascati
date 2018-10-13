# SortFrascati

### Sort RMI

Esta implementación expone un servidor para hacer sort a travez de una interfaz bien definida Sort. Las implementaciones de la interfaz comprenden ShellSort y BubbleSort, componentes intercambiables en el composite del servidor. Además, tambien se implementa un cliente para consumir el servicio de Sort provisto  por el servidor. El metodo de comunicación es RMI.

### Ejecucion con Frascati:

**1. Correr servidor:**

* Navegar hasta carpeta SortFrascati desde la terminal
* cd Sort
* cd server
* frascati compile src rmi-server
* frascati run server -libpath rmi-server.jar


**2. Correr cliente**

* Navegar hasta carpeta SortFrascati desde la terminal
* cd Sort
* cd client
* frascati compile src rmi-client
* frascati run client -libpath rmi-client.jar -s r -m run

