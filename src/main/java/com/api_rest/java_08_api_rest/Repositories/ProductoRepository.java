package com.api_rest.java_08_api_rest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api_rest.java_08_api_rest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>
{

}
