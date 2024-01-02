package soft.kr.maple.service;

import org.springframework.stereotype.Service;
import soft.kr.maple.mapper.CharterDao;

import java.sql.SQLException;

@Service
public class MemberService {

    CharterDao charterDao = new CharterDao();

    public void charaterFindAll() throws SQLException, ClassNotFoundException {
        charterDao.charaterFindAll();
    }
}
