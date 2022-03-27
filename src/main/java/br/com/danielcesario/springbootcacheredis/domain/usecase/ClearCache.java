package br.com.danielcesario.springbootcacheredis.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClearCache {

    private final CacheManager cacheManager;

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("ClearCache -------- Start");
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(n -> cacheManager.getCache(n).clear());
        log.info("ClearCache -------- Finish");
    }
}
