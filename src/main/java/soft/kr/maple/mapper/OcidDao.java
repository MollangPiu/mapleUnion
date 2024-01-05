package soft.kr.maple.mapper;

import soft.kr.maple.util.NowTime;
import soft.kr.maple.util.SQLiteOcidConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OcidDao {

    public int maxInt() throws SQLException {
        int cnt = 0;
        Connection cn = SQLiteOcidConnect.connectionDB();
        String sql = "SELECT IFNULL(MAX(IDX)+1, 0) AS CNT FROM TB_OCID";
        PreparedStatement pstm = cn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        if(rs.next()) {
            cnt = Integer.parseInt(rs.getString("CNT"));
        }

        rs.close();
        pstm.close();
        cn.close();

        return cnt;
    }

    public void regist(int idx, String ocid) throws SQLException {
        Connection cn = SQLiteOcidConnect.connectionDB();

        String sql = "INSERT INTO TB_OCID (IDX, OCID, FIRSTDATE) VALUES (?, ?, ?)";

        PreparedStatement pstm = cn.prepareStatement(sql);
        pstm.setString(1, String.valueOf(idx));
        pstm.setString(2, ocid);
        pstm.setString(3, NowTime.toDayNow());

        if(0 != pstm.executeUpdate()) {
            System.out.println("test");
        }

        pstm.close();
        cn.close();
    }

}
