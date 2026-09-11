public class YachtDirector {

    private final YachtBuilder builder;

    public YachtDirector(YachtBuilder builder) {
        this.builder = builder;
    }

    public Yacht buildWeekendCruiser() {
        return builder
                .setName("Weekend Cruiser")
                .setLength(12.0)
                .setBeam(4.0)
                .setHullMaterial(HullMaterial.FIBERGLASS)
                .setEngine(EngineType.SAIL, 50)
                .setCabins(2)
                .setCrew(1)
                .setMaxPassengers(6)
                .setCruisingSpeed(7)
                .setNavigationSystem("Garmin GPSMap 1243xsv")
                .build();
    }

    public Yacht buildOceanRacer() {
        return builder
                .setName("Ocean Racer")
                .setLength(22.0)
                .setBeam(5.5)
                .setHullMaterial(HullMaterial.CARBON_FIBER)
                .setEngine(EngineType.SAIL, 150)
                .setCabins(4)
                .setCrew(8)
                .setMaxPassengers(12)
                .setCruisingSpeed(14)
                .setNavigationSystem("B&G Zeus S 16")
                .build();
    }

    public Yacht buildMediterraneanSuperyacht() {
        return builder
                .setName("Mediterranean Diamond")
                .setLength(55.0)
                .setBeam(10.5)
                .setHullMaterial(HullMaterial.STEEL)
                .setEngine(EngineType.DIESEL, 4000)
                .setCabins(8)
                .setCrew(14)
                .setMaxPassengers(20)
                .setCruisingSpeed(16)
                .addSunDeck()
                .addJacuzzi()
                .setNavigationSystem("Furuno NavNet TZtouch3")
                .build();
    }

    public Yacht buildExplorerSuperyacht() {
        return builder
                .setName("Arctic Explorer")
                .setLength(72.0)
                .setBeam(13.0)
                .setHullMaterial(HullMaterial.STEEL)
                .setEngine(EngineType.HYBRID, 6000)
                .setCabins(10)
                .setCrew(20)
                .setMaxPassengers(24)
                .setCruisingSpeed(12)
                .addSunDeck()
                .addJacuzzi()
                .addHelipad()
                .setNavigationSystem("Simrad HALO 3000 Radar + Furuno FAR-2228")
                .build();
    }
}
