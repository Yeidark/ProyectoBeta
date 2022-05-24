/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexander.controlador;

import com.alexander.modelo.Carrito;
import com.alexander.modelo.Cliente;
import com.alexander.modelo.Compra;
import com.alexander.modelo.CompraDAO;
import com.alexander.modelo.Pago;
import com.alexander.modelo.Producto;
import com.alexander.modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    ProductoDAO pdao = new ProductoDAO();
    Producto pro = new Producto();
    List<Producto> producto = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalaPagar = 0.0;
    int cantidad = 1;
    int idpro;
    Carrito car;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        producto = pdao.listar();
        switch (accion) {
            case "Comprar":
                totalaPagar = 0;
                idpro = Integer.parseInt(request.getParameter("id"));
                pro = pdao.listarId(idpro);

                item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setIdProducto(pro.getId());
                car.setNombres(pro.getNombres());
                car.setDescripcion(pro.getDescripcion());
                car.setPrecioCompra(pro.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * pro.getPrecio());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalaPagar = totalaPagar + listaCarrito.get(i).getSubTotal();

                }
                request.setAttribute("totalaPagar", totalaPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Cliente/ClienteCarritocompras.xhtml").forward(request, response);

                break;

            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idpro = Integer.parseInt(request.getParameter("id"));
                pro = pdao.listarId(idpro);
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idpro == listaCarrito.get(i).getIdProducto()) {
                            pos = i;
                        }
                    }
                    if (idpro == listaCarrito.get(pos).getIdProducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subTotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subTotal);
                    } else {
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(pro.getId());
                        car.setNombres(pro.getNombres());
                        car.setDescripcion(pro.getDescripcion());
                        car.setPrecioCompra(pro.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * pro.getPrecio());
                        listaCarrito.add(car);
                    }
                } else {
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(pro.getId());
                    car.setNombres(pro.getNombres());
                    car.setDescripcion(pro.getDescripcion());
                    car.setPrecioCompra(pro.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * pro.getPrecio());
                    listaCarrito.add(car);
                }

                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("controlador?accion=home").forward(request, response);

                break;
                
            case "Delete" :
                int idproducto = Integer.parseInt(request.getParameter("idpro"));
                for(int i = 0; i < listaCarrito.size(); i++){
                    if(listaCarrito.get(i).getIdProducto()==idproducto){
                        listaCarrito.remove(i);
                    }
                }
                break;
                
            case "Carrito":
                totalaPagar = 0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalaPagar = totalaPagar + listaCarrito.get(i).getSubTotal();

                }
                request.setAttribute("totalaPagar", totalaPagar);
                request.getRequestDispatcher("Cliente/ClienteCarritocompras.xhtml").forward(request, response);

                break;
            

            default:
                request.setAttribute("producto", producto);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
