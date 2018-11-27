package com.udacity.gradle.builditbigger.paid;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.developer.albyroni.showjock.ShowJock;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivityFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);
        Button showJock = rootView.findViewById(R.id.jockBtn);

        showJock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.OnFinsihAsync() {
                    @Override
                    public void onFinish(String jock) {
                        if (jock != null) {
                            Intent intent = new Intent(getActivity(), ShowJock.class);
                            intent.putExtra("JOCK", jock);
                            startActivity(intent);
                        }
                    }
                });
                asyncTask.execute();
            }
        });

        return rootView;
    }


}
