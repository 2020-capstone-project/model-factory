package service;

import dto.ModelDto;
import mapper.LearningMapper;
import mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

  @Autowired
  private ModelMapper mapper;
  private static final String RESOURCE_PATH = "/Users/sangminlee/model-factory/restapiserver/src/main/resources";

  public void insert(ModelDto modelDto) {
    int learningId = modelDto.getLearningId();
    modelDto.setModelPath(getModelPath(learningId));
    mapper.insert(modelDto);
  }

  public ModelDto selectOneByLearningId(int learningId) {
    return mapper.selectOneByLearningId(learningId);
  }

  private String getModelPath(int learningId) {
    return RESOURCE_PATH + "/" + learningId + "/model.h5";
  }


}
