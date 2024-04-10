package com.springBootCache.cacheConfig;

import com.springBootCache.model.Student;
import com.springBootCache.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Objects;

@Configuration
@EnableCaching
@EnableScheduling
public class StudentCacheConfig {
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void preLoadCache(){
        Cache cache = cacheManager.getCache("applicationCache");
        System.out.println("========initializing the cache ========= ");
        List<Student> stdList = studentService.getAll();
        for (Student student: stdList){
            cache.put(student.getId(),student);
        }
    }

    /**
     * This method help us to removed data form cache after period of time
     */
    @Scheduled(fixedRate = 15000,initialDelay = 15000)
    public void clearCache(){
        System.out.println("cache is clear -------");
        cacheManager.getCacheNames().parallelStream().forEach(
                name-> Objects.requireNonNull(cacheManager.getCache(name)).clear()
        );
    }

}
