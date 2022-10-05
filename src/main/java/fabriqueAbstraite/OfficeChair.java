package fabriqueAbstraite;

public class OfficeChair implements Chair{
    @Override
    public String getSeatMaterial() {
        return "steel";
    }

    @Override
    public String getSeatCoverMaterial() {
        return "leather";
    }

    @Override
    public Boolean hasWheel() {
        return true;
    }
}
