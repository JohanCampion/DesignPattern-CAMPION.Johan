package chaineDeResponsabilite;

public class PasswordProcessor extends RegisterProcessor  {


    public PasswordProcessor(RegisterProcessor registerProcess) {
        super(registerProcess);
    }

    @Override
    public void canRegister(RegisterRequest registerRequest) {
        if(registerRequest.password.length() < 5) {
            System.out.println("Votre mot de passe n'est pas assez long");
        } else {
            super.canRegister(registerRequest);
        }
    }
}
