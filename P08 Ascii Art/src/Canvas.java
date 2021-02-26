
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
import java.util.Iterator;

/**
 * This class creats a new Canvas object with specific elements
 * 
 * @author evangelinelim
 *
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char[][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Constructor creates a new canvas which is initially blank
   * 
   * @throws IllegalArgumentException with a descriptive error message if width or height is 0 or
   *                                  negative.
   * @param width  is the width (# of column) of canvas
   * @param height is the height (# of row) of canvas
   */
  public Canvas(int width, int height) {

    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("Invalid input size.");
    }

    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();

  }

  /**
   * Draw a character at the given position drawingArray[row][col]
   * 
   * @throws IllegalArgumentException if row and column exceed canvas size
   * @param row integer row value
   * @param col integer col value
   * @param c   character to be drawn
   */
  public void draw(int row, int col, char c) {

    if (row >= height || col >= width || row < 0 || col < 0) {
      throw new IllegalArgumentException("Value is bigger than canvas size.");
    }

    for (int i = 0; i < getHeight(); i++) {
      for (int j = 0; j < getWidth(); j++) {
        if (drawingArray[i][j] == 0) {
          drawingArray[i][j] = '_';
        } // replacing default value with '_'
      }
    }

    char prevChar = drawingArray[row][col];// save previous character
    drawingArray[row][col] = c;

    DrawingChange newDraw = new DrawingChange(row, col, prevChar, c);
    undoStack.push(newDraw);// push new drawing into undoStack

    while (redoStack.isEmpty() != true) {
      redoStack.pop();
    } // making sure redoStack is empty
  }

  /**
   * Undo the most recent drawing change.
   * 
   * @return true if drawing is undone
   */
  public boolean undo() {
    if (undoStack.isEmpty() != true) {

      DrawingChange undone = undoStack.pop();
      redoStack.push(undone);
      drawingArray[undone.row][undone.col] = undone.prevChar;
      return true;

    } else
      return false;
  }

  /**
   * Redo the most recent undone drawing change.
   * 
   * @return true if drawing is redone
   */
  public boolean redo() {
    if (redoStack.isEmpty() != true) {
      DrawingChange redone = redoStack.pop();
      undoStack.push(redone);
      drawingArray[redone.row][redone.col] = redone.newChar;
      return true;
    } else
      return false;
  }

  /**
   *  Return a printable string version of the Canvas.
   */
  public String toString() {
    String toString = "";
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        toString = toString.concat(Character.toString(drawingArray[i][j]));
      }
      toString = toString + System.lineSeparator();//seperate each row to form a formatted canvas
    }
    return toString;
  }

  /**
   * Accessor method for width
   * @return width of canvas
   */
  public int getWidth() {
    return width;
  }

  /**
   * Accessor method for height
   * @return height of canvas
   */
  public int getHeight() {
    return height;
  }

  /**
   * Accessor method for undoStack
   * @return undoStack of DrawingStack type
   */
  public DrawingStack getUndoStack() {
    return undoStack;
  }

  
  /**
   * Accessor method for redoStack
   * @return redoStack of DrawingStack type
   */
  public DrawingStack getRedoStack() {
    return redoStack;
  }

  
  /**
   * Prints the canvas and it's drawings
   */
  public void printDrawing() {
    System.out.print(toString());
  }

  /** 
   * Shows the drawing history using the undoStack
   */
  public void printHistory() {

    Iterator<DrawingChange> iterUndo = undoStack.iterator();
    int count = undoStack.size();
    while (iterUndo.hasNext()) {
      DrawingChange printed = iterUndo.next();
      System.out.println(count + ". draws" + "'" + printed.newChar + "' on " + "(" + printed.row
          + "," + printed.col + ")");
      count--;
    }
  }

}
