/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author snavgar
 */
public class Carrito {
    private PasarelaDePago pasarelaPago;
    private ArrayList<ProductoVenta> m_carrito;
    
    public Carrito(){
        pasarelaPago=new PasarelaDePago();
        m_carrito= new ArrayList<>();
    }
    
    public void AñadirElemento(Producto producto,int cantidad){
     
      ProductoVenta productoventa= new ProductoVenta(producto.get_id(),producto.get_nombre()
                                                    ,producto.get_descripcion()
                                                    ,producto.Categoria
                                                    ,producto.subCategoria,
                                                    producto.get_precio(),producto.Iva,producto.get_stock(),cantidad);
       m_carrito.add(productoventa);
    }
    public String VerCarrito(){
        StringBuilder sb= new StringBuilder();
        double totalprecio=0.0f;
           sb.append("---Producto-----------Precio Sin iva------Con iva--------Unidades----------TOTAL").append("\n");
       for(ProductoVenta p : m_carrito){
            sb.append(p.toString()).append("\n");
            totalprecio+= ((p.get_precio() + ((p.get_precio() * p.Iva.get_iva()))) * p.unidades);
       }
        sb.append("-----------------------------------------------------").append("\n");
        sb.append("TOTAL: ").append(totalprecio).append("€");
        return sb.toString();
       }
    public void EliminarElemento(int id){
            for (ProductoVenta p : m_carrito)
            {
                if(p.get_id()== id)
                {
                    m_carrito.remove(p);
                }
            }
          
    }
    
    public String ProcesarCompra(String numeroTarjeta){
        /*Si la lista no está vacía*/
                /*Recorrer la lista y calcular el precio total*/
                /*Añadir la lista a las compras totales*/
                /*Restar de la base datos la cantidad de elementos*/
                /*Generar el ticket (ToSTRING)*/
         /*Si todo ha salido bien*/
            /*devuelve la lista que se guardar en la lista de compras del tpv*/
            double totalAcobrar=0;
            for(ProductoVenta pv : m_carrito){
                totalAcobrar+= (pv.get_precio()*(pv.Iva.get_iva()));
            }
            /*Tarjeta a validar*/
            String Tarjeta;
            if(numeroTarjeta.isBlank()|| numeroTarjeta.isEmpty()){
                return "Inserte una tarjeta valida";
            }
            Tarjeta=numeroTarjeta;
            /*Procesa el pago y retira fondos de la tarjeta devuelve true o false si lo consigue*/
            boolean estado=pasarelaPago.ProcesoDePago(totalAcobrar,Tarjeta);
         
            if(estado){
               String ticketResultado=ProcesarTicket();
               this.limpiarLista();
               return ticketResultado;
            }
            else{
                /*INFORMO DEL ERROR DURANTE LA PASARELA DE PAGO*/
                  String resultadoError= "Se ha producido un Error al realizar el cargo";
                  return resultadoError;
                /*VOLVER AL MENU PRINCIPAL*/}
    }
    /*Devuelve el texto con el ticket que debe ser mostrado en el JoptionPane*/
    private String ProcesarTicket(){
                Tpv.VENTASTOTALES+=1;
                Ticket ticket = new Ticket(Tpv.VENTASTOTALES,m_carrito.size());
                for(ProductoVenta p : m_carrito)
                {
                    ticket.AñadirElemento(p);
                }
                ticket.AñadirFecha(LocalDate.now());
                //Añadir metodo devolver string de ticket
                String textoTicket= ticket.toString();
                Tpv.AñadirTicket(ticket);
                return textoTicket;
                
    }
    
     private void limpiarLista(){
    /*Limpia la lista de los productos en el carrito*/
        m_carrito.clear();
    }
    
}
