package Alex;

import java.io.IOException;

class Main {
  
    public static void main(String[] args) throws IOException {
      // Activity 1: Call the sentimentVal method in Review with a word like "terrible" and print out the result
      System.out.println(Review.sentimentVal("aaron"));
      System.out.println(Review.totalSentiment("ReviewSentiment/Alex/myReview.txt"));
      System.out.println(Review.starRating("ReviewSentiment/Alex/myReview.txt"));
      Review.sortAdjectives();
    }
  }
