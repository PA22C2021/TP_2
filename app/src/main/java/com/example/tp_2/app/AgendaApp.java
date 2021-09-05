package com.example.tp_2.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.dao.ContactoDAO;

@Database(entities = {Contacto.class}, version = 1)
public abstract class AgendaApp extends RoomDatabase {
    public abstract ContactoDAO userDao();
}
