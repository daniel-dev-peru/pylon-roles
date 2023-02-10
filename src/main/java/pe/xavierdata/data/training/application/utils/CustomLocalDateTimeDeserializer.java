package pe.xavierdata.data.training.application.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.jboss.logging.Logger;

public class CustomLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    private static final Logger LOG = Logger.getLogger(CustomLocalDateTimeDeserializer.class);

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final long serialVersionUID = 1L;

    public CustomLocalDateTimeDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        System.out.println("CustomLocalDateTimeDeserializer deserialize : " + jsonParser.getValueAsString());

        if(Objects.isNull(jsonParser.getValueAsString())){
            return null;
        }
        return LocalDateTime.parse(jsonParser.getValueAsString(), formatter);
    }


}