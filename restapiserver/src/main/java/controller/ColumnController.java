package controller;

import dto.Column;
import dto.GetColumnAndDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ColumnService;
import service.DataService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ColumnController {

  @Autowired
  private ColumnService columnService;
  @Autowired
  private DataService dataService;

  @GetMapping("/files/{fileId}/columns")
  public List<GetColumnAndDataRequest> getColumnAndData(@PathVariable int fileId) {
    List<Column> columnList = columnService.selectListByFileId(fileId);
    return columnList.stream()
        .map(element -> new GetColumnAndDataRequest(
            element.getName(),
            element.getDescription(),
            dataService.selectListByColumnId(element.getId())
        ))
        .collect(Collectors.toList());
  }

}
