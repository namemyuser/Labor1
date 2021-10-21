/**
 * In aceasta clasa am declarat 4 functii care rezolva cele 4 cerinte fara a modifica array-ul/variabila de tip int folosite ca parametrii.
 * Preconditii : un array de note
 * Postconditii: o variabila de tip int (nrMax,nrMin,summe)
 */
package main;

public class Aufgabe2 {
    public static int maximal(int[] arr){
        int nrMax = -1;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > nrMax)
                nrMax = arr[i];
        }//Parcurgem array-ul si memoram maximul in variabila nrMax
        return nrMax;
    }
    public static int minimal(int[] arr){
        int nrMin = arr[0];
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] < nrMin)
                nrMin = arr[i];
        }//parcurgem array ul si memoram minimul in variabila nrMin;
        return nrMin;
    }
    public static int MaximalSumme(int[] arr){
        int summe = 0;
        for(int i = 0 ; i < arr.length; ++i)
            summe += arr[i]; // Calculam suma totala a elementelor array-ului
        summe -= minimal(arr); // Scadem din suma totala cel mai mic element din array si obtinem suma maxima de n-1 elemente
        return summe;
    }
    public static int MinimalSumme(int[] arr){
        int summe = 0;
        for(int i = 0 ; i < arr.length; ++i)
            summe += arr[i]; // calculam suma tuturor elementelor array-ului
        summe -= maximal(arr); // scadem din suma totala cel mai mare element pentru a afla suma minima de n-1 elemente
        return summe;
    }

}


