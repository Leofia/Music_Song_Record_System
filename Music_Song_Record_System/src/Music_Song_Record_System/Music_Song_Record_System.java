/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music_Song_Record_System;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ANIL
 */
public class Music_Song_Record_System {

    /**
     * @param args the command line arguments
     */
    static String[] value;
    static String line = null;
    static int count = 1;
    static Song[] song = new Song[100];

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("File content from song.txt file are: ");
        System.out.println(" ");
        String a = "b";
        // TODO code application logic here
        AVLTree avltree_Song = new AVLTree();
        AVLTree avltree_Artist = new AVLTree();
        AVLTree avltree_ID = new AVLTree();
        song = new Song[100];
        try {
            FileReader file = new FileReader("song.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                value = line.split(";");//Bu array ";" leri silmek için yeni bir arreye atılmıştır.
                song[i] = new Song(value[0], value[1], value[2], value[3], value[4]); // bu array ise constrocterda tanımladığımız objeleri tutan array.
                System.out.println(line);
                avltree_Song.insert(song[i].getSongname(), i);
                avltree_ID.insert(song[i].getId(), i);
                avltree_Artist.insert(song[i].getArtist(), i);
                i++;
            }
            bufferedReader.close();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println("Insertıon completed sucsesfuly.");
        System.out.println(" ");

        /*
       avltree.root = avltree.insertSong(avltree.root, "a");
       avltree.root = avltree.insertSong(avltree.root, "a");
         */
        int menu = 0;
        Scanner scn = new Scanner(System.in);
        //printInsertedSongList();
        System.out.println("Theese are the possible cohices you could choose");
        System.out.println("1- Show the list of songs based on id");
        System.out.println("2- Show the list of songs based on song name");
        System.out.println("3- Show the list of songs based on artist name");
        System.out.println("4- Search the song based on id,artist name or song name data fields");
        System.out.println("5- List the songs based on given interval");
        System.out.println("6- Delete a song");
        System.out.println("7-exit");
        while (menu != 7) {
            if(menu==0||(menu>7||menu<1)){
              System.out.println("Which task you want to do ?  ");  
            }
            else{
              System.out.println("If you want to do more task enter the task number below: ");  
            }
 
            menu = scn.nextInt();

            scn.nextLine();

            switch (menu) {
                case 1://testing id tree
                    System.out.println("Listed songs for ID are:");
                    //idye göre liste printlemesi lazım
                    avltree_ID.print(avltree_ID.root);
                    break;
                case 2://testing song tree
                    System.out.println("Listed songs for Song Name are:");
                    //songname print
                    avltree_Song.print(avltree_Song.root);
                    break;
                case 3:// testing artist tree
                    System.out.println("Listed songs for Artist are:");
                    //artist print
                    avltree_Artist.print(avltree_Artist.root);
                    break;
                case 4://testing first search tree
                    System.out.println("If you enter song name select 1; "
                            + " If you enter id select 2;"
                            + " or artist name select 3");
                    String input = scn.nextLine();
                    String src;
                    if (input.equals("1")) {
                        System.out.println("Which song do you want a search :");
                        src = scn.nextLine();
                        avltree_Song.search(avltree_Song.root, src);
                        if (avltree_ID.search(avltree_Song.root, src) == null) {
                            
                            System.out.println(src +" cannot be found");
                        } else {
                            int index = avltree_Artist.search(avltree_Song.root, src).index;
                            String songID = song[index].getId();
                            String songArtist = song[index].getArtist();
                            System.out.println("");
                            System.out.println(src+" has been found.");
                            System.out.println("The properties of "+src+" are: ");
                            System.out.println("Song id " + " -> " + songID + " -> " + " Artist " + " -> " + songArtist + " -> "
                                    + "Song genre " + " -> " + song[index].getGenre() + " -> " + " Song year " + " -> " + song[index].getYear());
                        }
                    } else if (input.equals("2")) {
                        System.out.println("Which id do you want a search");
                        src = scn.nextLine();
                        if (avltree_ID.search(avltree_ID.root, src) == null) {
                            System.out.println("");
                            System.out.println(src+" cannot be found");
                        } else {
                            int index = avltree_ID.search(avltree_ID.root, src).index;
                            String idSongName = song[index].getSongname();
                            String idArtist = song[index].getArtist();
                            System.out.println(src+" has been found.");
                            System.out.println("The properties of "+src+" are: ");
                            System.out.println("Song name " + " -> " + idSongName + " -> " + " Artist " + " -> " + idArtist + " -> "
                                    + "Song genre " + " -> " + song[index].getGenre() + " -> " + " Song year " + " -> " + song[index].getYear());
                        }
                    } else if (input.equals("3")) {
                        System.out.println("Which artist do you want a search");
                        src = scn.nextLine();
                        if (avltree_ID.search(avltree_Artist.root, src) == null) {
                            System.out.println("");
                            System.out.println(src+" cannot be found");
                        } else {
                            int index = avltree_Artist.search(avltree_Artist.root, src).index;
                            String artistSong = song[index].getSongname();
                            String artistID = song[index].getId();
                            System.out.println(src+" has been found.");
                            System.out.println("The properties of "+src+" are: ");
                            System.out.println("Song name " + " -> " + artistSong + " -> " + " ID " + " -> " + artistID + " -> "
                                    + "Song genre " + " -> " + song[index].getGenre() + " -> " + " Song year " + " -> " + song[index].getYear());
                        }
                    } else {
                        System.out.println("Please select number between 1 to 3");
                        System.out.println("You have been redirected to the menu...");

                    }
                    break;
                case 5://testing third search tree
                    System.out.println("Enter the interval with given order. For example: 1001 1010 ");
                    String id1 = scn.next();
                    String id2 = scn.next();
                    int first = Integer.parseInt(id1);
                    int last = Integer.parseInt(id2);
                    System.out.println("Listed songs are:");
                    avltree_ID.searchLowerAndUpperBounds(avltree_ID.root, id1, id2);
                    int index;
                    for (int i = first; i <= last; i++) {
                        String ab = String.valueOf(i);
                        
                        if(avltree_ID.search(avltree_ID.root, ab)==null){
                            
                        }
                        else{
                         index = avltree_ID.search(avltree_ID.root, ab).index;
                         System.out.println(song[index].getId() + " -> " + song[index].getArtist() + " -> " + song[index].getSongname() + " -> "
                                + song[index].getGenre() + " -> " + song[index].getYear());
                        }
                    }
                    break;
                case 6://testing delete method
                    System.out.println("Enter the id you want to be delete from song list ");
                    String id = scn.next();
                    index = avltree_ID.search(avltree_ID.root, id).index;
                    String acd = song[index].getSongname();
                    String abd = song[index].getArtist();
                    if (avltree_ID.deleteNode(avltree_ID.root, id) == null) {
                        System.out.println("");
                    } else {
                        System.out.println("ID " + id + " DELETED");
                    }

                    if (avltree_Artist.deleteNode(avltree_Artist.root, abd) == null) {
                        System.out.println("");
                    } else {
                        System.out.println("The artist " + abd + " ALSO DELETED ");
                    }
                    if (avltree_Song.deleteNode(avltree_Song.root, acd) == null) {
                        System.out.println("");
                    } else {
                        System.out.println("Song name " + acd + " ALSO DELETED ");
                    }
                    break;
                case 7:
                    System.out.println("Exiting the program …");
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Please enter between 1-7");
                    break;
            }
            
        }

    }


}
