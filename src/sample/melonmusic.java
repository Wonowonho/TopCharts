package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class melonmusic {
    public static String[][] melonList (){
            try {
                String[][] chartList = new String[100][3];
                Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
                Elements songTitle = doc.select(".wrap_song_info").select(".ellipsis.rank01");
                Elements result = doc.select(".ellipsis.rank02").select("span");
                Elements album = doc.select(".ellipsis.rank03");

                List<String> titleList = songTitle.eachText();
                List<String> singerList = result.eachText();
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
                for(String singer: singerList) {
                    chartList[j++][1]=singer;
                    System.out.printf("%s\n",singer);
                }
                for(String albumL : albumList) {
                    chartList[k++][2]=albumL;
                    System.out.printf("%s\n",albumL);
                }

                return chartList;


        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}