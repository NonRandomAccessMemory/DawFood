
package DawFoodSV.ClasesFuncionamiento;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class Tpv {
    public static int VENTASTOTALES= 0;
    public static ArrayList<Ticket> Ticket= new ArrayList<>();
    
    /*Añadir numero de serieUNICO*/
    /*Añadir entrada al menu*/
    
    /*Añadir metodo de Añadir ticket*/
    public static void AñadirTicket(Ticket ticket) {
        Ticket.add(ticket);
    }

    public ArrayList<Ticket> BuscarPor(int dia) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (Ticket t : Ticket) {
            if (t.getFecha().getDayOfMonth() == dia) {
                tickets.add(t);
            }
        }
        return tickets;
    }

    public ArrayList<Ticket> BuscarPor(LocalDate fecha) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (Ticket t : Ticket) {
            if (t.getFecha() == fecha) {
                tickets.add(t);
            }
        }
        return tickets;
    }

    public ArrayList<Ticket> todasLasVentas() {
        return (ArrayList<Ticket>) Ticket.clone();
    }

}
