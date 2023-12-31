package soft.kr.maple.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // JPA에서 lazy관련 에러 날 경우 사용
@Entity  // 객체와 테이블 매핑
@Table(name = "MEMBER")  // index 없음 (기본 테이블 생성)
public class Member {

    @Id //PK 지정
    @GeneratedValue(strategy = GenerationType.AUTO) //SEQ 정의
    @Column(name="MEMBER_SEQ")
    private Long memberSeq;     //MemberSeq
    
    @Column(unique = true, length=15, name="MEMBER_ID")   //유니크 설정, 길이 15글자 이내
    private String id;  //ID

    @Column(unique = true, length = 18, name="MEMBER_NICKNAME")
    private String nickName;
}
