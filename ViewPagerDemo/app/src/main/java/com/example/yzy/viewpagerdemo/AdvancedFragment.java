package com.example.yzy.viewpagerdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by yzy on 2017/8/3.
 */

public class AdvancedFragment extends Fragment {

    private static final String PHOTO_URL = "photo_url";

    private String mPhotoUrl;

    public static AdvancedFragment newInstance(String photoUrl) {
        AdvancedFragment fragment = new AdvancedFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PHOTO_URL, photoUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_advanced, null);
        SimpleDraweeView simpleDraweeView = root.findViewById(R.id.image);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mPhotoUrl = bundle.getString(PHOTO_URL);
        }
        simpleDraweeView.setImageURI(Uri.parse(mPhotoUrl));
        return root;
    }
}
