package com.arcileslab.arciles.drawerdeneme;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import AdaptersAndJson.GridViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArabalarFragment extends Fragment {

    ArrayList<String> urls;

    public ArabalarFragment() {
        // Required empty public constructor
        urls = new ArrayList<String>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_arabalar, container, false);
        GridView gridView = (GridView) V.findViewById(R.id.gvArabalar);
        urls.add("http://www.wallpaperawesome.com/wallpapers-awesome/wallpapers-full-hd-1080-x-1920-smatphone-htc-one-lumia-1520-lg-g2-galaxy-s4-s5-awesome/z-wallpaper-full-hd-1080-x-1920-smartphone-bale-of-hay.jpg");
        urls.add("http://www.wallpaperawesome.com/wallpapers-awesome/wallpapers-full-hd-1080-x-1920-smatphone-htc-one-lumia-1520-lg-g2-galaxy-s4-s5-awesome/wallpaper-full-hd-1080-x-1920-smartphone-yellow-circle-abstract.jpg");
        urls.add("http://www.wallpaperawesome.com/wallpapers-awesome/wallpapers-full-hd-1080-x-1920-smatphone-htc-one-lumia-1520-lg-g2-galaxy-s4-s5-awesome/wallpaper-full-hd-1080-x-1920-smartphone-yellow-and-dark.jpg");
        gridView.setAdapter(new GridViewAdapter(getActivity(),urls));
        return V;
    }

}
