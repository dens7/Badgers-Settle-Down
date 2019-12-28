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
 
/**
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents
 * a single node within a BST (known as a Sett).
 * 
 * @author Vedaant Tambi
 * @version 1.0
 * @since 1.0
 */
public class Badger {


  private final int size; // denotes the size of the badger
  private Badger leftLowerNeighbor; // the badger to the bottom left in the sett
  private Badger rightLowerNeighbor; // the badger to the bottom right in the sett


  /**
   * This constructor creates a new Badger with specified size.
   * 
   * @param size - The size of the newly constructed Badger object.
   */
  public Badger(int size) {
    this.size = size; // this keyword represents the size field of the object
  }

  /**
   * Retrieves neighboring badger that is smaller than this one.
   * 
   * @return The left lower neighbor of current badger.
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
  }


  /**
   * Retrieves neighboring badger that is larger than this one.
   * 
   * @returns The right lower neighbor of current badger.
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
  }

  /**
   * Retrieves the size of this badger.
   * 
   * @return The size of current badger.
   */
  public int getSize() {
    return size;
  }

  /**
   * Changes this badger's lower left neighbor.
   * 
   * @param badger - The new left lower neighbor of current badger.
   */
  public void setLeftLowerNeighbor(Badger badger) {
    leftLowerNeighbor = badger;
  }

  /**
   * Changes this badger's lower right neighbor.
   * 
   * @param badger - The new right lower neighbor of current badger.
   */
  public void setRightLowerNeighbor(Badger badger) {
    rightLowerNeighbor = badger;
  }

}
