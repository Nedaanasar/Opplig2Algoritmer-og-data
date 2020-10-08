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
        fratilKontroll (antall, fra, til); // vi bruker metoden til å sjekke at indeksene er ikke out of bounds
        DobbeltLenketListe<T> newlist=new DobbeltLenketListe<T>(); // vi lager ny liste
        Node<T> n =hode; //vi declarer n Node som hode
        int i=fra;// i er lik indeksne fra
        for (;i<til;i++){ // løkken skal skal øke til indeksen "til"
            n=finnNode(i);// vi bruker finnNode metode til å finnne indeksen i verdie
            if (n!=null){//hvis n er like null så skal den hoppe over men hvis ikke så skal den legge en tall i listen
                newlist.leggInn(n.verdi);//bruker LeggInn metode til å legge n verdi i listen
                n=n.neste;
            }
        }
        return newlist;




    }
    private static void fratilKontroll(int antall , int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall )                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall (" + antall  + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
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
            for (int i=antall-1;i>index;i--)n=n.forrige; //har skal den sjekke fra høyre siden
        }
        return n;
    }

    @Override
    public boolean inneholder(T verdi) {return indeksTil(verdi) !=-1;} //her så bruker jeg ett kall metode (indekstil)
    //{throw new UnsupportedOperationException();


    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        // her starter jeg med å legge en if-løkke som sjekker når verdien er lik null så skal retunere -1
        if (verdi == null)
            return -1;
            //her så er p  hode
            Node<T> p = hode;
            //her er det en for-løkke som looper gjennom, her så skal for-løkken sjekke om verdien finns i listen og retunere -1 hvis den ikke finnes
            for (int i = 0; i < antall; i++) {
                if (p.verdi.equals(verdi))
                    return i;
                p = p.neste;
            }
            return -1;
        }




        //throw new UnsupportedOperationException();


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
       // insiliserer hode noden
       Node<T> p = hode;
       // bruker while lukke for løpe over hele listen og finne verdien
       while (p!=null){
           if (p.verdi.equals(verdi)){
               break;// hvis vi finner den verdi så skal vi ut
           }
           p= p.neste; // eller skal vi sjekke neste noden her.

       }
       // 1- første tilfelle sjekker om null verdie og retunrer vi false
       if (p == null){
           return false;
       }
       // så sjekker på samme måten
       // 2- er listen inneholder en node
        if (antall ==1){
            hode = hale = null;
        }
        //3- er den noden som skal fjernes første noden
        else if (p==hode){
            hode = hode.neste;
            hode.forrige = null;
        }
        // 4- sisste noden i listen
        else if (p==hale){
            hale = hale.forrige;
            hale.neste = null;
        }
        //5- om den ligger inn i listen så endrer vi perkere....
        else {
            p.neste.forrige = p.forrige;
            p.forrige.neste = p.neste;
        }

        antall--;
        endringer++;
        return true;

    }

    @Override
    public T fjern(int indeks) {
        Node<T> q;
        indeksKontroll(indeks,false);
        //sjekker om listen inholder bare en node
        if (antall == 1){
            q= hode = hale = null;
        }
        //sjekker om indexen til noden som skal fjernes
        //1- første noden
        else if (indeks==0){
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
        else {
             q = finnNode(indeks); // her bruker vi metoden"finnNode" for finne posisjon til noden.
           q.forrige.neste = q.neste; //oppdatere neste pekeren slik at den peker på nesten noden
            q.neste.forrige = q.forrige; // oppdaterer forig peker....
        }

        antall--;
        endringer++;
        return q.verdi; // retunerer verdien til noden som vi hadde fjernet

    }

    @Override
    public void nullstill() {
        //throw new UnsupportedOperationException();
        //siden vi skal starte fra hode og mot hale så antar jeg at:
        Node<T> p= hode, q;
        while (p!=null){
            //her så bruker vi pekeren for å hjelpe for å gå fra hodet til hale
            q=p.neste;
           // her vi mener at neste indeksen og verdien er null som ble spurt om i oppgaven
            p.neste=null;
            p.verdi=null;
            //her sier jeg at både p og q skal være lik null
            p=q;
        }
        hode=hale;
        //her så øker vi endringer og setter antall til=0;
        endringer++;
        antall=0;
        //jeg har testa løsningen på denne oppgaven og det gikk greit. deretter så skal jeg teste den andre måten for å se hvilken som bruker mindre
        // tid for å sjekke hvilken som virker best.
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
            nå = nå.forrige;
            while (nå != null) {
                builder.append(", ");
                builder.append(nå.verdi);
                nå = nå.forrige;
            }

        }
        builder.append("]");
        return builder.toString();


    }

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();  //returner en instans av iteratorklassen
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks,false);
        return new DobbeltLenketListeIterator(indeks);
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
            denne=finnNode(indeks); //sette  denne til noden som hører til den gitt index ved hjelp av finnNode
            fjernOK = false; //resten skal være som gitt
            iteratorendringer = endringer;

        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            if (endringer!=iteratorendringer){throw new ConcurrentModificationException("liste er endret");}//sjekeks om det er like
            if (!hasNext()){throw new NoSuchElementException("Det er tom !");}//sjekeks hvis denne er null
            fjernOK=true; //settes til true
            T denneVerdi=denne.verdi; //lage variablen denneVerdi
            denne=denne.neste;//flyttes denne til neste node
            return denneVerdi; //vi returnerer "denne" verdi

        }

        @Override
        public void remove(){
            Node<T> p = (denne == null ? hale : denne.forrige);
            if(!fjernOK){
                throw new IllegalStateException("Kan ikke fjerne noe element nå!");
            }
            if(iteratorendringer != endringer){
                throw new ConcurrentModificationException("Listen er endret!");
            }
            fjernOK = false;
            if (p == hode)
            {
                if (antall == 1){ hode = hale = null;}      // kun en verdi i listen
                else{ hode = hode.neste; hode.forrige = null;}  // fjerner vi den første
            }
            else if (p == hale){ hale = hale.forrige; hale.neste = null;}  // fjerner vi den siste
            else{
                p.forrige.neste = p.neste;
                p.neste.forrige = p.forrige;    // da vi fjerner p
            }

            antall--;            // er en mindre i listen
            iteratorendringer++;
            endringer++;         //er  en endring

        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        if (liste.tom()) return;
        for (int i = 0; i < liste.antall(); i++) {
            for (int j = 0; j < liste.antall(); j++) {



            }
        }
    }
} // class DobbeltLenketListe


