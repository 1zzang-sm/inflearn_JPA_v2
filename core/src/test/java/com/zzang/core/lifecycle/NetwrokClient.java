package com.zzang.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetwrokClient {

    private String url;

    public NetwrokClient(){
        System.out.println("생성자 호출 , url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }
   // 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message : " + message);

    }
    // 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init()  {
        System.out.println("NetwrokClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close()  {
        System.out.println("NetwrokClient.close");
        disconnect();
    }
}
