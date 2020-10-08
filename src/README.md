# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 

# Krav til innlevering

Se oblig-tekst for alle krav. Oppgaver som ikke oppfyller følgende vil ikke få godkjent:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* Ingen debug-utskrifter
* Alle testene som kreves fungerer (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet

# Arbeidsfordeling

Oppgaven er levert av følgende studenter:
* Ali Haji, S341891, s341891@oslomet.no
* Nedaa Alnassar, s341875, s341875@oslomet.no
*Amr Hakmi ,s344081
* Omar Abbod, s341881, s341881@oslomet.no
* Yazan alshhabi s341871, s341871@oslomet.no

Vi har brukt git til å dokumentere arbeidet vårt. Vi har 16 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Ali Haji har hatt hovedansvar for oppgave 1, 2. 
* Amr Hakmi har hatt hovedansvar for oppgave 3,8. 
* Nedaa har hatt hovedansvar for oppgave 5 og 6. 
* Omar Abbod har hatt hovedansvar for oppgave 9,10.
*Yazan alshhabi har hatt hovedansvar for oppgave 4 og 7

# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

* Oppgave 1: Lager int antall metode med å returnere antall , 
              tom() metoden  returnerer true hvis antall er 0 , det vil si at listen er tom, 
              og returnerer false hvis listen er ikke tom,
             Konstruktøren : først hvis a er null, kastes NullPointerException, 
             etterpå finner vi elementene som ikke er null og lager hode, 
             etter på lager resten av listen
* Oppgave 2: toString-metoden : jeg bruker StringBuilder ,etterpå  sjekker når listen er ikke null og bruker vi neste-pekere, mens 
              verdien fortsatt ikke null legger vi ", "... etter på legger vi "]".
             Det samme for OmvendttoString men vi bruker forrige-peker fra hale til hode.
             Metoden boolean leggInn: først legger vi requireNonNull- metode, legger vi en ny Node og sjekker om listen er tom eller ikke,
             metoden returnerer true,, endringer og antallet økes,
* Oppgave 3: Her har jeg løste oppgaven 3.a : først lagde jeg denne privte hjelpe metoden finnNode som skal sjekke hvis
 indeksen er mindre enn antall/2 så skal den begynne å skjekke fra venstre eller så skal den skjekke fra høyre siden.
             derreter lagde jeg hent metode ved å bruke finn metoden som jeg lagde og indexkontroll so sjekker hvis
              indexen er mindre enn null.jeg har lagd også oppdater som skal erstatte verdien med et nytt verdie ,først
               skal den sjekkes hvis den ny verdie er null så kommer feil melding og den skal øke endringer
             jeg løste oppgaven 3.b og skrev noen forklaring ved metoden            
             
              hvis listen er tom da returnerer toString metoden ], hvis ikke da sitter vi verdien in 
*oppgave 4: ( jeg har skrevet før nå en beskrivelse angående denne oppgaven, men alt ble borte. derfor så skriver jeg alt på nytt). 
i denne oppgave så skulle vi lage en metode som sjekker indeksen eller posisjonen til en verdi finns i listen og retunere -1 om den ikke
finnes. jeg brukte ett kall metode (indeksTil) i den inneholder boolean metode som skal retunere true eller false om den finnes eller ikke
i andre metoden som skal returnere -1 så tok jeg en if hvor jeg la om verdien er lik null så retuner -1. og tok en for løkke som skal loope
gjennom listen for å sjekke neste verdien om den finnes siden den er dobbellenketlisteog retunerer -1 hvis den ikke finnes.
* Oppgave 5: "public void leggInn(int indeks, T verdi)" den er en metode som skal ta imot index og verdi,
 så først sjekker jeg om indeksen er mindre enn null eller større enn antall tilate noder,
 så sjekket om Null-verdi, ellers så skal sjekke om vi skal legg noden på hviken posisjon,
 om den er i første eller sisste posisjon, i 0 posisjon sier vi at den noden vi leger blir noden.nest er head, på samme måten når den skal legges i sisste posisjon.
 hvis vi ønsker å legge noden noen sted i mitdten så først prøver vi å finne noden som legger i indeks-posisjonen gjennom for løkke.
 * oppgave 6: første T fjern(int indeks)-metoden vi skal fjerne noden når vi har indeksen så først sjekker om antall noder er 1 så
 det skal vi fjerne den, og sjekker om posisjonen til noden om den ligger i 0 posisjon eller i sisste posisjen så bytter vi 
 bare pekere, i siste tilfylle brukte jeg metoden finnNode for å finne noden som vi skal fjernes og byttet etterpå perkere, og sist minuserte antall noder og retunerte verdien til moden som ble fjernet.
 boolean fjern(T verdi)-metoden: sjekket om verdien er null og retunerte false; så brukte While lokke for å loppe over listen og sjekker verdien.
 På samme måte til forig metoden.

*Oppgave 7: i denne oppgaven så ble vi bedt om tømme alt, og vi ble bedt om å gjøre den på to måter. jeg gjorde første måten som gikk greit
 gjennom testen. jeg antar at Node<T> p skal være hode og q. og antar at q vil være den p og pekeren (neste) som skal hjelpe til å ta oss 
mot hode og på slutten så øker jeg endringer og setter antall =0. i andre metoden så satt jeg fjern kallemetoden, men da jeg testa metoden 
så gikk den ikke gjennom og visste at det er noe feil i linjen 333 som hører til oppgave 6 og vi skal sjekke feilen og fikser den. og deretter 
skal jeg teste begge metodene og se hvilken er mest effektiv

 
* Oppgave 8.a først sjekeks hvis endringer!=iteratorendringer hvis ja så throws Exception. så sjekekr jeg hvis hvis
hasnext metode ikke er true så throws Exception at det er tom.vi setter fjernOk til true. så flyttes denne til neste node
og ruturnere denneVerdi.. 8.b vi returnere en instans av iteratorklassen 

* oppgave 9.a først jeg har lagt metode remove() for å kunne sjekke hvis fjernOK ikke så kan ikke fjerne noe element,
 så vi sjekker etterhvert hvis iteratorendringer != endringer hvis ja 
så vi lager endriger i listen og etter at Listen ble endret setter vi at fjernOK til false.