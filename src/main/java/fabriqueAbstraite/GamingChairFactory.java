package fabriqueAbstraite;

public class GamingChairFactory implements ChairFactory{

    @Override
    public Chair createChair() {
        return new GamingChair();
    }
}
