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
@Table(name = "TB_MEMBER")  // index 없음 (기본 테이블 생성)
@SequenceGenerator(name="SEQ_MEMBER", allocationSize = 1)
public class Member {

    
    //PK 설정, 자동 SEQ 설정
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER")
    @Column(name="MEMBER_SEQ")
    private Long id;    //ID 설정

    @Column(name="MEMBER_PASSWORD", length=64, nullable = false)
    private String password;

    @Column(name="MEMBER_NAME", unique = true, length=18)
    private String name;


}