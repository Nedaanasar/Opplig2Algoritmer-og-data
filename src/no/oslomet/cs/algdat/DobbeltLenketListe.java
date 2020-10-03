package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() { //konstruktør med tom liste
        hale = null;
        hode = null;
        antall = 0;
        endringer = 0;

    }

    public DobbeltLenketListe(T[] a) {  //Konstuktøren
       // først hvis a er null
       if (a == null) {
           throw new NullPointerException(" Tabellen a er null!");
       }
       if (a.length > 0) {
           int i = 0;
           for (; i < a.length; i++){
               if (a[i] != null){
                   hode = new Node<>(a[i]);
                   antall++;

                   break;
               }
           }

           hale = hode;
           if (hode != null) {
               i++;
               for (; i < a.length; i++){
                   if (a[i] != null){
                       hale.neste = new Node<>(a[i], hale, null);
                       hale = hale.neste;
                       antall++;
                   }
               }
           }
       }


    }

    public Liste<T> subliste(int fra, int til){
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        // hvis antall noder like null, så det betyr at listen er tom-
        if (antall==0){
            return true;
        } else
            return false;
    }

    @Override
    public boolean leggInn(T verdi) {
        // først legger vi requireNonNull- metode
            Objects.requireNonNull(verdi);
        // vi legger ny node
            Node<T> nyNode = new Node<>(verdi);
        // sjekker  om listen er tom eller ikke

        if ( hode == null && hale == null && antall == 0) { // tilfelle når listen er tom som beskrevet i oppgaves teksten
           hode = nyNode;
           hale = hode;

           endringer ++;
           antall ++;

           return true;
        }
        else { // når listen er ikke tom
            nyNode.forrige = hale;
            hale.neste = nyNode;
            hale = nyNode;

            endringer ++;
            antall ++;
            return true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        // sjekker om indeksen er <0 eller større en antal tilate noder i listen
        if (indeks < 0 || indeks > antall){
            throw new IndexOutOfBoundsException();
        }

        //sjekker om null-verdier
        if (verdi == null){
            throw new NullPointerException();
        }
        //Her skal vi sjekke om noden skal legges i første posisjon.
        if (indeks == 0){
            Node<T> r = new Node<>(verdi);
            r.neste=hode;
            hode.forrige=r;
            hode=r;
        }
        //sjekker om noden skal legges i sisste posisjon.
        else if (indeks == antall){
            Node<T> p = new Node<>(verdi);
            hale.neste=p;
            p.forrige=hale;
            hale=p;
        }
        else {
            //Node<T> m = new Node<>()
            //instaialisere hode noden
            Node<T> current= hode;
            //læper vi over hele listen for å finne noden.
            for (int i = 0;i<indeks;i++){
                current=current.neste;
            }
            //her instialiserer den noden som vi skal legge til
            Node<T> m = new Node<>(verdi,current.forrige,current);
            current = m;
            m.forrige.neste = current.neste.forrige = current;
        }
        antall++;
        endringer++;
    }
    //hjelp metoden
    private Node<T>finnNode(int index){
        Node<T> n;
        if (index <antall/ 2) {
            n=hode;
            for (int i =0;i<index;i++)n=n.neste;//har skal den begynne å sjekke fra venstre siden
        }
        else {
            n=hale;
            for (int i=antall-1;i<index;i--)n=n.forrige; //har skal den sjekke fra høyre siden
        }
        return n;
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks,false);//forst den sjekker hvis indexen er mindre enn 0
        Objects.requireNonNull(nyverdi,"verdien kan ikke være null");
        Node<T>n=finnNode(indeks);
        T gammleverdi=n.verdi;
        n.verdi=nyverdi; //erstatter verdien
        endringer ++; //oppdaterer endringer
        return gammleverdi;
    }

    @Override
    public boolean fjern(T verdi) {
       if (verdi == null){
           return false;
       }
       return true;
    }

    @Override
    public T fjern(int indeks) {

        Node<T> q;
        //sjekker om indexen til noden som skal fjernes
        //1- første noden
        if (indeks==0){
            q = hode;
            hode = hode.neste;
            hode.forrige=null;
        }
        //2- sisste noden i listen
        else if (indeks ==antall-1){
            q= hale;
            hale=q.forrige;
            hale.neste = null;
        }
        //3- om den er nærmere til hoden
        else if (indeks <antall/2){
            q = hode;
            for (int i = 0; i<indeks;i++){
                q =q.neste;
            }

        }
        // 4- om den er nærmere til halen
        else{
            q= hale;
            for (int i = antall-1; i>indeks;i--){
                q = q.forrige;
            }
        }
        antall--;
        endringer++;
        return q.verdi;

    }

    @Override
    public void nullstill() {
        //throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        Node<T> nå = hode;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if ( tom()){
            builder.append("]");
            return builder.toString();
        } else {
            builder.append(nå.verdi);
            nå = nå.neste;
            while (nå != null) {
                builder.append(", ");
                builder.append(nå.verdi);
                nå = nå.neste;
            }

        }
        builder.append("]");
        return builder.toString();
    }

    public String omvendtString() {
        Node<T> nå = hale;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if ( tom()){
            builder.append("]");
            return builder.toString();
        }else {
            builder.append(nå.verdi);
            nå = nå.neste;
            while (nå != null) {
                builder.append(", ");
                builder.append(nå.verdi);
                nå = nå.neste;
            }

        }
        builder.append("]");
        return builder.toString();


    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


