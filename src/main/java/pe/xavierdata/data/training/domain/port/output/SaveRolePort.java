package pe.xavierdata.data.training.domain.port.output;

import io.smallrye.mutiny.Uni;
import pe.xavierdata.data.training.entities.Role;

public interface SaveRolePort {

  Uni<Role> execute(Role o);

}
