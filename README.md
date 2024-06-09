# Tarea01-Aspectos
# Proyecto de Cambio de Color de Fondo

Este proyecto es una aplicación Java Swing que cambia el color de fondo de una ventana al hacer clic en diferentes botones. Los botones disponibles son "Rosado", "Magenta" y "Azul".

## Funcionalidades

- **Cambio de Color de Fondo:** Cada botón cambia el color de fondo de la ventana al color correspondiente y muestra un mensaje en la consola indicando el cambio.
- **Registro de Cambios de Color:** Se utiliza AspectJ para implementar la funcionalidad de logging. Cada vez que se cambia el color de fondo, se registra un mensaje en la consola antes de que el color cambie, utilizando aspectos para separar esta preocupación transversal del núcleo de la lógica de cambio de color.
- **Registro en Archivo de Texto:** Además de mostrar el mensaje en la consola, los cambios de color también se registran en un archivo de texto llamado `color_change_log.txt` junto con la fecha del cambio. Cada vez que se ejecuta el programa, se escribe una cabecera que separa un registro de ejecución de otro.

### Herramientas Utilizadas

- JDK 21
- Eclipse con AspectJ Development Tools (AJDT)

### Ejecución

1. Clonar el repositorio.
2. Importar el proyecto en Eclipse.
3. Ejecutar la clase `ColorChanger` para iniciar la aplicación.

### Funcionalidades (Cross-Cutting Concerns)

