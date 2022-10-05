package fabriqueAbstraite;

public class OfficeChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new OfficeChair();
    }
}
