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
//        validateAnimal();
//        validationHandler();
        distinguishingCharacteristic();
//            distinguishingValidator();
//        scanner();
    }



    public static String  firstAnimalName(){
        System.out.println("Enter the first animal");
        Scanner scanner = new Scanner(System.in);
//      String answer = scanner.nextLine();

        return scanner.nextLine();

    }
    public  static String secondAnimalNAme(){
        System.out.println("Enter the second animal");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static String firstAnimalNameHandler(){
        String[] ansArray = firstAnimalName().toLowerCase().split(" ");
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

        return animal.trim();
    }
    public static String secondAnimalNameHandler(){
        String[] ansArray = secondAnimalNAme().toLowerCase().split(" ");
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

        return animal.trim();
    }

    public static String[] validateAnimal(){
        String regex = "[aeiouAEIOU]";
        String firstAnimal = firstAnimalNameHandler().toLowerCase();
        String secondAnimal = secondAnimalNameHandler().toLowerCase();
        String[] animalNames = {firstAnimal, secondAnimal};
        String[] animalArrayWithPronoun = new String[animalNames.length];

        for(int i = 0; i<animalNames.length; i++){
            if(animalNames[i].equals("unicorn")){
//                System.out.println("a " +animalNames[i]);
                animalArrayWithPronoun[i] = "an " +animalNames[i];
            }
            else if(animalNames[i].equals("xeme")){
//                System.out.println("an " +animalNames[i]);
                animalArrayWithPronoun[i] = "an " +animalNames[i];
            }else if(String.valueOf(animalNames[i].charAt(0)).matches(regex)){
//                System.out.println("an " +animalNames[i]);
                animalArrayWithPronoun[i] = "an " +animalNames[i];
            }else{
//                System.out.println("a " +animalNames[i]);
                animalArrayWithPronoun[i] = "a " +animalNames[i];
            }
        }

        return animalArrayWithPronoun;
    }
    public static void distinguishingCharacteristic(){
        String[] animalArray = validateAnimal();
        System.out.println("Specify a fact that distinguishes "+animalArray[0]+" from "+ animalArray[1]+".\n" +
                "The sentence should be of the format: 'It can/has/is ...'.");
        distinguishedCharacteristicValues(animalArray);
    }
    public static void distinguishedCharacteristicValues(String[] arr){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        try{
            String valueWithoutIt = value.substring(3);
            if(value.toLowerCase().startsWith("it can")|| value.toLowerCase().startsWith("it is") || value.toLowerCase().startsWith("it has")){
                distinguishingValidator(arr, valueWithoutIt);
            }else{

                System.out.println("The examples of a statement:\n" +
                        " - It can fly\n" +
                        " - It has horn\n" +
                        " - It is a mammal");
                distinguishedCharacteristicValues(arr);
            }
        }catch(Exception e){
            System.out.println("The examples of a statement:\n" +
                    " - It can fly\n" +
                    " - It has horn\n" +
                    " - It is a mammal");
//            System.out.println("");
            distinguishedCharacteristicValues(arr);
        }

    }
    public static void distinguishingValidator(String[] animals, String value){
//        System.out.println(value);
        System.out.println("is this correct for "+animals[1]+"?");
        validationHandler(animals, value);
        answerHandler(animals, value);
    }
    public static String[] answerHandler(String[] animals,String value){

        String[] fixedPronouns = new String[animals.length];

        for(int i = 0; i< animals.length; i++){
            String str = "";
            String firstWord = animals[i].split(" ")[0];
            String secondWord = animals[i].split(" ")[1];

            if(firstWord.contains("a")){
                str = firstWord.replace("a", "The")+" "+secondWord;
                fixedPronouns[i] = str;
            }
            if(firstWord.contains("an")){
                str = firstWord.replace("an", "The")+" "+secondWord;
//                System.out.println(str +" this");
                fixedPronouns[i] = str;
            }
        }
//        System.out.println(Arrays.toString(animals));
//        System.out.println("I have learned the following facts about animals:");
//        System.out.println(fixedPronouns[0] +" "+ value);
//        System.out.println(fixedPronouns[1] +" "+negation(value));
//        System.out.println(Arrays.toString(fixedPronouns));
        return fixedPronouns;
    }
    public static String negation(String str){
        String newStr = "";
        if(str.contains("has")){
            newStr = str.replace("has", "doesn't have");
        }
        if(str.contains("can")){
            newStr = str.replace("can", "can't");
        }
        if(str.contains("is")){
            newStr = str.replace("is", "isn't");
        }
        return newStr;
    }

    public static void validationHandler(String[] animals, String value){
        Scanner animal = new Scanner(System.in);
        String str = animal.nextLine();
        validateResponse(str, animals, value);
    }

    public static void validateResponse(String str, String[] animals, String value){
        String[] posArr = {"y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"};
        String[] negArray = {"n", "no", "no way", "nah", "nope", "negative", "I don't think so, yeah no"};

        List<String> posList = Arrays.asList(posArr);
        List<String>negList = Arrays.asList(negArray);
        String regex = "[.!?]";
        String regexFixed = str.trim().replaceFirst(regex, "");
        //randdom number between 1 and farewells.length
        String[] fixedPronouns = answerHandler(animals, value);
//        System.out.println(Arrays.toString(answerHandler(animals, value)));
        String negatedValue = negation(value);


        if(posList.contains(regexFixed.toLowerCase())){
//            if(fixedPronouns[1].contains("unicorn") || fixedPronouns[0].contains("unicorn")){
//                System.out.println("");
//            }
            //if yes
            System.out.println("I have learned the following facts about animals:");

            System.out.println(fixedPronouns[0] +" "+ negatedValue.replaceAll(regex, "")+".");
            System.out.println(fixedPronouns[1] +" "+value.replaceAll(regex, "")+".");
            distinguishingQuestion(negatedValue);
//            System.out.println("You answered: Yes");
            chooseFarewell();
        }else if(negList.contains(regexFixed.toLowerCase())){
            //if no
            System.out.println("I have learned the following facts about animals:");
            System.out.println(fixedPronouns[0] +" "+ value+".");
            System.out.println(fixedPronouns[1] +" "+negatedValue+".");
            distinguishingQuestion(negatedValue);
//            System.out.println("You answered: No");
            chooseFarewell();
        }else{
            //invalid answer
            chooseClarification();
            validationHandler(animals, value);
        }
    }
    public static void distinguishingQuestion(String value){
        System.out.println(value);
        System.out.println("I can distinguish these animals by asking the question:");
        String[] valArray = value.split(" ");
        String newValue = "";
        for(int i = 1; i<valArray.length; i++){
            newValue += valArray[i]+" ";
        }
        if(value.contains("can't")){
            System.out.println("Can it " +newValue.trim()+"?");
        }if(value.contains("is")){
            System.out.println("Is it "+ newValue.trim()+"?");
        }
        if(value.contains("doesn't")){
            System.out.println("Does it "+newValue.trim()+"?");
        }
//        if(str.contains("has")){
//            newStr = str.replace("has", "doesn't have");
//        }
//        if(str.contains("can")){
//            newStr = str.replace("can", "can't");
//        }
//        if(str.contains("is")){
//            newStr = str.replace("is", "isn't");
//        }
    }
    public static void chooseFarewell(){
        String[] farewells = {"farewell", "adieu", "bye-bye", "hasta-lavista", "so long"};
        int randomNumberFarewells = (int) Math.floor(Math.random() * ((farewells.length -1) + 1));
        System.out.println(farewells[randomNumberFarewells]);
    }

    public static void chooseClarification(){
        String[] clarification = {"que paso.. yes or no?", "what? yes or no?", "come again yes or no?", "i dont understand yes or no?", "could you clarify.. yes or no?"};
        int randomNumberClarification = (int) Math.floor(Math.random() * ((clarification.length -1) + 1));
        System.out.println(clarification[randomNumberClarification]);
    }







    public static int getHour(){
        Calendar rightNow = Calendar.getInstance();
        return rightNow.get(Calendar.HOUR_OF_DAY);
    }


}
