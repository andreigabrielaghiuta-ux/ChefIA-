package backend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")

public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "altura", nullable = false)
    private Integer altura;
    @Column(name = "peso", nullable = false)
    private BigDecimal peso;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_actividad", nullable = false)
    private Actividad nivelActividad;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo", nullable = false)
    private Objetivo objetivo;
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;
    @ManyToMany
    @JoinTable(name = "perfil_alergias", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "alergia_id"))
    private Set<Alergia> alergias = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "perfil_enfermedades", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "enfermedad_id"))
    private Set<Enfermedad> enfermedades = new HashSet<>();

    // ---CONSTRUCTORES--- //

    public Perfil() {
    }

    public Perfil(Integer altura, BigDecimal peso, LocalDate fechaNacimiento, Actividad nivelActividad, Sexo sexo,
            Objetivo objetivo, Usuario usuario) {
        this.altura = altura;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelActividad = nivelActividad;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.usuario = usuario;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public Set<Alergia> getAlergias() {
        return alergias;
    }

    public Set<Enfermedad> getEnfermedades() {
        return enfermedades;
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
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void agregarAlergia(Alergia alergia) {
        this.alergias.add(alergia);
    }

    public void eliminarAlergia(Alergia alergia) {
        this.alergias.remove(alergia);
    }

    public void agregarEnfermedad(Enfermedad enfermedad) {
        this.enfermedades.add(enfermedad);
    }

    public void eliminarEnfermedad(Enfermedad enfermedad) {
        this.enfermedades.remove(enfermedad);
    }

}
