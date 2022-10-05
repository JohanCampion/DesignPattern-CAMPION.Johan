package chaineDeResponsabilite;

public abstract class RegisterProcessor {

    public RegisterProcessor registerProcess;

    public RegisterProcessor(RegisterProcessor registerProcess) {
        this.registerProcess = registerProcess;
    }

    public void canRegister(RegisterRequest registerRequest){
        if(registerProcess != null) {
            registerProcess.canRegister(registerRequest);
        }
    }
}
