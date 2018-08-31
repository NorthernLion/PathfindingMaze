## Testausdokumentti
Ohjelmisto on testattu Junit yksikkötesteillä, jotka testaavat kattavasti ohjelmiston eri osia. 
Kattavuuden määrittämiseksi on käytetty apuna pit-raportteja, joiden mukaan koodin rivikattavuus on 97% ja muaatiokattavuus on 92%.
Testauksen ulkopuolelle on jätetty kaikki UI liittyvät luokat (tekstuaalinen, graaffinen ja mouselistener) sekä Maze luokka, joka toimii ohjelman main/start metodina ja kutsuu ohjelman eri kohtia.
Testit voidaan luontevasti suorittaa uudestaan aina tarvittaessa Netbeansin kautta valitsemalla valikosta Test (Alt + f6).

Tämän lisäksi algoritmit ja heuristiikat on testattu esimerkki tapauksien avulla, joissa on käytetty hyväksi https://qiao.github.io/PathFinding.js/visual/ tuloksia.
Algoritmien testit ovat myös integraatiotestejä, koska niiden toiminnan mallintamiseksi luodaan myös ruudukko ja ruudokkoon palat eli kaikki ohjelmiston toiminnan kautta tarpeelliset osat ilman käyttäjän syötteitä ja graaffista esitystä.

Ohjelmiston tehtävä on havainnollistaa ja testata eri algoritmien suorituskykyä sokkelossa. Tämän saavuttamiseksi ohjelmistossa on graaffinen käyttöliittymä, joka esittää algoritmin toiminnan ensin värittämällä vieraillut palat ja sen jälkeen rakentamalla lopullisen algoritmin löytämän reitin.

Suorituskyky testeisteissä ohjelmisto tesaa 3 eri algoritmia 1. Tyhjässä sokkelossa jossa ei ole esteitä (maksimi määrä reittejä) 2. Sokkelossa jossa on paljon esteitä ja vain yksi mahdollinen reitti 3. Sokkelossa jossa on noin 10 mahdollista reittiä.

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

Tuloksista voidaan nähdä, että A Star on huomattavasti toisia algoritmeja parempi sokkeloissa joissa tyhjää tilaa on eniten. Dijkstra on puolestaan luontaisesti huonompi version BFS etsintä algoritmissa sokkeloissa, koska kaikkien siirtymien paino on yksi. Näin ollen Dijkstra toimii samalla tavalla kuin BFS mutta käyttää toimintaansa minimi prioriteettijonoa. BFS puolestaan käyttää FIFO jonoa, joka on huomattavasti nopeampi tietorakenne ratkaisu.

Suorityskykytestit löytyvät omasta luokastaan "PerformanceTest" ja ne laskevat jokaiselle algoritmille 10 kerran keskiarvon annetun sokkelon ratkaisemisessa. Suorituskykytestit suorittuvat muiden testien kanssa ja niiden tuloksia voidaan tarkastella output välilehdestä Netbeansista.
