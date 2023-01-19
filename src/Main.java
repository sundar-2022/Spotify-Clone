import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    }
}