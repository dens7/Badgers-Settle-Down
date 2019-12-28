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
 */
 
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a Sett, where a group of Badgers live together. Each Sett is organized as a
 * BST of Badger nodes.
 * 
 * @author Vedaant Tambi
 * @version 1.0
 * @since 1.0
 */
public class Sett {

  private Badger topBadger; // the root of the BST

  /**
   * Constructs an empty Sett.
   * 
   */
  public Sett() {
    topBadger = null; // if the root is initialized to null then the sett is empty
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    topBadger = null; // the root is initialized to null
  }

  /**
   * This method counts how many Badgers live in this Sett.
   * 
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    if (isEmpty()) // checks whether the sett is empty or not
      return 0; // if the sett is empty, the number of badgers is zero
    else
      return countHelper(topBadger); // call to the recursive helper method of count
  }

  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are counting the
   *        number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    if (current == null) {
      return 0; // 1st base case: when the node does not exist
    } else if (current.getLeftLowerNeighbor() == null && current.getRightLowerNeighbor() == null) {
      return 1; // 2nd base case: when the node is at the last level of the sub-tree
    } else
      /*
       * The value returned by the recursive case is incremented by 1 for each badger that is
       * returned.
       */
      return countHelper(current.getLeftLowerNeighbor())
          + countHelper(current.getRightLowerNeighbor()) + 1;
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   * 
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException - When there is no Badger in this Sett with the
   *         specified size.
   */
  public Badger findBadger(int size) throws java.util.NoSuchElementException {
    return findHelper(topBadger, size); // calls the recursive findHelper method
  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are searching for
   *        a Badger with the specified size within.
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException When there is no Badger in this Sett with the
   *         specified size
   */
  private Badger findHelper(Badger current, int size) throws java.util.NoSuchElementException {

    if (current == null) // 1st base class: when the badger could not be found
      throw new NoSuchElementException( // an exception is thrown, with a message for the user
          "WARNING: failed to find a badger with size " + size + " in " + "the sett");
    if (size == current.getSize()) // 2nd base class: successful search
      return current; // the badger is returned if it is found
    if (size < current.getSize())
      return findHelper(current.getLeftLowerNeighbor(), size); // recur on the left badgers (left
                                                               // sub-tree)
    return findHelper(current.getRightLowerNeighbor(), size); // recur on the right badgers (right
                                                              // sub-tree)
  }

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in
   * the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public List<Badger> getAllBadgers() {
    List<Badger> badgerList = new ArrayList<Badger>(); // ArrayList of Badgers upcasted to ListADT
    if (isEmpty()) // reach a leaf or binary search tree empty
      throw new NoSuchElementException("\nNo badgers to to show");
    getAllHelper(topBadger, badgerList); // Helper method for getting all the badgers
    return badgerList; // the list is returned as a List of Badgers
  }

  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are collecting all
   *        contained Badgers within, into the allBadgers List.
   * @param allBadgers - The list of all Badgers living in the Sett that is rooted at the current
   *        Badger node. The contents of this list should be in ascending order by Badger size.
   */
  private void getAllHelper(Badger current, List<Badger> allBadgers) {
    // Recursive Algorithm
    if (current.getLeftLowerNeighbor() != null) // process left Badger (left sub-tree)
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
    // the statement's position here makes sure that the badgers are added in ascending order
    allBadgers.add(current);
    if (current.getRightLowerNeighbor() != null) // process right Badger (right sub-tree)
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
  }

  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   * node.<
   * 
   * @return The depth of this Sett.
   */
  public int getHeight() {
    if (isEmpty()) // reach a leaf or binary search tree empty
      throw new NoSuchElementException("\nNo binary tree exists");
    return getHeightHelper(topBadger); // recursive call to the method helper seeded with topBadger
  }

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are calculating
   *        the height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    int leftHeight = 0, rightHeight = 0; // When there are zero nodes, the height is zero

    if (current.getLeftLowerNeighbor() != null) // process height of left sub-tree
      leftHeight = getHeightHelper(current.getLeftLowerNeighbor());

    if (current.getRightLowerNeighbor() != null) // process height of right sub-tree
      rightHeight = getHeightHelper(current.getRightLowerNeighbor());
    /*
     * The maximum of two (leftHeight and rightHeight) is returned with an increment of 1 to account
     * for the height of the top node of the subtree
     */
    return 1 + Math.max(leftHeight, rightHeight);
  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    Badger current = topBadger; // the current badger starts at the root of the Binary Search tree

    /*
     * Since the largest badger is the deepest right-most badger, the loop is used to traverse to
     * that badger
     */
    while (current.getRightLowerNeighbor() != null)
      current = current.getRightLowerNeighbor();
    return current; // after the largest badger is found, it is returned
  }

  /**
   * This method retrieves the top Badger within this Sett (the one that was settled first).
   * 
   * @return the Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    return topBadger == null; // BST is empty if the root is null
  }

  /**
   * Creates a new Badger object with the specified size, and inserts them into this Sett (BST).
   * 
   * @param size - The size of the new Badger that will be settled.
   * @throws java.lang.IllegalArgumentException When a Badger with the specified size already exists
   *         within this Sett.
   */
  public void settleBadger(int size) throws java.lang.IllegalArgumentException {
    if (isEmpty()) // checks whether the sett is empty
      topBadger = new Badger(size); // add item at root position of the Sett
    else
      settleHelper(topBadger, new Badger(size)); // make call to addHelper to recursively add item
                                                 // to this Sett
  }

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * current - The current Badger (previously settled within this Sett) that we are considering
   * settling the newBadger beneath (either to its left or right).
   * 
   * @param newBadger - The new Badger that needs to be settled within this Sett.
   * @throws java.lang.IllegalArgumentException When a Badger with the specified size already exists
   *         within this Sett.
   */
  private void settleHelper(Badger current, Badger newBadger)
      throws java.lang.IllegalArgumentException {

    if (newBadger.getSize() < current.getSize()) { // add newBadger to the left subtree

      if (current.getLeftLowerNeighbor() == null) // Base case: no left Badger
        current.setLeftLowerNeighbor(newBadger); // add newBadger as the left child of topBadger

      else // recur on the left subtree of the current Badger
        settleHelper(current.getLeftLowerNeighbor(), newBadger);

    } else if (newBadger.getSize() > current.getSize()) { // add newBadger to the right subtree

      if (current.getRightLowerNeighbor() == null) // Base case: no right Badger
        current.setRightLowerNeighbor(newBadger); // add newBadger as the right child of topBadger

      else // recur on the right subtree of the current node
        settleHelper(current.getRightLowerNeighbor(), newBadger);
    } else // Base class: duplicate item

      throw new IllegalArgumentException( // exception is thrown with a detailed warning message
          "WARNING: failed to settle the badger with size " + newBadger.getSize() + ", as there is"
              + " already a badger with the same size in this sett");
  }

}
