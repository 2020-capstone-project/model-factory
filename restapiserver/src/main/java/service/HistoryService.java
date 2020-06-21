package service;

import dto.PostHistoryRequestDto;
import mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

  @Autowired
  private HistoryMapper mapper;

  public void insert(PostHistoryRequestDto dto) {
    mapper.insert(dto);
  }

}
