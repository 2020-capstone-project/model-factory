package controller;

import dto.GetLearningStatusListResponseDto;
import dto.GetLearningStatusResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import service.LearningStatusService;

import javax.servlet.http.HttpServletResponse;
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

  @GetMapping("/{memberId}/learning-status/{learningId}")
  public GetLearningStatusResponseDto getOne(@PathVariable("memberId") int memberId,
                                             @PathVariable("learningId") int learningId) {
    return service.selectOne(memberId, learningId);
  }

  @GetMapping("/{memberId}/learning-status/{learningId}/download")
  @ResponseBody
  public FileSystemResource fileDownload(@PathVariable("memberId") int memberId,
                                         @PathVariable("learningId") int learningId,
                                         HttpServletResponse response) {
    return service.fileDownload(memberId, learningId, response);
  }

}
