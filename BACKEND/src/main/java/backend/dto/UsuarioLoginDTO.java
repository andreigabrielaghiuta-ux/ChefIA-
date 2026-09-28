package backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioLoginDTO {
    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Tiene que ser un email.")
    private String email;
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    // ---CONSTRUCTORES--- //
   
    public UsuarioLoginDTO(){
    }

    public UsuarioLoginDTO(String email, String password){
        this.email=email;
        this.password=password;
    }

    // ---GETTERS--- //

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // ---SETTERS--- //

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
