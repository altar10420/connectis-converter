package com.connectis.converter;

/*
- Napisz 2 klasy, które będą służyć do konwersji wartości między systemami metrycznym i imperialnym
- Jedna klasa potrafi konwertować wartości wyrażone w systemie metrycznym na wartości w systemie imperialnym
- Druga klasa dokonuje odwrotnej konwersji (z systemu imperialnego na metryczny)
- Klasy powinny konwertować następujące wartości (pamiętaj o zastosowaniu odpowiedniego typu,
 tj. int, long, double itp.):
    - Metry vs Stopy
    - Centymetry vs Cale
    - Litry vs Galony
    - Kilogramy vs Funty
    - Stopnie Celsjusza vs Stopnie Fahrenheita
    - Dopuszczalna dokładność to min. do 2 miejsca po przecinku
- W projekcie użyj narzędzia Maven
- Projekt musi implementować standardową strukturę katalogów narzucaną przez bibliotekę Maven
- Projekt musi poprawnie przechodzić pełen cykl budowania przez Maven'a
- Działaniem wynikowym powinno być skompilowanie projektu do samodzielnego pliku JAR,
 który można uruchomić z konsoli
- W projekcie zaimplementuj testy używając biblioteki JUnit
    - Każda metoda powinna mieć min. 5 test case'ów. Pomyśl o jak największej ilości tzw. edge cases.
    - Do "wciągnięcia" zależności użyj Maven'a
- Faza test z cyklu Maven'a musi uruchamiać testy
- W ramach projektu stwórz repozytorium Git i umieść je w dedykowanym projekcie w narzędziu GitLab.
- Projekt powinien zawierać min. 5 commitów.
    - Każdy commit powinien mieć pełny opis zmian, które w jego ramach zostały zaimplementowane
    - Pełna historia musi być dostępna w projekcie GitLab
- Stwórz merge request'a na merge gotowego kodu do brancha master
 */


public class Main {

    public static void main(String[] args) {

        MetricToImperialConverter metricToImperialConverter = new MetricToImperialConverter();

    }
}
