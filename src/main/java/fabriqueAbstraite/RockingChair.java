package fabriqueAbstraite;

public class RockingChair implements Chair{
    @Override
    public String getSeatMaterial() {
        return "wood";
    }

    @Override
    public String getSeatCoverMaterial() {
        return "wood";
    }

    @Override
    public Boolean hasWheel() {
        return false;
    }
}
