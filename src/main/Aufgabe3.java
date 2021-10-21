/**
 * In aceasta clasa am declarat 4 functii care rezolva cerintele si nu modifica datele de intrare.(array/cifra de inmultire-impartire)
 * Preconditii:un array de note(valori de tip int) si o cifra sau 2 array-uri de note,depinzand de operatia efectuata.
 * Postconditii: un array care contine notele dupa operatia efectuata.
 */
package main;

public class Aufgabe3 {
    public static int[] Summe(int[] arr1, int[] arr2){
        boolean depasit = false; // boolean pentru a verifica daca suma elementelor de acceasi pozitie
        //din cele 2 array uri depaseste o cifra
        int[] newArr;
        newArr = new int[arr1.length + 1]; // array-ul nou care va fi returnat si reprezinta suma(declarat de marime arr.length + 1)
        // pentru cazul in care arr1[0] + arr1[0] > 9
        for(int i = arr1.length -1; i >=0; i--){
            int sum = arr1[i] + arr2[i]; //suma elementelor de aceeasi pozitie
            if(depasit){
                sum += 1;
                depasit = false;
            } // daca depasit e true atunci suma elementelor pozitiei anterioare a depasit o cifra
            newArr[i + 1] += sum > 9 ? sum % 10 : sum; // adaugam in array-ul nou ultima cifra a sumei pe o pozitie superioara
            //pozitie superioara pentru a avea primul element nemodificat in cazul in care depasit = true;

            if(sum > 9) depasit = true; // depasire de numar de cifre
        }
        if(depasit) newArr[0] = 1; // daca suma primelor 2 elem din cele 2 array uri depaseste o cifra
        if(newArr[0] == 0) {
            int[] newArr1;
            newArr1 = new int[newArr.length - 1];
            for(int i = 1; i < newArr.length; ++i)
                newArr1[i - 1] = newArr[i];
            return newArr1;
        } // eliminam primul element din array-ul returnat daca depasit = false;
        else
            return newArr;
    }
    public static int[] Differenz(int[] arr1, int[] arr2){
        boolean depasit = false; // pentru a verifica daca diferenta celor 2 elemente este negativa
        int newArr[];
        newArr = new int[arr1.length];
        for(int i = arr1.length - 1; i >= 0; i--){
            int dif = arr1[i] - arr2[i];
            if(depasit){
                dif += 1;
                depasit = false;
            } // daca diferenta elementelor pozitiei anterioare este negativa
            newArr[i] += dif < 0 ? -dif : dif; // adaugam -dif daca e negativa , +dif daca e pozitiva

            if(dif < 0) depasit = true;
        }
        return newArr;
    }
    public static int[] Multiplikation(int[] arr1, int cif){
        int depasit = 0; // cu depasit retinem prima cifra a produsului dintre element si cifra
        // pentru a o adauga la pozitia urmatoare
        int[] newArr;
        newArr = new int[arr1.length + 1];
        for(int i = arr1.length - 1; i >= 0; i--){
            int produs = arr1[i] * cif;
            produs += depasit; // adaugam prima cifra a produsului d intre element si cifra(pentru i = 0 depasit = 0)
            newArr[i + 1] += produs < 10 ? produs : produs % 10; // adaugam la array-ul returnat produsul in cazul in care e de o cifra
            // sau ultima cifra in cazul in care depaseste o cifra
            depasit = produs / 10; // lui depasit ii este alocata valoarea produs / 10
            // daca produs < 10 depasit devine 0 altfel devine prima cifra a produsului
        }
        newArr[0] += depasit; // adaugam la primul element al array ului returnat valoarea lui depasit
        if(newArr[0] == 0) {
            int[] newArr1;
            newArr1 = new int[newArr.length - 1];
            for(int i = 1; i < newArr.length; ++i)
                newArr1[i - 1] = newArr[i];
            return newArr1;
        } // in cazul in care depasit = 0 stergem primul element al array-ului returnat
        else
            return newArr;
    }
    public static int[] Division(int[] arr1, int cif){
        int[] newArr;
        newArr = new int[arr1.length];
        int nr = 0;
        for(int i = 0; i < arr1.length; i++){
            nr *= 10;
            nr += arr1[i];
        } // transformam array-ul intr-un numar pentru a il imparti cu exactitate
        nr /= cif;
        for(int i = newArr.length - 1; i >= 0; i--){
            newArr[i] = nr % 10;
            nr /= 10;
        }// introducem in noul array pas cu pas cifrele rezultatului impartirii
        return newArr;
    }

}
