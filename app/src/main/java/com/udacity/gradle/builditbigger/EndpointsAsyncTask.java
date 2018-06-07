package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.JokeCallback, Void, String> {
    private MyApi myApi = null;
    String joke ="";
    private boolean errorOccurred = false;

    @Override
    protected String doInBackground(JokeCallback... params) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("192.168.1.20:8080")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();
        }


        try {
            joke = myApi.getJoke().execute().getJoke();
        } catch (IOException e) {
            joke= "error";
            return e.getMessage();
        }
        return joke;
    }

    @Override
    protected void onPostExecute(String result) {
        result = joke;
    }

    public interface JokeCallback {
        void done(String result, boolean error);
    }
}