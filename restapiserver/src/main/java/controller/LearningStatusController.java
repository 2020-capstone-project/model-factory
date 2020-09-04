package controller;

import client.ClientApi;
import dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import service.LearningStatusService;
import service.ModelService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/members")
public class LearningStatusController {

  @Autowired
  private LearningStatusService learningStatusService;
  @Autowired
  private ModelService modelService;
  @Autowired
  private ClientApi clientApi;

  @GetMapping("/{id}/learning-status")
  public List<GetLearningStatusListResponseDto> getList(@PathVariable int id) {
    return learningStatusService.selectList(id);
  }

  @GetMapping("/{memberId}/learning-status/{learningId}")
  public GetLearningStatusResponseDto getOne(@PathVariable("memberId") int memberId,
                                             @PathVariable("learningId") int learningId) {
    return learningStatusService.selectOne(memberId, learningId);
  }

  @GetMapping("/{memberId}/learning-status/{learningId}/download")
  @ResponseBody
  public FileSystemResource fileDownload(@PathVariable("memberId") int memberId,
                                         @PathVariable("learningId") int learningId,
                                         HttpServletResponse response) {
    return learningStatusService.fileDownload(memberId, learningId, response);
  }

  @PostMapping("/{memberId}/learning-status/{learningId}/test")
  public PostTestResponseByFlask postTest(@PathVariable("learningId") int learningId, @RequestBody PostTestDto dto) {
    ModelDto modelDto = modelService.selectOneByLearningId(learningId);
    return clientApi.postTestToFlask(new PostTestToFlaskDto(modelDto.getModelPath(), dto.getValues()));
  }

}
