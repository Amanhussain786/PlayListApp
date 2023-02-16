import java.util.ArrayList;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Jal","Farhan");
        album1.addSongtoAlbum("Sajni Paas Bulao na",4.5);
        album1.addSongtoAlbum("Woh Lamhe",4.2);
        album1.addSongtoAlbum("Aadat", 5.5);

        Album album2 = new Album("Moosa","Sidhu");
        album2.addSongtoAlbum("295",5.2);
        album2.addSongtoAlbum("Scapegoat",4.4);
        album2.addSongtoAlbum("Same Beef",3.8);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(album2.addSongtoPlaylistfromAlbum("295",myPlaylist));
        System.out.println(album1.addSongtoPlaylistfromAlbum(2,myPlaylist));
        System.out.println(album1.addSongtoPlaylistfromAlbum("Aadat",myPlaylist));

        play(myPlaylist);
    }

    public static void play(List<Song> playList)
    {
        ListIterator<Song> it = playList.listIterator();


        if(playList.size()==0)
        {
            System.out.println("Playlist is Empty");
            return;
        }

        boolean isNext;

        System.out.println("Currently Playing :");
        System.out.println(it.next());
        isNext = true;

        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter Your Choice :");
            int choice  = sc.nextInt();

            switch (choice)
            {
                case 1:
                    if(isNext)
                    {
                        it.next();
                    }
                    if(it.hasNext())
                    {
                        System.out.println("Your Next Song is :");
                        System.out.println(it.next());
                        isNext = true;
                    }
                    else
                    {
                        System.out.println("Reached Last");
                    }
                    break;
                case 2:
                    if(isNext)
                    {
                        it.previous();
                    }
                    if(it.hasPrevious())
                    {
                        System.out.println("Your Previous Song is :");
                        System.out.println(it.previous());
                        isNext = false;
                    }
                    else
                    {
                        System.out.println("Reached Last");
                    }
                    break;
                case 3:
                    if(isNext==true){
                        if(it.hasPrevious()) {
                            System.out.println(it.previous());
                            isNext = false;
                        }
                    }
                    else{
                        if(it.hasNext()){
                            System.out.println(it.next());
                            isNext = true;
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    playAllsongs(playList);
                    break;
                case 6:
                    printmenu();
                    break;
                case 7:
                    return;
            }
        }
    }

    static void playAllsongs(List<Song> playlist)
    {
        for(Song song:playlist)
        {
            System.out.println(song);
        }
        return;
    }
    static void printmenu()
    {
        System.out.println("1. Play Next Song");
        System.out.println("2. Play Previous Song");
        System.out.println("3. Play Current Song");
        System.out.println("4. Delete Current Song");
        System.out.println("5. Show ALl Song");
        System.out.println("6. Show Menu Again");
        System.out.println("7. Exit");
    }
}