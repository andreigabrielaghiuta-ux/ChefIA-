package backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import backend.entity.Actividad;
import backend.entity.Objetivo;
import backend.entity.Sexo;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class PerfilRegistroDTO {
    @NotNull(message = "Debe introducir su estatura.")
    @Min(value = 50, message = "La altura mínima es 50 cm.")
    @Max(value = 250, message = "La altura máxima es 250 cm.")
    private Integer altura;

    @NotNull(message = "Debe introducir su peso.")
    @DecimalMin(value = "10.0", message = "El peso mínimo es 10 kg.")
    @DecimalMax(value = "500.0", message = "El peso máximo es 500 kg.")
    @Digits(integer = 3, fraction = 2, message = "El peso puede tener un máximo de dos decimales.")
    private BigDecimal peso;

    @NotNull(message = "Debe introducir su fecha de nacimiento.")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy.")
    private LocalDate fechaNacimiento;

    @NotNull(message = "Debe seleccionar su nivel de actividad.")
    private Actividad nivelActividad;

    @NotNull(message = "Debe seleccionar el sexo utilizado para el cálculo.")
    private Sexo sexo;

    @NotNull(message = "Debe seleccionar un objetivo.")
    private Objetivo objetivo;

    // ---CONSTRUCTORES--- //

    public PerfilRegistroDTO() {
    }

    public PerfilRegistroDTO(Integer altura, BigDecimal peso, Actividad nivelActividad, Sexo sexo, Objetivo objetivo, LocalDate fechaNacimiento) {
        this.altura = altura;
        this.peso = peso;
        this.nivelActividad = nivelActividad;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.fechaNacimiento = fechaNacimiento;
    }

    // ---GETTERS--- //

    public Integer getAltura() {
        return altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public Actividad getNivelActividad() {
        return nivelActividad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    // ---SETTERS--- //

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public void setNivelActividad(Actividad nivelActividad) {
        this.nivelActividad = nivelActividad;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
}
