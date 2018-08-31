## Testausdokumentti
Ohjelmisto on testattu Junit yksikkötesteillä, jotka testaavat kattavasti ohjelmiston eri osia. 
Kattavuuden määrittämiseksi on käytetty apuna pit-raportteja, joiden mukaan koodin rivikattavuus on xx ja muaatiokattavuus on xx. 
Testauksen ulkopuolelle on jätetty kaikki UI liittyvät luokat (tekstuaalinen, graaffinen ja mouselistener).
Testit voidaan luontevasti suorittaa uudestaan aina tarvittaessa Netbeansin kautta valitsemalla valikosta Test (Alt + f6).

Tämän lisäksi algoritmit ja heuristiikat on testattu esimerkki tapauksien avulla, joissa on käytetty hyväksi https://qiao.github.io/PathFinding.js/visual/ tuloksia.
Algoritmien testit ovat myös integraatiotestejä, koska niiden toiminnan mallintamiseksi luodaan myös ruudukko ja ruudokkoon palat eli kaikki ohjelmiston toiminnan kautta tarpeelliset osat ilman käyttäjän syötteitä ja graaffista esitystä.

Ohjelmiston tehtävä on havainnollistaa ja testata eri algoritmien suorituskykyä sokkelossa. Tämän saavuttamiseksi ohjelmistossa on graaffinen käyttöliittymä, 
joka esittää algoritmin toiminnan ensin värittämällä vieraillut palat ja sen jälkeen rakentamalla lopullisen algoritmin löytämän reitin.

```
It took 362936 nano seconds to solve manyPathGrid with A Star
It took 231292 nano seconds to solve manyPathGrid with Dijkstra
It took 133356 nano seconds to solve manyPathGrid with BFS
It took 238838 nano seconds to solve onePathGrid with A Star
It took 148630 nano seconds to solve onePathGrid with Dijkstra
It took 101682 nano seconds to solve onePathGrid with BFS
It took 96739 nano seconds to solve empty grid with A Star
It took 314806 nano seconds to solve empty grid with Dijkstra
It took 200119 nano seconds to solve empty grid with BFS
```
