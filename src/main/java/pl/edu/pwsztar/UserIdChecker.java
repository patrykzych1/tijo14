package pl.edu.pwsztar;

import java.util.Optional;

interface UserIdChecker {

    enum Sex {
        MAN, WOMAN
    }

    // TODO: Wstep teoretyczny - https://pl.wikipedia.org/wiki/PESEL
    // TODO: Numer PESEL powinien byc przekazany w konstruktorze klasy, ktora implementuje interfejs UserIdChecker
    // TODO: PESEL powinien byc typu String

    /** Czy PESEL posiada prawidlowa dlugosc */
    boolean isCorrectSize();

    /** Zwraca plec na podstawie numeru PESEL (MAN, WOMAN) */
    Optional<Sex> getSex();

    /** Sprawdza poprawnosc numeru PESEL */
    boolean isCorrect();

    /** Zwraca date (format: dd-MM-yyyy - np. 17-07-1987) na podstawie numeru PESEL */
    Optional<String> getDate();
}
