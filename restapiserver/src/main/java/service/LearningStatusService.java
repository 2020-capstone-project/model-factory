package service;

import dto.GetLearningStatusListResponseDto;
import dto.GetLearningStatusResponseDto;
import error.MemberNotFoundException;
import mapper.LearningStatusMapper;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningStatusService {

  @Autowired
  private LearningStatusMapper learningStatusMapper;
  @Autowired
  private MemberMapper memberMapper;

  public List<GetLearningStatusListResponseDto> selectList(int id) {
    if (memberMapper.selectOneById(id) == null)
      throw new MemberNotFoundException();
    return learningStatusMapper.selectList(id).stream()
        .peek(element -> element.setLearningState(
            element.getLearningProgress() == 100 ? "학습 완료" : "학습중"
        )).collect(Collectors.toList());
  }

  public GetLearningStatusResponseDto selectOne(int memberId, int learningId) {
    if (memberMapper.selectOneById(memberId) == null)
      throw new MemberNotFoundException();
    return new GetLearningStatusResponseDto(
        learningStatusMapper.selectHistoryList(learningId),
        learningStatusMapper.selectHyperparametersAndColumns(learningId));
  }

  public FileSystemResource fileDownload(int memberId, int learningId, HttpServletResponse response) {
    if (memberMapper.selectOneById(memberId) == null)
      throw new MemberNotFoundException();
    File file = new File("/Users/sangminlee/model-factory/restapiserver/src/main/resources/" + learningId
        + "/model.h5");
    response.setContentType("application/h5");
    response.setHeader("Content-Disposition", "attachment; filename=model.h5");

    return new FileSystemResource(file);
  }

}
