package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class genniemusic {
    public static String[][] gennieList (){
            try {
                String[][] chartList = new String[50][3];
                Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
                Elements songTitle = doc.select(".list-wrap").select(".title.ellipsis");
                Elements artist = doc.select(".list-wrap").select(".artist.ellipsis");
                Elements album = doc.select(".list-wrap").select(".albumtitle.ellipsis");

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
                    chartList[j++][1]=artists;
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