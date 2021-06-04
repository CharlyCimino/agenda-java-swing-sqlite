# Agenda persistente

Agenda persistente que permite agregar, modificar, borrar y filtrar contactos. Realizado con [**Java Swing**](https://www.javatpoint.com/java-swing) utilizando el patrón MVC y base de datos [**SQLite**](https://www.sqlite.org/index.html).

## Base de datos de contactos

Embebida en un archivo, dentro del proyecto. Precisamente en la carpeta **src\agenda\modelo\bd** existen los archivos:
* agenda.bd: Para poder probar la app en desarrollo
* agenda-backup.bd: Para recuperar los datos originales.

## Driver para SQLite

Incluido en el proyecto.

Realizado con JDK 8. Proyecto de Apache NetBeans 12.3