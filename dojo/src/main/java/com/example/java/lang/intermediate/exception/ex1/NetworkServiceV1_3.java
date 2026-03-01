package com.example.java.lang.intermediate.exception.ex1;


public class NetworkServiceV1_3 {

    public void sendMessage(String data){
        NetworkClientV1 client = new NetworkClientV1("http://example.com");
        client.initError(data);

        try {
            String connectResult = client.connect();
            if(isError(connectResult)) {
                throw new RuntimeException("[네트워크 오류 발생] 연결 오류 코드: " + connectResult);
            }

            String sendResult = client.send(data);
            if(isError(sendResult)) {
                throw new RuntimeException("[네트워크 오류 발생] 전송 오류 코드: " + sendResult);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            client.disconnect();
        }
    }
    private static boolean isError(String connecResult) {
        return !connecResult.equals("success");
    }
}
