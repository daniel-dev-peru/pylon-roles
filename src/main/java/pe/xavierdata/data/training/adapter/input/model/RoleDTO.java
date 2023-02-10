package pe.xavierdata.data.training.adapter.input.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {

  private String id;
  private String companyId;
  private String name;
  private String description;
  private List<String> permissionResourcePathIds;
  private List<String> resourcesPathIds;
  private List<ResourcePathDTO> resourcePaths;
  private List<PermissionResourcePathDTO> permissionResourcePaths;

}
