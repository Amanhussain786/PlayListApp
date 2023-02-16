import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
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

    public List<Song> getSong() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = song;
    }

    //find song
    boolean findSong(String name)
    {
      for(Song song : songs)
      {
          if(song.getTitle().equals(name))
              return true;
      }
      return false;
    }

    //add song to album
    String addSongtoAlbum(String name, double duration)
    {
       Song s = new Song( name, duration );

       if(findSong(name)==false)
       {
           songs.add(s);
           return "Song Added Successfully!!";
       }
       else
       {
           return "Song Already Exist";
       }
    }

    //add song from albums to playlist -- for users
    String addSongtoPlaylistfromAlbum(String name, List<Song> playlist)
    {
       if(findSong(name)==true)
       {
           for(Song s: this.songs)
           {
               if(s.getTitle().equals(name))
               {
                   playlist.add(s);
                   return "Song Added to Playlist Successfully!!";
               }
           }
           return "Error";
       }
       else
       {
           return "Song Does Not Exist in the Playlist";
       }
    }


    String addSongtoPlaylistfromAlbum(int TrackNo , List<Song> playlist)
    {
        //index of Tracknumber
        int index = TrackNo - 1;

        //check tracknumber is valid or not
        if(index >= 0 && index < this.songs.size())
        {
            playlist.add(this.songs.get(index));
            return "Song has been Added to Your Playlist";
        }
        else
        {
            return "Invalid Index!!";
        }
    }


}
