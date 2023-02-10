package pe.xavierdata.data.training.application.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final long serialVersionUID = 1L;

    public CustomLocalDateTimeSerializer(){
        super(LocalDateTime.class);
    }


    @Override
    public void serialize(LocalDateTime localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDate.format(formatter));
    }
}