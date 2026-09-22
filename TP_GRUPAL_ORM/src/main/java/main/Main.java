package main;

import Util.JPAUtil;
import entities.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            // ==========================
            // USUARIO (Auditoría)
            // ==========================
            Usuario admin = new Usuario();
            admin.setUsuario("admin");
            admin.setClave("1234");
            admin.setNombre("Matias");
            admin.setApellido("Soto");

            em.persist(admin);

            // ==========================
            // CONDICIÓN IVA (NUEVO)
            // ==========================
            CondicionIva condicionIva = new CondicionIva();
            condicionIva.setCodigoAfip(1);
            condicionIva.setDenominacion("IVA Responsable Inscripto");

            condicionIva.setFechaAlta(LocalDate.now());
            condicionIva.setFechaModificacion(LocalDate.now());
            condicionIva.setUsuarioCarga(admin);
            condicionIva.setUsuarioModificacion(admin);

            em.persist(condicionIva);

            // ==========================
            // TIPO MONEDA (NUEVO)
            // ==========================
            TipoMoneda tipoMoneda = new TipoMoneda();
            tipoMoneda.setCodigoAfip("PES");
            tipoMoneda.setDenominacion("Pesos Argentinos");
            tipoMoneda.setSimbolo("$");

            tipoMoneda.setFechaAlta(LocalDate.now());
            tipoMoneda.setFechaModificacion(LocalDate.now());
            tipoMoneda.setUsuarioCarga(admin);
            tipoMoneda.setUsuarioModificacion(admin);

            em.persist(tipoMoneda);

            // ==========================
            // PUNTO DE VENTA
            // ==========================
            PuntoVenta puntoVenta = new PuntoVenta();
            puntoVenta.setNumero(1);
            puntoVenta.setDescripcion("Casa Central");
            puntoVenta.setTipoEmision("Manual");
            puntoVenta.setDomicilioComercial("San Martín 123");

            puntoVenta.setFechaAlta(LocalDate.now());
            puntoVenta.setFechaModificacion(LocalDate.now());
            puntoVenta.setUsuarioCarga(admin);
            puntoVenta.setUsuarioModificacion(admin);

            em.persist(puntoVenta);

            // ==========================
            // MARCA
            // ==========================
            Marca marca = new Marca();
            marca.setCodigo(100);
            marca.setDenominacion("Coca Cola");

            marca.setFechaAlta(LocalDate.now());
            marca.setFechaModificacion(LocalDate.now());
            marca.setUsuarioCarga(admin);
            marca.setUsuarioModificacion(admin);

            em.persist(marca);

            // ==========================
            // RUBRO
            // ==========================
            Rubro rubro = new Rubro();
            rubro.setCodigo(10);
            rubro.setDenominacion("Bebidas");

            rubro.setFechaAlta(LocalDate.now());
            rubro.setFechaModificacion(LocalDate.now());
            rubro.setUsuarioCarga(admin);
            rubro.setUsuarioModificacion(admin);

            em.persist(rubro);

            // ==========================
            // ARTÍCULO
            // ==========================
            Articulo articulo = new Articulo();
            articulo.setCodigo("COCA500");
            articulo.setDenominacion("Coca Cola 500 ml");
            articulo.setMarca(marca);
            articulo.setRubro(rubro);

            articulo.setFechaAlta(LocalDate.now());
            articulo.setFechaModificacion(LocalDate.now());
            articulo.setUsuarioCarga(admin);
            articulo.setUsuarioModificacion(admin);

            em.persist(articulo);

            // ==========================
            // LISTA DE PRECIOS
            // ==========================
            ListaPrecio listaPrecio = new ListaPrecio();
            listaPrecio.setCodigo("LP01");
            listaPrecio.setDenominacion("Lista General");

            listaPrecio.setFechaAlta(LocalDate.now());
            listaPrecio.setFechaModificacion(LocalDate.now());
            listaPrecio.setUsuarioCarga(admin);
            listaPrecio.setUsuarioModificacion(admin);

            em.persist(listaPrecio);

            // ==========================
            // LISTA PRECIO ARTÍCULO
            // ==========================
            ListaPrecioArticulo listaPrecioArticulo = new ListaPrecioArticulo();
            listaPrecioArticulo.setListaPrecio(listaPrecio);
            listaPrecioArticulo.setArticulo(articulo);
            listaPrecioArticulo.setPrecioVenta(2500);

            listaPrecioArticulo.setFechaAlta(LocalDate.now());
            listaPrecioArticulo.setFechaModificacion(LocalDate.now());
            listaPrecioArticulo.setUsuarioCarga(admin);
            listaPrecioArticulo.setUsuarioModificacion(admin);

            em.persist(listaPrecioArticulo);

            // ==========================
            // CONTACTO
            // ==========================
            Contacto contacto = new Contacto();
            contacto.setEmail("cliente@gmail.com");
            contacto.setTelefono("2614567890");
            contacto.setCelular("2615555555");

            em.persist(contacto);

            // ==========================
            // DOMICILIO
            // ==========================
            Domicilio domicilio = new Domicilio();
            domicilio.setNombreCalle("Belgrano");
            domicilio.setNumeroCalle("450");

            em.persist(domicilio);

            // ==========================
            // CLIENTE
            // ==========================
            Cliente cliente = new Cliente();
            cliente.setCuitCuil("20-12345678-9");
            cliente.setDenominacion("Juan Pérez");
            cliente.setContacto(contacto);
            cliente.setDomicilio(domicilio);

            cliente.setFechaAlta(LocalDate.now());
            cliente.setFechaModificacion(LocalDate.now());
            cliente.setUsuarioCarga(admin);
            cliente.setUsuarioModificacion(admin);

            em.persist(cliente);

            // ==========================
            // FACTURA CABECERA
            // ==========================
            FacturaVenta factura = new FacturaVenta();

            factura.setNumero(1001L);
            factura.setFechaEmision(LocalDate.now());
            factura.setPuntoVenta(puntoVenta);

            // --- SE ASIGNAN LAS 3 NUEVAS RELACIONES ---
            factura.setCliente(cliente);           // Asignación de Cliente
            factura.setCondicionIva(condicionIva); // Asignación Obligatoria
            factura.setTipoMoneda(tipoMoneda);     // Asignación Obligatoria
            // ------------------------------------------

            factura.setImporteCobrado(5000);
            factura.setImporteSaldo(0);
            factura.setImporteTotal(7500); // Actualizado al total de los 2 detalles

            factura.setCae("12345678901234");
            factura.setCaeFechaVencimiento(LocalDate.now().plusDays(10));

            factura.setResultadoAfip("A");
            factura.setEstado("EMITIDA");
            factura.setObservaciones("Factura de prueba");

            factura.setFechaAlta(LocalDate.now());
            factura.setFechaModificacion(LocalDate.now());
            factura.setUsuarioCarga(admin);
            factura.setUsuarioModificacion(admin);

            // ==========================
            // DETALLE 1
            // ==========================
            FacturaVentaDetalle detalle1 = new FacturaVentaDetalle();

            detalle1.setFactura(factura);
            detalle1.setListaPrecioArticulo(listaPrecioArticulo);
            detalle1.setDescripcion("Coca Cola 500 ml");

            detalle1.setCantidad(2);
            detalle1.setPrecioUnitario(2500);
            detalle1.setPorcentajeBonificacion(0);
            detalle1.setImporteNeto(5000);
            detalle1.setImporteIva(0);
            detalle1.setImporteSubtotal(5000);

            // ==========================
            // DETALLE 2
            // ==========================
            FacturaVentaDetalle detalle2 = new FacturaVentaDetalle();

            detalle2.setFactura(factura);
            detalle2.setListaPrecioArticulo(listaPrecioArticulo);
            detalle2.setDescripcion("Coca Cola 500 ml");

            detalle2.setCantidad(1);
            detalle2.setPrecioUnitario(2500);
            detalle2.setPorcentajeBonificacion(0);
            detalle2.setImporteNeto(2500);
            detalle2.setImporteIva(0);
            detalle2.setImporteSubtotal(2500);

            // Relación bidireccional
            List<FacturaVentaDetalle> detalles = new ArrayList<>();
            detalles.add(detalle1);
            detalles.add(detalle2);

            factura.setDetalles(detalles);

            // ==========================
            // SOLO SE PERSISTE LA FACTURA
            // ==========================
            em.persist(factura); //[cite: 2]

            em.getTransaction().commit(); //[cite: 2]

            System.out.println("==================================");
            System.out.println("FACTURA GUARDADA CORRECTAMENTE");
            System.out.println("Número: " + factura.getNumero());
            System.out.println("Cliente: " + factura.getCliente().getDenominacion());
            System.out.println("Condición IVA: " + factura.getCondicionIva().getDenominacion());
            System.out.println("Moneda: " + factura.getTipoMoneda().getSimbolo());
            System.out.println("Detalles: " + factura.getDetalles().size());
            System.out.println("Importe Total: $" + factura.getImporteTotal());
            System.out.println("==================================");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {

            em.close(); //[cite: 2]
            JPAUtil.close();

        }

    }

}
