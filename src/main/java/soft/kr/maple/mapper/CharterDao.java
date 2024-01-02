package soft.kr.maple.mapper;

import soft.kr.maple.util.SQLiteConnect;

import java.sql.*;

/**
 * 캐릭터 정보 조회
 */
public class CharterDao {

    public void charaterFindAll() throws SQLException, ClassNotFoundException {
        Connection cn = SQLiteConnect.connectionDB();

        String sql = "SELECT * FROM TB_CHARACTER";

        PreparedStatement pstm = cn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getInt(1));
        }

    }
}
