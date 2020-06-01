package service;

import dto.LearningDto;
import dto.MemberDto;
import dto.ResultByInsertLearningDto;
import error.MemberNotFoundException;
import mapper.LearningMapper;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningService {

  @Autowired
  private LearningMapper learningMapper;
  @Autowired
  private MemberMapper memberMapper;

  public ResultByInsertLearningDto insert(LearningDto learningDto) {
    if(memberMapper.selectOneById(learningDto.getMemberId()) == null)
      throw new MemberNotFoundException();
    learningMapper.insert(learningDto);
    return new ResultByInsertLearningDto(learningDto.getId());
  }

}
