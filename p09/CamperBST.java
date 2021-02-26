import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * This class represents a Binary Search Tree for Camp Badger.
 * 
 * @author josiahchoong
 *
 */
public class CamperBST {
  public CampTreeNode root;
  private int size;
  private LinkedList<Camper> traversedLList; // LinkedList to maintain current traversal

  /**
   * Constructor for an empty CamperBST object.
   */
  public CamperBST() {
    root = null;
    size = 0;
    traversedLList = null;
  }

  /**
   * Returns the current size of the CamperBST.
   * 
   * @return the size
   */
  public int size() {
    return size;
  }

  /**
   * Checks whether the tree is empty.
   * 
   * @return true if the tree is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Starts tree insertion by calling insertHelp() on the root and assigning root to be the subtree
   * returned by that method.
   * 
   * @param newCamper camper to be added
   */
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current   The "root" of the subtree we are inserting into, ie the node we are currently
   *                  at
   * @param newCamper the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {
    CampTreeNode newCamperNode = new CampTreeNode();
    newCamperNode.setData(newCamper);

    // Base Case 1: if Binary Search Tree is empty
    if (current == null) {
      size++;
      return newCamperNode;
    }

    // Check to see if camper added is lexigraphically larger or smaller than current
    int i = newCamper.compareTo(current.getData());
    if (i > 0) {
      // Base Case 2a: if right node is null, insert node
      if (current.getRightNode() == null) {
        current.setRightNode(newCamperNode);
        size++;
        return root;
      } else {
        return insertHelp(current.getRightNode(), newCamper);
      }
    } else if (i < 0) {
      // Base Case 2b: if left node is null, insert node
      if (current.getLeftNode() == null) {
        current.setLeftNode(newCamperNode);
        size++;
        return root;
      } else {
        return insertHelp(current.getLeftNode(), newCamper);
      }
    } else {
      return root;
    }
  }

  /**
   * Prints the contents of this tree in alphabetical order based on the string "lastName,
   * firstName"
   */
  public void print() {
    printHelp(root);
  }

  /**
   * Recursive print helper method.
   * 
   * @param current The "root" of the subtree we are inserting into, ie the node we are currently at
   */
  private void printHelp(CampTreeNode current) {
    if (current == null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }

  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current The "root" of the subtree we are deleting from, ie the node we are currently at
   * @param key     the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) throws NoSuchElementException {
    CampTreeNode parent = findParentNodeToDelete(current, null, key);

    // If node to be removed is a root node
    if (parent == null) {
      // If node is a leaf node
      if (current.getLeftNode() == null && current.getRightNode() == null) {
        size--;
        return null;
      }
      // If node has one right child
      else if (current.getLeftNode() == null && current.getRightNode() != null) {
        size--;
        return current.getRightNode();
      }
      // If node has one left child
      else if (current.getLeftNode() != null && current.getRightNode() == null) {
        size--;
        return current.getLeftNode();
      }
      // If node has two children
      else {
        Camper successorData = findSuccessor(current).getData();
        CampTreeNode successorCopy = new CampTreeNode();
        successorCopy.setData(successorData);
        successorCopy.setLeftNode(current.getLeftNode());
        successorCopy.setRightNode(current.getRightNode());
        deleteHelp(current, successorData);
        size--;
        return successorCopy;
      }
    }

    // If node to be removed is the parent's right node
    else if (parent.getRightNode().getData().compareTo(key) == 0) {
      current = parent.getRightNode();
      // If node is a leaf node
      if (current.getLeftNode() == null && current.getRightNode() == null) {
        parent.setRightNode(null);
        size--;
        return root;
      }
      // If node has one right child
      else if (current.getLeftNode() == null && current.getRightNode() != null) {
        parent.setRightNode(current.getRightNode());
        size--;
        return root;
      }
      // If node has one left child
      else if (current.getLeftNode() != null && current.getRightNode() == null) {
        parent.setRightNode(current.getLeftNode());
        size--;
        return root;
      }
      // If node has two children
      else {
        Camper successorData = findSuccessor(current).getData();
        CampTreeNode successorCopy = new CampTreeNode();
        successorCopy.setData(successorData);
        successorCopy.setLeftNode(current.getLeftNode());
        successorCopy.setRightNode(current.getRightNode());
        parent.setRightNode(successorCopy);
        deleteHelp(current, successorData);
        size--;
        return root;
      }
    }

    // If node to be removed is the parent's left node
    else {
      current = parent.getLeftNode();
      // If node is a leaf node
      if (current.getLeftNode() == null && current.getRightNode() == null) {
        parent.setLeftNode(null);
        size--;
        return root;
      }
      // If node has one right child
      else if (current.getLeftNode() == null && current.getRightNode() != null) {
        parent.setLeftNode(current.getRightNode());
        size--;
        return root;
      }
      // If node has one left child
      else if (current.getLeftNode() != null && current.getRightNode() == null) {
        parent.setLeftNode(current.getLeftNode());
        size--;
        return root;
      }
      // If node has two children
      else {
        Camper successorData = findSuccessor(current).getData();
        CampTreeNode successorCopy = new CampTreeNode();
        successorCopy.setData(successorData);
        successorCopy.setLeftNode(current.getLeftNode());
        successorCopy.setRightNode(current.getRightNode());
        parent.setLeftNode(successorCopy);
        deleteHelp(current, successorData);
        size--;
        return root;
      }
    }
  }

  /**
   * This is a helper method for deleteHelp() to find the successor.
   * 
   * @param current node to find the successor
   * @return the successor node
   */
  private CampTreeNode findSuccessor(CampTreeNode current) {
    CampTreeNode successor = current.getRightNode();
    while (successor.getLeftNode() != null) {
      successor = successor.getLeftNode();
    }

    return successor;
  }

  /**
   * This is a helper method for deleteHelp() to find the node to remove and returns the parent
   * node.
   * 
   * @param current The "root" node of the Binary Search Tree
   * @param parent  of the current node
   * @param key     the camper to be deleted from the tree
   * @return the parent node of the node to delete
   * @throws NoSuchElementException if the node can not be found in the tree
   */
  private CampTreeNode findParentNodeToDelete(CampTreeNode current, CampTreeNode parent, Camper key)
      throws NoSuchElementException {
    if (current == null) {
      throw new NoSuchElementException("That camper is not enrolled.");
    }

    int i = key.compareTo(current.getData());

    // If current matches key, returns the parent node
    if (i == 0) {
      return parent;
    }
    // Otherwise, search the right or left node depending on i (comparison)
    else if (i > 0) {
      if (current.getRightNode() == null) {
        throw new NoSuchElementException("That camper is not enrolled.");
      } else {
        return findParentNodeToDelete(current.getRightNode(), current, key);
      }
    } else {
      if (current.getLeftNode() == null) {
        throw new NoSuchElementException("That camper is not enrolled.");
      } else {
        return findParentNodeToDelete(current.getLeftNode(), current, key);
      }
    }
  }

  /**
   * Returns an iterator of camper in the correct order as designated.
   * 
   * @param order of which to traverse through the Binary Search Tree
   * @return the iterator
   */
  public Iterator<Camper> traverse(String order) {
    // First time traversing need to initialize LinkedList
    if (traversedLList == null) {
      traversedLList = new LinkedList<Camper>();
    } else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /**
   * Recursive helper method to traverse. Will take the current CampTreeNode's data and add it to
   * traversedLList based on the given order. Then continue to recurse on the correct subtree.
   * 
   * @param current the root of the current subtree we are traversing
   * @param order   the type of traversal to perform
   */
  private void traverseHelp(CampTreeNode current, String order) {
    // Checks whether current is empty
    if (current == null) {
      return;
    }
    if (order.equals("PREORDER")) {
      traversedLList.add(current.getData());
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
    } else if (order.equals("POSTORDER")) {
      traverseHelp(current.getLeftNode(), order);
      traverseHelp(current.getRightNode(), order);
      traversedLList.add(current.getData());
    } else if (order.equals("INORDER")) {
      traverseHelp(current.getLeftNode(), order);
      traversedLList.add(current.getData());
      traverseHelp(current.getRightNode(), order);
    }
  }
}
