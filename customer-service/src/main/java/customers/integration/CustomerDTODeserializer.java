package customers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import customers.dto.CustomerDTO;
import org.apache.kafka.common.errors.PrincipalDeserializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

 
public class CustomerDTODeserializer implements Deserializer<CustomerDTO> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public CustomerDTO deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();

        try{
            if(bytes == null){
                System.out.println("customerDto data is empty ...");
                return null;
            }
            System.out.println("Deserializing the bytes data ...");
            CustomerDTO customerDTO = mapper.readValue(bytes, CustomerDTO.class);
            System.out.println("Deserializing customerDTO : "+ customerDTO);
            return customerDTO;
        }catch(Exception e){

            String errMessage = "Error while deserializing stream of customerDTO data ...";
            throw new PrincipalDeserializationException(errMessage);
        }
    }

    @Override
    public CustomerDTO deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
