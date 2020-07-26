package controller;

import dto.GetLearningStatusListResponseDto;
import dto.GetLearningStatusResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LearningStatusService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class LearningStatusController {

  @Autowired
  private LearningStatusService service;

  @GetMapping("/{id}/learning-status")
  public List<GetLearningStatusListResponseDto> getList(@PathVariable int id) {
    return service.selectList(id);
  }

  // TODO 실행 테스트
  @GetMapping("/{memberId}/learning-status/{learningId}")
  public GetLearningStatusResponseDto getOne(@PathVariable("memberId") int memberId,
                                             @PathVariable("learningId") int learningId) {
    return service.selectOne(memberId, learningId);
  }

}
