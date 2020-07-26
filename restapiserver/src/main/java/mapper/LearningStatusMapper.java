package mapper;

import dto.GetLearningStatusListResponseDto;
import dto.GetLearningStatusResponseDto;
import dto.HistoryDto;
import dto.HyperparameterDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LearningStatusMapper {

  @Select("select l.id, l.name, l.learningDate \"learningDate\", " +
      "round(h.executedEpoch * 1.0 / l.epoch * 100) \"learningProgress\", " +
      "round((h.validationAccuracy * 100)::numeric, 2) \"accuracy\" " +
      "from learning l, history h " +
      "where l.id = h.learningId and l.memberId = #{id} " +
      "and h.createdDate in (" +
      "select max(createdDate) " +
      "from history " +
      "group by learningId)")
  List<GetLearningStatusListResponseDto> selectList(@Param("id") int id);

  @Select("select trainLoss, trainAccuracy, validationLoss, validationAccuracy " +
      "from history " +
      "where learningId = #{learningId} " +
      "order by executedEpoch")
  List<HistoryDto> selectHistoryList(@Param("learningId") int id);

  @Select("select epoch, batchSize, lossFunction, optimizerFunction " +
      "from learning " +
      "where id = #{learningId}")
  HyperparameterDto selectHyperparameters(@Param("learningId") int id);

}
