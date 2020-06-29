package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LayerDto;
import mapper.LayerMapper;
import org.json.simple.JSONObject;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LayerService {

  @Autowired
  private LayerMapper mapper;

  public void insert(final List<LayerDto> layers, final int modelId) {
    PGobject jsonObject = new PGobject();
    jsonObject.setType("json");
    layers.forEach(layer -> {
      try {
        jsonObject.setValue(new ObjectMapper().writeValueAsString(layer.getInformation()));
      } catch (SQLException | JsonProcessingException throwables) {
        throwables.printStackTrace();
      }
      mapper.insert(
          layer.getNumber(),
          jsonObject,
          modelId);
    });

  }

}
