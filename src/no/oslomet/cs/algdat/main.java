package no.oslomet.cs.algdat;

public class main {
    public static void main(String[] args) {

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
    }
}
