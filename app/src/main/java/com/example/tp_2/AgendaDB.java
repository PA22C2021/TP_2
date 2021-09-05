package com.example.tp_2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tp_2.Class.Contacto;
import com.example.tp_2.dao.ContactoDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contacto.class}, version = 1, exportSchema = false)
public abstract class AgendaRoomDatabase extends RoomDatabase {

    public abstract ContactoDAO contactoDAO();

    private static volatile AgendaRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AgendaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgendaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AgendaRoomDatabase.class, "agenda_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}