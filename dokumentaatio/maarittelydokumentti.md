## Maarittelydokumentti

Ohjelma kirjoitetaan Javalla Maven projketina.

Ohjelma vertaa erilaisten algoritmien tehoa lyhimmän reitin löytämisesssä kahden pisteen välillä 2d ruudukossa, jossa kaikkien pisteiden välisten kaarien arvo on sama (1). 2D ruudukossa pisteen voi kuitenkin merkata estetyksi, jolloin algoritmi ei pysty kulkemaan sen läpi reittiä etsissäessä. Reitin löytymisen jälkeen ohjelma mallintaa algoritmien toimintaa graaffisesti käyttäen Java Swingiä. Käyttäjä pystyy luomaan kartan ohjelmiston kautta hiiren avulla. Hiiren oikealla näppäimellä voidaan poistaa ja lisätä esteitä ja vasemmalla painikkeella (yhdesti) asettaa aloituspisteen ja (kahdesti) asettaa lopetuspisteen. 

Algoritmit joita käytetään ovat A* Dijkstra ja BFS. A* toteuttaminen vaatii prioriteettijonon, hajautustaulun ja hajautus kartan käyttämistä. Dijkstra voidaan toteuttaa joko keon tai minimi prioriteettijonon avulla ja BFS toteuttamiseen riittää FIFO jono. A* toteutetaan käyttäen Manhattan distance heurestiikkana. 

Tavoitteena on, että ohjelmalla pystytään helposti hahmottamaan eri algoritmien erot reitin etsimisessä. Eri algoritmien aika ja tila vaatimukset riippuvat luodusta tilanteesta ja ohjelma ilmoittaa ne suorituksen jälkeen pop up ikkunalla.

Esimerkkinä työlle toimii github projekti: https://qiao.github.io/PathFinding.js/visual/


### n = solmujen määrä ja m = kaarien määrä
Algoritmi | Aikavaatimus | Tilavaatimus
--------------- | ----- | ------
BFS | O(n+m) | O(n) |
Dijkstra | O((n + m) log n) | O(n)
A* | O((n + m) log n) | O(n)
