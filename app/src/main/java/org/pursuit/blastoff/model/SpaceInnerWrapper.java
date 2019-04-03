package org.pursuit.blastoff.model;

import java.util.List;

public class SpaceInnerWrapper {

    private List<SolarSystem> solarSystem;
    private List<Universe> universe;

    public SpaceInnerWrapper(List<SolarSystem> solarSystem, List<Universe> universe) {
        this.solarSystem = solarSystem;
        this.universe = universe;
    }

    public List<SolarSystem> getSolarSystem() {
        return solarSystem;
    }

    public List<Universe> getUniverse() {
        return universe;
    }
}
