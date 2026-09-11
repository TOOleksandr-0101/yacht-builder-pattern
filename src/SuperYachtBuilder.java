import java.util.List;

public class SuperYachtBuilder extends AbstractYachtBuilder {

    private static final double MIN_SUPERYACHT_LENGTH_METERS = 24.0;
    private static final int MIN_SUPERYACHT_ENGINE_HP = 500;

    @Override
    protected void applyDefaults() {
        this.hullMaterial = HullMaterial.STEEL;
        this.engineType = EngineType.DIESEL;
        this.engineHorsepower = 3000;
        this.cabinCount = 8;
        this.crewCount = 12;
        this.maxPassengers = 18;
        this.cruisingSpeedKnots = 15;
        this.beamMeters = 9.0;
        this.hasSunDeck = true;
    }

    @Override
    protected void validateCategoryRules(List<String> errors) {
        if (lengthMeters < MIN_SUPERYACHT_LENGTH_METERS) {
            errors.add("Superyacht must be at least " + MIN_SUPERYACHT_LENGTH_METERS + " m long");
        }

        if (engineHorsepower < MIN_SUPERYACHT_ENGINE_HP) {
            errors.add("Superyacht engine must be at least " + MIN_SUPERYACHT_ENGINE_HP + " HP");
        }
    }
}
