package com.sjy.shining.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @ClassName JsonTimeSerializer
 * @Description Long时间格式化化为标准时间
 */
public class JsonDateSerializer extends JsonSerializer<Long> {
	   private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	   @Override  
	   public void serialize(Long datel, JsonGenerator gen, SerializerProvider provider)  throws IOException, JsonProcessingException {  
		   if(datel.toString().length()<13){
		       datel= datel*1000L;
		   }
	       Date date= new Date(datel);
	       String value = dateFormat.format(date);  
	       gen.writeString(value);  
	   }  
	}  
