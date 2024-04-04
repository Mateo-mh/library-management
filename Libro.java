public class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo(){
        return titulo;
    };

    public String getAutor(){
        return autor;
    };

    @Override
    public String toString(){
        return "Titulo: " + titulo + ", Autor: " + autor;
    }
}
