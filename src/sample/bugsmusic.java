package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class bugsmusic {
    public static String[][] bugsList (){
        try {
            String[][] chartList = new String[100][3];
            Document doc = Jsoup.connect("https://music.bugs.co.kr/chart/track/realtime/total?wl_ref=M_contents_03_01").get();
            Elements songTitle = doc.select(".list.trackList.byChart").select("tbody").select(".title");
            Elements result = doc.select(".list.trackList.byChart").select("tbody").select(".artist");
            Elements album = doc.select(".list.trackList.byChart").select("tbody").select(".album");

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