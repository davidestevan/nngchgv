package com.sena.modelo;   // Si no usas com.sena, cambia a "package modelo;"

public class Hamburguesa {

    // 1. ATRIBUTOS
    private String nombreCliente;
    private String tipoPan;
    private String tipoCarne;
    private int cantidadCarne;
    private boolean tieneQueso;
    private boolean tieneTocineta;
    private String tamano;
    private double precio;

    // 2. CONSTRUCTOR
    public Hamburguesa(String nombreCliente, String tipoPan, String tipoCarne, int cantidadCarne,
                       boolean tieneQueso, boolean tieneTocineta, String tamano, double precio) {
        setNombreCliente(nombreCliente);
        setTipoPan(tipoPan);
        setTipoCarne(tipoCarne);
        setCantidadCarne(cantidadCarne);
        this.tieneQueso = tieneQueso;
        this.tieneTocineta = tieneTocineta;
        setTamano(tamano);
        setPrecio(precio);
    }

    // 3. GETTERS
    public String getNombreCliente() { return nombreCliente; }
    public String getTipoPan() { return tipoPan; }
    public String getTipoCarne() { return tipoCarne; }
    public int getCantidadCarne() { return cantidadCarne; }
    public boolean isTieneQueso() { return tieneQueso; }
    public boolean isTieneTocineta() { return tieneTocineta; }
    public String getTamano() { return tamano; }
    public double getPrecio() { return precio; }

    // 4. SETTERS CON VALIDACIONES
    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        this.nombreCliente = nombreCliente;
    }

    public void setTipoPan(String tipoPan) {
        if (tipoPan == null || tipoPan.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de pan no puede estar vacío");
        }
        this.tipoPan = tipoPan;
    }

    public void setTipoCarne(String tipoCarne) {
        if (tipoCarne == null || tipoCarne.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de carne no puede estar vacío");
        }
        this.tipoCarne = tipoCarne;
    }

    public void setCantidadCarne(int cantidadCarne) {
        if (cantidadCarne <= 0) {
            throw new IllegalArgumentException("La cantidad de carne debe ser mayor a 0");
        }
        this.cantidadCarne = cantidadCarne;
    }

    public void setTamano(String tamano) {
        if (tamano == null || tamano.trim().isEmpty()) {
            throw new IllegalArgumentException("El tamaño no puede estar vacío");
        }
        String normalizado = tamano.trim().toLowerCase();
        if (!normalizado.equals("pequeña") && !normalizado.equals("mediana") && !normalizado.equals("grande")) {
            throw new IllegalArgumentException("El tamaño debe ser: pequeña, mediana o grande");
        }
        this.tamano = normalizado;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }

    // 5. MÉTODO PARA MOSTRAR INFORMACIÓN
    public void mostrarInformacion() {
        System.out.println("========================================");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Pan: " + tipoPan);
        System.out.println("Carne: " + tipoCarne + " (x" + cantidadCarne + ")");
        System.out.println("Queso: " + (tieneQueso ? "Sí" : "No"));
        System.out.println("Tocineta: " + (tieneTocineta ? "Sí" : "No"));
        System.out.println("Tamaño: " + tamano);
        System.out.println("Precio: $" + precio);
        System.out.println("========================================");
    }
}