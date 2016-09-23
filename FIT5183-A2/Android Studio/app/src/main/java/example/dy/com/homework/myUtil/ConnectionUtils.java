package example.dy.com.homework.myUtil;

import android.os.AsyncTask;
import android.text.TextUtils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by dy on 2016/4/17.
 */
public class ConnectionUtils {

    public ConnectionUtils(final String url, final ConnectionCallback callback, final String... params) {


        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... param) {
                BufferedReader reader = null;
                StringBuffer sb = new StringBuffer();
                if(params != null || params.length != 0){
                    for (int i = 0; i < params.length; i++) {
                        sb.append("/").append(params[i]);
                    }
                }

                try {
                    String path = url + sb.toString();
                    System.out.println("path:" + path);
                    URLConnection conn = new URL(path).openConnection();
                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    String line = null;
                    StringBuffer result = new StringBuffer();
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
//                    System.out.println("utils->"+result.toString());
                    return result.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                            reader = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (!TextUtils.isEmpty(result)) {
                    if (callback != null) {
                        callback.onSuccess(result);
                    }
                } else {
                    if (callback != null) {
                        callback.onFail();
                    }
                }
            }
        }.execute();

    }


    public interface ConnectionCallback {
        void onSuccess(Object result);

        void onFail();
    }

    //post
    public ConnectionUtils(final String url, final ConnectionCallback callback, final String str, int i) {


        new AsyncTask<Void, Void, String>() {
            DataOutputStream printout;


            @Override
            protected String doInBackground(Void... param) {
                int httpResult = 0;
                try {
                    URL urlurl = new URL(url);
                    HttpURLConnection urlConnection = (HttpURLConnection) urlurl.openConnection();
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    urlConnection.setUseCaches(false);
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.connect();

                    printout = new DataOutputStream(urlConnection.getOutputStream());
                    byte[] data = str.getBytes("UTF-8");
                    printout.write(data);
                    printout.flush();

                    httpResult = urlConnection.getResponseCode();
//                    System.out.println("httpResult"+httpResult);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (printout != null) {
                        try {
                            printout.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


                return String.valueOf(httpResult);


            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (!TextUtils.isEmpty(result)) {
                    if (callback != null) {
                        callback.onSuccess(result);
                    }
                } else {
                    if (callback != null) {
                        callback.onFail();
                    }
                }
            }
        }.execute();

    }


}
