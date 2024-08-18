package com.api_rest.java_08_api_rest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_rest.java_08_api_rest.Entities.Producto;
import com.api_rest.java_08_api_rest.Repositories.ProductoRepository;

@RestController
@RequestMapping("/Productos")
public class ProductoController
{
    @Autowired
    private ProductoRepository productoRepository;
    
    @GetMapping
    public List<Producto> ListarProductos()
    {
        return productoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Producto ListarProductoPorId(@PathVariable Long id)
    {
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el Producto con el Id: " + id));
    }
    
    @PostMapping
    public Producto CrearProducto(@RequestBody Producto detalleProducto)
    {
        return productoRepository.save(detalleProducto);
    }
    
    @PutMapping("/{id}")
    public Producto ActualizarProducto(@PathVariable Long id, @RequestBody Producto detalleProducto)
    {
        Producto prod = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el Producto con el Id: " + id));
        
        prod.setNombre(detalleProducto.getNombre());
        prod.setPrecio(detalleProducto.getPrecio());
        return productoRepository.save(prod);
    }
    
    @DeleteMapping("/{id}")
    public String EliminarProducto(@PathVariable Long id)
    {
        Producto prod = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el Producto con el Id: " + id));
        
        productoRepository.delete(prod);
        return "El Producto con el id: " + id + " fue eliminado correctamente . . . ";
    }
}
