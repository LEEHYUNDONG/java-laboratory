package com.easttwave.pr.architecture.layered.service;

import com.easttwave.pr.architecture.hexagonal.ads.serving.adapter.in.dto.ServableAdsRequest;
import com.easttwave.pr.architecture.hexagonal.ads.serving.domain.ServableAd;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServableAdService {
    // redis에 직접 의존 -> local cache로 변경할때 문제가 발생할 수 있다.
    private final RedisTemplate<String, ServableAd> redisTemplate;

    // JPA 직접 의존 x DIP를 통해 Impl을 주입받아 Service와 동일한 레벨에서 servableAdJpaRepository에 접근한다.
    private final ServableAdRepository servableAdRepository;

    public List<ServableAd> getServableAds(ServableAdsRequest request) {
        String key = "servable-ad";

        // local cache 조회 - Caffeine

        // 캐시 로직이 서비스에 직접 존재
        List<ServableAd> cached = redisTemplate.opsForSet().pop(key, request.size());
        if (cached != null) {
            return cached;
        }

        // DB 조회
        List<ServableAd> servableAds = servableAdRepository.findAll()
                .stream()
                .map(ServableAd::of)
                .toList();

        // 캐시 저장 - 하나의 예시일뿐
        redisTemplate.opsForSet().add(key, servableAds.toArray(new ServableAd[0]));

        return servableAds;
    }
}
