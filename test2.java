import java.util.Scanner;


/**
 * Created by Kyle Foley on 11/16/2016.
 */
public class test2 {

    public static void main (String[] args){

        startInputs();

    }//end main

/***************************************It Begins***************************************/

    public static double temperature;
    public static double weight;

    public static void pounds2kilos (double input){

        double newWeight = input / 2.2046226218 ;

        setWeight(newWeight);

    }// end pounds2kilos

    public static void faren2cels (double input){

        double temp;
        double buf = input - 32;
        temp = (buf * 5) / 9;

        setTemperature(temp);

    }//end faren2cels

    public static void kilos2pounds (double input){

        double newWeight = input * 2.2046226218;

        setWeight(newWeight);

    }//end kilos2pounds

    public static void cels2faren (double input){

        double temp;
        double buf = (input * 9) / 5;
        temp = buf + 32;

        setTemperature(temp);

    }//end cels2faren

    public static void inputHandler (char convCode, char unitCode, double num){

        if (convCode == 't' || convCode == 'T'){
            if (unitCode == 'f' || unitCode == 'F'){
                faren2cels(num);
                printTempCels();
            }else if (unitCode == 'c' || unitCode == 'C'){
                cels2faren(num);
                printTempFar();
            }//end if
        }else if (convCode == 'w' || convCode == 'W'){
            if (unitCode == 'p' || unitCode == 'P'){
                pounds2kilos(num);
                printWeightKilos();
            }else if(unitCode == 'k' || unitCode == 'K') {
                kilos2pounds(num);
                printWeightPounds();
            }
        }

    }//end inputHandler

    public static char firstInput (){

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter what type of conversion you wish to " +
                "perform. Acceptable inputs are: 't' or 'T' for temperature and " +
                "'w' or 'W' for weight.");

        String buff = in.next();
        char convCode = buff.charAt(0);

        //debug:
        //System.out.println("String entered was: " + buff);
        //System.out.println("Char at 0 of string was: " + convCode);


        if(convCode != 't' && convCode != 'T' && convCode != 'w' && convCode != 'W'){
            System.out.println("Incorrect input, proper inputs are: 't' or 'T'" +
                    " for temperature and 'w' or 'W' for weight. Application will" +
                    " now terminate.");
            System.exit(0);
        }//end if

        return convCode;

    }//end firstInput

    public static char secondInput (char convCode){

        Scanner in = new Scanner(System.in);

        char unitCode = ' ';

        if (convCode == 'w' || convCode == 'W') {
            System.out.println("Please enter what type of units you wish to" +
                    " convert. Acceptable inputs are: 'p' or 'P' for pounds " +
                    "to kilograms, 'k' or 'K' for kilograms to pounds.");

            String buff = in.next();
            unitCode = buff.charAt(0);

            if(unitCode != 'p' && unitCode != 'P' && unitCode != 'k' && unitCode != 'K'){
                System.out.println("Incorrect input, proper inputs are: 'p' or 'P'" +
                        " for pounds to kilograms, 'k' or 'K' for kilograms to pounds." +
                        " Application will now terminate");
                System.exit(0);
            }//end if

        }else if (convCode == 't' || convCode == 'T') {
            System.out.println("Please enter what type of units you wish to" +
                    " convert. Acceptable inputs are: 'f' or 'F' for fahrenheit" +
                    " to celsius, and 'c' or 'C' for celsius to fahrenheit.");

            String buff = in.next();
            unitCode = buff.charAt(0);

            if (unitCode != 'f' && unitCode != 'F' && unitCode != 'c' && unitCode != 'C') {
                System.out.println("Incorrect input, proper inputs are: 'f' or 'F'" +
                        " for fahrenheit to celsius, and 'c' or 'C' for " +
                        "celsius to fahrenheit. Application will now terminate.");
                System.exit(0);
            }//end if
        }//end if

        return unitCode;

    }//end secondInput

    public static void startInputs (){

        char convCode = firstInput();
        char unitCode = secondInput(convCode);

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number to convert: ");

        try {
            double num = in.nextDouble();
            inputHandler(convCode, unitCode, num);
        } catch (NumberFormatException nfe){
            System.out.println("Input must be a number.");
        }//end tryCatch

    }//end thirdInput

    public static void setTemperature (double temp){

        temperature = temp;

    }//end setTemperature

    public static void setWeight (double newWeight){

        weight = newWeight;

    }//end weight

    public static void printTempFar (){

        System.out.println("The specified Celsius temperature in Fahrenheit is: "
                + temperature);

    }//end printTempFar

    public static void printTempCels (){

        System.out.println("The specified Fahrenheit temperature in Celsius is: "
                + temperature);

    }//end printTempCels

    public static void printWeightKilos (){

        System.out.println("The Specified weight in Kilograms is: "
                + weight);

    }//end printWeightKilos

    public static void printWeightPounds (){

        System.out.println("The specified weight in Pounds is: "
                + weight);

    }//end printWeightPounds

}// end test2
