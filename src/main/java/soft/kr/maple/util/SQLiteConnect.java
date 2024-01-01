package soft.kr.maple.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SQLiteConnect {

    
    //SQLite 설정 보내기
    public static Connection ConnectionDB() {

        String DB_URL = "C:\\Users\\MHS\\Desktop\\mapleUnion\\db";      //DB 경로 명
        String DATABASE_NAME = "maple";         //DATABASE 명

        Connection ct = null;
        try {

            Class.forName("org.sqlite.JDBC");
            ct = DriverManager.getConnection("jdbc:sqllite:"+DB_URL+"/"+DATABASE_NAME);

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return ct;
    }
}
