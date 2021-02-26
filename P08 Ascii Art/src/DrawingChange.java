//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 Ascii Art
// Files: AsciiArtDriver.java, AsciiArtTester.java, Canvas.java, DrawingChange.java,
// DrawingStack.java, DrawingStackIterator.java, LinkedNode.java, StackADT.java
// Course: COMP SCI 300 Fall 2019
//
// Author: Evangeline Lim
// Email: elim28@wisc.edu
// Lecturer's Name: Gary Dahl
//
//
/////////////////////////////// ///////////////////////////////////////////////
/**
 * This class creates a new DrawingChange object
 * 
 * @author evangelinelim
 *
 */
public class DrawingChange {
  public final int row;
  public final int col;
  public final char prevChar;
  public final char newChar;

  /**
   * Constructor that takes in specific arguments
   * 
   * @param row      integer value of row (y-coordinate) for this DrawingChange
   * @param col      integer value of col (x-coordinate) for this DrawingChange
   * @param prevChar previous character in the (row,col) position
   * @param newChar  new character in the (row,col) position
   */
  public DrawingChange(int row, int col, char prevChar, char newChar) {
    this.row = row;
    this.col = col;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
