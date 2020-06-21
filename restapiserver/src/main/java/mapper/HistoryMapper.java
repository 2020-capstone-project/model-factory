package mapper;

import dto.PostHistoryRequestDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface HistoryMapper {

  @Insert("insert into history (trainLoss, trainAccuracy, verificationLoss, " +
      "verificationAccuracy, createdDate, executedEpoch, learningId) values " +
      "(#{trainLoss}, #{trainAccuracy}, #{valLoss}, " +
      "#{valAccuracy}, now(), #{epochCount}, #{learningId})")
  void insert(PostHistoryRequestDto postHistoryRequestDto);

}
