package org.example;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args) {
        //registro con archivos
        RegistroVentas Archivo = new Resibo ("ARCHIVO.txt");

        //registro con base de datos
        Connection conexion = conexionABDD.coneccion();
        RegistroVentas BDD_Archivo = new BDDRegistroVenta (conexion);

        Mesa mesa = new Mesa (Archivo);
        ItemMenu bebida1 = new ItemMenu ("Coca Cola", 30, TipoItem.BEBIDA);
        ItemMenu plato1 = new ItemMenu ("Papas Fritas", 50, TipoItem.PLATO_PRINCIPAL);
        ItemMenu bebida2 = new ItemMenu ("Pepsi", 20, TipoItem.BEBIDA);
        ItemMenu plato2 = new ItemMenu ("Milanesa de pollo", 70, TipoItem.PLATO_PRINCIPAL);

        mesa.agregarItem (bebida1);
        mesa.agregarItem (plato1);
        mesa.agregarItem (bebida2);
        mesa.confirmarPedido ();
        mesa.realizarPago (new Visa (), PorcentajePropinas.TRES_PORCIENTO);


    }
}