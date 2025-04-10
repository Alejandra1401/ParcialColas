import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;
//Alejandra Reyes Diaz 
public class principal 
{
    public int Menu()
    {
        String input;
        int vrUsu = 0; 
        boolean validInput = false;
        do 
        {
            input = JOptionPane.showInputDialog("        MENU\n" +
                                                "1: Ingrese articulos\n" +
                                                "2: Venta de articulos \n" +
                                                "3: Modificar articulos\n" +
                                                "4: Eliminar articulos\n" + 
                                                "5: Salir\n" );
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 5) 
                {
                    validInput = true;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }

        } while (!validInput);

        return vrUsu;
    }
    public static void main(String[] args) 
    {
        Queue<objEmpresa> cola = new LinkedList<>();
        int opc;
        do 
        {
            metodos m = new metodos();
            principal p = new principal();
            opc = p.Menu();
            switch (opc) 
            {
                case 1:
                    cola = m.Ingresar(cola);
                    break;
                case 2:
                    m.vender(cola);
                    break;
                case 3:
                    m.modificar(cola, opc);
                    break;
                case 4:
                    cola = m.elimiNAR(cola);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "BYE");
                    break;
            }
            
        } while (opc != 5);
    }
    
}
