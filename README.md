# Verificación formal con Java + OpenJML

Programa verificado: `Suma.java` (suma de los primeros n naturales).
Herramienta: OpenJML (basada en lógica de Hoare / cálculo de precondición más débil, con solver SMT).

## Requisitos
- Java JDK 17 (u otra versión soportada por tu release de OpenJML)
- OpenJML (descargar release desde https://www.openjml.org/ o https://github.com/OpenJML/OpenJML/releases)
  - Descomprimir y, si quieres, agregar la carpeta al PATH.
  - Ya trae el solver Z3/CVC4 incluido.

## Ejecutar la verificación estática
```bash
openjml --esc Suma.java
```
Resultado esperado: sin mensajes de error (la verificación pasa).

## Comprobar que la herramienta realmente detecta errores
Cambia el invariante `2 * s == i * (i + 1)` por `2 * s == i * i` y vuelve a correr el comando:
OpenJML debe reportar `LoopInvariant ... is false`.

## Ejecutar el programa (opcional)
```bash
javac Suma.java && java Suma
```

## Versiones usadas (completar)
- Sistema operativo: <Windows>
- Java: <java version 1.8.0_503, `java -version`>
- OpenJML: <openjml 21.0.29, `openjml --version`>
