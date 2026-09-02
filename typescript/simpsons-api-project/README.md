# Trabajo Práctico TypeScript - Simpsons API

## ¿Qué hace `npm init -y`?

El comando `npm init -y` inicializa un proyecto de Node.js de forma automática utilizando la configuración por defecto.

Genera el archivo `package.json`, que contiene la información del proyecto, sus dependencias, scripts y configuración general.


## ¿Por qué se usa `--save-dev`?

Se utiliza `--save-dev` porque TypeScript es una dependencia de desarrollo.

Solo se necesita para escribir y compilar el código durante el desarrollo del proyecto, pero no es necesaria cuando la aplicación ya está ejecutándose en el navegador.


## Explicación de las opciones principales

### strict

Activa el modo estricto de TypeScript. Obliga a declarar correctamente los tipos y ayuda a detectar errores antes de ejecutar el programa.

### target

Indica la versión de JavaScript a la que TypeScript compilará el código. En este proyecto se utiliza ES2020.

### outDir

Especifica la carpeta donde se guardarán los archivos JavaScript compilados. En este proyecto será la carpeta `dist`.

## Scripts del proyecto

### npm run build

Ejecuta el compilador TypeScript (`tsc`) y convierte todos los archivos `.ts` en archivos `.js`.

### npm run watch

Ejecuta TypeScript en modo observación (`--watch`). Cada vez que se guarda un archivo `.ts`, se recompila automáticamente sin necesidad de volver a ejecutar el comando.
