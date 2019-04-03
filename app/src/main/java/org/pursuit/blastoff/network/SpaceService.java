package org.pursuit.blastoff.network;

import org.pursuit.blastoff.model.SpaceResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceService {

    String ENDPOINT = "/Jperv23/BlastOff-/master/JSON";

    @GET(ENDPOINT)
    Call<SpaceResponse> getSpaceResponse();


}
