package com.easttwave.pr.architecture.hexagonal.ads.serving.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceInfo {

    private String deviceId;            // ADID, IDFA

    private String os;                  // iOS, Android, Web

    private String appVersion;

    private ScreenSize screenSize;

}
