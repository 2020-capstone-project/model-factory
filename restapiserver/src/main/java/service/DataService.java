package service;

import dto.ColumnAndDataDto;
import dto.DataDto;
import error.ColumnNotFoundException;
import mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

  @Autowired
  private DataMapper mapper;

  public List<DataDto> selectListByColumnId(int id) {
    List<DataDto> list = mapper.selectListByColumnId(id);
    if (list == null || list.size() == 0)
      throw new ColumnNotFoundException();
    return list;
  }

  public void insertData(List<ColumnAndDataDto> columnAndDataList) {
    columnAndDataList
        .forEach(element -> element.getValue()
            .forEach(
                value -> mapper.insert(value, element.getId())));
  }

}
