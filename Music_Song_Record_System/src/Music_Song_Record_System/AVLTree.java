/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Song_Record_System;

import jdk.nashorn.internal.codegen.TypeMap;

/**
 *
 * @author ANIL
 */
public class AVLTree {

    Node root;

    AVLTree() {
        root = null;
    }

    public void print(Node focus) {
        if (focus == null) {
            focus = root;
        }
        System.out.println(focus.key);
        if (focus.left != null) {
            print(focus.left);
        }
        if (focus.right != null) {
            print(focus.right);
        }
    }

    public Node minSearch(Node focus) {
        if (focus == null) {
            System.out.println("Null");
        }
        while (focus.left != null) {
            focus = focus.left;
        }
        return focus;
    }

    public int height(Node focus) {
        if (focus == null) {
            return 0;
        }
        return focus.height;
    }

    public int getBalance(Node focus) {
        if (focus == null) {
            return 0;
        } else {
            return height(focus.left) - height(focus.right);
        }
    }

    Node rightRotate(Node y) 
    { 
        Node x = y.left; 
        Node T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    } 

    Node leftRotate(Node x) 
    { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        // Update heights 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
    } 

    public void insert(String key, int index) {
        root = insert(root, key, index);
    }

    public Node insert(Node focus2, String st, int index) {
        if (focus2 == null) {
            focus2 = new Node(st, index);
        }
        if (st.compareTo((String) focus2.key) > 0) {
            focus2.right = insert(focus2.right, st, index);
        } else if (st.compareTo((String) focus2.key) < 0) {
            focus2.left = insert(focus2.left, st, index);
        } else {
            return focus2;
        }
        focus2.height = Math.max(height(focus2.left), height(focus2.right)) + 1;
        int balance = getBalance(focus2);
        if (balance > 1) {
            if (st.compareTo((String) focus2.key) < 0) {
                return rightRotate(focus2);
            } else {
                focus2.left = leftRotate(focus2.left);
                return rightRotate(focus2);
            }
        }
        if (balance < -1) {
            if (st.compareTo((String) focus2.key) > 0) {
                return leftRotate(focus2);
            } else {
                focus2.right = rightRotate(focus2.right);
                return leftRotate(focus2);
            }
        }
        return focus2;
    }

    public Node search(Node focus, String key) {
        if (focus == null) {
            return null;
        } else if (key.compareTo(focus.key) > 0) {
            return search(focus.right, key);
        } else if (key.compareTo(focus.key) < 0) {
            return search(focus.left, key);
        } else {
            return focus;
        }
    }

    public Node searchLowerAndUpperBounds(Node focus, String id1, String id2) {
        if (focus == null) {
            return null;
        }
        int a = Integer.parseInt(id1);
        int b = Integer.parseInt(id2);
        int c = Integer.parseInt(focus.key);
        if (c > a && c < b) {         
            searchLowerAndUpperBounds(focus.left, id1, id2);
            searchLowerAndUpperBounds(focus.right, id1, id2);
        } else if (c < a) {
            return searchLowerAndUpperBounds(focus.right, id1, id2);
        } else if (c > b) {
            return searchLowerAndUpperBounds(focus.left, id1, id2);
        }
        return null;
    }

    Node deleteNode(Node root, String key) {  
        if (root == null) 
            return root;   
        if (key.compareTo(root.key)<0) 
            root.left = deleteNode(root.left, key); 
        else if (key.compareTo(root.key)>0) 
            root.right = deleteNode(root.right, key); 
        else
        { 
            if ((root.left == null) || (root.right == null)) 
            { 
                Node temp = null; 
                if (temp == root.left) 
                    temp = root.right; 
                else
                    temp = root.left; 
                if (temp == null) 
                { 
                    temp = root; 
                    root = null; 
                } 
                else  
                    root = temp; 
            } 
            else
            { 
                Node temp = minSearch(root.right); 
                root.key = temp.key; 
                root.right = deleteNode(root.right, temp.key); 
            } 
        } 
        if (root == null) 
            return root; 
        root.height = Math.max(height(root.left), height(root.right)) + 1; 
        int balance = getBalance(root); 
        if (balance > 1 && getBalance(root.left) >= 0) 
            return rightRotate(root); 
        if (balance > 1 && getBalance(root.left) < 0) 
        { 
            root.left = leftRotate(root.left); 
            return rightRotate(root); 
        } 
        if (balance < -1 && getBalance(root.right) <= 0) 
            return leftRotate(root); 
        if (balance < -1 && getBalance(root.right) > 0) 
        { 
            root.right = rightRotate(root.right); 
            return leftRotate(root); 
        } 
  
        return root; 
    }
}


