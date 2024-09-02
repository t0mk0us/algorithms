package tomkous.algos;

import junit.framework.TestCase;

public class JavaTest extends TestCase {
   protected String value1, value2, value3;
   protected DuplicateCharsInString testDups = new DuplicateCharsInString();
   
   // assigning the values
   protected void setUp(){
      value1 = "Our love will live forever";
      value2 = "Deleveled";
      value3 = "Something Not Palindromic";
   }

   // test method to add two values
   public void testDups(){
	   boolean result = testDups.findIfDups(value1);
      assertTrue(result == true);
   }
   
   public void testIfPalindrome(){
	   boolean result = Palindrome.isPalindrome1(value2);
      assertEquals(result, true);
   }
  
   public void testIfPalindrome2(){
	   boolean result = Palindrome.isPalindrome1(value3);
      assertEquals(result, true);
   }

   
   public void tearDown(){
	   
   }
}
