package com.example.android.camera2basic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class PreviewFragment extends Fragment {
    private static final String ARG_PATH_FILE = "pathFile";

    private File mFile;

    public PreviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param file Parameter with file.
     * @return A new instance of fragment PreviewFragment.
     */
    public static PreviewFragment newInstance(File file) {
        PreviewFragment fragment = new PreviewFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PATH_FILE, file);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFile = (File) getArguments().getSerializable(ARG_PATH_FILE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preview, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.preview_photo_image);

        Picasso.with(getActivity())
                .load(mFile)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imageView);

        return view;
    }


}
