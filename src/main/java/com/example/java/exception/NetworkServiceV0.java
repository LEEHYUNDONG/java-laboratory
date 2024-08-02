package com.example.java.exception;

/**
 * @author : lhd
 * @packageName : com.example.java.exception
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-06-05         lhd
 */
public class NetworkServiceV0 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV0 networkClientV0 = new NetworkClientV0(address);

        networkClientV0.connect();
        networkClientV0.send(data);
        networkClientV0.disconnect();
    }
}
