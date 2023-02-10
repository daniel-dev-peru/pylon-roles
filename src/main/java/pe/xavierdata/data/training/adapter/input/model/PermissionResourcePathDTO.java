package pe.xavierdata.data.training.adapter.input.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionResourcePathDTO {

  private String id;
  private String roleId;
  private String pathPattern;
  private List<String> scopes;
  private String expressionPermission;
  private int order;

}
