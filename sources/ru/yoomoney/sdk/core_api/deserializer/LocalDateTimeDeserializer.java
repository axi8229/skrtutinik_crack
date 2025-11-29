package ru.yoomoney.sdk.core_api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import kotlin.Metadata;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

/* compiled from: LocalDateTimeCoder.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/core_api/deserializer/LocalDateTimeDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "Lorg/threeten/bp/LocalDateTime;", "()V", "deserialize", "jsonParser", "Lcom/fasterxml/jackson/core/JsonParser;", "ctxt", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) {
        if (jsonParser != null) {
            return LocalDateTime.ofInstant(OffsetDateTime.parse(((JsonNode) jsonParser.getCodec().readTree(jsonParser)).asText()).toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}
