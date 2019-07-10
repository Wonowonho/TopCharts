package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class applemusic {
    public static String[][] appleList (){
            try {
                String[][] chartList = new String[100][4];
                Document doc = Jsoup.connect("https://www.apple.com/itunes/charts/songs/").get();
                Elements songTitle = doc.select(".section-content").select("h3");
                Elements artist = doc.select(".section-content").select("h4");


                List<String> titleList = songTitle.eachText();
                List<String> singerList = artist.eachText();

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
                    chartList[j++][1]=artists;
                    chartList[k++][2]="unknowned";
                    System.out.printf("%s\n",artist);
                }


                return chartList;


        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}