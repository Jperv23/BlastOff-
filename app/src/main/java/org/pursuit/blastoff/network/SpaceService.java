package org.pursuit.blastoff.network;

import org.pursuit.blastoff.model.SpaceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SpaceService {

    String ENDPOINT = "/Jperzval/FanDuel_CodingChallenge/master/app/sampledata/sample.json?";


    @GET(ENDPOINT)
    Observable<SpaceResponse> getSpaceResponse();




}
