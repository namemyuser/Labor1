/**In aceasta clasa am declarat 4 functii care rezolva cele 4 cerinte fara a modifica datele de intrare.
 * Preconditii: array/int,fiecare functie are natura parametrilor diferita una de alta.
 * Postconditii: o variabila de tip int(min/max) care reprezinta rezultatul operatiilor cerute facute pe array-uri.
 */
package main;

public class Aufgabe4 {
    public static int billigsteTastatur(int[] arr){
        int min = arr[0];
        for(int i = 1 ; i < arr.length; ++i) {
            if (arr[i] < min)
                min = arr[i];
        } // memoram cel mai mic element al array-ului in variabila min
        return min;
    }
    public static int teuersteGegenstand(int[] arr1, int[] arr2){
        int max = -1;
        for(int i = 0; i < arr1.length; ++i){
            if(arr1[i] > max)
                max = arr1[i];
        }//retinem cel mai mare elem din arr1 in variabila max
        for(int i = 0; i < arr2.length; ++i){
            if(arr2[i] > max)
                max = arr2[i];
        } // verificam daca exista vreun element mai mare decat max in arr2 si il retinem
        return max;
    }
    public static int teuersteUsb(int[] arr, int Budget){
        int max = -1;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > max && arr[i] <= Budget)
                max = arr[i];
        } //retinem cel mai mare element din array care este mai mic sau egal cu Budget
        return max;
    }
    public static int maximalGeldbetrag(int Budget, int[] arr1 , int[] arr2){
        int max = -1;
        for(int i = 0 ; i < arr1.length; ++i){
            for(int j = 0; j < arr2.length; ++j){
                int sum = arr1[i] + arr2[j];// retinem pretul fiecarei combinatii de USB + Tastatur
                if(sum > max && sum <= Budget) {
                    max = sum;
                } // retinem pretul maxim al combinatiilor USB+Tastatur care se si incadreaza in buget
            }
        }
        return max;
    }

}

