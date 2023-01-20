import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Songs> songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {

        this.artist = artist;
    }

    public List<Songs> getSongs() {

        return songs;
    }

    public void setSongs(List<Songs> songs) {

        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Songs s: songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    void addSongToAlbum(String name, double duration){
        Songs s = new Songs(name,duration);
        if(findSong(s.getTitle())){
            System.out.println("its already added");
        }else{
            songs.add(s);
            System.out.println("Song has been added to your album");
        }
    }

    void addPlaylistFromAlbum(String title, LinkedList<Songs> playlist){
        if(findSong(title)){
            for(Songs s : songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    System.out.println("Song has been added to your playlist");
                }
            }
        }else{
            System.out.println("the song is not in the album");
        }
    }
    void addPlaylistFromAlbum(int trackNo, LinkedList<Songs> playlist){
        int index = trackNo - 1;
        if(index>=0 && index < songs.size()){
            playlist.add(songs.get(index));
            System.out.println("Song has been added to your playlist");
        }else{
            System.out.println("invalid trackNo");
        }
    }
}
