package service;

import dto.PostHistoryRequestDto;
import mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

  private HistoryMapper mapper;

  @Autowired
  public HistoryService(HistoryMapper mapper) {
    this.mapper = mapper;
  }

  public void insert(PostHistoryRequestDto dto) {
    mapper.insert(dto);
  }

}
