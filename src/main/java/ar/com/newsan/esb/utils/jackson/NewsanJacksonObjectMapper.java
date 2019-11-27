package ar.com.newsan.esb.utils.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "mapper")
public class NewsanJacksonObjectMapper extends ObjectMapper {

}
