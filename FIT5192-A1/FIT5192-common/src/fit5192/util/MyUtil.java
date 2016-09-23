/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author dy
 */
public class MyUtil {

    public static String getId() {
        String id = UUID.randomUUID().toString();
        id = id.replace("-", "");
        return id;
    }

    public static String getURLFromGoogle(String keyword) {
        String link = "";
        keyword = keyword.replaceAll(" ", "%20");
        try {
            String s = "https://www.googleapis.com/customsearch/v1?q=" + keyword + "&cx=014672565480653443522:dyeujxmfkda&key=AIzaSyCww4RAetD_OrkuKw72Zwc_bqozSVdOyns";
            String charset = "UTF-8";
            URLConnection conn = new URL(s).openConnection();
            URLEncoder.encode(s, charset);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String line = null;
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
//            System.out.println("reslut->" + result);
            JSONObject jsonObj = new JSONObject(result.toString());
            JSONArray jsonArray = jsonObj.getJSONArray("items");
            JSONObject item = (JSONObject) jsonArray.get(0);
            link = item.getString("link");
//            System.out.println("link->" + link);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return link;

    }
}
