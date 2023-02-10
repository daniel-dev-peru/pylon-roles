package pe.xavierdata.data.training.domain.iteractor;
/*
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.BackPressureStrategy;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.jboss.logging.Logger;
import pad.xavdat.bas.multi.companies.dto.RoleDTO;
import pad.xavdat.bas.multi.companies.error.ApplicationException;
import pad.xavdat.bas.multi.companies.error.ErrorCategory;
import pad.xavdat.bas.multi.companies.model.AuditEntityDb;
import pad.xavdat.bas.multi.companies.model.security.RoleEntityDb;

@ApplicationScoped
public class ReactiveRoleService {
    private static final Logger LOG = Logger.getLogger(ReactiveRoleService.class);

    @Inject
    ReactiveCompanyService companyService;

    @Inject
    ReactivePermissionResourcePathService permissionResourcePathService;

    @Inject
    ReactiveResourcePathService resourcePathService;

    public Uni<RoleDTO> save(RoleDTO roleDTO, boolean update) {
        LOG.info("save flow : " + update);
        return Uni.createFrom().item(() -> {
            RoleEntityDb search = null;
            try {
                search = searchByDescription(roleDTO);
            } catch (ApplicationException e) {
                LOG.debug("No exists role " + roleDTO.getCompanyId() + "|" + roleDTO.getDescription());
            }
            if (!update) {
                if (search != null) {
                    LOG.error("Exists role " + roleDTO.getDescription());
                    throw new ApplicationException(ErrorCategory.DATA_EXISTS);
                }
            }
            RoleEntityDb roleEntityDb = Util.convertRoleModel(roleDTO);
            if (null != roleDTO.getId()) {
                ObjectId oId = new ObjectId(roleDTO.getId());
                roleEntityDb.id = oId;
            }

            if (null == companyService.get(roleDTO.getCompanyId()).subscribeAsCompletionStage().join()) {
                LOG.error("Company ruc " + roleDTO.getDescription());
                throw new ApplicationException(ErrorCategory.COMPANY_NOT_EXISTS);
            }

            String role = "ROLE_" + roleEntityDb.getDescription();
            roleEntityDb.setDescription(role);
            auditBuild(roleEntityDb, search);
            roleEntityDb.persistOrUpdate();
            LOG.info("obj transaction id : " + roleEntityDb.id);
            roleDTO.setId(roleEntityDb.id.toString());
            return roleDTO;
        });
    }

    private void auditBuild(RoleEntityDb roleEntityDb, RoleEntityDb search) {
        AuditEntityDb audit = null;
        if (search == null) {
            audit = new AuditEntityDb();
            audit.setActive(true);
            audit.setCreated(LocalDateTime.now());
        } else {
            audit = search.getAudit();
            audit.setUpdated(LocalDateTime.now());
        }
        roleEntityDb.setAudit(audit);
    }

    private RoleEntityDb searchByDescription(RoleDTO roleDTO) {
        LOG.info("searchByDescription : " + roleDTO.getCompanyId() + "|" + roleDTO.getDescription());
        RoleEntityDb search = RoleEntityDb.find("{companyId: ?1,description: ?2}", roleDTO.getCompanyId(), roleDTO.getDescription()).firstResult();
        if (search == null) {
            throw new ApplicationException(ErrorCategory.DATA_NOT_EXISTS);
        }
        return search;
    }

    public Uni<RoleDTO> get(String id, boolean detailPath) {
        return Uni.createFrom().item(() ->
                Util.convertRoleDTO(RoleEntityDb.findById(new ObjectId(id)))
            )
            .map(sa -> {
                if(detailPath){
                    sa.setPermissionResourcePaths(permissionResourcePathService.getByRoleDirect(sa.getId()));
                }else{
                    sa.setPermissionResourcePathIds(permissionResourcePathService.getIdsByRole(sa.getId()));
                }
                return sa;
            })
            .map(sa -> {
                if(detailPath){
                    sa.setResourcePaths(resourcePathService.getByRoleDirect(sa.getId()));
                }else{
                    sa.setResourcesPathIds(resourcePathService.getIdsByRole(sa.getId()));
                }
                return sa;
            });
    }

    public Multi<RoleDTO> getByCompany(String id, boolean detailPath) {
        LOG.info("LOG LIST");
        return Multi.createFrom().emitter((s) -> {
            RoleEntityDb
                    .find("companyId", id)
                    .stream()
                    .forEach(a -> {
                        s.emit(a);
                    });
            s.complete();
        }, BackPressureStrategy.BUFFER)
                .map(sa ->
                        Util.convertRoleDTO((RoleEntityDb) sa)
                )
                .map(sa -> {
                    if(detailPath){
                        sa.setPermissionResourcePaths(permissionResourcePathService.getByRoleDirect(sa.getId()));
                    }else{
                        sa.setPermissionResourcePathIds(permissionResourcePathService.getIdsByRole(sa.getId()));
                    }
                    return sa;
                })
                .map(sa -> {
                    if(detailPath){
                        sa.setResourcePaths(resourcePathService.getByRoleDirect(sa.getId()));
                    }else{
                        sa.setResourcesPathIds(resourcePathService.getIdsByRole(sa.getId()));
                    }
                    return sa;
                });
    }
}*/