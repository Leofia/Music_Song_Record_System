/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Song_Record_System;

/**
 *
 * @author ANIL
 */
public class Node<Item> {
    int index;
    Node left;
    Node right;
    String key;
    int height;

    Node(String key, int index) {
        this.index = index ;
        this.key = key;
        right = null;
        left = null;
        height = 1;
    }
}
