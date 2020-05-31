package service;

import dto.Data;
import error.ColumnNotFoundException;
import mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

  @Autowired
  private DataMapper mapper;

  public List<Data> selectListByColumnId(int id) {
    List<Data> list = mapper.selectListByColumnId(id);
    if (list == null || list.size() == 0)
      throw new ColumnNotFoundException();
    return list;
  }

}
