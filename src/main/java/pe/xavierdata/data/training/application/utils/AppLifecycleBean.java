package pe.xavierdata.data.training.application.utils;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {

  private static final Logger LOGGER = Logger.getLogger("ListenerBean");

  @ConfigProperty(name = "pad.xavdat.ruc.xav.data")
  String rucXavDat;

    /*@Inject
    PasswordService passwordService;*/

  void onStart(@Observes StartupEvent ev) {
    LOGGER.info("The application is starting...");
        /*CompanyEntityDb companyEntityDbXavDat = CompanyEntityDb.findByRuc(rucXavDat);
        if (Objects.isNull(companyEntityDbXavDat) || !(Objects.isNull(companyEntityDbXavDat.getCompanyId()) && Objects.isNull(companyEntityDbXavDat.getRucParent()))) {

            AuditEntityDb audit = new AuditEntityDb();
            audit.setActive(true);
            audit.setCreated(LocalDateTime.now());

            LOGGER.info("Create super company parent");
            CompanyEntityDb companyEntityDb = new CompanyEntityDb();
            companyEntityDb.setRuc(rucXavDat);
            companyEntityDb.setComercialName("xav");
            companyEntityDb.setFiscalName("saff");
            companyEntityDb.setAddress("sadsdsa");
            companyEntityDb.setExpiryDate(null);
            companyEntityDb.setLimitChildren(null);
            companyEntityDb.setContactEmail("asdas.com");
            ClientDetailEntityDb clientDetail = new ClientDetailEntityDb();
            clientDetail.setClientId("xav-data-ws");
            clientDetail.setClientSecret(passwordService.generate("1234"));
            clientDetail.setScope(Arrays.asList("read", "write"));
            clientDetail.setAccessTokenValiditySeconds(3600L);
            clientDetail.setRefreshTokenValiditySeconds(21600L);
            clientDetail.setResourceIds(Arrays.asList("any"));
            clientDetail.setAuthorizedGrantTypes(Arrays.asList("password", "authorization_code", "refresh_token", "implicit"));
            clientDetail.setRegisteredRedirectUris(Arrays.asList("devclientId"));
            companyEntityDb.setClientDetail(clientDetail);
            companyEntityDb.setPhone("3454355");
            List<LegalPersonEntityDb> legals = new ArrayList<>();
            LegalPersonEntityDb legalPersonEntityDb = new LegalPersonEntityDb();
            legalPersonEntityDb.setEmail("asdas@wwqdwqd.com");
            legalPersonEntityDb.setFirstName("legal1");
            legalPersonEntityDb.setName("asda");
            legalPersonEntityDb.setTypeDocument("1");
            legalPersonEntityDb.setNumberDocument("12321234");
            companyEntityDb.setLegalPerson(legals);
            companyEntityDb.setAudit(audit);
            companyEntityDb.persistOrUpdate();
            LOGGER.info("create company " + companyEntityDb.id.toString());

            RoleEntityDb rol = new RoleEntityDb();
            rol.setCompanyId(companyEntityDb.id.toString());
            rol.setDescription("ROLE_ROOT");
            rol.setAudit(audit);
            rol.persistOrUpdate();

            PersonEntityDb personEntityDb = new PersonEntityDb();
            personEntityDb.setCompanyId(companyEntityDb.id.toString());
            personEntityDb.setEmail("asdas@wwqdwqd.com");
            personEntityDb.setFirstName("admin01");
            personEntityDb.setLastName("admin01");
            personEntityDb.setTypeDocument("1");
            personEntityDb.setNumberDocument("12341235");
            personEntityDb.setRoles(Arrays.asList(rol.id.toString()));
            personEntityDb.setUserName("admin_xav_dat");
            personEntityDb.setPassword(passwordService.generate("1234"));
            personEntityDb.setAudit(audit);
            personEntityDb.persistOrUpdate();

            PermissionResourcePathEntityDb permissionResourcePathEntityDb = new PermissionResourcePathEntityDb();
            permissionResourcePathEntityDb.setExpressionPermission("hasRole(\"ROLE_ROOT\")");
            permissionResourcePathEntityDb.setOrder(1);
            permissionResourcePathEntityDb.setScopes(Arrays.asList("administration"));
            permissionResourcePathEntityDb.setPathPattern("/*");
            permissionResourcePathEntityDb.setRoleId(rol.id.toString());
            permissionResourcePathEntityDb.setAudit(audit);
            permissionResourcePathEntityDb.persistOrUpdate();


        }*/
  }

  void onStop(@Observes ShutdownEvent ev) {
    LOGGER.info("The application is stopping...");
  }

}