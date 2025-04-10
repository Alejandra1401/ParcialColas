import java.util.Queue;
import javax.swing.JOptionPane;

public class metodos 
{
    public Queue<objEmpresa> Ingresar(Queue<objEmpresa> c) 
    {
        String ingreso = "";
        objEmpresa o = new objEmpresa();
        do {
            ingreso = JOptionPane.showInputDialog("Ingrese la referencia de articulo");
            
            if (ingreso == null) {
                JOptionPane.showMessageDialog(null, "Debe ingresar referencia del art");
            } else if (ingreso.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La referencia no puede estar vacía");
            }
            
        } while (ingreso == null || ingreso.trim().isEmpty());
        o.setReferencia(ingreso);
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese la marca del articulo");
        while (ingreso == null || (ingreso.trim().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null, "La marca no puede estar vacío");  
            ingreso = JOptionPane.showInputDialog(null, "Ingrese marca valida");
            
        }
        o.setMarca(ingreso);
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese la cantidad de articulos");
        while (!ingreso.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese cantidad valida");
        }
        o.setCantidad(Integer.parseInt(ingreso));
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese el precio del articulo");
            while (!ingreso.matches("\\d+(\\.\\d+)?")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese precio valido");
            }
        o.setPrecio(Double.parseDouble(ingreso));
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese nombre del usuario");
        while (ingreso == null || (ingreso.trim().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");  
            ingreso = JOptionPane.showInputDialog(null, "Ingrese nombre valida");
            
        }
        o.setNombreUsuario(ingreso);
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese cedula del usuario");
        while (ingreso == null || (ingreso.trim().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null, "La cedula no puede estar vacío");  
            ingreso = JOptionPane.showInputDialog(null, "Ingrese cedula valida");
            
        }
        o.setCedulaUsu(ingreso);
        return validarExisteDispo(c,o);//No vaya a ingresar dispositivo exixtente 
    }
    public void mostrarCola (Queue<objEmpresa> c)
    {
        for (objEmpresa cola : c) //Deshapilando para mostrar(es lo mismo que un for normal)
        {
            JOptionPane.showMessageDialog(null, "COLA\n"+
                         "  Referencia:" + cola.getReferencia()+"\n" + "Marca: " + cola.getMarca() +"\n"+ 
                         "Precio " + cola.getPrecio()); 
        }
    }
     public Queue<objEmpresa> validarExisteDispo(Queue<objEmpresa> c, objEmpresa ingresoComp )
    {
        boolean encontrado = false;
        for(objEmpresa ropa : c)
        {
            if (ropa.getReferencia().equalsIgnoreCase(ingresoComp.getReferencia())) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog( null, "El articulo ya existe");
                break;
            }
        }
        if(!encontrado)
        {
            c.offer(ingresoComp);
            JOptionPane.showMessageDialog(null, "Articulo ingresado correctamente");
        }
        mostrarCola(c);
        return c; 
    } 
    public void vender(Queue<objEmpresa> c)
    {
        while (c.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay articulos ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        String marcaBusc = "";
        Double ventaPromedio;
        boolean encontrado = false;
        Double precioConDsto = 0.0;
        marcaBusc = JOptionPane.showInputDialog(null, "Ingrese la marca a vender");
        for(objEmpresa ropa : c)
        {
            if(ropa.getMarca().equalsIgnoreCase(marcaBusc))
            {
                if(ropa.getCantidad() > 0)
                {
                    encontrado = true;
                    int cantAVend = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender")));
                    ventaPromedio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la venta promedio"));
                    if(cantAVend <= ropa.getCantidad())
                    {
                        ropa.setCantidad(ropa.getCantidad() - cantAVend);
                        if(ropa.getPrecio() > ventaPromedio)
                        {
                            precioConDsto = ropa.getPrecio()*10/100;
                            modificar(c, precioConDsto);
                        }
                            JOptionPane.showMessageDialog(null, "Venta realizada");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Stock insuficiente");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, " No hay Stock disponible");
                    }
                    JOptionPane.showMessageDialog(null, "Datos del articulo vendido\n"+
                        "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                        "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() + "Descuento de: " + precioConDsto ); 
                        return;
                }
        }
        if(!encontrado)
        {
            JOptionPane.showMessageDialog(null, "Articulo no encontrado");
        }
    }
    public void modificar(Queue<objEmpresa> c, double descuento)
    {
        while (c.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay articulos ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        
        boolean amodif = false;
        String refAMod = JOptionPane.showInputDialog(null, "Ingrese la referencia del articulo a modificar precio");
            for(objEmpresa ropa : c)
            {
                if(ropa.getReferencia() == refAMod)
                {
                    amodif = true;
                    double newprecio = ropa.getPrecio() - descuento;
                    ropa.setPrecio(newprecio);
                    JOptionPane.showMessageDialog(null, "Modificación realizada correctamente");
                    JOptionPane.showMessageDialog(null, "Datos del articulo modificado\n"+
                    "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                    "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
                    return;
                }
            
            }
            if(!amodif)
            {
                JOptionPane.showMessageDialog(null, "Referencia del articulo no encontrada");
            }
    }
    public Queue<objEmpresa> elimiNAR (Queue<objEmpresa> c)
    {
        while (c.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay articulos ingresados");
            c = Ingresar(c); //para me lleve directamente al metodo llenar y no al menu 
            //return;
        }
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca a eliminar");
        for(objEmpresa bici : c)
        {   
            if(bici.getMarca() == marca)
            {
                c.remove(bici);
                JOptionPane.showMessageDialog(null, "Articulo eliminado");
            }
        }
        return c;
    }
    
}
