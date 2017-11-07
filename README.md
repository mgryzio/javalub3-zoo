# javalub3-zoo
**Opis**

Naszym zadaniem będzie stworzenie aplikacji, która będzie modelowała zoo. Będziemy krok po kroku rozbudowywali aplikację o kolejne elementy, pamiętając o technikach i dobrych zasadach, których nauczyliśmy się do tej pory. Logikę aplikacji będziemy tworzyli korzystając z TDD.

Stworzyliśmy odpowiednią hierarchię zwierząt. Jako kierownicy zoo będziemy sprawdzali czy każde zwierzę (Animal) żyje oraz ważyli je od czasu do czasu w ramach rutynowych badań.

Niestety nie udało się nam otrzymać dofinansowania od UE na nowy startup, więc na razie w naszym zoo będą się znajdowały tylko niedźwiedzie (Bear). Na początek będą się tam znajdowały niedźwiedzie czarne (BlackBear), niedźwiedzie brunatne (BrownBear) i niedźwiedzie polarne (PolarBear).

Nasze niedźwiedzie to nietypowe zwierzęta. Żeby sprawdzić czy żyją (isAlive) należy przypomnieć sobie ostatnią datę ich posiłku. Jeśli zwierzę jadło mniej niż 10 dni temu, to jest żywe. Warto tutaj pomyśleć o JodaTime.

Aby utrzymywać nasze niedźwiedzie przy życiu powinniśmy żywić nasze zwierzaki. Każdy niedźwiedź powinien mieć możliwość jedzenia (eat). Wystarczy, by metoda ustawiała czas posiłku na obecną datę. Zjedzenie powinno ożywiać niedźwiedzia oraz wydłużać jego obecny czas życia.

**Pobieranie kodu**

Należy założyć konto na GitHub oraz utworzyć fork repozytorium. 
https://help.github.com/articles/fork-a-repo/ 

Następnie repozytorium można sklonować za pomocą komendy:
git clone https://github.com/<TWOJ_LOGIN>/javalub3-zoo.git

**Struktura kodu**

W projekcie znajdują się 2 foldery src/main/java oraz src/test/java. W każdym z nich znajduje się pakiet pl.sdacademy. Piszcie swój kod w tym pakiecie (testy w src/test/java i kod aplikacji w src/main/java). W folderze main znajdują się już jakieś klasy, m.in. Bear.java, którą będziecie w pełni implementowali. W folderze test znajduje się plik BearTest.java oraz BearSpec.groovy. Testy powinniście zamieszczać w tym pierwszym.

**Importowanie kodu do IntelliJ**

Wybieracie opcję Import Project, przechodzicie do sklonowanego folderu (WAŻNE: mocks, nie src), Import from external model, wybieracie Maven i klikacie Next aż do końca. Jeśli JDK nie jest ustawione, wybieracie 1.8.

**Zadania**

Wszystkie zadania należy wykonywać metodą TDD - najpierw piszemy niedziałający test, później implementację, a następnie polerujemy kod. Zakres zadań celowo jest bardzo prosty. Należy skupić się na sposobie programowania TDD, zamiast na zadaniach.

Niedźwiedź może przybierać lub tracić na wadzę.

1. Po zjedzeniu posiłku o danej masie, jego waga wzrasta o tę samą wartość. 
2. Po wypiciu wody (void drink(double waterWeight)) o danej masie, jego waga wzrasta o 3/4 tej wartości.
3. Po zrobieniu kupy (void poop()) masa misia spada o 5%.

Niedźwiedzie zapadają w sen zimowy. 

4. Niedźwiedzie czarne śpią (boolean isHibernating) od 20 listopada do 15 marca.
5. Niedźwiedzie polarna śpią od 5 maja do 10 października.
5. Karmienie lub pojenie misia w trakcie snu zimowego powinno wyrzucać wyjątek BearHibernatingException.
