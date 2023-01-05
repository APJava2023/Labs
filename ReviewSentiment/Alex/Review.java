package Alex;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 * (method removePunctuation() was added from teacher code)
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();

 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("ReviewSentiment/src/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("ReviewSentiment/src/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
      //  System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("ReviewSentiment/src/negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }
  
  /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
// comment
/** Activity 2: totalSentiment()
  * Write the code to total up the sentimentVals of each word in a review.
 */
  public static double totalSentiment(String filename)
  {
    // read in the file contents into a string using the textToString method with the filename

    // set up a sentimentTotal variable
    double sentimentTotal = 0;
    String review = textToString(filename);
    String[] reviewSplit = review.split(" ");
    

    // loop through the file contents 
      for (String str : reviewSplit) {
        sentimentTotal += sentimentVal(removePunctuation(str));
      }
       // find each word
       // add in its sentimentVal
       // set the file contents to start after this word
   
   


    return Double.parseDouble(String.format("%.2f", sentimentTotal));
  }


  /** Activity 2 starRating method
     Write the starRating method here which returns the number of stars for the review based on its totalSentiment.
  */
  public static int starRating(String filename)
  {
    // call the totalSentiment method with the fileName

    // determine number of stars between 0 and 4 based on totalSentiment value 
    int stars = 0; // change this!
    double value = totalSentiment(filename);
    // write if statements here
    if (value >= 5) stars = 4;
    else if (value >= 4) stars = 3;
    else if (value >= 0) stars = 2;
    else if (value >= -1) stars = 1;
    else stars = 0;


  
    // return number of stars
    return stars; 
  }

  public static void sortAdjectives() throws IOException {
    File posAdj = new File("ReviewSentiment/src/positiveAdjectives.txt");
    FileWriter posAdjFw = new FileWriter(posAdj, true);

    File negAdj = new File("ReviewSentiment/src/negativeAdjectives.txt");
    FileWriter negAdjFw = new FileWriter(negAdj, true);
    if (textToString("ReviewSentiment/src/positiveAdjectives.txt").isEmpty() &&
    textToString("ReviewSentiment/src/negativeAdjectives.txt").isEmpty() ) {
      
      for (String word : sentiment.keySet()) {
        if (sentimentVal(word) > 0) {
          posAdjFw.write(word + "\n");
        }
        else negAdjFw.write(word + "\n");
      }

      posAdjFw.close();
      negAdjFw.close();
    }
    else {
      Scanner scan = new Scanner(System.in);
      System.out.print("It looks like target files are not empty, are you sure you want to run this again? [y/n] ");
      
      try {
        String answer = scan.next();
        System.out.println();
        if (answer.toLowerCase().equals("y")) {
          sortAdjectives();
        }
        else if (answer.toLowerCase().equals("n")) {
          System.out.println("exiting...");
        }
        else sortAdjectives();
      } catch (Exception e) {
        System.out.println("error reading input");
      }
    }
    
  }

  public static String fakeReview(String fileName) {
    String fileContents = textToString(fileName);
    int index = fileContents.indexOf("*");
    int current = 0;
    while (index >= 0) {
      current = index;
      while ((Character.isAlphabetic(fileContents.charAt(current)) && !fileContents.substring(current, current + 1).equals(" ")) || current == index) {
        current++;
      }
      String firstPart = fileContents.substring(0, index);
      String lastPart = fileContents.substring(current);
      fileContents = firstPart + randomAdjective() + lastPart;
      index = fileContents.indexOf("*");
    }
    return fileContents;
  }
}