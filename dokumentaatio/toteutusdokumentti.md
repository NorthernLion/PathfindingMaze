## Ohjelman yleisrakenne
Ohjelmiston koodi löytyy kansiosta PathfindingMazeJava/src/main/java/north/pathfindingmazejava/
ja testit kansiosta PathfindingMazeJava/src/test/java/north/pathfindingmazejava/

Testit on nimetty selkeästi tyylillä {luokkanNimi}Test ja asetettu samannimisiin kansioihin kuin testattava luokka.

Koodi on jaoteltu neljään eri kansioon
* datastructures - sisältää kaikki ohjelmiston kannalta tarpeelliset tietorakenteet
* gui - sisältää kaikki käyttöliittymään liittyvät luokat, joita ei ole testattu
* logic - sisältää ohjelmiston ytimen ja karttaan ja sen osiin liittyvän logiikan
* pathfinders - sisältää algoritmit joita käytetään reitin etsimiseen sokkelossa

Reitinetsijien käytettävyyden parentamiseksi niillä on oma rajapinta ja abstrakti pathfinder luokka, joka toteuttaa algoritmeille yhteiset osat.



### n = solmujen määrä ja m = kaarien määrä
Algoritmi | Aikavaatimus | Tilavaatimus
--------------- | ----- | ------
BFS | O(n+m) | O(n) |
Dijkstra | O((n + m) log n) | O(n)
A* | O((n + m) log n) | O(n)

## Puutteet
Työn jatkokehittäminen lisäämällä lisää algoritmeja on helposti mahdollista rakenteen avulla.
