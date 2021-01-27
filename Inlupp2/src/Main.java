import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("src/text.txt");                                       //create file text and reads in in java
        Scanner theFile = new Scanner(text);                                                 //scanner to read file
        String fileContent = " ";                                                            //String containing the file
        int rowNumber = 0;                                                                   //int counting the rows, starts with 1 because the row begins at 1
        String pattern = "if[(].+[}]|for[(].+[}]";                                                    //String containing the alphabet
        String currentLine = " ";

        while (theFile.hasNextLine()) {
            currentLine = theFile.nextLine();
            rowNumber++;
            finder(currentLine, pattern, rowNumber);

        }

    }

    public static void finder (String myString, String pattern, int rowNumber) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while (matcher.find()){
            if(matcher.group().length() != 0){

               count++;
                System.out.println("on row: " + rowNumber + " there is a for-loop or if-statement: " +  matcher.group());
               // System.out.println("Found at " + pattern + matcher.end()); matcher.group() + matcher.start()
            }

        }
    }
}
//---------------------------- Övning Regular expressions Svar:
// 1. På rad 531 : String pattern = "abcdefghij";
// 2. på rad 9 & 17 : String pattern = "ola";
// 3. på rad 316, 335, 342, 363 & 377 : String pattern = "a{3,5}+";
// 4. 4296 gånger : String pattern = "[\\W]{2,}"; | System.out.println("Found at " + count + " " + rowNumber);
// 5. 5 stycken : String pattern = "[A-Za-z0-9.%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}"; | System.out.println("Found at " + count + "  " +  matcher.group() + " at line number: " + rowNumber);
// 6. 8 stycken : String pattern = "\\d{2,10}[\\d+\\s-/]+\\d{5,}";  | System.out.println(rowNumber + " is the phone number " +  matcher.group());
// 7. på rad 319(llll), 334(aaaa), 341(aaaaaaa), 376(aaaaa), 495(MMMM) : String pattern = "([a-zA-Z])\\1{3,}"; | System.out.println("on row: " + rowNumber + " there is 4 identical letters " +  matcher.group());
// 8. På rad 96(fvS_422), 230(abc/656), 645(leE_114) : String pattern = "[a-zA-Z]{3}[_/][\\d]{3}"; | System.out.println("on row: " + rowNumber + " reg plate " +  matcher.group());
// 9. på rad 223(Banankontakt123), 266(Kalle kanin gillar svamp), 272(Hej) : String pattern = "\\((.*?)\\)"; | System.out.println("on row: " + rowNumber + " there is perfect matched parentheses containing: " +  matcher.group());
// 10. på rad 223, 234, 466, 525 : String pattern = "if[(].+[}]|for[(].+[}]"; | System.out.println("on row: " + rowNumber + " there is a for-loop or if-statement: " +  matcher.group());


//  System.out.println(matcher.group() + " is on row: " + number);