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
 * This class tests for important methods in this program.
 * 
 * @author evangelinelim
 *
 */
public class AsciiArtTester {

  /**
   * Checks if DrawingStack class' push() and peek() method works
   * 
   * @return true if the test is passed
   */
  public static boolean testStackPushPeek() {

    DrawingStack testStack = new DrawingStack();
    DrawingChange testHead = new DrawingChange(0, 0, 'a', 'b');

    try {
      testStack.peek();// test if peek throws exception if peeking empty stack
      return false;

    } catch (Exception peek) {
      try {
        testStack.push(null);// test push throws exception if program tries to push a null node.
        return false;
      } catch (Exception push) {

        push.getMessage();

        testStack.push(testHead);

        if (testStack.peek() != testHead) {
          return false;
        } else
          return true;
      } // end try-catch

    } // end try-catch


  }// end testStackPushPeek

  /**
   * Checks if pop() method in DrawingStack works
   * 
   * @return true if test is passed
   */
  public static boolean testPop() {
    DrawingStack testStack = new DrawingStack();
    DrawingChange testSecond = new DrawingChange(2, 2, '_', 'b');
    DrawingChange testHead = new DrawingChange(1, 1, '_', 'a');
    try {

      testStack.pop();// test if pop throws exception when trying to pop an empty stack
      return false;

    } catch (Exception e) {

      testStack.push(testSecond);
      testStack.push(testHead);// pushing two new nodes into the stack
      testStack.pop();// pop the first

      if (testStack.peek() == testSecond) {
        return true;// test if the stack is popped correctly
        // checks if peek is the same object as the testSecond DrawingChange
      } else
        return false;

    } // end try-catch
  }// end testPop

  /**
   * Checks if methods in Canvas class works
   * 
   * @return true if all methods work correctly
   */
  public static boolean testCanvas() {

    Canvas testCanvas;

    try {

      testCanvas = new Canvas(-1, -1);// checks if Canvas constructor throws exception if there is
                                      // invalid Canvas size input
      return false;

    } catch (Exception e) {
      e.getMessage();

      testCanvas = new Canvas(2, 3);

      try {
        testCanvas.draw(3, 4, 'a');// test if draw() method throws exception if row and column are
                                   // invalid values
        return false;
      } catch (Exception d) {

        d.getMessage();

        testCanvas.draw(1, 1, 'a');

        if (testCanvas.getUndoStack().peek().row == 1 || testCanvas.getUndoStack().peek().col == 1
            || testCanvas.getUndoStack().peek().prevChar == '_'
            || testCanvas.getUndoStack().peek().newChar == 'a') {

          testCanvas.undo();// test if the newly drawn object is pushed into undoStack
          // if yes, call undo method and this newly drawn object should be pushed into redoStack

          if (testCanvas.getRedoStack().peek().row == 1 || testCanvas.getRedoStack().peek().col == 1
              || testCanvas.getRedoStack().peek().prevChar == '_'
              || testCanvas.getRedoStack().peek().newChar == 'a') {
            return true;// return true if redoStack contains newly drawn object
          } else {
            return false;
          } // end if-else

        } else {
          return false;

        } // end if-else

      } // end catch
    } // end catch


  }// end testCanvas

  /**
   * Checks if DrawingStackIterator works correctly
   * 
   * @return true if DrawingStackIterator methods work correctly
   */
  public static boolean testIterator() {

    DrawingStack testStack = new DrawingStack();
    DrawingChange testSecond = new DrawingChange(2, 2, '_', 'b');
    DrawingChange testHead = new DrawingChange(1, 1, '_', 'a');

    Iterator<DrawingChange> iterTry = testStack.iterator();

    try {
      iterTry.next();// checks if iterator throws exception if trying to iterate through an empty
                     // stack
      return false;
    } catch (Exception e) {

      e.getMessage();

      testStack.push(testSecond);
      testStack.push(testHead);
      Iterator<DrawingChange> iterStack = testStack.iterator();

      DrawingChange firstDraw = iterStack.next();
      DrawingChange secondDraw = iterStack.next();
      if (firstDraw == testHead && secondDraw == testSecond) {
        return true;// returns true if first iteration and second iteration returns the right object
      } else
        return false;

    } // end try-catch block

  }// end testIterator

  /**
   * Checks if a series of tests returns true
   * 
   * @return true if all the test methods in this method returns true
   */
  public static boolean runAsciiArtTestSuite() {

    if (testCanvas() != true || testIterator() != true || testPop() != true) {
      return false;
    } else
      return true;

  }

  /**
   * Printing out results
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testStackPushPeek());
    System.out.println(runAsciiArtTestSuite());

  }
}
