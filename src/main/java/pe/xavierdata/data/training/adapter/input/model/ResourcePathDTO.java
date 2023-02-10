package pe.xavierdata.data.training.adapter.input.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResourcePathDTO {

  private String id;
  private String roleId;
  private String description;
  private int order;
  private String path;
  private String icon;
  private String type;
  private String translate;

}
