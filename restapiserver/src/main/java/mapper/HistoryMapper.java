package mapper;

import dto.PostHistoryRequestDto;
import org.apache.ibatis.annotations.Insert;

public interface HistoryMapper {

  @Insert("insert into history (trainLoss, trainAccuracy, validationLoss, " +
      "validationAccuracy, createdDate, executedEpoch, learningId) values " +
      "(#{trainLoss}, #{trainAccuracy}, #{valLoss}, " +
      "#{valAccuracy}, now(), #{epochCount}, #{learningId})")
  void insert(PostHistoryRequestDto postHistoryRequestDto);

}
