package chaineDeResponsabilite;

public class UsernameProcessor extends RegisterProcessor {

    public UsernameProcessor(RegisterProcessor nextProcess) {
        super(nextProcess);
    }

    @Override
    public void canRegister(RegisterRequest registerRequest) {
        if (registerRequest.username.contains("$")) {
            System.out.println("Nom d'utilisateur invalide");
        } else  {
            super.canRegister(registerRequest);
        }
    }


}
