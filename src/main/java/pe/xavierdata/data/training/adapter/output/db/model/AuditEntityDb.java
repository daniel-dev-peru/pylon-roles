package pe.xavierdata.data.training.adapter.output.db.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import pe.xavierdata.data.training.application.utils.CustomLocalDateTimeDeserializer;
import pe.xavierdata.data.training.application.utils.CustomLocalDateTimeSerializer;

@Getter
@Setter
public class AuditEntityDb {

  private Boolean active;

  private Boolean deleted;

  @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
  @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
  @BsonProperty("created")
  private LocalDateTime created;

  @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
  @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
  @BsonProperty("updated")
  private LocalDateTime updated;

}
