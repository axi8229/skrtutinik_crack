package ru.yoomoney.sdk.core_api.deserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import kotlin.Metadata;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/* compiled from: LocalDateTimeCoder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/core_api/deserializer/LocalDateTimeSerializer;", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "Lorg/threeten/bp/LocalDateTime;", "()V", "serialize", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "gen", "Lcom/fasterxml/jackson/core/JsonGenerator;", "serializers", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            OffsetDateTime offsetDateTimeWithOffsetSameInstant = value.atOffset(ZoneId.systemDefault().getRules().getOffset(value)).withOffsetSameInstant(ZoneOffset.UTC);
            if (gen != null) {
                gen.writeString(offsetDateTimeWithOffsetSameInstant.format(DateTimeFormatter.ISO_DATE_TIME));
            }
        }
    }
}
