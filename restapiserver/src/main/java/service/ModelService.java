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

  public void insert(ModelDto modelDto) {
      mapper.insert(modelDto);
  }

}
