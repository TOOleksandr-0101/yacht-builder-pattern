public class Main {

    public static void main(String[] args) {
        buildSailingYachtsViaDirector();
        buildSuperyachtsViaDirector();
        buildCustomYachtWithoutDirector();
        demonstrateValidation();
    }

    private static void buildSailingYachtsViaDirector() {
        printHeader("Director + Sailing Yacht Builder");

        YachtBuilder sailingBuilder = new SailingYachtBuilder();
        YachtDirector director = new YachtDirector(sailingBuilder);

        Yacht weekendCruiser = director.buildWeekendCruiser();
        System.out.println(weekendCruiser);

        Yacht oceanRacer = director.buildOceanRacer();
        System.out.println(oceanRacer);
    }

    private static void buildSuperyachtsViaDirector() {
        printHeader("Director + Superyacht Builder");

        YachtBuilder superBuilder = new SuperYachtBuilder();
        YachtDirector director = new YachtDirector(superBuilder);

        Yacht mediterranean = director.buildMediterraneanSuperyacht();
        System.out.println(mediterranean);

        Yacht explorer = director.buildExplorerSuperyacht();
        System.out.println(explorer);
    }

    private static void buildCustomYachtWithoutDirector() {
        printHeader("Custom Build (no Director)");

        Yacht custom = new SuperYachtBuilder()
                .setName("Royal Falcon One")
                .setLength(41.0)
                .setBeam(15.5)
                .setHullMaterial(HullMaterial.CARBON_FIBER)
                .setEngine(EngineType.DIESEL, 5400)
                .setCabins(6)
                .setCrew(10)
                .setMaxPassengers(10)
                .setCruisingSpeed(18)
                .addSunDeck()
                .addJacuzzi()
                .setNavigationSystem("Raymarine Axiom XL 24")
                .build();

        System.out.println(custom);
    }

    private static void demonstrateValidation() {
        printHeader("Validation Demo");

        try {
            new SailingYachtBuilder()
                    .setName("Invalid Sailboat")
                    .setLength(50.0)
                    .setEngine(EngineType.DIESEL, 500)
                    .addHelipad()
                    .setNavigationSystem("Basic GPS")
                    .build();
        } catch (IllegalStateException exception) {
            System.out.println("Caught expected validation error:");
            System.out.println(exception.getMessage());
        }

        System.out.println();
    }

    private static void printHeader(String title) {
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println("  " + title);
        System.out.println("=".repeat(50));
        System.out.println();
    }
}
