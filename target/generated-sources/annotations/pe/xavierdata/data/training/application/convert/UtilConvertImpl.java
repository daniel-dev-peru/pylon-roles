package pe.xavierdata.data.training.application.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import pe.xavierdata.data.training.adapter.input.model.PermissionResourcePathDTO;
import pe.xavierdata.data.training.adapter.input.model.ResourcePathDTO;
import pe.xavierdata.data.training.adapter.input.model.RoleDTO;
import pe.xavierdata.data.training.adapter.output.db.model.AuditEntityDb;
import pe.xavierdata.data.training.adapter.output.db.model.RoleEntityDb;
import pe.xavierdata.data.training.entities.Audit;
import pe.xavierdata.data.training.entities.PermissionResourcePath;
import pe.xavierdata.data.training.entities.ResourcePath;
import pe.xavierdata.data.training.entities.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-26T06:48:06-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (GraalVM Community)"
)
@ApplicationScoped
public class UtilConvertImpl implements UtilConvert {

    @Override
    public Role fromRoleDTOToRole(RoleDTO d) {
        if ( d == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( d.getId() );
        role.setCompanyId( d.getCompanyId() );
        role.setName( d.getName() );
        role.setDescription( d.getDescription() );
        List<String> list = d.getPermissionResourcePathIds();
        if ( list != null ) {
            role.setPermissionResourcePathIds( new ArrayList<String>( list ) );
        }
        List<String> list1 = d.getResourcesPathIds();
        if ( list1 != null ) {
            role.setResourcesPathIds( new ArrayList<String>( list1 ) );
        }
        role.setResourcePaths( resourcePathDTOListToResourcePathList( d.getResourcePaths() ) );
        role.setPermissionResourcePaths( permissionResourcePathDTOListToPermissionResourcePathList( d.getPermissionResourcePaths() ) );

        return role;
    }

    @Override
    public RoleEntityDb fromRoleToRoleEntityDb(Role o) {
        if ( o == null ) {
            return null;
        }

        RoleEntityDb roleEntityDb = new RoleEntityDb();

        roleEntityDb.setCompanyId( o.getCompanyId() );
        roleEntityDb.setName( o.getName() );
        roleEntityDb.setDescription( o.getDescription() );
        roleEntityDb.setAudit( auditToAuditEntityDb( o.getAudit() ) );

        return roleEntityDb;
    }

    @Override
    public Role fromRoleEntityDbToRole(RoleEntityDb r) {
        if ( r == null ) {
            return null;
        }

        Role role = new Role();

        role.setAudit( auditEntityDbToAudit( r.getAudit() ) );
        role.setCompanyId( r.getCompanyId() );
        role.setName( r.getName() );
        role.setDescription( r.getDescription() );

        return role;
    }

    protected ResourcePath resourcePathDTOToResourcePath(ResourcePathDTO resourcePathDTO) {
        if ( resourcePathDTO == null ) {
            return null;
        }

        ResourcePath resourcePath = new ResourcePath();

        resourcePath.setId( resourcePathDTO.getId() );
        resourcePath.setRoleId( resourcePathDTO.getRoleId() );
        resourcePath.setDescription( resourcePathDTO.getDescription() );
        resourcePath.setOrder( resourcePathDTO.getOrder() );
        resourcePath.setPath( resourcePathDTO.getPath() );
        resourcePath.setIcon( resourcePathDTO.getIcon() );
        resourcePath.setType( resourcePathDTO.getType() );
        resourcePath.setTranslate( resourcePathDTO.getTranslate() );

        return resourcePath;
    }

    protected List<ResourcePath> resourcePathDTOListToResourcePathList(List<ResourcePathDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ResourcePath> list1 = new ArrayList<ResourcePath>( list.size() );
        for ( ResourcePathDTO resourcePathDTO : list ) {
            list1.add( resourcePathDTOToResourcePath( resourcePathDTO ) );
        }

        return list1;
    }

    protected PermissionResourcePath permissionResourcePathDTOToPermissionResourcePath(PermissionResourcePathDTO permissionResourcePathDTO) {
        if ( permissionResourcePathDTO == null ) {
            return null;
        }

        PermissionResourcePath permissionResourcePath = new PermissionResourcePath();

        permissionResourcePath.setId( permissionResourcePathDTO.getId() );
        permissionResourcePath.setRoleId( permissionResourcePathDTO.getRoleId() );
        permissionResourcePath.setPathPattern( permissionResourcePathDTO.getPathPattern() );
        List<String> list = permissionResourcePathDTO.getScopes();
        if ( list != null ) {
            permissionResourcePath.setScopes( new ArrayList<String>( list ) );
        }
        permissionResourcePath.setExpressionPermission( permissionResourcePathDTO.getExpressionPermission() );
        permissionResourcePath.setOrder( permissionResourcePathDTO.getOrder() );

        return permissionResourcePath;
    }

    protected List<PermissionResourcePath> permissionResourcePathDTOListToPermissionResourcePathList(List<PermissionResourcePathDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PermissionResourcePath> list1 = new ArrayList<PermissionResourcePath>( list.size() );
        for ( PermissionResourcePathDTO permissionResourcePathDTO : list ) {
            list1.add( permissionResourcePathDTOToPermissionResourcePath( permissionResourcePathDTO ) );
        }

        return list1;
    }

    protected AuditEntityDb auditToAuditEntityDb(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        AuditEntityDb auditEntityDb = new AuditEntityDb();

        auditEntityDb.setActive( audit.getActive() );
        auditEntityDb.setDeleted( audit.getDeleted() );
        auditEntityDb.setCreated( audit.getCreated() );
        auditEntityDb.setUpdated( audit.getUpdated() );

        return auditEntityDb;
    }

    protected Audit auditEntityDbToAudit(AuditEntityDb auditEntityDb) {
        if ( auditEntityDb == null ) {
            return null;
        }

        Audit audit = new Audit();

        audit.setActive( auditEntityDb.getActive() );
        audit.setDeleted( auditEntityDb.getDeleted() );
        audit.setCreated( auditEntityDb.getCreated() );
        audit.setUpdated( auditEntityDb.getUpdated() );

        return audit;
    }
}
