/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.ohana;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 57301
 */
@Entity
@Table(name = "ventas")
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentas")
    private Integer idVentas;
    @Column(name = "cantidadProducto")
    private Integer cantidadProducto;
    @Column(name = "valorUnitario")
    private Integer valorUnitario;
    @Column(name = "valorTotal")
    private Integer valorTotal;
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Column(name = "numeroDeCompra")
    private Integer numeroDeCompra;
    @OneToMany(mappedBy = "idVentas", fetch = FetchType.LAZY)
    private Collection<Recibos> recibosCollection;
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administradores idAdministrador;
    @JoinColumn(name = "idCliente", referencedColumnName = "idClientes")
    @ManyToOne(fetch = FetchType.LAZY)
    private Clientes idCliente;
    @JoinColumn(name = "idEstadoDeEnvios", referencedColumnName = "idEstadoDeEnvios")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estadodeenvios idEstadoDeEnvios;
    @JoinColumn(name = "idMediosDePago", referencedColumnName = "idMediosDePago")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mediosdepago idMediosDePago;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Productos idProducto;
    @OneToMany(mappedBy = "idVentas", fetch = FetchType.LAZY)
    private Collection<Inventario> inventarioCollection;

    public Ventas() {
    }

    public Ventas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getNumeroDeCompra() {
        return numeroDeCompra;
    }

    public void setNumeroDeCompra(Integer numeroDeCompra) {
        this.numeroDeCompra = numeroDeCompra;
    }

    public Collection<Recibos> getRecibosCollection() {
        return recibosCollection;
    }

    public void setRecibosCollection(Collection<Recibos> recibosCollection) {
        this.recibosCollection = recibosCollection;
    }

    public Administradores getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Administradores idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Estadodeenvios getIdEstadoDeEnvios() {
        return idEstadoDeEnvios;
    }

    public void setIdEstadoDeEnvios(Estadodeenvios idEstadoDeEnvios) {
        this.idEstadoDeEnvios = idEstadoDeEnvios;
    }

    public Mediosdepago getIdMediosDePago() {
        return idMediosDePago;
    }

    public void setIdMediosDePago(Mediosdepago idMediosDePago) {
        this.idMediosDePago = idMediosDePago;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.ohana.Ventas[ idVentas=" + idVentas + " ]";
    }
    
}
