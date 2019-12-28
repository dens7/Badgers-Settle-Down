/**
 * 
 * ////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION///////////////////////////// 
 * // Title: Badger Settle Down
 * // Files: Badger.java, P9Tests.java, Sett.java, BadgersSettleDown.java  
 * // Course: CS 300 Fall term 2018 
 * // Author: Vedaant Tambi 
 * // Email: tambi@wisc.edu 
 * // Lecturer's Name: MOUNA AYARI BEN HADJ KACEM 
 * //////////////////////////////////////// CREDIT OUTSIDE HELP ////////////////////////////////////
 * //                                              NONE                                           //
 * //////////////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////////////
 * 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents the testing class for the Badger and Sett class. This class tests whether
 * the public methods of both these classes are showing correct functionality
 * 
 * @author Vedaant Tambi
 * @version 1.0
 * @since 1.0
 */
public class P9Tests {

  /**
   * This method is responsible for 'filling' or inserting badgers of random sizes into an empty
   * sett
   * 
   * @param test is the empty sett that needs to be filled with badgers
   */
  private static void settFiller(Sett test) {

    // Badgers of random sizes are created and inserted in the sett
    test.settleBadger(49); // this will be the root of the BST that is created
    test.settleBadger(12);
    test.settleBadger(33);
    test.settleBadger(40);
    test.settleBadger(21);
    test.settleBadger(67);
    test.settleBadger(56);
    test.settleBadger(61);
  }

  /**
   * This method checks whether the constructor of the Sett class initializes a Sett properly
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean settConstructorTest() {
    Sett test1 = new Sett();
    if (test1 == null) // checks whether the sett has been initialized or not
      return false; // false is returned if the sett is null

    if (test1.getTopBadger() != null) // checks whether the topBadger is null or not
      return false; // if the top badger is not null, it means that the constructor shows incorrect
                    // functionality
    return true; // if no errors are found, then the test is successful
  }

  /**
   * This method tests the clear method of the sett class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean clearTest() {
    Sett test2 = new Sett(); // create a sett
    test2.settleBadger(16); // inserting a badger of a specific size in the sett
    test2.clear(); // clear the sett
    if (!test2.isEmpty()) // this checks whether the sett has been cleared or not
      return false; // if the sett is not cleared then the test is unsuccessful
    return true;
  }

  /**
   * This method checks whether the countBadger method counts the number of badgers in the sett
   * correctly
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean countBadgerTest() {
    Sett test3 = new Sett(); // a new sett is created

    // if the number of badgers is not zero then the countBadgerTest
    if (test3.countBadger() != 0) 
      return false;  

    /*
     * Like this we add 7 more badgers to the Sett using the settleBadger method and count the
     * number of badgers in the Sett after each addition. False is returned for incorrect
     * functionality of countBadger
     * 
     */
    test3.settleBadger(49);
    if (test3.countBadger() != 1)
      return false;

    test3.settleBadger(12);
    if (test3.countBadger() != 2)
      return false;

    test3.settleBadger(33);
    if (test3.countBadger() != 3)
      return false;

    test3.settleBadger(40);
    if (test3.countBadger() != 4)
      return false;

    test3.settleBadger(21);
    if (test3.countBadger() != 5)
      return false;

    test3.settleBadger(67);
    if (test3.countBadger() != 6)
      return false;

    test3.settleBadger(56);
    if (test3.countBadger() != 7) // notice how the number of badgers is increasing
      return false;

    test3.settleBadger(61);
    if (test3.countBadger() != 8)
      return false;
    return true;
  }

  /**
   * This method tests the findBadger method of the Sett class.
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean findBadgerTest() {
    Sett test4 = new Sett(); // a Sett is created to store the badgers
    settFiller(test4); // the sett is filled with the badgers of random sizes
    if (test4.findBadger(21) == null) // checks whether the badger is present in the sett or not
      return false; // false is returned because badger of size of 21 is present in the sett
    try {
      test4.findBadger(21);
    } catch (NoSuchElementException expt) {
      return false; // false is returned because an exception is not supposed to be thrown
    }
    if (test4.findBadger(21).getSize() != 21) // checks whether the right badger is returned or not
      return false;
    return true; // execution reaches here if no errors; this means that the method is successful
  }

  /**
   * This method checks whether the findBadger method works on an empty sett
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean findBadgerEmptyTest() {
    Sett test5 = new Sett(); // empty sett
    // try-catch statement to catch NoSuchElementException
    try {
      test5.findBadger(89); // finding a badger in an empty sett will throw an exception
    } catch (NoSuchElementException expt) {
      // checks whether the exception thrown has
      if (expt.getMessage().equals("WARNING: failed to find a badger with size 89 in the sett"))
        return true;
    }
    return false; // if the exception is not caught then the findBadger method has failed
  }

  /**
   * This method tests the getAllBadgers method of the sett class.
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean getAllBadgersTest() {
    Sett test6 = new Sett(); // new sett object
    settFiller(test6); // the sett is filled with badgers of random sizes
    // getAllBadgers returns an ArrayList which has badgers stored in ascending order of sizes
    List<Badger> badgerList = test6.getAllBadgers();
    if (badgerList.get(0).getSize() != 12) // since 12 is the smallest size, the first element is 12
      return false;
    if (badgerList.get(4).getSize() != 49) // the 5th element is 49
      return false; // if the 5th element is not 49, then the method shows incorrect functionality
    if (badgerList.get(7).getSize() != 67)
      return false;
    return true; // execution reaches here when no errors have been detected
  }

  /**
   * This method tests the getHeight method of the sett class for correct functionality
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean getHeightTest() {
    Sett test7 = new Sett(); // creation of sett object
    // try-catch block to catch an exception thrown because of no badgers in the sett
    try {
      test7.getHeight(); // an exception is thrown here because there is not BST present as of yet
    } catch (NoSuchElementException excpt) {
      if (!excpt.getMessage().equals("\nNo binary tree exists"))
        return false; // if the exception with the right message is not thrown then test if wrong
    }

    /*
     * A badger is added to the sett method and the getHeight method is checked against the
     * theoretical value of height. Six badgers are added like this, and the getHeight method is
     * checked after every addition.
     */
    test7.settleBadger(49);
    if (test7.getHeight() != 1)
      return false;

    test7.settleBadger(12);
    if (test7.getHeight() != 2)
      return false;

    test7.settleBadger(33);
    if (test7.getHeight() != 3)
      return false;

    test7.settleBadger(40);
    if (test7.getHeight() != 4)
      return false; // if the height does not match then the method shows incorrect functionality

    test7.settleBadger(21);
    if (test7.getHeight() != 4)
      return false;

    test7.settleBadger(67);
    if (test7.getHeight() != 4)
      return false;
    return true; // if execution reaches this statement, then the test was successful
  }

  /**
   * This method tests the getLargestBadger() method of the Sett class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean getLargestBadgerTest() {
    Sett test8 = new Sett();
    settFiller(test8); // the empty sett is filled with badgers of random sizes
    // checks whether the badger size for the largest badger is returned
    if (test8.getLargestBadger().getSize() != 67)
      return false;

    test8.settleBadger(96); // A badger larger than the current one is added
    // checks whether the method gets the largest badger of the updated BST
    if (test8.getLargestBadger().getSize() != 96)
      return false;
    return true; // true is returned if no errors are found
  }

  /**
   * This method tests the getTopBadger method of the sett class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean getTopBadgerTest() {
    Sett test9 = new Sett(); // Sett object
    settFiller(test9); // the sett is filled with badgers
    // the badger with size 49 is the top badger because it was the first to be added
    if (test9.getTopBadger().getSize() != 49)
      return false;
    test9.clear(); // the sett is cleared of all the badgers
    test9.settleBadger(23); // a new badger is added as the topBadger (the root of the BST)
    // badger with size 23 is the first badger added after the sett is cleared
    if (test9.getTopBadger().getSize() != 23)
      return false;
    return true; // true is returned if no errors are found
  }

  /**
   * This test method tests the isEmpty method of the Sett class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean isEmptyTest() {
    Sett test10 = new Sett(); // Creates and empty sett
    if (!test10.isEmpty()) // checks whether the sett is empty or not
      return false; // since sett is empty, false is returned if isEmpty method returns otherwise
    settFiller(test10); // now the sett is not empty
    if (test10.isEmpty()) // since sett is not empty, false is returned if isEmpty method returns
                          // otherwise
      return false;
    return true;
  }

  /**
   * This method tests the settleBadger method of the sett class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean settleBadgerTest() {
    Sett test11 = new Sett(); // empty sett
    settFiller(test11);
    // checks if the first addition to the sett is the topBadger of the BST
    if (test11.getTopBadger().getSize() != 49)
      return false;
    // checks whether the specified position in the Binary Search tree does not exist (is null)
    if (test11.getTopBadger().getLeftLowerNeighbor().getLeftLowerNeighbor() != null)
      return false;
    // checks if the specified element in this if-block has the badger of the right size
    if (test11.getTopBadger().getLeftLowerNeighbor().getRightLowerNeighbor().getLeftLowerNeighbor()
        .getSize() != 21)
      return false;
    if (test11.getTopBadger().getRightLowerNeighbor().getLeftLowerNeighbor().getRightLowerNeighbor()
        .getSize() != 61)
      return false;
    return true; // if the badgers have been settled appropriately then the test is successful
  }

  /**
   * This method checks whether an exception is thrown when a duplicate item is added to the sett
   * using the settleBadger method
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean settleDuplicateTest() {
    Sett test12 = new Sett(); // empty sett
    test12.settleBadger(33); // Badger with size 33 is added to the sett
    // try-catch to catch an exception because a badger with size 33 is added again to the sett
    try {
      test12.settleBadger(33);
    } catch (IllegalArgumentException exc) {
      // checks whether the correct message is displayed when the exception is thrown
      if (exc.getMessage().equals("WARNING: failed to settle the badger with size 33, as there is"
          + " already a badger with the same size in this sett"))
        return true;
    }
    return false;
  }

  /**
   * This method is the driver function of the tests methods for the Sett class. If all the tests
   * are successful then true is returned, otherwise false
   * 
   * @return true if all test methods of Sett.java show correct functionality, otherwise false
   */
  public static boolean runAllSettTests() {
    // list of all test methods of Sett.java class
    return (settConstructorTest() && clearTest() && countBadgerTest() && findBadgerTest()
        && findBadgerEmptyTest() && getAllBadgersTest() && getHeightTest() && getLargestBadgerTest()
        && getTopBadgerTest() && isEmptyTest() && settleBadgerTest() && settleDuplicateTest());
  }

  /**
   * This method tests the constructor of the Badger.java class by making sure it creates an object
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean badgerConstructorTest() {
    Badger b1 = new Badger(56); // Constructor is implicitly called when the object is initialized
    return b1 != null; // checks if the object with the specified name has been created
  }

  /**
   * This method tests the setLowerNeighbor method of the Badger.java class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean setLeftLowerNeighborTest() {

    // Creation of two Badger objects
    Badger b2 = new Badger(56);
    Badger b3 = new Badger(45);
    b2.setLeftLowerNeighbor(b3); // the left lower neighbor of b2 is set to badger b3

    // checks whether the left lower neighbor has been appropriately set up to point to b3
    return b2.getLeftLowerNeighbor().equals(b3); // true is returned for correct functionality
  }


  /**
   * This method tests the getSize method of the Badger class
   * 
   * @return true if method shows correct functionality, false otherwise
   */
  public static boolean getSizeTest() {
    Badger b4 = new Badger(93); // Creates a Badger with a size of 93
    return b4.getSize() == 93; // checks whether the getSize method returns the correct size of b4
  }

  /**
   * This method is the driver function of the tests methods for the Badger class. If all the tests
   * are successful then true is returned, otherwise false
   * 
   * @return true if the test methods of Badger.java show correct functionality, otherwise false
   */
  public static boolean runAllBadgerTests() {
    // list of all the test methods of the Badger class
    return (badgerConstructorTest() && setLeftLowerNeighborTest() && getSizeTest());
  }

  /**
   * This method calls the test batteries of Sett.java and Badger.java and displays the results of
   * the tests
   * 
   * @param args takes string arguments
   */
  public static void main(String[] args) {
    
    // The result of the tests are displayed here
    System.out.println("Results:");
    System.out.println("runAllSettTests: " + runAllSettTests());
    System.out.println("runAllBadgerTests: " + runAllBadgerTests());
  }

}
