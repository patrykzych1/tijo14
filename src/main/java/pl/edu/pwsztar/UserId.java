package pl.edu.pwsztar;

import java.util.Optional;

final class UserId implements UserIdChecker {

    private final String id;    // NR. PESEL

    public UserId(final String id) {
        this.id = id;
    }

    @Override
    public boolean isCorrectSize() {
        return false;
    }

    @Override
    public Optional<Sex> getSex() {
        return Optional.empty();
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public Optional<String> getDate() {
        return Optional.empty();
    }
}
