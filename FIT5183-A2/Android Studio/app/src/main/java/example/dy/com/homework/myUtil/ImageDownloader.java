package example.dy.com.homework.myUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;

/**
 * Created by dy on 2016/4/27.
 */
public  class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    private ImageView bmImage;
    private ProgressBar progressBar;
    public ImageDownloader(ImageView bmImage,ProgressBar progressBar) {
        this.bmImage = bmImage;
        this.progressBar = progressBar;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap mIcon = null;
        try {
            InputStream in = new java.net.URL(url).openConnection().getInputStream();
            mIcon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return mIcon;
    }

    protected void onPostExecute(Bitmap result) {
        if (result != null && bmImage != null) {
            bmImage.setImageBitmap(result); // change 'image' to the ImageView you retreived earlier from your RelativeLayout
        }
        progressBar.setVisibility(View.GONE); // hide the ProgressBar
//        bmImage.setImageBitmap(result);
    }
}
