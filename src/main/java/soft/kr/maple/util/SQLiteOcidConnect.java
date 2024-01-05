package soft.kr.maple.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteOcidConnect {

    
    //SQLite 설정 보내기
    public static Connection connectionDB() {

        String DB_URL = "jdbc:sqlite:C:/Users/MHS/Desktop/mapleUnion/db";      //DB 경로 명
        String DATABASE_NAME = "/myMaple.db";         //DATABASE 명

        Connection cn = null;
        try {

            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection(DB_URL+DATABASE_NAME);

            return cn;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }
}
