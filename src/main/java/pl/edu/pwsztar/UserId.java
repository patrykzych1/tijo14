package pl.edu.pwsztar;

import java.util.Arrays;
import java.util.Optional;

final class UserId implements UserIdChecker {

    private final String id;    // NR. PESEL

    public UserId(final String id) {
        this.id = id;
    }

    @Override
    public boolean isCorrectSize() {
        return id.length() == 11;
    }

    @Override
    public Optional<Sex> getSex() {
        if(!isCorrect()){
            return Optional.empty();
        }

        if(Double.parseDouble(String.valueOf(id.charAt(9))) % 2 == 0){
            return Optional.of(Sex.WOMAN);
        } else {
            return Optional.of(Sex.MAN);
        }
    }

    @Override
    public boolean isCorrect() {
        if(!isCorrectSize()){
            return false;
        }


        for (int i = 0; i < 11; i++) {
            if(id.charAt(i) == '.') {
                return false;
            }
        }
        try {
            Double number = Double.parseDouble(id);
        } catch(NumberFormatException e) {
            return false;
        }

        double sum = 9 * Double.parseDouble(String.valueOf(id.charAt(0))) +
                     7 * Double.parseDouble(String.valueOf(id.charAt(1))) +
                     3 * Double.parseDouble(String.valueOf(id.charAt(2))) +
                     1 * Double.parseDouble(String.valueOf(id.charAt(3))) +
                     9 * Double.parseDouble(String.valueOf(id.charAt(4))) +
                     7 * Double.parseDouble(String.valueOf(id.charAt(5))) +
                     3 * Double.parseDouble(String.valueOf(id.charAt(6))) +
                     1 * Double.parseDouble(String.valueOf(id.charAt(7))) +
                     9 * Double.parseDouble(String.valueOf(id.charAt(8))) +
                     7 * Double.parseDouble(String.valueOf(id.charAt(9)));

        double checkDigit = sum % 10;

        String month = id.substring(2, 4);
        int monthNumeric = Integer.parseInt(month);
        if(monthNumeric > 12 && monthNumeric < 20){
            return false;
        } else if(monthNumeric > 32 && monthNumeric < 40) {
            return false;
        } else if(monthNumeric > 52 && monthNumeric < 60) {
            return false;
        } else if(monthNumeric > 72 && monthNumeric < 80) {
            return false;
        } else if(monthNumeric > 92) {
            return false;
        }

        return Double.parseDouble(String.valueOf(id.charAt(10))) == checkDigit;
    }

    @Override
    public Optional<String> getDate() {
        if(!isCorrect()) {
            return Optional.empty();
        }

        String day;
        String month;
        String year;
        int monthNumeric;
        day = id.substring(4, 6);
        month = id.substring(2, 4);
        year = id.substring(0, 2);

        monthNumeric = Integer.parseInt(month);
        if(monthNumeric > 0 && monthNumeric < 12){
            year = "19" + year;
            month = String.valueOf(monthNumeric);
        } else if(monthNumeric > 20 && monthNumeric < 33) {
            year = "20" + year;
            month = String.valueOf(monthNumeric - 20);
        } else if(monthNumeric > 40 && monthNumeric < 53) {
            year = "21" + year;
            month = String.valueOf(monthNumeric - 40);
        } else if(monthNumeric > 60 && monthNumeric < 73) {
            year = "22" + year;
            month = String.valueOf(monthNumeric - 60);
        } else if(monthNumeric > 80 && monthNumeric < 93) {
            year = "18" + year;
            month = String.valueOf(monthNumeric - 80);
        } else {
            return Optional.empty();
        }

        if(Integer.parseInt(month) < 10) {
            month = "0" + month;
        }

        return Optional.of(day + "-" + month + "-" + year);
    }
}
