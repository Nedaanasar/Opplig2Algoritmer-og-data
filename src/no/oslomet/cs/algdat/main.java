package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.Comparator;




public class main {
    public static void main(String[] args) {

        System.out.println("testen for metodene int antall() og boolean tom(): ");
        Liste<String> liste8 = new DobbeltLenketListe<>();
        System.out.println(liste8.antall() + " " + liste8.tom());
        System.out.println(" ");

        // Oppgave 1- konstruktøren
        System.out.println("testen for konstruktøren:  ");
        String[] n = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste1 = new DobbeltLenketListe<>(n);
        System.out.println(liste1.antall() + " " + liste1.tom());
        System.out.println(" ");

        // Oppgave 2- metodene toString og omvendtString
        System.out.println("testen for metodene toString og omvendtString: ");
        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());
        System.out.println(" ");

        // Oppgave 2- metoden boolean legginn
        System.out.println(" testen for metoden boolean legginn (T verdi) :  ");

        DobbeltLenketListe<Integer> liste7 = new DobbeltLenketListe<>();
        System.out.println(liste7.toString() + " " + liste7.omvendtString());
        for (int i = 1; i <= 3; i++)
        {
            liste7.leggInn(i);
            System.out.println(liste7.toString() + " " + liste7.omvendtString());
        }
        System.out.println(" ");


        // skejkke oppgave 5
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();
        System.out.println("oppgave 5");
        //Her legger jeg elemnter til listen
        for (int i = 1; i < 5; i++) {
            liste.leggInn(i);
        }
        System.out.println(liste.toString());
        liste.leggInn(0, 0);
        System.out.println("legg nummer 0 til liste {1,2,3,4} i foran" + liste.toString());
        liste.leggInn(5, 5);
        System.out.println("legg nummer 5 til liste {0,1,2,3,4} i bakerst" + liste.toString());
        liste.leggInn(3, 88);
        System.out.println("legg nummer 88 til liste {0,1,2,3,4,5} i midten " + liste.toString());
        //sjekke oppgave 3
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste2 =new DobbeltLenketListe<>(c);
        System.out.println(liste2.subliste(3,8));
        System.out.println(liste2.subliste(5,5));
        System.out.println(liste2.subliste(8,liste2.antall()));
        //System.out.println(liste2.subliste(0,11));
        // prøve oppgave 8
        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Liste<String> liste3 =new DobbeltLenketListe<>(navn);
        liste.forEach(s -> System.out.print(s + "​ ​"));
        System.out.println();
         for(String s :liste3) System.out.print(s +"​ ​");

         System.out.println(",");

//Oppgave 10

        System.out.println("oppgave 10");

        String[] Navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};

        Liste<String> Liste1 = new DobbeltLenketListe<>(Navn);
        //Liste<String> Liste2 = new TabellListe<>(Navn);
     //   Liste<String> Liste3 = new EnkeltLenketListe<>(Navn);
        DobbeltLenketListe.sorter(liste1, Comparator.naturalOrder());
        DobbeltLenketListe.sorter(liste2, Comparator.naturalOrder());
        DobbeltLenketListe.sorter(liste3, Comparator.naturalOrder());
        System.out.println(Liste1); // [Anders, Berit, Bodil, Kari, Lars, Per]
      //  System.out.println(Liste2); // [Anders, Berit, Bodil, Kari, Lars, Per]
       // System.out.println(Liste3); // [Anders, Berit, Bodil, Kari, Lars, Per]
// Tabellen navn er upåvirket:
        System.out.println(Arrays.toString(navn));
// [Lars, Anders, Bodil, Kari, Per, Berit]





    }
}
