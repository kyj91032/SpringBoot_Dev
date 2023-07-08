package com.example.springboot_dev.Recommend;

import com.example.springboot_dev.Recommend.Data.RecommendRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recommend")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;

    @PostMapping(value = "/inc") // recommend++
    public void saveRecommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        recommendService.saveRecommend(recommendRequestDTO);
    }

    @DeleteMapping(value = "/dec/{uid}/{bid}") // recommend--
    public void deleteRecommend(@PathVariable("uid") Long uid, @PathVariable("bid") Long bid) {
        recommendService.deleteRecommend(uid, bid);
    }

}
