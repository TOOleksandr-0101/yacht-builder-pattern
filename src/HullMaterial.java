public enum HullMaterial {

    FIBERGLASS("Fiberglass"),
    ALUMINUM("Aluminum"),
    STEEL("Steel"),
    CARBON_FIBER("Carbon Fiber"),
    WOOD("Wood");

    private final String displayName;

    HullMaterial(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
