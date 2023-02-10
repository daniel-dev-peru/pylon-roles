package pe.xavierdata.data.training.adapter.input.web;

import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;
import pe.xavierdata.data.training.adapter.input.model.RoleDTO;
import pe.xavierdata.data.training.application.convert.UtilConvert;
import pe.xavierdata.data.training.domain.port.input.CreateRoleUseCase;

@Path("/multi-companies/api/v1/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {

  @Inject
  CreateRoleUseCase createRoleUseCase;

  @Inject
  UtilConvert utilConvert;

  @POST
  public Uni<Response> create(@RequestBody RoleDTO roleDTO) {
    return createRoleUseCase.execute(utilConvert.fromRoleDTOToRole(roleDTO))
            .map((rs) -> {
              RoleDTO res = new RoleDTO();
              res.setId(rs.getId());
              return Response.ok(res)
                      .build();
            });
  }

    /*@PUT()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> update(@PathParam(value = "id") String id, @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        return service.save(roleDTO, true).map((rs) -> {
            return Response.noContent().build();
        });
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<RoleDTO> get(@PathParam(value = "id") String id, @QueryParam("detail") Boolean detail) {
        return service.get(id, detail);
    }

    @GET()
    @Path("/company/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<RoleDTO> getByCompany(@PathParam(value = "id") String id, @QueryParam("detail") boolean detail) {
        return service.getByCompany(id, detail);
    }
*/
}