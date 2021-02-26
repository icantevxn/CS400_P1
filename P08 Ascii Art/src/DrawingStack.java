
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

import java.util.EmptyStackException;
import java.util.Iterator;
import java.lang.Iterable;

/**
 * This class creates a new DrawingStack object that implements StackADT and Iterable interfaces
 * 
 * @author evangelinelim
 *
 */
public class DrawingStack implements StackADT<DrawingChange>, Iterable<DrawingChange> {

  private LinkedNode<DrawingChange> top;
  private int size;

  /**
   * Default constructor with no arguments
   */
  public DrawingStack() {
    top = null;
    size = 0;
  }

  /**
   * Add a DrawingChange object to this stack
   * 
   * @param head a DrwaingChange object to be added
   * @throws IllegalArgumentException with a descriptive error message if the input head is null
   */
  @Override
  public void push(DrawingChange head) {
    if (head == null) {
      throw new IllegalArgumentException("No object found.");
    }

    top = new LinkedNode<DrawingChange>(head, top);// uses LinkedNode constructor with two arguments
                                                   // to set a next LinkedNode <DrawingChange>
                                                   // object
    size++;

  }

  /**
   * Remove the DrawingChange object on the top of this stack and return it
   * 
   * @return the first DrawingChange object to be removed from the top of the stack
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  public DrawingChange pop() {

    if (top == null) {
      throw new EmptyStackException();
    }
    LinkedNode<DrawingChange> first = top;
    top = top.getNext();
    size--;
    return first.getData();

  }

  /**
   * Get the DrawingChange on the top of this stack
   * 
   * @return the DrawingChange object on the stack top
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  public DrawingChange peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.getData();

  }

  /**
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no DrawingChange object, otherwise false
   */
  public boolean isEmpty() {
    if (top == null) {
      return true;
    } else
      return false;
  }

  /**
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  public int size() {
    return size;
  }

  /**
   * Accessor for data field of DrawingChange object
   * 
   * @return the data within this linked node
   */
  public DrawingChange getData() {
    return top.getData();
  }

  /**
   * Accessor for next field
   * 
   * @return the next
   */
  public LinkedNode<DrawingChange> getNext() {
    return top.getNext();
  }

  /**
   * Setter for next field
   * 
   * @param next the next to set
   */
  public void setNext(LinkedNode<DrawingChange> next) {
    top.setNext(next);
  }

  /**
   * Creates new iterator object of DrawingChange type
   * 
   * @return the DrawingStackIterator object to be iterated through
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    DrawingStackIterator stack = new DrawingStackIterator(top);
    return stack;

  }

}
