package fabriqueAbstraite;

public class RockingChairFactory implements ChairFactory {
    @Override
    public Chair createChair() {
        return new RockingChair();
    }
}
