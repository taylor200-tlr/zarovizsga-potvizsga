package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        int digitCounter= 0;
        int letterCounter = 0;
        if(s.equals("") || s == null){
            return false;
        }else{
            for(int i = 0; i< s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    digitCounter ++;
                }else{
                    letterCounter++;
                }
            }

        }
        return digitCounter > letterCounter;
    }
}
