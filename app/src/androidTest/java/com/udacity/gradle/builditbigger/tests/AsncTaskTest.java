package com.udacity.gradle.builditbigger.tests;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AsncTaskTest {

    private String joke;

    @Test
    public void testForJokes() throws Exception {
        //Make sure to deploy server locally before running tests
        EndpointsAsyncTask endPointAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.OnFinsihAsync() {
            @Override
            public void onFinish(String result) {
                joke = result;
            }
        });
        endPointAsyncTask.execute();
        try {
            Thread.sleep(10000);
            joke = endPointAsyncTask.get();
            assertNotNull("success", joke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
