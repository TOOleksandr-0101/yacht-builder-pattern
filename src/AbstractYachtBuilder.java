import java.util.ArrayList;
import java.util.List;

public abstract class AbstractYachtBuilder implements YachtBuilder {

    private static final double MIN_LENGTH_METERS = 5.0;
    private static final double MIN_BEAM_METERS = 2.0;
    private static final int MIN_CABIN_COUNT = 1;

    protected String name;
    protected double lengthMeters;
    protected double beamMeters;
    protected HullMaterial hullMaterial;
    protected EngineType engineType;
    protected int engineHorsepower;
    protected int cabinCount;
    protected int crewCount;
    protected int maxPassengers;
    protected int cruisingSpeedKnots;
    protected boolean hasSunDeck;
    protected boolean hasJacuzzi;
    protected boolean hasHelipad;
    protected String navigationSystem;

    protected AbstractYachtBuilder() {
        applyDefaults();
    }

    protected abstract void applyDefaults();

    protected abstract void validateCategoryRules(List<String> errors);

    @Override
    public YachtBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public YachtBuilder setLength(double meters) {
        this.lengthMeters = meters;
        return this;
    }

    @Override
    public YachtBuilder setBeam(double meters) {
        this.beamMeters = meters;
        return this;
    }

    @Override
    public YachtBuilder setHullMaterial(HullMaterial material) {
        this.hullMaterial = material;
        return this;
    }

    @Override
    public YachtBuilder setEngine(EngineType type, int horsepower) {
        this.engineType = type;
        this.engineHorsepower = horsepower;
        return this;
    }

    @Override
    public YachtBuilder setCabins(int count) {
        this.cabinCount = count;
        return this;
    }

    @Override
    public YachtBuilder setCrew(int count) {
        this.crewCount = count;
        return this;
    }

    @Override
    public YachtBuilder setMaxPassengers(int count) {
        this.maxPassengers = count;
        return this;
    }

    @Override
    public YachtBuilder setCruisingSpeed(int knots) {
        this.cruisingSpeedKnots = knots;
        return this;
    }

    @Override
    public YachtBuilder addSunDeck() {
        this.hasSunDeck = true;
        return this;
    }

    @Override
    public YachtBuilder addJacuzzi() {
        this.hasJacuzzi = true;
        return this;
    }

    @Override
    public YachtBuilder addHelipad() {
        this.hasHelipad = true;
        return this;
    }

    @Override
    public YachtBuilder setNavigationSystem(String system) {
        this.navigationSystem = system;
        return this;
    }

    @Override
    public Yacht build() {
        validate();

        Yacht yacht = new Yacht(
                name, lengthMeters, beamMeters, hullMaterial,
                engineType, engineHorsepower, cabinCount, crewCount,
                maxPassengers, cruisingSpeedKnots, hasSunDeck,
                hasJacuzzi, hasHelipad, navigationSystem
        );

        reset();
        return yacht;
    }

    @Override
    public YachtBuilder reset() {
        name = null;
        lengthMeters = 0;
        beamMeters = 0;
        hullMaterial = null;
        engineType = null;
        engineHorsepower = 0;
        cabinCount = 0;
        crewCount = 0;
        maxPassengers = 0;
        cruisingSpeedKnots = 0;
        hasSunDeck = false;
        hasJacuzzi = false;
        hasHelipad = false;
        navigationSystem = null;

        applyDefaults();
        return this;
    }

    private void validate() {
        List<String> errors = new ArrayList<>();

        requireNonBlank(name, "Name", errors);
        requireNonBlank(navigationSystem, "Navigation system", errors);

        if (lengthMeters < MIN_LENGTH_METERS) {
            errors.add("Length must be at least " + MIN_LENGTH_METERS + " m");
        }
        if (beamMeters < MIN_BEAM_METERS) {
            errors.add("Beam must be at least " + MIN_BEAM_METERS + " m");
        }
        if (hullMaterial == null) {
            errors.add("Hull material is required");
        }
        if (engineType == null) {
            errors.add("Engine type is required");
        }
        if (cabinCount < MIN_CABIN_COUNT) {
            errors.add("Must have at least " + MIN_CABIN_COUNT + " cabin");
        }
        if (maxPassengers <= 0) {
            errors.add("Max passengers must be positive");
        }
        if (cruisingSpeedKnots <= 0) {
            errors.add("Cruising speed must be positive");
        }

        validateCategoryRules(errors);

        if (!errors.isEmpty()) {
            throw new IllegalStateException(
                    "Invalid yacht configuration:\n - " + String.join("\n - ", errors)
            );
        }
    }

    private void requireNonBlank(String value, String fieldName, List<String> errors) {
        if (value == null || value.isBlank()) {
            errors.add(fieldName + " is required");
        }
    }
}
