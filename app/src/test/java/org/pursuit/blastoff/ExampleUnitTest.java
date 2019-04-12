package org.pursuit.blastoff;

import org.junit.Test;
import org.pursuit.blastoff.network.RetrofitSingleton;

import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void getRetrofitInstance() {
        Retrofit expected = RetrofitSingleton.getRetrofitInstance();
        assertEquals(expected, RetrofitSingleton.getRetrofitInstance());
    }
}