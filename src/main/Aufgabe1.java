/**
 * In aceasta clasa am declarat 4 functii care rezolva cele 4 cerinte fara a modifica array-ul dat.
 * Preconditii: un array de note(valori de tip int)
 * Postconditii: array[] sau int(2 functii returneaza un array si 2 returneaza o variabila de tip int)
 */
package main;


public class Aufgabe1 {
    public static int[] Nicht_Ausreichend(int[] arr){
        int[] array;
        array = new int[30];// declaram o copie de array pentru a nu modifica array ul principal
        int index = 0; // pozitia curenta din array-ul copie
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] < 38){
                array[index] = arr[i]; // adaugam elementul curent la array ul copie daca indeplineste conditia de Nichtausreichend
                index++;
            }
        }
        int[] finali = new int[index];//declaram array-ul nou care va fi returnat, pentru a scapa de elementele
        // egale cu 0 din array, obtinute prin declararea de aceeasi lungime
        for(int i = 0; i < index; ++i)
            finali[i] = array[i];
        return finali;
    }
    public static int DurschnittsNote(int[] arr){
        int suma = 0;
        for(int i = 0; i < arr.length;++i){
            suma += arr[i];
        }
        suma /= arr.length; // media aritmetica
        return suma;
    }
    public static int[] Aufgerundet(int [] arr){
        int j = 0;
        int [] array = arr;
        for(int i = 0; i < array.length; ++i){
            if((array[i] % 10) % 5 >= 3 && array[i] >= 38 ) {
                array[i] += 5- arr[i] % 5;      //daca elementul curent e Ausreichend atunci il vom rotunji
                //prin adaugarea restului diferentei dintre urmatorul multiplu de 5 si elementul curent
            }
        }
        return array;
    }
    public static int MaximalNote(int[] arr){
        int[] aufgerunder = Aufgerundet(arr); // rotunjim elementele array-ului pentru a afla notele finale
        int maximal = -1;
        for(int i = 0 ; i < aufgerunder.length; ++i){
            if(aufgerunder[i] > maximal) maximal = aufgerunder[i];//parcurgem array-ul pentru a afla maximul;
        }
        return maximal;
    }
}
