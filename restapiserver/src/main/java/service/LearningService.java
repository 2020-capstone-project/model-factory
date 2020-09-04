package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LearningDto;
import dto.MemberDto;
import dto.PostLearningRequestDto;
import dto.ResultByInsertLearningDto;
import error.MemberNotFoundException;
import mapper.LearningMapper;
import mapper.MemberMapper;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LearningService {

  @Autowired
  private LearningMapper learningMapper;
  @Autowired
  private MemberMapper memberMapper;

  public ResultByInsertLearningDto insert(PostLearningRequestDto dto) throws JsonProcessingException, SQLException {
    if(memberMapper.selectOneById(dto.getMemberId()) == null)
      throw new MemberNotFoundException();
    LearningDto learningDto = new LearningDto(dto);
    PGobject input = new PGobject();
    input.setType("json");
    input.setValue(new ObjectMapper().writeValueAsString(dto.getInputColumns()));
    PGobject output = new PGobject();
    output.setType("json");
    output.setValue(new ObjectMapper().writeValueAsString(dto.getOutputColumns()));
    learningMapper.insert(learningDto);
    learningMapper.insertColumns(input, output, learningDto.getId());
    return new ResultByInsertLearningDto(learningDto.getId());
  }

}
