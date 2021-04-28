package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int digitCounter = 0;
        int charCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            try {
                Integer.parseInt(s.substring(i, i+1));
                digitCounter++;
            } catch (NumberFormatException e) {
                charCounter++;
            }
        }
        return digitCounter > charCounter;
    }
}
