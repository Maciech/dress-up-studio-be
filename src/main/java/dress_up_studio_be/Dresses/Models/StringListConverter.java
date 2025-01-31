package dress_up_studio_be.Dresses.Models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;

@Converter(autoApply = true)
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(stringList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting List<String> to JSON", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to List<String>", e);
        }
    }
}