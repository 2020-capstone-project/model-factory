package service;

import dto.Column;
import error.FileNotFoundException;
import mapper.ColumnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService {

  @Autowired
  private ColumnMapper mapper;

  public List<Column> selectListByFileId(int id) {
    List<Column> list = mapper.selectListByFileId(id);
    if (list == null || list.size() == 0)
      throw new FileNotFoundException();
    return list;
  }

}
