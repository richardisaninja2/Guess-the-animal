package animals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if(getHour() <= 12 && getHour() >= 5){
            System.out.println("Good morning");
        }if(getHour() >= 12 && getHour() <=  18){
            System.out.println("Good afternoon");
        }else{
            System.out.println("Good evening");
        }

//        animalName();
        validateAnimal();
        validationHandler();
//        scanner();
    }



    public static String  animalName(){
        System.out.println("Enter an animal:");
        Scanner scanner = new Scanner(System.in);
//      String answer = scanner.nextLine();

        return scanner.nextLine();

    }
    public static String question(){
        String[] ansArray = animalName().toLowerCase().split(" ");
        int beginning = 0;
        String animal = "";

        if(ansArray.length > 1){
            for(int i = 1; i< ansArray.length; i++){
                if(ansArray[i-1].equals("the") || ansArray[i-1].equals("an") || ansArray[i-1].equals("a")){
                    beginning = i;
                }
            }
            for(int i = beginning; i<ansArray.length; i++){
                animal += ansArray[i]+" ";
            }
        }else{
            animal = ansArray[0];
        }

        //if its greater than 1 word
//        if(ansArray.length > 1){
//            animal = ansArray[ansArray.length - 1];
//        }else{
//
//        }
        return animal.trim();
    }
    public static void validateAnimal(){
        String regex = "[aeiouAEIOU]";
        String animal = question().toLowerCase();
        if(animal.equals("unicorn")){
            System.out.println("Is it a " +animal+"?");
        }
        else if(animal.equals("xeme")){
            System.out.println("Is it an " +animal+"?");
        }else if(String.valueOf(animal.charAt(0)).matches(regex)){
            System.out.println("Is it an " +animal+"?");

        }else{
            System.out.println("Is it a " +animal+"?");

        }
    }
    public static void validationHandler(){
            Scanner animal = new Scanner(System.in);
            String str = animal.nextLine();
            validateResponse(str);
    }

    public static void validateResponse(String str){
        String[] posArr = {"y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"};
        String[] negArray = {"n", "no", "no way", "nah", "nope", "negative", "I don't think so, yeah no"};
        String[] farewells = {"farewell", "adieu", "bye-bye", "hasta-lavista", "so long"};

        String[] clarification = {"que paso.. yes or no?", "what? yes or no?", "come again yes or no?", "i dont understand yes or no?", "could you clarify.. yes or no?"};
        List<String> posList = Arrays.asList(posArr);
        List<String>negList = Arrays.asList(negArray);
        String regex = "[.!]";
        String regexFixed = str.trim().replaceFirst(regex, "");
        //randdom number between 1 and farewells.length
        int randomNumberClarification = (int) Math.floor(Math.random() * ((clarification.length -1) + 1));
        int randomNumberFarewells = (int) Math.floor(Math.random() * ((farewells.length -1) + 1));

        if(posList.contains(regexFixed.toLowerCase())){
            System.out.println("You answered: Yes");
            System.out.println(farewells[randomNumberFarewells]);
        }else if(negList.contains(regexFixed.toLowerCase())){
            System.out.println("You answered: No");
            System.out.println(farewells[randomNumberFarewells]);
        }else{
            System.out.println(clarification[randomNumberClarification]);
            validationHandler();
        }
    }








    public static int getHour(){
        Calendar rightNow = Calendar.getInstance();
        return rightNow.get(Calendar.HOUR_OF_DAY);
    }


}
