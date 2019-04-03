package org.pursuit.blastoff.model;

import java.util.List;

public class SpaceResponse {

    private List<SpaceInnerWrapper> space;

    public SpaceResponse(List<SpaceInnerWrapper> space) {
        this.space = space;
    }

    public List<SpaceInnerWrapper> getSpace() {
        return space;
    }
}
