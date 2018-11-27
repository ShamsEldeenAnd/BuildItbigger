package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.developer.albyroni.showjock.ShowJock;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    private OnFinsihAsync onFinsihAsync;

    public EndpointsAsyncTask() {

    }

    public EndpointsAsyncTask(OnFinsihAsync onFinsihAsync) {
        this.onFinsihAsync = onFinsihAsync;
    }

    @Override
    protected String doInBackground(Void... contexts) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver

                    //note i'm using gennymotion so my local 10.0.3.2 instead of 10.0.2.2
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

//        context = contexts[0];

        try {
            return myApiService.tellJock().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String jock) {
        onFinsihAsync.onFinish(jock);
//        Intent intent = new Intent(context, ShowJock.class);
//        intent.putExtra("JOCK", jock);
//        context.startActivity(intent);

    }

    public interface OnFinsihAsync {
        void onFinish(String jock);
    }
}