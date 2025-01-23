# Music Song Record System

## Overview

This project implements a basic music song record system using AVL trees for efficient storage and retrieval of song data.  The system reads song data from a `song.txt` file, stores it in AVL trees indexed by song name, artist, and ID, and provides a command-line interface for various operations like listing songs, searching, and deleting entries.

## Features

*   **Data Loading:** Reads song data from a `song.txt` file.  Each line in the file represents a song with data fields separated by semicolons (`;`).
*   **AVL Tree Implementation:** Utilizes AVL trees to store and index song information based on:
    *   Song Name
    *   Artist
    *   ID
*   **Search Functionality:** Allows searching for songs based on song name, artist, or ID.
*   **Listing Functionality:**  Lists songs sorted by song name, artist, or ID.
*   **Range Search:**  Lists songs within a specified ID range (inclusive).
*   **Deletion Functionality:** Enables deleting songs based on their ID.  Deleting a song from the ID-indexed AVL tree also removes the song from the artist and song name indexed AVL trees to maintain consistency.
*   **Command-Line Interface:**  Provides a simple text-based menu for interacting with the system.
*   **Error Handling:** Basic error handling for file I/O and invalid menu inputs.
*   **Balance Maintenance:**  Ensures AVL trees remain balanced after insertions and deletions, guaranteeing logarithmic time complexity for search, insertion, and deletion operations.

## File Format (`song.txt`)

The `song.txt` file is expected to have the following format:
songname;artist;id;genre;year
songname2;artist2;id2;genre2;year2
...

*   **songname:** The name of the song.
*   **artist:** The artist of the song.
*   **id:** A unique identifier for the song (assumed to be an integer represented as a String).
*   **genre:** The genre of the song.
*   **year:** The release year of the song.

**Example:**
Bohemian Rhapsody;Queen;1001;Rock;1975
Like a Rolling Stone;Bob Dylan;1002;Folk Rock;1965
Hotel California;Eagles;1003;Rock;1976
Stairway to Heaven;Led Zeppelin;1004;Hard Rock;1971
Imagine;John Lennon;1005;Pop;1971

## Project Structure

The project is structured as follows:

*   **`Music_Song_Record_System` package:**
    *   **`AVLTree.java`:**  Implements the AVL tree data structure. Includes methods for insertion, deletion, search, rotation, height calculation, balance factor calculation, and printing the tree.
    *   **`Music_Song_Record_System.java`:**  The main class containing the `main` method.  Handles file I/O, AVL tree initialization, the command-line interface, and calling the appropriate methods.
    *   **`Song.java`:** Defines the `Song` class, representing a song object with attributes for song name, artist, ID, genre, and year.
    *   **`Node.java`:**  Defines the `Node` class, representing a node in the AVL tree. Each node stores the key (song name, artist, or ID), an index referencing the `song` array, and pointers to its left and right children.

## Dependencies

*   **Java Development Kit (JDK):** The project requires a JDK to compile and run. Version 8 or higher is recommended.


## Usage

After running the program, a menu will be displayed with the following options:

1.  **Show the list of songs based on ID:** Prints the keys (IDs) of the nodes in the ID-indexed AVL tree in an in-order traversal.
2.  **Show the list of songs based on song name:** Prints the keys (song names) of the nodes in the song name-indexed AVL tree in an in-order traversal.
3.  **Show the list of songs based on artist name:** Prints the keys (artist names) of the nodes in the artist-indexed AVL tree in an in-order traversal.
4.  **Search the song based on ID, artist name, or song name data fields:** Prompts the user to select the search field (ID, artist name, or song name) and then enter the search term.  Displays the song's properties if found.
5.  **List the songs based on the given interval:** Prompts the user to enter a start and end ID (as strings).  Lists all songs with IDs within that range (inclusive).
6.  **Delete a song:** Prompts the user to enter the ID of the song to delete.  Removes the song from all three AVL trees.
7.  **Exit:** Terminates the program.

**Example Interaction:**
File content from song.txt file are:
... (song data from song.txt) ...

Insertıon completed sucsesfuly.

Theese are the possible cohices you could choose
1- Show the list of songs based on id
2- Show the list of songs based on song name
3- Show the list of songs based on artist name
4- Search the song based on id,artist name or song name data fields
5- List the songs based on given interval
6- Delete a song
7-exit
Which task you want to do ?
4
If you enter song name select 1; If you enter id select 2; or artist name select 3
2
Which id do you want a search
1003
1003 has been found.
The properties of 1003 are:
Song name -> Hotel California -> Artist -> Eagles -> Song genre -> Rock -> Song year -> 1976
If you want to do more task enter the task number below:
7
Exiting the program …

## Class Details

*   **`AVLTree`:**
    *   `Node root`: The root node of the AVL tree.
    *   `print(Node focus)`: Prints the tree in a pre-order traversal.
    *   `minSearch(Node focus)`: Finds the node with the minimum key in a subtree. Used for deletion.
    *   `height(Node focus)`: Calculates the height of a node.
    *   `getBalance(Node focus)`: Calculates the balance factor of a node.
    *   `rightRotate(Node y)`: Performs a right rotation.
    *   `leftRotate(Node x)`: Performs a left rotation.
    *   `insert(String key, int index)`:  Inserts a new node with the given key and index.
    *   `insert(Node focus2, String st, int index)`:  Recursive helper method for insertion.
    *   `search(Node focus, String key)`: Searches for a node with the given key.
    *   `searchLowerAndUpperBounds(Node focus, String id1, String id2)`: Searches for nodes within the given ID range and prints the results.
    *   `deleteNode(Node root, String key)`: Deletes a node with the given key.

*   **`Music_Song_Record_System`:**
    *   `String[] value`: An array to store the split values from each line in the `song.txt` file.
    *   `String line`:  Stores each line read from the file.
    *   `int count`:  Not used.  (Originally likely intended as a counter).
    *   `Song[] song`:  An array to store `Song` objects.
    *   `main(String[] args)`:  The main method:
        *   Reads data from `song.txt`.
        *   Creates AVL trees for song name, artist, and ID.
        *   Inserts song data into the AVL trees.
        *   Presents the command-line menu.
        *   Handles user input and calls the appropriate AVL tree methods.

*   **`Song`:**
    *   `String songname`: The name of the song.
    *   `String artist`: The artist of the song.
    *   `String genre`: The genre of the song.
    *   `String id`: The ID of the song.
    *   `String year`: The year the song was released.
    *   `Song(String songname, String artist, String id, String genre, String year)`: Constructor to create a `Song` object.
    *   Getter methods for all attributes.

*   **`Node`:**
    *   `int index`: The index of the song in the `song` array.
    *   `Node left`: Pointer to the left child.
    *   `Node right`: Pointer to the right child.
    *   `String key`: The key used for sorting in the AVL tree (song name, artist, or ID).
    *   `int height`: The height of the node in the tree.
    *   `Node(String key, int index)`: Constructor to create a `Node` object.

## Limitations

*   **Fixed-size song array:** The `song` array has a fixed size of 100, limiting the number of songs that can be loaded.
*   **Basic Error Handling:** Error handling is limited and could be improved.
*   **No Data Persistence:** Song data is lost when the program exits.
*   **Command-Line Interface:** The text-based interface is not as user-friendly as a GUI.
*   **Assumes Integer IDs as Strings:**  The code assumes that the song IDs are integers, but they are stored as strings.  Parsing them to integers for comparisons could be more efficient in some cases.
