package pe.xavierdata.data.training.adapter.output.db.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

@MongoEntity(collection = "role")
@Getter
@Setter
public class RoleEntityDb extends ReactivePanacheMongoEntity {

  private String companyId;
  private String name;
  private String description;
  //private List<String> resourcesPathIds;
  private AuditEntityDb audit;

}
