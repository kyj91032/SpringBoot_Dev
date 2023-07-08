package com.example.springboot_dev.Recommend.Repository;

import com.example.springboot_dev.Recommend.Data.RecommendEntity;
import com.example.springboot_dev.Recommend.Data.RecommendId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<RecommendEntity, RecommendId> {

    void deleteById(RecommendId recommendId);


}
