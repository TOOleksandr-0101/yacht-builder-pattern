public enum EngineType {

    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    HYBRID("Hybrid"),
    SAIL("Sail Only");

    private final String displayName;

    EngineType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
