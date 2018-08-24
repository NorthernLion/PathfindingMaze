## Testausdokumentti
Ohjelmisto on testattu Junit yksikkötesteillä, jotka testaavat kattavasti ohjelmiston eri osia. 
Kattavuuden määrittämiseksi on käytetty apuna pit-raportteja, joiden mukaan koodin rivikattavuus on xx ja muaatiokattavuus on xx. 
Testauksen ulkopuolelle on jätetty kaikki UI liittyvät luokat (tekstuaalinen, graaffinen ja mouselistener).
Testit voidaan luontevasti suorittaa uudestaan aina tarvittaessa Netbeansin kautta valitsemalla valikosta Test (Alt + f6).

Tämän lisäksi algoritmit ja heuristiikat on testattu esimerkki tapauksien avulla, joissa on käytetty hyväksi https://qiao.github.io/PathFinding.js/visual/ tuloksia.
Algoritmi testit ovat myös integraatio testejä, koska niiden toiminnan mallintamiseksi luodaan myös ruudukko ja ruudokkoon palat.

Ohjelmiston tehtävä on havainnollistaa ja testata eri algoritmien suorituskykyä sokkelossa. Tämän saavuttamiseksi ohjelmistossa on graaffinen käyttöliittymä, 
joka esittää algoritmin toiminnan ensin värittämällä vieraillut palat ja sen jälkeen rakentamalla lopullisen algoritmin löytämän reitin.
