package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;



@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends AndroidTestCase {
    Context context;

    @Test
    public void testEndpointAsyncTask() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null) {
                    if (!result.equals( "Failed to connect to /10.0.2.2:8080")){
                        Log.d("EndpointsAsyncTaskTest_TESTING", result);
                        assertTrue(result.length() > 0);
                        latch.countDown();
                    }
                }
            }
        };
        testTask.execute(context);
        latch.await();
    }
}