package com.example.session.springsession;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Getter
@Setter
@Component
//SCOP_SESSION : 객체가 한 세션에서 생명주기를 갖도록 Bean Scope를 session으로 설정
//proxyMode=TARGET_CLASS : Bean Scope를 session으로 설정할 경우에는 proxyMode를 TARGE_CLASS로 설정
//Serializable : 중요한건 객체를 직렬화(Serializable)를 하여 자바 외부 시스템에서도 사용할 수 있도록 Byte 형태로 변환.
// 그 이유는 외부 Redis와 같은 데이터베이스에 세션을 저장할 것이기 때문.
// 외부에 저장하지 않고 애플리케이션 서버 내에 메모리에서 해결할 계획이라면 굳이 직렬화하지 않아도 됨.
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userNm;
}
