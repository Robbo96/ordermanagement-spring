package com.example.springjparest.repository;

import com.example.springjparest.entity.MenuOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<MenuOrder,Long> {
}
