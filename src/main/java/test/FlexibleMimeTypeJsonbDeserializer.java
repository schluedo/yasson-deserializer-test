package test;

import java.lang.reflect.Type;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.bind.JsonbException;
import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

public class FlexibleMimeTypeJsonbDeserializer implements JsonbDeserializer<MimeType> {

	public MimeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		JsonValue jsonValue = parser.getValue();
		try {
			
			switch (jsonValue.getValueType()) {
			case STRING:
				String str = ((JsonString)jsonValue).getString();
				return new MimeType(str);
			case OBJECT:
				JsonObject jsonObject = jsonValue.asJsonObject();
				String primary = jsonObject.getString("primary");
				String sub = jsonObject.getString("sub");
				return new MimeType(primary, sub);
			default:
				throw new JsonbException("not supported!");
			}
		} catch (MimeTypeParseException e) {
			throw new JsonbException("fail", e);
		}
	}

}
