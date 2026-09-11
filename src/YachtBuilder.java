public interface YachtBuilder {

    YachtBuilder setName(String name);

    YachtBuilder setLength(double meters);

    YachtBuilder setBeam(double meters);

    YachtBuilder setHullMaterial(HullMaterial material);

    YachtBuilder setEngine(EngineType type, int horsepower);

    YachtBuilder setCabins(int count);

    YachtBuilder setCrew(int count);

    YachtBuilder setMaxPassengers(int count);

    YachtBuilder setCruisingSpeed(int knots);

    YachtBuilder addSunDeck();

    YachtBuilder addJacuzzi();

    YachtBuilder addHelipad();

    YachtBuilder setNavigationSystem(String system);

    Yacht build();

    YachtBuilder reset();
}
