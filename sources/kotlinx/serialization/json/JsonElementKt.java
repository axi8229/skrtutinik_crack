package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0019\u001a\u00020\u0016*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u001d\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010!\u001a\u00020\u001e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0017\u0010%\u001a\u0004\u0018\u00010\"*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0017\u0010(\u001a\u0004\u0018\u00010\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlinx/serialization/json/JsonPrimitive;", "JsonPrimitive", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonElement;", "element", "", "error", "(Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Ljava/lang/Void;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "jsonUnquotedLiteralDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonUnquotedLiteralDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "jsonPrimitive", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "int", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "long", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "double", "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "float", "", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "booleanOrNull", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "contentOrNull", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JsonElementKt {
    private static final SerialDescriptor jsonUnquotedLiteralDescriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));

    public static final JsonPrimitive JsonPrimitive(String str) {
        if (str == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonLiteral(str, true, null, 4, null);
    }

    public static final SerialDescriptor getJsonUnquotedLiteralDescriptor() {
        return jsonUnquotedLiteralDescriptor;
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        error(jsonElement, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final int getInt(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            long jConsumeNumericLiteral = new StringJsonLexer(jsonPrimitive.getContent()).consumeNumericLiteral();
            if (-2147483648L <= jConsumeNumericLiteral && jConsumeNumericLiteral <= 2147483647L) {
                return (int) jConsumeNumericLiteral;
            }
            throw new NumberFormatException(jsonPrimitive.getContent() + " is not an Int");
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final long getLong(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            return new StringJsonLexer(jsonPrimitive.getContent()).consumeNumericLiteral();
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final double getDouble(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.getContent());
    }

    public static final float getFloat(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.getContent());
    }

    public static final Boolean getBooleanOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringOpsKt.toBooleanStrictOrNull(jsonPrimitive.getContent());
    }

    public static final String getContentOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.getContent();
    }

    private static final Void error(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(jsonElement.getClass()) + " is not a " + str);
    }
}
