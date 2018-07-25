Ohjelma kirjoitetaan Javalla Maven projketina.
Ohjelma vertaa erilaisten algoritmien tehoa reitin löytämisesssä kahden pisteen välillä ruudukossa ja mallintaa niitten toimintaa graaffisesti käyttäen Java Swingiä.
Algoritmit joita käytetään ovat A* Dijkstra ja BFS (Varmasti myös monia muita tai haastavampia algoritmeja, mutta näillä aloitetaan). Käyttäjä pystyy valitsemaan aloitus pisteen algoritmille, sekä lisäämään ruudukkoon esteitä, joiden
läpi reitti ei saa kulkea. Ohjelma ilmoittaa millä algoritmilla kyseisessä tapauksessa saataisiin nopein aika.
Työssä käytetään ainakin Stackkia ja Listiä  algoritmien tekemiseen ja grafiikka puolen esitys viiveen saavuttamiseksi.

Tavoitteena on, että ohjelmalla pystytään helposti hahmottamaan eri algoritmien erot reitin etsimisessä. Eri algoritmien aika ja tila vaatimukset riippuvat luodusta tilanteesta ja ohjelma ilmoittaa ne suorituksen jälkeen.

Esimerkkinä työlle toimii github projekti: https://qiao.github.io/PathFinding.js/visual/


### n = solmujen määrä ja m = kaarien määrä
Algoritmi | Aikavaatimus | Tilavaatimus
--------------- | ----- | ------
BFS | O(n+m) | O(n) |
Dijkstra | O((n + m) log n) | O(n)
A* | O((n + m) log n) | O(n)
