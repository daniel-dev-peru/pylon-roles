package pe.xavierdata.data.training.entities;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Audit {

    private Boolean active;

    private Boolean deleted;

    private LocalDateTime created;

    private LocalDateTime updated;

}
