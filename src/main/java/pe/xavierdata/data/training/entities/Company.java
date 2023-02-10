package pe.xavierdata.data.training.entities;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    private String id;
    private String fiscalName;
    private String comercialName;
    private String ruc;
    private String phone;
    private String contactEmail;
    private String address;
    private String rucParent;
    private String companyId;
    private Long limitChildren;
    private LocalDate expiryDate;
    private Audit audit;

}
