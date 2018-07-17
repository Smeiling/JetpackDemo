package com.sml.jetpack.jetpackdemo.cheese.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.sml.jetpack.jetpackdemo.cheese.dao.CheeseDao;
import com.sml.jetpack.jetpackdemo.cheese.entity.Cheese;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Smeiling
 * @Date: 2018/7/1
 * @Description
 */
@Database(entities = Cheese.class, version = 1)
public abstract class CheeseDb extends RoomDatabase {

    private static CheeseDb instance;

    public static CheeseDb get(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CheeseDb.class,
                    "CheeseDatabase")
                    .addCallback(new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            fillInDb(context.getApplicationContext());
                        }
                    }).build();
        }
        return instance;
    }

    public abstract CheeseDao cheeseDao();

    private static void fillInDb(Context context) {
        List<Cheese> cheeses = new ArrayList<>();
        for (int i = 0; i < CHEESE_DATA.length; i++) {
            cheeses.add(new Cheese(i, CHEESE_DATA[i]));
        }
        get(context).cheeseDao().insert(cheeses);
    }

    private static String[] CHEESE_DATA = {
            "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale",
            "Aisy Cendre", "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
            "Ami du Chambertin", "Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro", "Appenzell",
            "Aragon", "Ardi Gasna", "Ardrahan", "Armenian String", "Aromes au Gene de Marc",
            "Asadero", "Asiago", "Aubisque Pyrenees", "Autun", "Avaxtskyr"};

}
