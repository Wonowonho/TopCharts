package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class mnetmusic {
    public static String[][] mnetList (){
            try {
                String[][] chartList = new String[50][3];
                Document doc = Jsoup.connect("http://www.mnet.com/chart/top100/").get();
                Elements songTitle = doc.select(".MMLITitleSong_Box").select(".MMLI_Song");
                Elements artist = doc.select(".MMLITitle_Info");
                Elements album = doc.select(".MMLIInfo_Album");


                List<String> titleList = songTitle.eachText();
                List<String> singerList = artist.eachText();
                List<String> albumList = album.eachText();

                int i =0,j=0,k = 0,l = 1;
                for(String title : titleList) {
                    if(l<10) {
                        chartList[i++][0] = String.valueOf(l) + ".  " + title;
                    } else {
                        chartList[i++][0] = String.valueOf(l) + ". " + title;
                    }
                    System.out.printf("%s\n",title);
                    l++;
                }

                for(String artists : singerList) {
                    artists = artists.substring(0,artists.lastIndexOf("/")-1);
                    chartList[j++][1] = artists;
                    System.out.printf("%s\n",artists);
                }

                for(String albums : albumList) {
                    chartList[k++][2]=albums;
                    System.out.printf("%s\n",albums);
                }


                return chartList;


        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}