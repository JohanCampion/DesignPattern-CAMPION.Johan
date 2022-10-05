package fabriqueAbstraite;

public class GamingChair implements Chair {

    @Override
    public String getSeatMaterial() {
        return "Plastic";
    }

    @Override
    public String getSeatCoverMaterial() {
        return "Synthetic";
    }

    @Override
    public Boolean hasWheel() {
        return true;
    }
}
