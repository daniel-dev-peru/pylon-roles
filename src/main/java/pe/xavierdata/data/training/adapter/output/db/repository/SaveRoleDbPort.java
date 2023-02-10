package pe.xavierdata.data.training.adapter.output.db.repository;

import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import pe.xavierdata.data.training.adapter.output.db.model.RoleEntityDb;
import pe.xavierdata.data.training.application.convert.UtilConvert;
import pe.xavierdata.data.training.domain.port.output.SaveRolePort;
import pe.xavierdata.data.training.entities.Role;

@ApplicationScoped
@Slf4j
public class SaveRoleDbPort implements SaveRolePort {

  @Inject
  UtilConvert utilConvert;

  @Override
  public Uni<Role> execute(Role o) {
    return utilConvert.fromRoleToRoleEntityDb(o)
            .persist()
            .map(RoleEntityDb.class::cast)
            .map(r -> {
              Role role = utilConvert.fromRoleEntityDbToRole(r);
              role.setId(r.id.toHexString());
              return role;
            });
  }

}