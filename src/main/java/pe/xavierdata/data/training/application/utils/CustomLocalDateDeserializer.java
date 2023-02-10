package pe.xavierdata.data.training.application.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.jboss.logging.Logger;

public class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static final Logger LOG = Logger.getLogger(CustomLocalDateDeserializer.class);

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final long serialVersionUID = 1L;

    public CustomLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        System.out.println("CustomLocalDateDeserializer deserialize : " + jsonParser.getValueAsString());

        if(Objects.isNull(jsonParser.getValueAsString())){
            return null;
        }
        return LocalDate.parse(jsonParser.getValueAsString(), formatter);
    }


}