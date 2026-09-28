package backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import backend.entity.Actividad;
import backend.entity.Objetivo;
import backend.entity.Sexo;

public class PerfilRespuestaDTO {

    private Long id;
    private Integer altura;
    private BigDecimal peso;
    private LocalDate fechaNacimiento;
    private Actividad nivelActividad;
    private Sexo sexo;
    private Objetivo objetivo;

    // ---CONSTRUCTORES--- //

    public PerfilRespuestaDTO() {
    }

    public PerfilRespuestaDTO(Long id, Integer altura, BigDecimal peso,LocalDate fechaNacimiento, Actividad nivelActividad, Sexo sexo, Objetivo objetivo) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelActividad = nivelActividad;
        this.sexo = sexo;
        this.objetivo = objetivo;
    }

    // ---GETTERS--- //

    public Long getId() {
        return id;
    }

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

    public LocalDate getFechaNacimiento() {
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

}
