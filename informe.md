# Verificación formal de correctitud parcial con Java + OpenJML

**Integrantes:** <Emmanuel Jimenez>
**Curso / fecha:** <Samuel David>

## 1. Herramienta seleccionada
OpenJML, verificador estático para Java con especificaciones JML. Genera condiciones de verificación a partir de pre/postcondiciones e invariantes (cálculo de precondición más débil, basado en la lógica de Hoare) y las resuelve con un solver SMT (Z3/CVC4). Es el equivalente en Java de Frama-C/WP para C.

## 2. Programa elegido
Suma de los primeros n naturales, con un ciclo `while` y 4 asignaciones (`s=0`, `i=0`, `i=i+1`, `s=s+i`).
Código completo en `Suma.java` (ver repositorio).

## 3. Especificación y verificación
Terna de Hoare:

{ 0 ≤ n ≤ 1000 }  `sumar(n)`  { 2·resultado = n·(n+1) }

- Precondición: `0 <= n && n <= 1000`
- Postcondición: `2 * \result == n * (n + 1)`
- Invariante del ciclo: `0 <= i <= n` y `2*s == i*(i+1)`

Justificación del invariante:
- Inicialización: con i=0, s=0 se cumple 2·0 = 0·1.
- Preservación: si 2s = i(i+1) y se hace i' = i+1, s' = s+i', entonces 2s' = i(i+1) + 2(i+1) = (i+1)(i+2) = i'(i'+1).
- Salida: al terminar, i ≥ n y i ≤ n, entonces i = n, y el invariante da la postcondición.

Se trata de **correctitud parcial**: se garantiza la postcondición si el programa termina. (La cláusula `decreases n - i` es opcional y solo aporta terminación.)

Resultado de OpenJML: <pegar salida / captura de pantalla>

## 4. Cómo ejecutar
Ver `README.md`: `openjml --esc Suma.java`.

## 5. Sistema operativo y versiones
- SO: <completar>
- Java: <completar>
- OpenJML: <completar>

## 6. Referencias
- OpenJML. https://www.openjml.org/
- Leavens, G. T., et al. *JML Reference Manual*. https://www.openjml.org/documentation/JML_Reference_Manual.pdf
- Cok, D. R. *OpenJML Tutorial*. https://www.openjml.org/tutorial/
- Hoare, C. A. R. (1969). An axiomatic basis for computer programming. *CACM* 12(10).
- Material de clase (sumatorias y algoritmo de la división).

## 7. Declaración de uso de inteligencia artificial
1. **Agentes utilizados:** Claude (Anthropic).
2. **Para qué se usaron:** <detallar: p. ej., sugerir el programa y la especificación JML inicial, plantilla del README e informe>.
3. **Qué hizo el grupo sin IA:** <detallar: instalación de OpenJML, ejecución y verificación, prueba con invariante erróneo, revisión y comprensión de la demostración, subida a GitHub>.

## 8. Repositorio
<URL de GitHub>
