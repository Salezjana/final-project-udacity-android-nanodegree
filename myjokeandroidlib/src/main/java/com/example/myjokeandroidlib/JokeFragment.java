package com.example.myjokeandroidlib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeFragment extends Fragment {
    public static String BUNDLE_JOKE = "jokebundle";

    public JokeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joke, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String joke = "smomething gone wrong :(";
        if (getArguments() != null){
            joke = getArguments().getString(BUNDLE_JOKE);
        }
        TextView textView = (TextView) getActivity().findViewById(R.id.joke);
        textView.setText(joke);

    }
}
