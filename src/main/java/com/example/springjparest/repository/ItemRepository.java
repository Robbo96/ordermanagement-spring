package com.example.springjparest.repository;

import com.example.springjparest.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("select itemId from MenuItem where itemName = :iname")
    boolean existsByItemNameEquals(@Param("iname")String item);


}
