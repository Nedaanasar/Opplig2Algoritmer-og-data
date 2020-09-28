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

    public DobbeltLenketListe() {

    }

    public DobbeltLenketListe(T[] a) {


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
        }
        else
            return false;
    }

    @Override
    public boolean leggInn(T verdi) {
            throw new UnsupportedOperationException();
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

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        throw new UnsupportedOperationException();
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


