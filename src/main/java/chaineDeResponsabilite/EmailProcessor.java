package chaineDeResponsabilite;

public class EmailProcessor extends RegisterProcessor {
    public EmailProcessor(RegisterProcessor registerProcess) {
        super(registerProcess);
    }

    @Override
    public void canRegister(RegisterRequest registerRequest) {
        if (!registerRequest.email.contains("@")) {
            System.out.println("Votre email est invalide");
        } else {
            super.canRegister(registerRequest);
        }

    }
}
