package com.example.tp_2.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tp_2.Class.Contacto;

import java.util.List;

@Dao
public interface ContactoDAO {
    @Query("SELECT * FROM Contacto")
    List<Contacto> getAll();

    @Insert
    void insertAll(Contacto... contacts);
}
