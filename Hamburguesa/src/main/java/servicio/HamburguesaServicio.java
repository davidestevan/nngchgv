package com.sena.servicio;   // Si no usas com.sena, cambia a "package servicio;"

import com.sena.modelo.Hamburguesa;   // O "import modelo.Hamburguesa;"
import java.util.ArrayList;

public class HamburguesaServicio {

    private ArrayList<Hamburguesa> pedidos;

    // Constructor
    public HamburguesaServicio() {
        pedidos = new ArrayList<>();
    }

    // 1. Registrar un nuevo pedido
    public void registrarPedido(Hamburguesa hamburguesa) {
        pedidos.add(hamburguesa);
        System.out.println("✅ Pedido registrado para: " + hamburguesa.getNombreCliente());
    }

    // 2. Listar todos los pedidos
    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("📭 No hay pedidos registrados.");
            return;
        }
        System.out.println("\n=== LISTA DE PEDIDOS ===");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("\n🔹 Pedido #" + (i + 1));
            pedidos.get(i).mostrarInformacion();
        }
    }

    // 3. Buscar pedido por nombre del cliente (devuelve el índice, privado)
    private int buscarIndicePorCliente(String nombre) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getNombreCliente().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // 4. Mostrar un pedido específico
    public void mostrarPedido(String nombreCliente) {
        int indice = buscarIndicePorCliente(nombreCliente);
        if (indice == -1) {
            System.out.println("❌ No se encontró un pedido para: " + nombreCliente);
        } else {
            pedidos.get(indice).mostrarInformacion();
        }
    }

    // 5. Actualizar un pedido existente
    public void actualizarPedido(String nombreCliente, Hamburguesa nuevosDatos) {
        int indice = buscarIndicePorCliente(nombreCliente);
        if (indice == -1) {
            System.out.println("❌ No se encontró un pedido para: " + nombreCliente);
            return;
        }
        pedidos.set(indice, nuevosDatos);
        System.out.println("✅ Pedido actualizado para: " + nombreCliente);
    }

    // 6. Eliminar un pedido
    public void eliminarPedido(String nombreCliente) {
        int indice = buscarIndicePorCliente(nombreCliente);
        if (indice == -1) {
            System.out.println("❌ No se encontró un pedido para: " + nombreCliente);
            return;
        }
        pedidos.remove(indice);
        System.out.println("🗑️ Pedido eliminado para: " + nombreCliente);
    }

    // 7. Contar total de pedidos
    public int totalPedidos() {
        return pedidos.size();
    }
}