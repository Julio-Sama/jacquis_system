package com.jacquis.jacquis_system.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String medio_pago;
    private String tipo_cliente;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> venta;


    public Cliente() {
    }

    public Cliente(String medio_pago, String tipo_cliente) {
        this.medio_pago = medio_pago;
        this.tipo_cliente = tipo_cliente;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }


    

}
