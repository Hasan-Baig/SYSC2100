

public class BSTDictionary<E, K extends Sortable> implements Dictionary {

    private BSTNode currentNode, head;

    public BSTDictionary() {
        head = null;
    }

    /**
     * Method searches through Binary Search Tree for item whose search key is param key
     *
     * @param key
     */
    @Override
    public Object search(Sortable key) {
        // if BST empty
        if (this.currentNode == null) {
            this.currentNode = head;
            return null;
        // if key equal search key of item located
        } else if (this.currentNode.getKey().compareTo(key) == 0) {
            BSTNode temp = new BSTNode(this.currentNode.getKey(), this.currentNode.getElement(), this.currentNode.getLeft(), this.currentNode.getRight());
            this.currentNode = head;
            return temp.getElement();
        // if key < currentNode's key then continue left
        } else if (key.compareTo(this.currentNode.getKey()) < 0){
            this.currentNode = this.currentNode.getLeft();
            return search(key);
        // if key > currentNode's key then continue right
        } else {
            this.currentNode = this.currentNode.getRight();
            return search(key);
        }
    }
    
    /**
     * Method inserts element into the binary search tree of which key is the root new BST
     *
     * @param key, element
     */
    @Override
    public void insert(Sortable key, Object element) {
        BSTNode<String, SortableString> temp = new BSTNode<String, SortableString>((SortableString) key, (String) element, null, null);

        //if head is null then set the temp node as head
        if (this.head == null) { 
            this.head = temp;
            this.currentNode = this.head;
        //if keys not equal
        } else if (this.currentNode.getKey().compareTo(temp.getKey()) != 0) {
            //if key < key at currentNode and left node is empty
            if (temp.getKey().compareTo(this.currentNode.getKey()) < 0) { 
                if (this.currentNode.getLeft() == null) {
                    this.currentNode.setLeft(temp);
                    this.currentNode = head;
                //if the node was not empty the current node is now the left node
                } else { 
                    this.currentNode = this.currentNode.getLeft();
                    insert(key, element);
                }
            //if key > key at currentNode and right node is empty
            } else if (temp.getKey().compareTo(this.currentNode.getKey()) > 0) { 
                if (this.currentNode.getRight() == null) {
                    this.currentNode.setRight(temp);
                    this.currentNode = head;
                //if the node was not empty the current node is now the right node
                } else {
                    this.currentNode = this.currentNode.getRight();
                    insert(key, element);
                }
            }
        }
    }
    
    /**
     * Finds the smallest value on the right side of the tree
     *
     * @param n
     * @return left most node on the right of the tree
     */
    public BSTNode<String, SortableString> findMinimum(BSTNode<String, SortableString> n) {
        BSTNode<String, SortableString> temp = n;
        //keep looping when there are available left nodes
        while (temp.getLeft() != null) {
        	temp = temp.getLeft();
        }
        return temp;
    }
    
    /**
     * Method locates and deletes nodes for given key. Then relocates surrounding nodes 
     * accordingly.
     * 
     * @param key
     */
    @Override
    public void delete(Sortable key) {
        BSTNode<String, SortableString> current = head;
        BSTNode<String, SortableString> point = null;
        BSTNode<String, SortableString> target = null; //target node is to be deleted

        if (key == null) {
        	throw new IllegalArgumentException("Null key");
        }
        
        //similar to search method
        while (current != null) {
        	// If key equal search key of item located
            if (key.compareTo(current.getKey()) == 0) {
                target = current;
                break;
            // If key < currentNode's key then continue left
            } else if (key.compareTo(current.getKey()) < 0) {
                point = current;
                current = current.getLeft();
            // If key > currentNode's key then continue right
            } else {
                point = current;
                current = current.getRight();
            }
        }
        
        //if node to be deleted is not null
        if (target != null) {
            //if nodes below target, needs to be switched
            if (target.getLeft() != null && target.getRight() != null) {
                //find the minimum of the right side of the tree
                BSTNode<String, SortableString> temp = findMinimum(target.getRight());
                target.key = temp.getKey();
                target.element = temp.getElement();
                //delete node
                temp = null;
            //if only exists left values
            } else if (target.getLeft() != null && target.getRight() == null) {
                //left value is new parent
                point.setLeft(target.getLeft()); 
                //delete node
                target = null;
            //if the node only has right values
            } else if (target.getLeft() == null && target.getRight() != null) {
            	//right value is new parent
            	point.setRight(target.getRight()); 
                //delete node
                target = null;
            } else {
                //delete the node
                target = null;
            }
        }
    }

    /**
     * Recursive method that builds a string made up of the content of the tree
     *
     * @param current
     */
    public String recursivePrint(BSTNode current) {
        //if current is empty then return empty string
        if (current == null) {
        	return ""; 
        }
        
        String s = "";
        s += current.getElement() + " ";
        //get all left nodes
        s += recursivePrint(current.getLeft()) + " "; 
        //get all right nodes
        s += recursivePrint(current.getRight()) + " "; 

        return s;
    }
    
    /**
     *  This method prints the tree
     */
    @Override
    public void printTree() {
        System.out.println();
        System.out.println(recursivePrint(this.head));
    }
    
    /** 
     * Recursive method that determines depth of the largest branch of the tree.
     * Then returns largest number from left/right side
     *
     * @param current
     */
    public int recursiveDepth(BSTNode current) {
    	//if current is null there is no depth to the BST
    	if (current == null) { 
    		return 0;
    	}
    	//returns the max number of traversals where it adds one each recursive loop
	    return 1 + Math.max(recursiveDepth(current.getLeft()), recursiveDepth(current.getRight()));
    }
    
    /**
     * This method returns the depth of the tree
     */
    @Override
    public int depth() {
        return recursiveDepth(this.head);
    }
}