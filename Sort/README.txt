# Sort RMI:

Esta implementación expone un servidor para hacer sort a travez de una interfaz Sort. Las implementaciones de la interfaz comprenden ShellSort y BubbleSort, componentes intercambiables. Además, tambien se implementa un servidor para consumir el servicio de Sort. El metodo de comunicación es RMI.

Compilacion con Maven:

  mvn install

Ejecucion con Maven:

  1) Open a console for the server
     cd server
     mvn -Prun                      (standalone execution)
     mvn -Pexplorer                 (with FraSCAti Explorer)
     mvn -Pexplorer-fscript         (with FraSCAti Explorer and FScript plugin)
     mvn -Pfscript-console          (with FraSCAti FScript Console)
     mvn -Pfscript-console-explorer (with FraSCAti Explorer and FScript Console)
     mvn -Pexplorer-jdk6            (with FraSCAti Explorer and JDK6)

  2) Open another console for the client
     cd client
     mvn -Prun                      (standalone execution)
     mvn -Pexplorer                 (with FraSCAti Explorer)
     mvn -Pexplorer-fscript         (with FraSCAti Explorer and FScript plugin)
     mvn -Pfscript-console          (with FraSCAti FScript Console)
     mvn -Pfscript-console-explorer (with FraSCAti Explorer and FScript Console)
     mvn -Pexplorer-jdk6            (with FraSCAti Explorer and JDK6)

