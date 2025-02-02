package dress_up_studio_be.Dresses.Models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;

@Converter(autoApply = true)
public class DressAvailabilityConverter implements AttributeConverter<List<DressAvailability>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<DressAvailability> dressAvailabilityList) {
        if (dressAvailabilityList == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(dressAvailabilityList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting DressAvailability list to JSON", e);
        }
    }

    @Override
    public List<DressAvailability> convertToEntityAttribute(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, DressAvailability.class));
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to DressAvailability list", e);
        }
    }
}