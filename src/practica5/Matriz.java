/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author cristianyeis
 */
public class Matriz {

    //atributos
    private int cantidadFilas = 0;
    private int cantidadColumnas = 0;
    private int[][] objetoMatriz = null;

    //metodos
    public Matriz(int filas, int Columnas) throws Exception {
        if (filas <= 0 || Columnas <= 0) {
            throw new Exception("La cantidad de filas o columnas no puede ser < 0");
        }
        objetoMatriz = new int[filas][Columnas];
        this.cantidadFilas = filas;
        this.cantidadColumnas = Columnas;
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public int getElemento(int filas, int columnas) throws Exception {
        if (filas < 0 || filas >= cantidadFilas) {
            throw new Exception("Filas fuera de rango válido");
        }
        if (columnas < 0 || columnas >= cantidadColumnas) {
            throw new Exception("Columnas fuera de rango válido");
        }
        return objetoMatriz[filas][columnas];
    }

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

    //+ calcularPotencia(exponente >=0 : int) : Matriz
//    public Matriz Potencia(int exponente) throws Exception {
//        //Valida si el exponente es negativo
//        if (exponente < 0) {
//            throw new Exception("Exponente no es mayor o igual a cero!");
//        }
//        // valida si la matriz es cuadrada
//        if (cantidadFilas != cantidadColumnas) {
//            throw new Exception("La matriz no es cuadrada");
//        }
//        //crea un objeto
//        Matriz aux = new Matriz(cantidadFilas, cantidadColumnas);
//        //si el exponente es = cero el resultado es 1
//        switch (exponente) {
//            //si el exponente es igual a 1 el resultado es la base
//            case 0:
//                for (int f = 0; f < cantidadFilas; f++) {
//                    for (int c = 0; c < cantidadColumnas; c++) {
//                        if (f == c) {
//                            aux.objetoMatriz[f][c] = 1;
//                        } else {
//                            aux.objetoMatriz[f][c] = 0;
//                        }
//                    }
//                }
//                return aux;
//            case 1:
//                return this;
//            default:
//                for (int f = 0; f < cantidadFilas; f++) {
//                    for (int c = 0; c < cantidadColumnas; c++) {
//                        aux.objetoMatriz[f][c] = this.objetoMatriz[f][c];
//                    }
//                }
//                for (int f = 0; f < exponente - 1; f++) {
//                    aux = aux.Multiplicar(this);
//                }
//                return aux;
//        }
//    }
    
//    public Matriz multiplicarK(int constante) throws Exception {
//        Matriz aux = new Matriz(this.cantidadFilas, this.cantidadColumnas);
//        for (int f = 0; f < this.cantidadFilas; f++) {
//            for (int c = 0; c < cantidadColumnas; c++) {
//                aux.objetoMatriz[f][c] = this.objetoMatriz[f][c] * constante;
//            }
//        }
//        return aux;
//    }
    //  METODOS CREADOS EN LA CLASE MATRIZ
    public static Matriz sumar(Matriz a, Matriz b) throws Exception {
        int filas = a.getCantidadFilas();
        int columnas = a.getCantidadColumnas();
        
        System.out.println(String.format("%s %s", filas, columnas));
        
        if (filas != b.getCantidadFilas() || columnas != b.getCantidadColumnas()) {
            throw new Exception("Las matrices no son del mismo Orden");
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

    public static Matriz restar(Matriz a, Matriz b) throws Exception {
        int filasA = a.getCantidadFilas();
        int columnasA = a.getCantidadColumnas();
        if (filasA != b.getCantidadFilas() || columnasA != b.getCantidadColumnas()) {
            throw new Exception("Las matrices no son del mismo Orden");
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
        switch (exponente) {
            //si el exponente es igual a 1 el resultado es la base
            case 0:
                for (int f = 0; f < filasA; f++) {
                    for (int c = 0; c < columnasA; c++) {
                        if (f == c) {
                            result.objetoMatriz[f][c] = 1;
                        } else {
                            result.objetoMatriz[f][c] = 0;
                        }
                    }
                }
                return result;
            case 1:
                return a;
            default:
//                for (int f = 0; f < filasA; f++) {
//                    for (int c = 0; c < columnasA; c++) {
//                        result[f][c] = a[f][c];
//                    }
//                }
                for (int f = 0; f < exponente; f++) {
                    result = multiplicacionPunto(a, a);
                }
                return result;
        }
    }

//HASTA ACA LLEGAN TODOS LOS METODOS DE LA CLASE "MATRIZ"
}// Fin de la clase Matriz

