import java.util.*;

public class Main {
    public static List<Album> albumList = new ArrayList<>();
    public static void main(String[] args) {

        Album a1 = new Album("Rahman hits","Ar rahman");
        a1.addSongToAlbum("Jay ho",5.50);
        a1.addSongToAlbum("minnale",4.05);
        a1.addSongToAlbum("malai kuruvi",5.20);

        Album a2 = new Album("Anirudh Songs","Anirudh");
        a2.addSongToAlbum("swag mari",4.44);
        a2.addSongToAlbum("why this kolaveri",3.23);
        a2.addSongToAlbum("beep song",5.50);

        albumList.add(a1);
        albumList.add(a2);

        System.out.println(a1.findSong("Jay ho"));


        LinkedList<Songs>  myPlaylist= new LinkedList<>();
        a1.addPlaylistFromAlbum("Jay ho",myPlaylist);
        a2.addPlaylistFromAlbum(2,myPlaylist);
        a1.addPlaylistFromAlbum(2, myPlaylist);
        a2.addPlaylistFromAlbum("beep song",myPlaylist);
        a2.addPlaylistFromAlbum("swag mari",myPlaylist);

//        Songs sample = new Songs("Arr",50);
//        System.out.println(sample);
        play(myPlaylist);
    }

    public static void play(LinkedList<Songs> Playlist){

        ListIterator<Songs> itr = Playlist.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean isForward = false;
        if(Playlist.size()>0){
            System.out.print("Your currently playing");
            System.out.println(itr.next());
            isForward = true;
        }else{
            System.out.println("Your Playlist is empty");
        }
        printMenu();
        System.out.println("Enter Your Choice");
        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice){
                case 1 :
                    if(!isForward){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }else{
                        System.out.println("you have reached the end of the playlist");
                    }
                    break;
                case 2 :
                    if(isForward){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("your at the starting of the playlist");
                    }
                    break;
                case 3 :
                    if(isForward){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }else{
                       if(itr.hasNext()){
                           System.out.println(itr.next());
                           isForward = true;
                       }
                    }
                    break;
                case 4 :
                    printMenu();
                    break;
                case 5 :
                    break;
                case 6 :
                    printSongs(Playlist);
                    break;
                case 7 :
                    quit = true;
                    break;
            }
        }
    }

    public static void printSongs(LinkedList<Songs> Playlist){
        for(Songs s : Playlist){
            System.out.println(s);
        }
    }

    public static void printMenu(){
//        System.out.println("Enter your choice");
        System.out.println("1 - Play Next Song");
        System.out.println("2 - Play Previous Song");
        System.out.println("3 - Repeat the current Song");
        System.out.println("4 - Show Menu Again");
        System.out.println("5 - Delete The Current Song");
        System.out.println("6 - Play All The Songs in Playlist");
        System.out.println("7 - Exit");
    }
}