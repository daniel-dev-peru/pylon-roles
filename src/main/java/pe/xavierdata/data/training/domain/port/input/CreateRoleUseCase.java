package pe.xavierdata.data.training.domain.port.input;

import io.smallrye.mutiny.Uni;
import pe.xavierdata.data.training.adapter.input.model.RoleDTO;
import pe.xavierdata.data.training.entities.Role;

public interface CreateRoleUseCase {
  Uni<Role> execute(Role r);
}
