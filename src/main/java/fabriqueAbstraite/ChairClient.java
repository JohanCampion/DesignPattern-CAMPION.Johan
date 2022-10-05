package fabriqueAbstraite;

public class ChairClient {
    private Chair chair;

    public ChairClient(ChairFactory chairFactory) {
        this.chair = chairFactory.createChair();
    }

    public void getChairInformation() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Class Name : " + this.chair.getClass().getSimpleName());
        System.out.println("Seat material : " + chair.getSeatMaterial());
        System.out.println("Seat cover material : " + chair.getSeatCoverMaterial());
        System.out.println("has wheels ? : " + chair.hasWheel());
        System.out.println("-------------------------------------------------------");
    }
}
