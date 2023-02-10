package pe.xavierdata.data.training.application.convert;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pe.xavierdata.data.training.adapter.input.model.RoleDTO;
import pe.xavierdata.data.training.adapter.output.db.model.RoleEntityDb;
import pe.xavierdata.data.training.entities.Role;


@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UtilConvert {

  Role fromRoleDTOToRole(RoleDTO d);

  @Mapping(target = "id", ignore = true)
  RoleEntityDb fromRoleToRoleEntityDb(Role o);

  @Mapping(target = "id", ignore = true)
  Role fromRoleEntityDbToRole(RoleEntityDb r);


  // RoleDTO fromRoleToRoleDTO(Role d);

  //@Mapping(target = "id", ignore = true)
  // RoleEntityDb fromRoleDTOToRoleEntityDb(RoleDTO r);

  /*@Mapping(target = "id", ignore = true)
  FileDataTrainRest fromFileDataTrainRestToFileDataTrain(FileDataTrain d);*/


}