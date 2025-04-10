public class objEmpresa
{
    private String referencia;
    private String marca; 
    private Double precio;
    private int cantidad;
    private String nombreUsuario;
    private String cedulaUsu;
    public objEmpresa() {
    }
    public objEmpresa(String referencia, String marca, Double precio, int cantidad, String nombreUsuario,
            String cedulaUsu) {
        this.referencia = referencia;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombreUsuario = nombreUsuario;
        this.cedulaUsu = cedulaUsu;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getCedulaUsu() {
        return cedulaUsu;
    }
    public void setCedulaUsu(String cedulaUsu) {
        this.cedulaUsu = cedulaUsu;
    }
    
}