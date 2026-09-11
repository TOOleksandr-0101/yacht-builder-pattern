import java.util.StringJoiner;

public class Yacht {

    private final String name;
    private final double lengthMeters;
    private final double beamMeters;
    private final HullMaterial hullMaterial;
    private final EngineType engineType;
    private final int engineHorsepower;
    private final int cabinCount;
    private final int crewCount;
    private final int maxPassengers;
    private final int cruisingSpeedKnots;
    private final boolean hasSunDeck;
    private final boolean hasJacuzzi;
    private final boolean hasHelipad;
    private final String navigationSystem;

    public Yacht(String name,
                 double lengthMeters,
                 double beamMeters,
                 HullMaterial hullMaterial,
                 EngineType engineType,
                 int engineHorsepower,
                 int cabinCount,
                 int crewCount,
                 int maxPassengers,
                 int cruisingSpeedKnots,
                 boolean hasSunDeck,
                 boolean hasJacuzzi,
                 boolean hasHelipad,
                 String navigationSystem) {
        this.name = name;
        this.lengthMeters = lengthMeters;
        this.beamMeters = beamMeters;
        this.hullMaterial = hullMaterial;
        this.engineType = engineType;
        this.engineHorsepower = engineHorsepower;
        this.cabinCount = cabinCount;
        this.crewCount = crewCount;
        this.maxPassengers = maxPassengers;
        this.cruisingSpeedKnots = cruisingSpeedKnots;
        this.hasSunDeck = hasSunDeck;
        this.hasJacuzzi = hasJacuzzi;
        this.hasHelipad = hasHelipad;
        this.navigationSystem = navigationSystem;
    }

    public String getName() {
        return name;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    public double getBeamMeters() {
        return beamMeters;
    }

    public HullMaterial getHullMaterial() {
        return hullMaterial;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getEngineHorsepower() {
        return engineHorsepower;
    }

    public int getCabinCount() {
        return cabinCount;
    }

    public int getCrewCount() {
        return crewCount;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getCruisingSpeedKnots() {
        return cruisingSpeedKnots;
    }

    public boolean hasSunDeck() {
        return hasSunDeck;
    }

    public boolean hasJacuzzi() {
        return hasJacuzzi;
    }

    public boolean hasHelipad() {
        return hasHelipad;
    }

    public String getNavigationSystem() {
        return navigationSystem;
    }

    @Override
    public String toString() {
        StringJoiner lines = new StringJoiner("\n");

        lines.add("+--------------------------------------------+");
        lines.add("|  YACHT: " + padRight(name, 34) + "|");
        lines.add("+--------------------------------------------+");
        lines.add(formatLine("Length", lengthMeters + " m"));
        lines.add(formatLine("Beam", beamMeters + " m"));
        lines.add(formatLine("Hull", hullMaterial.getDisplayName()));
        lines.add(formatLine("Engine", engineType.getDisplayName()));
        lines.add(formatLine("Horsepower", engineHorsepower + " HP"));
        lines.add(formatLine("Cabins", String.valueOf(cabinCount)));
        lines.add(formatLine("Crew", String.valueOf(crewCount)));
        lines.add(formatLine("Max Passengers", String.valueOf(maxPassengers)));
        lines.add(formatLine("Cruising Speed", cruisingSpeedKnots + " knots"));
        lines.add(formatLine("Sun Deck", hasSunDeck ? "Yes" : "No"));
        lines.add(formatLine("Jacuzzi", hasJacuzzi ? "Yes" : "No"));
        lines.add(formatLine("Helipad", hasHelipad ? "Yes" : "No"));
        lines.add(formatLine("Navigation", navigationSystem));
        lines.add("+--------------------------------------------+");

        return lines.toString();
    }

    private String formatLine(String label, String value) {
        return String.format("|  %-16s | %-22s |", label, value);
    }

    private String padRight(String text, int length) {
        if (text.length() >= length) {
            return text.substring(0, length);
        }
        return text + " ".repeat(length - text.length());
    }
}
