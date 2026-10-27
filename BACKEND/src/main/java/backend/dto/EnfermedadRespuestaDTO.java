package backend.dto;


public class EnfermedadRespuestaDTO {
    private Long id;
    private String nombre;
    private String descripcion;

    public EnfermedadRespuestaDTO(){
    }

    public EnfermedadRespuestaDTO(Long id, String nombre, String descripcion){
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