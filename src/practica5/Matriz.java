/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/** SE CREA LA CLASE MATRIZ
 *
 * @author cristianyeis
 */
public class Matriz {

    //atributos
    private int cantidadFilas = 0;
    private int cantidadColumnas = 0;
    private int[][] objetoMatriz = null;

    //metodos
    /**
     * 
     * @param filas
     * @param Columnas
     * @throws Exception 
     */
    public Matriz(int filas, int Columnas) throws Exception {
        if (filas <= 0 || Columnas <= 0) {
            throw new Exception("La cantidad de filas o columnas no puede ser < 0");
        }
        objetoMatriz = new int[filas][Columnas];
        this.cantidadFilas = filas;
        this.cantidadColumnas = Columnas;
    }
    
    /**
     *
     * @return
     */
    public int getCantidadFilas() {
        return cantidadFilas;
    }

    /**
     * 
     * @return 
     */
    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    /**
     * 
     * @param filas
     * @param columnas
     * @return
     * @throws Exception 
     */
    public int getElemento(int filas, int columnas) throws Exception {
        if (filas < 0 || filas >= cantidadFilas) {
            throw new Exception("Filas fuera de rango válido");
        }
        if (columnas < 0 || columnas >= cantidadColumnas) {
            throw new Exception("Columnas fuera de rango válido");
        }
        return objetoMatriz[filas][columnas];
    }

    /**
     * 
     * @param filas
     * @param columnas
     * @param elemento
     * @throws Exception 
     */
    public void setElemento(int filas, int columnas, int elemento) throws Exception {
        if (filas < 0 || filas >= cantidadFilas) {
            throw new Exception("Filas fuera de rango válido");
        }
        if (columnas < 0 || columnas >= cantidadColumnas) {
            throw new Exception("Columnas fuera de rango válido");
        }
        objetoMatriz[filas][columnas] = elemento;
    }
//
//    public String getMatriz() {
//        String salida = "";
//        for (int f = 0; f < cantidadFilas; f++) {
//            for (int c = 0; c < cantidadColumnas; c++) {
//                salida += objetoMatriz[f][c] + "  ";
//            }
//            salida += "\n";
//        }
//        return salida;
//    }

    //  METODOS CREADOS EN LA CLASE MATRIZ
    /**
     * 
     * @param a
     * @param b
     * @return
     * @throws Exception 
     */
    public static Matriz sumar(Matriz a, Matriz b) throws Exception {
        int filas = a.getCantidadFilas();
        int columnas = a.getCantidadColumnas();

        if (filas != b.getCantidadFilas() || columnas != b.getCantidadColumnas()) {
            throw new Exception("Las matrices NO son del mismo Orden");
        }
        Matriz result = new Matriz(filas, columnas);
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                int valor = a.getElemento(f, c) + b.getElemento(f, c);
                result.setElemento(f, c, valor);
            }
        }
        return result;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     * @throws Exception 
     */
    public static Matriz restar(Matriz a, Matriz b) throws Exception {
        int filasA = a.getCantidadFilas();
        int columnasA = a.getCantidadColumnas();
        if (filasA != b.getCantidadFilas() || columnasA != b.getCantidadColumnas()) {
            throw new Exception("Las matrices NO son del mismo Orden");
        }
        Matriz result = new Matriz(filasA, columnasA);
        for (int f = 0; f < filasA; f++) {
            for (int c = 0; c < columnasA; c++) {
                int valor = a.getElemento(f, c) - b.getElemento(f, c);
                result.setElemento(f, c, valor);
            }
        }
        return result;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     * @throws Exception 
     */
    public static Matriz multiplicacionPunto(Matriz a, Matriz b) throws Exception {
        int filasA = a.getCantidadFilas();
        int columnasA = a.getCantidadColumnas();
        int filasB = b.getCantidadFilas();
        int columnasB = b.getCantidadColumnas();

        if (filasA != filasB || columnasA != columnasB) {
            throw new Exception("Las matrices NO son del mismo Orden");
        }
        //las filas de la primera Matriz son multiplicados por las columnas de la segunda matriz
        Matriz result = new Matriz(filasA, columnasB);
        for (int f = 0; f < filasA; f++) {
            for (int c = 0; c < columnasB; c++) {
                int valor = a.getElemento(f, c) * b.getElemento(f, c);
                result.objetoMatriz[f][c] = valor;
            }
        }
        return result;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     * @throws Exception 
     */
    public static Matriz multiplicacionMatricial(Matriz a, Matriz b) throws Exception {
        int filasA = a.getCantidadFilas();
        int columnasA = a.getCantidadColumnas();

        int filasB = b.getCantidadFilas();
        int columnasB = b.getCantidadColumnas();
        if (columnasA != filasB) {
            throw new Exception("Las matrices NO son del mismo Orden");
        }
        //las filas de la primera Matriz son multiplicados por las columnas de la segunda matriz
        Matriz result = new Matriz(filasA, columnasB);
        for (int f = 0; f < filasA; f++) {
            for (int c = 0; c < columnasB; c++) {
                int valor = 0;
                for (int k = 0; k < columnasA; k++) {
                    valor += (a.getElemento(f, k) * b.getElemento(k, c));
                }
                result.objetoMatriz[f][c] = valor;
            }
        }
        return result;
    }

    /**
     * 
     * @param t
     * @return
     * @throws Exception 
     */
    public static Matriz traspuesta(Matriz t) throws Exception {

        int filasT = t.getCantidadFilas();
        int columnasT = t.getCantidadColumnas();

        if (filasT != columnasT) {
            throw new Exception("La matriz NO es cuadrada");
        } else {
            Matriz result = new Matriz(filasT, columnasT);

            for (int f = 0; f < filasT; f++) {
                for (int c = 0; c < columnasT; c++) {
                    int valor = t.getElemento(f, c);
                    result.setElemento(c, f, valor);
                }
            }
            return result;
        }

    }

    /**
     * 
     * @param a
     * @param exponente
     * @return
     * @throws Exception 
     */
    public static Matriz Potencia(Matriz a, int exponente) throws Exception {

        //Valida si el exponente es negativo
        if (exponente < 0) {
            throw new Exception("Exponente NO es mayor o igual a cero!");
        }
        int filasA = a.getCantidadFilas();
        int columnasA = a.getCantidadColumnas();
        // valida si la matriz es cuadrada
        if (filasA != columnasA) {
            throw new Exception("La matriz NO es cuadrada");
        }
        //crea un objeto
        Matriz result = new Matriz(filasA, columnasA);
        //si el exponente es = cero el resultado es 1

        for (int f = 0; f < filasA; f++) {
            for (int c = 0; c < columnasA; c++) {
                int valor = (int) Math.pow(a.getElemento(f, c), exponente);
                result.objetoMatriz[f][c] = valor;
            }
        }
        return result;
    }
//HASTA ACA LLEGAN TODOS LOS METODOS DE LA CLASE "MATRIZ"
}// Fin de la clase Matriz

