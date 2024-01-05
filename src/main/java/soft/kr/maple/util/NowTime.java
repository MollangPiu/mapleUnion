package soft.kr.maple.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NowTime {


    /**
     * 어제 시간 불러오기
     * @return
     */
    public static String yesterdayNow() {

        DateTimeFormatter ymdFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate today = LocalDate.now();
        today = today.minusDays(1);

        return String.valueOf(today);
    }

    /**
     * 오늘 날짜 저장하기
     * @return
     */
    public static String toDayNow() {

        DateTimeFormatter ymdFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate today = LocalDate.now();

        return String.valueOf(today);
    }

}
