package org.pursuit.blastoff.network;

import org.pursuit.blastoff.model.SpaceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SpaceService {

    String ENDPOINT = "/Jperv23/BlastOff-/master/JSON";

    @GET(ENDPOINT)
    Observable<SpaceResponse> getSpaceResponse();


}
