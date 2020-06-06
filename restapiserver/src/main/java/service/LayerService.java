package service;

import dto.LayerDto;
import mapper.LayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayerService {

  @Autowired
  private LayerMapper mapper;

  public void insert(final List<LayerDto> layers, final int modelId) {
    layers.forEach(layer ->
        mapper.insert(
            layer.getNumber(),
            layer.getActivationFunction(),
            layer.getNeuronCount(),
            modelId));
  }

}
