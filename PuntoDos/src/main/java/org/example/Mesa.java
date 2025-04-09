package org.example;

import java.util.ArrayList;
import java.util.List;

enum PorcentajePropinas {

    DOS_PORCIENTO (0.02), TRES_PORCIENTO (0.03), CINCO_PORCIENTO (0.05);

    private final double valor;

    PorcentajePropinas (double Valor) {
        valor = Valor;
    }

    public double getValor () {
        return valor;
    }
}

public class Mesa {
    private List<ItemMenu> consumos;
    private Tarjeta targetaPago;
    private PorcentajePropinas propinas;
    private boolean pedidoComfirmado = false;
    private RegistroVentas registroVenta;

    public Mesa (RegistroVentas registroVenta) {
        consumos = new ArrayList<> ();
        this.registroVenta=registroVenta;
    }

    public void agregarItem (ItemMenu item) {
        if (pedidoComfirmado) {
            throw new IllegalStateException ("No se pueden agregar items despues de comfirmar el pedido");
        }
        consumos.add (item);
    }

    public void confirmarPedido () {
        pedidoComfirmado = true;
    }

    public void realizarPago (Tarjeta tarjeta, PorcentajePropinas propinas) {
        if (!pedidoComfirmado) {
            throw new IllegalStateException ("Debe confirmar el pedido antes de establecer el pago");
        }
        this.targetaPago = tarjeta;
        this.propinas = propinas;
        registroVenta.registrarVenta (calcularTotal ());
    }

    public double calcularTotal () {
        if (!pedidoComfirmado) {
            throw new IllegalStateException ("Debe confirmar el pedido antes de calcular el costo");
        }
        double totalSinDescuento = 0;
        for (ItemMenu item : consumos) {
            totalSinDescuento += item.getPrecio ();
        }

        double descuento = targetaPago.aplicarDescuento (consumos);
        double totalConDescuento = totalSinDescuento - descuento;
        double propinaMonto = totalConDescuento * propinas.getValor ();

        return totalConDescuento + propinaMonto;
    }

}
