package service;

import dto.ColumnAndDataDto;
import dto.ColumnDto;
import error.FileNotFoundException;
import mapper.ColumnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ColumnService {

  @Autowired
  private ColumnMapper mapper;

  public List<ColumnDto> selectListByFileId(int id) {
    List<ColumnDto> list = mapper.selectListByFileId(id);
    if (list == null || list.size() == 0)
      throw new FileNotFoundException();
    return list;
  }

  public List<ColumnAndDataDto> insertColumns(List<List<String>> records, int fileId) {
    List<ColumnAndDataDto> list = createDto(records, fileId);
    list.forEach(element -> mapper.insert(element));
    System.out.println(list);
    return list;
  }

  private List<ColumnAndDataDto> createDto(List<List<String>> records, int fileId) {
    List<ColumnAndDataDto> columnAndDataList = new ArrayList<>();
    List<String> nameList = records.get(0);
    List<String> descriptionList = records.get(1);
    List<String> data1 = records.get(2);
    List<String> data2 = records.get(3);
    List<String> data3 = records.get(4);
    for (int i = 0; i < records.get(0).size(); i++) {
      columnAndDataList.add(ColumnAndDataDto.builder()
          .fileId(fileId)
          .name(nameList.get(i))
          .description(descriptionList.get(i))
          .value(Arrays.asList(data1.get(i), data2.get(i), data3.get(i)))
          .build());
    }
    return columnAndDataList;
  }


}
