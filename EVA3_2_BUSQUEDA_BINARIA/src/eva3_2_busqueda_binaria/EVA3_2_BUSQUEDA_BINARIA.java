/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_busqueda_binaria;

import java.util.Scanner;


/**
 *
 * @author Ximena Hernandez
 */
public class EVA3_2_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] datos = new int [20];
         llenar (datos);  //envio el arreglo a llenar con valores aleatorios
         imprimir (datos);
         selectionSort (datos);
         imprimir (datos);
         Scanner input = new Scanner(System.in);
         System.out.println("Valor a buscar: ");
         int valor = input.nextInt();
    }
    //LLENADO DE ARREGLO CON VALORES ALEATORIOS
    public static void llenar (int[] datos){
        for (int i = 0; i < datos.length; i++) {
          datos[i] =(int) (Math.random() *100);
        } 
    } 
     //IMPRIMIR ARREGLO
     public static void imprimir (int[] datos){
         System.out.println("");
        for (int i = 0; i < datos.length; i++) { 
            System.out.print("[" + datos [i] + "]");
        }
         System.out.println("");
     }
      //EFICIENCIA O(N"2)
     public static void selectionSort (int[] datos){
         for (int i = 0; i < datos.length; i++) {
             int iMin = i; //EMPIEZA EL ALGORITMO, EL MINIMO ES EL PRIMER ELEMENTO
             for (int j = 0; j < datos.length; j++) {
                 //COMPARAR
                 //VALOR J VS VALOR MIN
                 if(datos[j] < datos[iMin]){ //COMPARO ACTUAL VS MINIMO ACTUAL
                     iMin = j;
                 }
             }
             //INTERCAMBIO
             if (i != iMin){
             //3 PASOS
             //RESPALDAR UN VALOR
                 int iTemp = datos[i];
             //INTERCAMBIAR UN VALOR
             datos[i] = datos[iMin];
             //REPONER EL VALOR RESPALDADO
             datos[iMin] = iTemp;
         }
         }
     }
         
}
