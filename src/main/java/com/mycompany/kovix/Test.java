/*

 */
package com.mycompany.kovix;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String palabra;
        Integer repetir;
        String palabraCompleta;

        System.out.print("Ingresar la palabra: ");
        palabra = sc.nextLine();

        System.out.print("Ingresar la cantidad de veces que se van a repetir cada letra: ");
        repetir = sc.nextInt();

        palabraCompleta = CaracterConsecutivos(palabra, repetir);
        System.out.print("La frase modificada es: " + palabraCompleta);
    }
    
    static String CaracterConsecutivos(String S, Integer R) {

        ArrayList<String> contenedorPalabra = new ArrayList<>();
        Boolean flag = false;
        String vecPalabra[] = new String[S.length()];
        String posActu;
        String palabraCompleta = "";

        for (int i = 0; i < vecPalabra.length; i++) {
            vecPalabra[i] = S.substring(i, i + 1);
        }    
        
        /*Inicializo mi posicion actual*/
        posActu = vecPalabra[0];

        for (int i = 1; i < vecPalabra.length; i++) { 

            if (flag == false) { 
                /*Cuando el flag es falso quiere decir que estoy posicionado en un nuevo caracter*/

                if (posActu.equals(vecPalabra[i])) { 
                    /*
                    * Al estar en un nuevo caracter compruebo si es consecutivo.
                    * Si es consecutivo el array se carga con la cantidad indicada de caracteres.
                    */                    
                    for (int j = 0; j < R; j++) { 
                        contenedorPalabra.add(posActu);
                    }
                    /*El flag cambia a verdadero hasta encontrar un caracter diferente al actual.*/
                    flag = true;
                } else {
                    /*Si no es consecutivo solo se carga una vez.*/
                    contenedorPalabra.add(posActu);
                }
            }
            
            
            if (!(posActu.equals(vecPalabra[i]))) {
                /*
                * Aca se actualizara la posicion actual siempre que se encuentre un caracter diferente
                * El flag pasa a falso para indicar que mi posicion actual tiene un caracter distinto.
                */
                posActu = vecPalabra[i];
                flag = false;
            }            
            
            if (i == vecPalabra.length - 1 && !(vecPalabra[i].equals(vecPalabra[i - 1]))) {
                /*
                 * Este if es para comprobar si la ultima posicion de nuestra palabra es consecutiva o no,
                 * ya que si no es consecutiva no se guarda en el array.
                */
                contenedorPalabra.add(vecPalabra[i]);                
            }

        }

        for (String pal : contenedorPalabra) {
            /*Paso el array a una variable string*/
            palabraCompleta += pal;
        }

        return palabraCompleta;
    }

}
