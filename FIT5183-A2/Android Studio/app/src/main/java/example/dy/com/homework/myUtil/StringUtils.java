package example.dy.com.homework.myUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by dy on 2016/4/19.
 */
public class StringUtils {
    //        public static final  String IPString  = "172.16.153.14";
//    public static final String IPString = "172.16.120.97";
//    public static final String IPString = "1u4d986139.iask.in:17471";
    public static final String IPString = "1u4d986139.iask.in:15758";


    public static String getPasswordEncryption(String inputStr) {
//        System.out.println("=======加密前的数据:" + inputStr);
        BigInteger bigInteger = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    public static String getCurTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
//        System.out.println(time);
        return time;
    }

    public static double timeToNumber(String time) {
        String myTime = time.substring(10, time.length());
        String[] ss = myTime.split("-");
        double res = Double.valueOf(ss[0]) + Double.valueOf(ss[1]) / 100 / 60 + Double.valueOf(ss[2]) / 100 / 3600;
        return res;

    }

    public static double dayToNumber(String time) {
        String myTime = time.substring(0, 10);
        String[] ss = myTime.split("-");
        double res = Double.valueOf(ss[0]) * 365 + Double.valueOf(ss[1]) * 30 + Double.valueOf(ss[2]);
        return res;
    }

    public static String getImageURL(String keyword) {
        String s = "https://www.googleapis.com/customsearch/v1?q=" + keyword + "&cx=014672565480653443522:pzdmuyfup4e&fileType=jpg&imgSize=medium&imgType=photo&safe=medium&searchType=image&key=AIzaSyCww4RAetD_OrkuKw72Zwc_bqozSVdOyns";
        return s;
    }

    public static HashMap<String, Double> getPosition() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("latitude", 31.2681406);
        map.put("longitude", 120.746597);
        return map;
    }

    public static String getMapURL(String type, double latitude, double longitude) {
        String APIKEY = "AIzaSyBLshoGEjPToryWReHwg4H20teN8oF4xDU";
        String radius = "5000";

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + radius);
        googlePlacesUrl.append("&types=" + type);
        googlePlacesUrl.append("&sensor=false");
        googlePlacesUrl.append("&key=" + APIKEY);
        return googlePlacesUrl.toString();
    }
}
