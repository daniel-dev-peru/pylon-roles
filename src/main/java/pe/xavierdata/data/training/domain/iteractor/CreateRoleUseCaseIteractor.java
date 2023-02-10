package pe.xavierdata.data.training.domain.iteractor;

import io.smallrye.mutiny.Uni;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import pe.xavierdata.data.training.adapter.input.model.RoleDTO;
import pe.xavierdata.data.training.adapter.output.db.model.AuditEntityDb;
import pe.xavierdata.data.training.adapter.output.db.model.RoleEntityDb;
import pe.xavierdata.data.training.application.convert.UtilConvert;
import pe.xavierdata.data.training.application.error.ApplicationException;
import pe.xavierdata.data.training.application.error.ErrorCategory;
import pe.xavierdata.data.training.domain.port.input.CreateRoleUseCase;
import pe.xavierdata.data.training.domain.port.output.SaveRolePort;
import pe.xavierdata.data.training.entities.Audit;
import pe.xavierdata.data.training.entities.Role;

@ApplicationScoped
@Slf4j
public class CreateRoleUseCaseIteractor implements CreateRoleUseCase {

  @Inject
  UtilConvert utilConvert;

  @Inject
  SaveRolePort saveRolePort;

  @Override
  public Uni<Role> execute(Role r) {
    log.info("execute : {} ", r.getDescription());
    return Uni.createFrom()
            .<Role>emitter((c) -> {

              //RoleEntityDb search = null;
              /*try {
                search = searchByDescription(role);
              } catch (ApplicationException e) {
                log.debug("No exists role " + r.getCompanyId() + "|" + r.getDescription());
              }*/
              /*if (search != null) {
                log.error("Exists role " + r.getDescription());
                throw new ApplicationException(ErrorCategory.DATA_EXISTS);
              }*/

              //RoleEntityDb roleEntityDb = utilConvert.fromRoleDTOToRoleEntityDb(r);

              /*if (null == companyService.get(roleDTO.getCompanyId()).subscribeAsCompletionStage().join()) {
                log.error("Company ruc " + roleDTO.getDescription());
                throw new ApplicationException(ErrorCategory.COMPANY_NOT_EXISTS);
              }*/

              String role_description = "ROLE_" + r.getDescription();
              r.setDescription(role_description);

              Audit audit = new Audit();
              audit.setActive(true);
              audit.setCreated(LocalDateTime.now());

              r.setAudit(audit);

              //log.info("obj transaction id : " + roleEntityDb.id);
              //r.setId(roleEntityDb.id.toString());
              c.complete(r);
            }).<Role>flatMap( saveRolePort::execute );
  }

  /*private RoleEntityDb searchByDescription(RoleDTO roleDTO) {
    log.info("searchByDescription : " + roleDTO.getCompanyId() + "|" + roleDTO.getDescription());
    RoleEntityDb
            search =
            RoleEntityDb.find("{companyId: ?1,description: ?2}", roleDTO.getCompanyId(), roleDTO.getDescription())
                    .firstResult();
    if (search == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_EXISTS);
    }
    return search;
  }*/

}
