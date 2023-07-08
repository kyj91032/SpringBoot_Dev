package com.example.springboot_dev.Recommend;

import com.example.springboot_dev.Board.Data.BoardEntity;
import com.example.springboot_dev.Board.Repository.BoardRepository;
import com.example.springboot_dev.Recommend.Data.RecommendEntity;
import com.example.springboot_dev.Recommend.Data.RecommendId;
import com.example.springboot_dev.Recommend.Data.RecommendRequestDTO;
import com.example.springboot_dev.Recommend.Repository.RecommendRepository;
import com.example.springboot_dev.User.Data.UserEntity;
import com.example.springboot_dev.User.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RecommendService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final RecommendRepository recommendRepository;

    public void saveRecommend(RecommendRequestDTO recommendRequestDTO) {
        Optional<UserEntity> user = userRepository.findById(recommendRequestDTO.getUid());
        Optional<BoardEntity> board = boardRepository.findById(recommendRequestDTO.getBid());

        if(user.isPresent() && board.isPresent()) {
            RecommendEntity recommendEntity = new RecommendEntity(
                    user.get(),
                    board.get()
            );
            recommendRepository.save(recommendEntity);
        }
    }

    public void deleteRecommend(Long uid, Long bid) {
        RecommendId recommendId = new RecommendId(uid, bid);
        recommendRepository.deleteById(recommendId);

    }

}
