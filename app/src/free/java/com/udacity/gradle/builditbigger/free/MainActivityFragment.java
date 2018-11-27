package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.developer.albyroni.showjock.ShowJock;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivityFragment extends Fragment {

    private InterstitialAd interstitialAd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);

        Button showJock = rootView.findViewById(R.id.jockBtn);

        AdView mAdView = rootView.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(getActivity());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        showJock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdRequest request = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();
                interstitialAd.loadAd(request);


                interstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        // Code to be executed when when the interstitial ad is closed.
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

                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
            }
        });

        return rootView;
    }


}