package pe.xavierdata.data.training.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

  private Audit audit;
  private String id;
  private String companyId;
  private String name;
  private String description;
  private List<String> permissionResourcePathIds;
  private List<String> resourcesPathIds;
  private List<ResourcePath> resourcePaths;
  private List<PermissionResourcePath> permissionResourcePaths;


}
