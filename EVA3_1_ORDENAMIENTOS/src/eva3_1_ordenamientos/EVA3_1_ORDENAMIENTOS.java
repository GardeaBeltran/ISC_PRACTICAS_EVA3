/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

import java.util.Arrays;

/**
 *
 * @author Ximena Hernandez
 */
public class EVA3_1_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //vamos a ordenar arreglos (int)
        int [] datos = new int [10];
        int [] copiaSe1 = new int [datos.length];
        int [] copiaIns = new int [datos.length];
        int [] copiaBubble = new int [datos.length];
        int [] copiaQuicks = new int [datos.length];
        long iniT,finT;
        llenar (datos);  //envio el arreglo a llenar con valores aleatorios
        
        duplicar(datos,copiaSe1);
        Arrays.sort(copiaSe1);
        
        System.out.println("PRUEBA CON SELECTION SORT");
        duplicar(datos, copiaSe1);
        imprimir (copiaSe1);
        iniT = System.nanoTime(); //tiempo antes de empezar el metodo
        selectionSort(copiaSe1);
        finT = System.nanoTime(); //tiempo al terminar el metodo
        imprimir(copiaSe1); //imprimir contenidos
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
       
       System.out.println("PRUEBA CON INSERTION SORT");
       duplicar(datos, copiaIns);
        imprimir (copiaIns);
        iniT = System.nanoTime(); //tiempo antes de empezar el metodo
        insertionSort(copiaIns);
        finT = System.nanoTime(); //tiempo al terminar el metodo
        imprimir(copiaIns); //imprimir contenidos
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
       System.out.println("PRUEBA CON BUBBLE SORT");
       duplicar(datos, copiaBubble);
        imprimir (copiaBubble);
        iniT = System.nanoTime(); //tiempo antes de empezar el metodo
        insertionSort(copiaBubble);
        finT = System.nanoTime(); //tiempo al terminar el metodo
        imprimir(copiaBubble); //imprimir contenidos
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
        
        System.out.println("PRUEBA CON Quicks");
       duplicar(datos, copiaQuicks );
        imprimir (copiaQuicks );
        iniT = System.nanoTime(); //tiempo antes de empezar el metodo
        insertionSort(copiaQuicks );
        finT = System.nanoTime(); //tiempo al terminar el metodo
        imprimir(copiaQuicks ); //imprimir contenidos
        System.out.println("Tiempo en ordenar: " + (finT - iniT));
    }
    //LLENADO DE ARREGLO CON VALORES ALEATORIOS
    public static void llenar (int[] datos){
        for (int i = 0; i < datos.length; i++) {
          datos[i] =(int) (Math.random() *100);
        }
    }
    //DUPLICAR EL ARREGLO
    public static void duplicar (int[] datos, int[] copia){
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
    }
    //COPIA DE ARREGLO
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
     public static void insertionSort(int[] datos){
         for (int i = 0; i < datos.length; i++) {
             int temp = datos [i]; //valor a insertar
             int insP = i; //posicion donde vamos a insertar
             for (int prev = i- 1; prev >=0; prev--) {
                 if (datos [prev] > temp){
                     datos[insP] = datos[prev]; //movemos el valor de prev a la posicion de insP
                     insP --;//retrocede una posicion
                 }else{
                     break;
                 }
             }
             //insertamos
             datos[insP]= temp;
         }
     }
     //EFICIENCIA O(N"2)
     public static void bubbleSort (int[] datos){
         for (int i = 0; i < datos.length; i++) { //pasadas
             for (int j = 0; j < (datos.length - 1); j++) { //compara e intercambia
                 if (datos[j] > datos[j + 1]){//comparemos j vs j + 1
                 //intercambiamos
                 int temp= datos[j];
                 datos[j] = datos[j+1];
             }
         }
     }
}
     //QUICKSORT DE ARRANQUE
      public static void quickSort(int[] datos){
          quickSortRecu (datos, 0, datos.length - 1); //quickSort a todo el arreglo
      }
      private static void quickSortRecu(int[] datos, int ini, int fin){
          int iPivote; //inicio
          int too_big; // buscar a los mas grandes en el pivote
          int too_small; //buxcar a los mas pequeños en el pivote
          boolean stopBig = false, stopSmall = false;
          //controlar la recursividad
          int tama = fin-ini + 1;
          if(tama > 1){//¿Cuando si puedes realizar quickSort
              iPivote= ini;
              too_big = ini + 1;
              too_small = fin;
              for (int i = ini + 1; i <= fin; i++) { //numero de veces a recorrer
                  if((datos[too_big] <= datos[iPivote]) && (!stopBig)){
                      too_big++; //avanza
                  }else{
                      stopBig = true; //me detengo cuando encuentro uno mas grande
                  }
                  if((datos[too_small] <= datos[iPivote]) && (!stopBig)){
                      too_small--; //avanza
                  }else{
                       stopSmall = true; //me detengo cuando encuentro uno mas pequeñp
                  }
                  //ambos se detienen
                  if(stopBig && stopSmall){ //ambos indices se detuvieron
                      if(too_big < too_small){ //intercambio SWAP
                          int temp = datos [too_big];
                          datos [too_big] = datos[too_small];
                          datos[too_small] = temp;
                          stopBig= false; //seguir avanzando
                          stopSmall=false; //seguir avanzando
                      }else
                          break;//termino el ciclo
                  }
              }
              //intercambio el pivote
              int temp = datos [iPivote];
              datos [iPivote] = datos[too_small];
              datos[too_small] = temp;
              iPivote= too_small; //tambien cambia la posicion del pivote
              //quickSort izq
              quickSortRecu(datos,ini,iPivote - 1);
              //quickSort der
                quickSortRecu(datos,iPivote + 1, fin);
      }
      }
}
