public class Livro extends Object {

    //atributos
    private String titulo, categoria;
    private int qtdPag;

    private Livro[] estante;

    public Livro(){}

    public Livro(String titulo, String categoria, int qtdPag) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.qtdPag = qtdPag;

    }
    //setters
    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //getters

    public String getTitulo() {
        return titulo;
    }


    public String getCategoria() {
        return categoria;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public String mostrardados(){
        return "TITULO: "+getTitulo()+"\nCATEGORIA:"+getCategoria()+ "\nQUANTIDADE DE PAG:"+getQtdPag();
    }
}

