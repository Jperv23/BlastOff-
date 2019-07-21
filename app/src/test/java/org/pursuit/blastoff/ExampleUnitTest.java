package org.pursuit.blastoff;

import org.junit.Test;
import org.pursuit.blastoff.network.RetrofitSingleton;

import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
public class ExampleUnitTest {

    @Test
    public void getRetrofitInstance() {
        Retrofit expected = RetrofitSingleton.getRetrofitInstance();
        assertEquals(expected, RetrofitSingleton.getRetrofitInstance());
    }
}