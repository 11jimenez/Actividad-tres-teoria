/**
 * Verificación formal con OpenJML (lógica de Hoare + invariante de ciclo).
 * Programa: suma de los primeros n números naturales.
 * Correctitud parcial: si el programa termina, entonces 2*resultado == n*(n+1).
 */
public class Suma {

    //@ requires 0 <= n && n <= 1000;          // precondición (evita desbordamiento)
    //@ ensures 2 * \result == n * (n + 1);     // postcondición: s = n(n+1)/2
    public static int sumar(int n) {
        int s = 0;                              // asignación 1
        int i = 0;                              // asignación 2

        //@ maintaining 0 <= i && i <= n;       // invariante 1
        //@ maintaining 2 * s == i * (i + 1);   // invariante 2
        //@ decreases n - i;                    // (opcional) variante: solo para terminación total
        while (i < n) {
            i = i + 1;                          // asignación 3
            s = s + i;                          // asignación 4
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(sumar(10)); // 55
    }
}
