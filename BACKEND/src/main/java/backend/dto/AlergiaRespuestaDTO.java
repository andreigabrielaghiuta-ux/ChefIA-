package backend.dto;

import jakarta.persistence.Column;

public class AlergiaRespuestaDTO {
    private Long id;
    @Column(unique = true)
    private String nombre;
    private String descripcion;

    public AlergiaRespuestaDTO(){
    }

    public AlergiaRespuestaDTO(Long id, String nombre, String descripcion){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

        // ---GETTERS--- //

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }


    // ---SETTERS--- ///

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}


