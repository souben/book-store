package customers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import customers.dto.CustomerDTO;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomerDTOSerializer implements Serializer<CustomerDTO> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public byte[] serialize(String s, CustomerDTO customerDTO) {
        try{
            if( customerDTO == null){
                System.out.println("Received data at serializing is null ...");
                return null;
            }
            System.out.println("Serializing customerDTO data ... ");
            return mapper.writeValueAsBytes(customerDTO);
        }catch (Exception e){
           throw new SerializationException("Error while serializing customerDTO data ... ");
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, CustomerDTO data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {}
}
