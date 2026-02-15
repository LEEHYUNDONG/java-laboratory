package com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.api;

import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.AdResponse;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.adapter.in.dto.CreateAdRequest;
import com.easttwave.pr.architecture.hexagonal.ads.management.ad.application.port.in.AdUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "광고 관리", description = "광고 등록, 삭제, 조회 API")
@RestController
@RequestMapping("/api/v1/ads")
public class AdController {

    private final AdUsecase adUsecase;

    public AdController(AdUsecase adUsecase) {
        this.adUsecase = adUsecase;
    }

    @Operation(summary = "광고 등록", description = "새로운 광고를 등록합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping("/register")
    public ResponseEntity<?> createAds(@RequestBody CreateAdRequest request) {
        adUsecase.registerAd(request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "광고 삭제", description = "광고 ID로 광고를 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "광고를 찾을 수 없음")
    })
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteAds(@Parameter(description = "광고 ID") @RequestParam String adId) {
        adUsecase.deleteAd(adId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "전체 광고 조회", description = "등록된 모든 광고를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping
    public ResponseEntity<List<AdResponse>> getAllAds() {
        return ResponseEntity.ok(adUsecase.getAllAds().stream().map(AdResponse::of).toList());
    }

    @Operation(summary = "단일 광고 조회", description = "등록한 단일 광고를 광고 Id로 조회합니다.")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping("/{adId}")
    public ResponseEntity<AdResponse> getAd(@PathVariable Long adId) {
        return ResponseEntity.ok().build();
    }
}
