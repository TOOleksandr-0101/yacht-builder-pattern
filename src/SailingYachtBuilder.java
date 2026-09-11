import java.util.List;

public class SailingYachtBuilder extends AbstractYachtBuilder {

    private static final double MAX_SAILING_LENGTH_METERS = 40.0;
    private static final int MAX_AUXILIARY_ENGINE_HP = 200;

    @Override
    protected void applyDefaults() {
        this.hullMaterial = HullMaterial.FIBERGLASS;
        this.engineType = EngineType.SAIL;
        this.engineHorsepower = 0;
        this.cabinCount = 2;
        this.crewCount = 2;
        this.maxPassengers = 6;
        this.cruisingSpeedKnots = 8;
        this.beamMeters = 4.5;
    }

    @Override
    protected void validateCategoryRules(List<String> errors) {
        if (lengthMeters > MAX_SAILING_LENGTH_METERS) {
            errors.add("Sailing yacht length cannot exceed " + MAX_SAILING_LENGTH_METERS + " m");
        }

        if (engineHorsepower > MAX_AUXILIARY_ENGINE_HP) {
            errors.add("Sailing yacht engine cannot exceed " + MAX_AUXILIARY_ENGINE_HP
                    + " HP (auxiliary only)");
        }

        if (hasHelipad) {
            errors.add("Sailing yachts do not support a helipad");
        }
    }
}
