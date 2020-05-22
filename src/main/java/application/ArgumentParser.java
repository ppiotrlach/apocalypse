package application;

public class ArgumentParser {
    private static String[] args;

    public ArgumentParser(String[] args){
        this.args = args;
    }

    private static boolean isStringInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public  int getNumber(int indexOfArray){
        if(args.length <= indexOfArray || !isStringInteger(args[indexOfArray]) ) return 5;
        int handler = Integer.parseInt(args[indexOfArray]);
        if(handler<0 || handler>20) return 5;
        return handler;
    }}