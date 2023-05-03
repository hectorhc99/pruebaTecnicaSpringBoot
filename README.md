Aplicación encargada de ordenar productos en función de la si dicho producto se encuentra disponible o lo estará pronto.

Está configurada para leer ficheros csv, si no se integran, los recuperará de base de datos.
Estos ficheros se deben incluir en la carpeta resources.

Para lanzar la aplicación se debe enviar una petición GET a la ruta localhost:8080/api/algoritmo

Devolverá todos los productos disponibles o backsoon ordenados por su secuencia.

Se han usado listas (ArrayList) debido a que en las entidades he mapeado el producto con sus tallas y stock, simulando un acceso a base de datos con sus correspondientes relaciones. Inicialmente lo planteé mediante mapas pero aumentaba mucho la complejidad ciclomática.

La forma de optimizar la aplicación sería ejecutar una consulta a base de datos para que no devuelva las tallas que no tengan stock ni back soon, con eso ya empezamos con los datos filtrados. Solo faltaría ver que los que tengan talla especial, tengan su talla normal y ordenarlos a partir de la función ordenarProductos.

