package example.dy.com.homework.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import example.dy.com.homework.R;
import example.dy.com.homework.entity.JsonUser;
import example.dy.com.homework.myUtil.ConnectionUtils;
import example.dy.com.homework.myUtil.DatabaseHelper;
import example.dy.com.homework.myUtil.StringUtils;

/**
 * Created by dy on 2016/4/26.
 */
public class MapFragment extends Fragment {
    private MapView mMapView;
    private GoogleMap googleMap;
    private DatabaseHelper databaseHelper;
    private View vMap;
    private EditText keyword;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        vMap = inflater.inflate(R.layout.fragment_map, container, false);
        keyword = (EditText) vMap.findViewById(R.id.where_map);
        button = (Button) vMap.findViewById(R.id.button_map);
        mMapView = (MapView) vMap.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();


        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setZoomGesturesEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setRotateGesturesEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        uiSettings.setMapToolbarEnabled(true);

        JsonUser u = this.getArguments().getParcelable("user");

        databaseHelper = new DatabaseHelper(vMap.getContext());
        HashMap<String, Double> map = databaseHelper.getPosition(u.getId());

        final double latitude = map.get("latitude");
        final double longitude = map.get("longitude");
        final LatLng cur = new LatLng(latitude, longitude);

        // create marker
        MarkerOptions marker = new MarkerOptions();
        marker.position(cur).title("My Location");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        googleMap.addMarker(marker);


        new ConnectionUtils(StringUtils.getMapURL("park", latitude, longitude), new ConnectionUtils.ConnectionCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("gooooooooooo->" + result);

                try {

                    JSONObject jsonObj = new JSONObject(result.toString());
                    JSONArray jsonArray = jsonObj.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject cur = (JSONObject) jsonArray.get(i);
                        JSONObject geometry = (JSONObject) ((JSONObject) cur.get("geometry")).get("location");
                        double lat = geometry.getDouble("lat");
                        double lng = geometry.getDouble("lng");
                        System.out.println("lat->" + lat + "," + lng);
                        String placeName = cur.getString("name");
                        String vicinity = cur.getString("vicinity");
                        System.out.println("name->" + placeName + "v->" + vicinity);
                        LatLng latLng = new LatLng(lat, lng);
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(placeName + " : " + vicinity);
                        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                        googleMap.addMarker(markerOptions);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFail() {
                System.out.println("cannot get google nearby");

            }
        }, new String[]{});


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(cur).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = keyword.getText().toString();
                if(TextUtils.isEmpty(type)){
                    Toast.makeText(vMap.getContext(),"Input Somewhere Firstly!",Toast.LENGTH_SHORT).show();
                }else{

                    new ConnectionUtils(StringUtils.getMapURL(type, latitude, longitude), new ConnectionUtils.ConnectionCallback() {
                        @Override
                        public void onSuccess(Object result) {
                            System.out.println("gooooooooooo->" + result);

                            try {

                                googleMap.clear();
                                // create marker
                                MarkerOptions marker = new MarkerOptions();
                                marker.position(cur).title("My Location");
                                // Changing marker icon
                                marker.icon(BitmapDescriptorFactory
                                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
                                // adding marker
                                googleMap.addMarker(marker);

                                keyword.setText("");
                                InputMethodManager inputMethodManager = (InputMethodManager) vMap.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(vMap.getWindowToken(), 0);


                                JSONObject jsonObj = new JSONObject(result.toString());
                                JSONArray jsonArray = jsonObj.getJSONArray("results");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject cur = (JSONObject) jsonArray.get(i);
                                    JSONObject geometry = (JSONObject) ((JSONObject) cur.get("geometry")).get("location");
                                    double lat = geometry.getDouble("lat");
                                    double lng = geometry.getDouble("lng");
                                    System.out.println("lat->" + lat + "," + lng);
                                    String placeName = cur.getString("name");
                                    String vicinity = cur.getString("vicinity");
                                    System.out.println("name->" + placeName + "v->" + vicinity);
                                    LatLng latLng = new LatLng(lat, lng);
                                    MarkerOptions markerOptions = new MarkerOptions();
                                    markerOptions.position(latLng);
                                    markerOptions.title(placeName + " : " + vicinity);
                                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                                    googleMap.addMarker(markerOptions);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onFail() {
                            System.out.println("cannot get google nearby");

                        }
                    }, new String[]{});

                }



            }
        });

        // Perform any camera updates here
        return vMap;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
