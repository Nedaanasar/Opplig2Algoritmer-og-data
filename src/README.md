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
* Yazan Alshhabi, s341871, s341871@oslomet.no

Vi har brukt git til å dokumentere arbeidet vårt. Vi har 16 commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Ali Haji har hatt hovedansvar for oppgave 1, 2. 
* Amr Hakmi har hatt hovedansvar for oppgave 3,8.  
* Yazan alshhabi har hatt hovedansvar for oppgave 4 og 7.
* Vi har i fellesskap løst oppgave 10. 


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
* Oppgave 5: "public void leggInn(int indeks, T verdi)" den er en metode som skal ta imot index og verdi,
 så først sjekker jeg om indeksen er mindre enn null eller større enn antall tilate noder,
 så sjekket om Null-verdi, ellers så skal sjekke om vi skal legg noden på hviken posisjon,
 om den er i første eller sisste posisjon, i 0 posisjon sier vi at den noden vi leger blir noden.nest er head, på samme måten når den skal legges i sisste posisjon.
 hvis vi ønsker å legge noden noen sted i mitdten så først prøver vi å finne noden som legger i indeks-posisjonen gjennom for løkke.
oppgave 4: indekstil metoden er den metoden som skal retunere -1 om indeksen til verdein om den ikke finnes i listen og skal retunere posisjonen eller indeksen til verdien 
hvis den finnes. jeg lagde boolean metoden som skal retunere true eller false ved bruk av ett kall metode (indekstil)
i den indeksTil metoden så la jeg en for-løkke som sjekker posisjoen til verdien om den finnes i listen eller ikke og retunere -1. 
 

