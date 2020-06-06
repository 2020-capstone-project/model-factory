package controller;

import client.ClientApi;
import dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.FileService;
import service.LayerService;
import service.LearningService;
import service.ModelService;

import javax.validation.Valid;

@RestController
public class LearningController {

  @Autowired
  private LearningService learningService;
  @Autowired
  private ModelService modelService;
  @Autowired
  private LayerService layerService;
  @Autowired
  private FileService fileService;
  @Autowired
  private ClientApi clientApi;

  @PostMapping("/learning")
  // @Transactional
  public ResultByInsertLearningDto postLearning(@RequestBody @Valid PostLearningRequestDto dto) {
    ResultByInsertLearningDto resultByInsertLearningDto
        = learningService.insert(new LearningDto(dto));
    ModelDto modelDto = new ModelDto(resultByInsertLearningDto);
    modelService.insert(modelDto);
    layerService.insert(dto.getLayers(), modelDto.getId());
    clientApi.postLearningToFlask(
        new PostLearningToFlaskDto(
            fileService.selectPathById(dto.getFileId()), modelDto, dto));
    return resultByInsertLearningDto;
  }

}
