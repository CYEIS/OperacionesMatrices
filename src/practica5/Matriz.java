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

    public String getMatriz() {
        String saida = "";
        for (int f = 0; f < cantidadFilas; f++) {
            for (int c = 0; c < cantidadColumnas; c++) {
                saida += objetoMatriz[f][c] + "  ";
            }
            saida += "\n";
        }
        return saida;
    }

    public Matriz adicionar(Matriz objetoMatriz) throws Exception {
        if (this.cantidadFilas != objetoMatriz.cantidadFilas || this.cantidadColumnas != objetoMatriz.cantidadColumnas) {
            throw new Exception("Las matrices no son del mismo Orden");
        }
        Matriz aux = new Matriz(this.cantidadFilas, this.cantidadColumnas);
        for (int f = 0; f < this.cantidadFilas; f++) {
            for (int c = 0; c < this.cantidadColumnas; c++) {
                int valor = this.getElemento(f, c) + objetoMatriz.getElemento(f, c);
                aux.setElemento(f, c, valor);
            }
        }
        return aux;
    } //ok

    public Matriz sustraer(Matriz objetoMatriz) throws Exception {
        if (this.cantidadFilas != objetoMatriz.cantidadFilas || this.cantidadColumnas != objetoMatriz.cantidadColumnas) {
            throw new Exception("Las matrices no son del mismo Orden");
        }
        Matriz aux = new Matriz(this.cantidadFilas, this.cantidadColumnas);
        for (int f = 0; f < this.cantidadFilas; f++) {
            for (int c = 0; c < this.cantidadColumnas; c++) {
                int valor = this.getElemento(f, c) - objetoMatriz.getElemento(f, c);
                aux.setElemento(f, c, valor);
            }
        }
        return aux;
    } //ok

    public Matriz Multiplicar(Matriz objetoMatriz) throws Exception {
        if (this.cantidadColumnas != objetoMatriz.cantidadFilas) {
            throw new Exception("El número de columnas da matriz A debe ser igual al número de filas de la matriz B");
        }
        //linhas da primeira matriz são multiplicados por colunas da matriz segunda
        Matriz aux = new Matriz(this.cantidadFilas, objetoMatriz.cantidadColumnas);
        for (int f = 0; f < cantidadFilas; f++) {
            for (int c = 0; c < objetoMatriz.cantidadColumnas; c++) {
                int valor = 0;
                for (int k = 0; k < cantidadFilas; k++) {
                    valor += (this.getElemento(f, k) * objetoMatriz.getElemento(k, c));
                }
                aux.objetoMatriz[f][c]=valor;
            }
        }
        return aux;
    } 
    
    
        public Matriz MultiplicarPunto(Matriz objetoMatriz) throws Exception {
        if (this.cantidadColumnas != objetoMatriz.cantidadFilas) {
            throw new Exception("El número de columnas da matriz A debe ser igual al número de filas de la matriz B");
        }
        //linhas da primeira matriz são multiplicados por colunas da matriz segunda
        Matriz aux = new Matriz(this.cantidadFilas, objetoMatriz.cantidadColumnas);
        for (int f = 0; f < cantidadFilas; f++) {
            for (int c = 0; c < objetoMatriz.cantidadColumnas; c++) {
                int valor = 0;
                for (int k = 0; k < cantidadFilas; k++) {
                    valor += (this.getElemento(f, k) * objetoMatriz.getElemento(k, c));
                }
                aux.objetoMatriz[f][c]=valor;
            }
        }
        return aux;
    } 

    public Matriz Transpuesta() throws Exception {
        if (cantidadFilas != cantidadColumnas) {
            throw new Exception("La matriz no es cuadrada");
        }else {
            Matriz aux = new Matriz(cantidadFilas, cantidadColumnas);
            
            for (int f = 0; f < cantidadFilas; f++) {
                for (int c = 0; c < cantidadColumnas; c++) {
                    int valor = getElemento(f, c);
                    aux.setElemento(c, f, valor);
                }
            }
            return aux;
        }

    } 

    //+ calcularPotencia(exponente >=0 : int) : Matriz
    public Matriz Potencia(int exponente) throws Exception {
        //Valida si el exponente es negativo
        if (exponente < 0) {
            throw new Exception("Exponente no es mayor o igual a cero!");
        }
        // valida si la matriz es cuadrada
        if (cantidadFilas != cantidadColumnas) {
            throw new Exception("La matriz no es cuadrada");
        }
        //crea un objeto
        Matriz aux = new Matriz(cantidadFilas, cantidadColumnas);
        //si el exponente es = cero el resultado es 1
        switch (exponente) {
        //si el exponente es igual a 1 el resultado es la base
            case 0:
                for (int f = 0; f < cantidadFilas; f++) {
                    for (int c = 0; c < cantidadColumnas; c++) {
                        if (f == c) {
                            aux.objetoMatriz[f][c] = 1;
                        } else {
                            aux.objetoMatriz[f][c] = 0;
                        }
                    }
                }
                return aux;
            case 1:
                return this;
            default:
                for (int f = 0; f < cantidadFilas; f++) {
                    for (int c = 0; c < cantidadColumnas; c++) {
                        aux.objetoMatriz[f][c] = this.objetoMatriz[f][c];
                    }
                }
                for (int f = 0; f < exponente - 1; f++) {
                    aux = aux.Multiplicar(this);
                }
                return aux;
        }
    }

    public Matriz multiplicarK(int constante) throws Exception {
        Matriz aux = new Matriz(this.cantidadFilas, this.cantidadColumnas);
        for (int f = 0; f < this.cantidadFilas; f++) {
            for (int c = 0; c < cantidadColumnas; c++) {
                aux.objetoMatriz[f][c] = this.objetoMatriz[f][c] * constante;
            }
        }
        return aux;
    }

//HASTA ACA LLEGAN TODOS LOS METODOS DE LA CLASE "MATRIZ"
    
}// Fin de la clase Matriz


