
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
import java.util.NoSuchElementException;

/**
 * This class implements Iterator interface and iterates through a DrawingStack of object
 * DrawingChange
 * 
 * @author evangelinelim
 *
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {
  private LinkedNode<DrawingChange> next;

  /**
   * Constructor that takes in specific arguments
   * @param next is the next node to be iterated 
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> next) {
    this.next = next;
  }

  /**
   * Gets next DrawingChange object in the stack
   * 
   * @return the next DrawingChange object on the top of the stack
   */
  public DrawingChange next() {
    LinkedNode<DrawingChange> first;
    first = next; // keeps track of the first node

    if (next != null) {
      next = next.getNext();
      return first.getData();
    } else {
      throw new NoSuchElementException("End of the stack. No more elements to show.");
    }
  }

  /**
   * Check if stack still has next object
   * 
   * @return true if still has next.
   */
  @Override
  public boolean hasNext() {
    if (next != null)
      return true;
    else
      return false;
  }

}
