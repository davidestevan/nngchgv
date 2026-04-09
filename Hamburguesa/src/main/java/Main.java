package com.sena;

import com.sena.modelo.Hamburguesa;
import com.sena.servicio.HamburguesaServicio;

public class Main {
    public static void main(String[] args) {
        HamburguesaServicio servicio = new HamburguesaServicio();

        Hamburguesa h1 = new Hamburguesa("Carlos", "Arabe", "Res", 1, true, false, "mediana", 18000);
        servicio.registrarPedido(h1);

        servicio.listarPedidos();
    }
}