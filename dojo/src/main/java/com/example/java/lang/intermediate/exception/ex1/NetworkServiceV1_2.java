package com.example.java.lang.intermediate.exception.ex1;

public class NetworkServiceV1_2 {
    public void sendMessage(String data){
        NetworkClientV1 client = new NetworkClientV1("http://example.com");
        client.initError(data);

        String connectResult = client.connect();
        if(isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
            return;
        }

        String sendResuilt = client.send(data);
        if(isError(sendResuilt)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResuilt);
            return;
        }
        client.disconnect();
    }

    private static boolean isError(String connecResult) {
        return !connecResult.equals("success");
    }
}
