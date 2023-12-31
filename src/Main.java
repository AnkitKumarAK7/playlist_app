import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album arijitAlbum = new Album("Arijit Sing", "Arijit's album");
        Album alanAlbum = new Album("Alan Walker", "Walker's Album");

        arijitAlbum.addSongToAlbum("kesaria", 3.5);
        arijitAlbum.addSongToAlbum("Tum kya Mile", 4.2);
        arijitAlbum.addSongToAlbum("Lal Ishq", 5.1);

        alanAlbum.addSongToAlbum("Faded", 3.5);
        alanAlbum.addSongToAlbum("Alone", 4.1);
        alanAlbum.addSongToAlbum("Darkside",2.5);

        LinkedList<Song> myPlaylist = new LinkedList<>();  // myPlaylist

        System.out.println(arijitAlbum.addToPlaylistFromAlbum("kesaria",myPlaylist));
        System.out.println(arijitAlbum.addToPlayListFromAlbum(2,myPlaylist));
        System.out.println(arijitAlbum.addToPlayListFromAlbum(5,myPlaylist));

        System.out.println(alanAlbum.addToPlaylistFromAlbum("Alone", myPlaylist));
        System.out.println(alanAlbum.addToPlayListFromAlbum(3 , myPlaylist));

        play(myPlaylist);
    }

    private static void play(LinkedList<Song> myPlayList){

        if(myPlayList.size() == 0){
            System.out.println("Your playList is empty");
            return;
        }

        ListIterator<Song> itr = myPlayList.listIterator();
        System.out.println("Now playing: " + itr.next());

        Scanner sc = new Scanner(System.in);
        printMenu();

        boolean quit = false;
        while(!quit){
            System.out.println("Please enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist");
                    }
                    else{
                        System.out.println("Currently playing: "+ itr.next());
                    }
                    break;
                case 3:
                    if(!itr.hasPrevious()){
                        System.out.println("You are at the start of the playlist");
                    }else{
                        System.out.println("Currently playing: "+ itr.previous());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlayList);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
    }

    private static void printSongs(LinkedList<Song> myPlayList) {
        for(Song song: myPlayList){
            System.out.println(song);
        }
        return;
    }

    private static void printMenu(){
        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Print all the song in playlist");
        System.out.println("7. Quit application");

    }
}