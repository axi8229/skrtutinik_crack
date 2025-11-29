package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: StreamingJsonDecoder.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001jB1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010\u001cJ\u000f\u0010&\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J#\u0010.\u001a\u00028\u0000\"\u0004\b\u0000\u0010+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u0010\u0017J\u000f\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u00105J\u0011\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b7\u00108J=\u0010:\u001a\u00028\u0000\"\u0004\b\u0000\u0010+2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001a2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,2\b\u00109\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010!J\u000f\u0010=\u001a\u00020\u0012H\u0016¢\u0006\u0004\b=\u00105J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u001aH\u0016¢\u0006\u0004\bD\u0010\u001cJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010'J\u0017\u0010S\u001a\u00020R2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\u001a2\u0006\u0010U\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010W\u001a\u0004\bX\u0010YR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010ZR\u0014\u0010\t\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\t\u0010[R\u001a\u0010]\u001a\u00020\\8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010cR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u0004\u0018\u00010g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "", "Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/WriteMode;", "mode", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "discriminatorHolder", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;)V", "", "unknownKey", "", "trySkip", "(Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;Ljava/lang/String;)Z", "", "skipLeftoverElements", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "checkLeadingComma", "()V", "", "decodeMapIndex", "()I", "index", "coerceInputValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeObjectIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "key", "handleUnknown", "(Ljava/lang/String;)Z", "decodeListIndex", "decodeStringKey", "()Ljava/lang/String;", "Lkotlinx/serialization/json/JsonElement;", "decodeJsonElement", "()Lkotlinx/serialization/json/JsonElement;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "endStructure", "decodeNotNullMark", "()Z", "", "decodeNull", "()Ljava/lang/Void;", "previousValue", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeElementIndex", "decodeBoolean", "", "decodeByte", "()B", "", "decodeShort", "()S", "decodeInt", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeChar", "()C", "decodeString", "Lkotlinx/serialization/encoding/Decoder;", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "enumDescriptor", "decodeEnum", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/internal/WriteMode;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "currentIndex", "I", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "elementMarker", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "DiscriminatorHolder", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    private final JsonConfiguration configuration;
    private int currentIndex;
    private DiscriminatorHolder discriminatorHolder;
    private final JsonElementMarker elementMarker;
    private final Json json;
    public final JsonReader lexer;
    private final WriteMode mode;
    private final SerializersModule serializersModule;

    /* compiled from: StreamingJsonDecoder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WriteMode.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json getJson() {
        return this.json;
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, JsonReader lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.json = json;
        this.mode = mode;
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
        this.currentIndex = -1;
        this.discriminatorHolder = discriminatorHolder;
        JsonConfiguration configuration = json.getConfiguration();
        this.configuration = configuration;
        this.elementMarker = configuration.getExplicitNulls() ? null : new JsonElementMarker(descriptor);
    }

    /* compiled from: StreamingJsonDecoder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "", "discriminatorToSkip", "", "(Ljava/lang/String;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiscriminatorHolder {
        public String discriminatorToSkip;

        public DiscriminatorHolder(String str) {
            this.discriminatorToSkip = str;
        }
    }

    private final boolean trySkip(DiscriminatorHolder discriminatorHolder, String str) {
        if (discriminatorHolder == null || !Intrinsics.areEqual(discriminatorHolder.discriminatorToSkip, str)) {
            return false;
        }
        discriminatorHolder.discriminatorToSkip = null;
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        try {
            if ((deserializer instanceof AbstractPolymorphicSerializer) && !this.json.getConfiguration().getUseArrayPolymorphism()) {
                String strClassDiscriminator = PolymorphicKt.classDiscriminator(deserializer.getDescriptor(), this.json);
                String strPeekLeadingMatchingValue = this.lexer.peekLeadingMatchingValue(strClassDiscriminator, this.configuration.getIsLenient());
                if (strPeekLeadingMatchingValue == null) {
                    return (T) PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
                }
                try {
                    DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializer, this, strPeekLeadingMatchingValue);
                    Intrinsics.checkNotNull(deserializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                    this.discriminatorHolder = new DiscriminatorHolder(strClassDiscriminator);
                    return (T) deserializationStrategyFindPolymorphicSerializer.deserialize(this);
                } catch (SerializationException e) {
                    String message = e.getMessage();
                    Intrinsics.checkNotNull(message);
                    String strRemoveSuffix = StringsKt.removeSuffix(StringsKt.substringBefore$default(message, '\n', (String) null, 2, (Object) null), ".");
                    String message2 = e.getMessage();
                    Intrinsics.checkNotNull(message2);
                    JsonReader.fail$default(this.lexer, strRemoveSuffix, 0, StringsKt.substringAfter(message2, '\n', ""), 2, null);
                    throw new KotlinNothingValueException();
                }
            }
            return deserializer.deserialize(this);
        } catch (MissingFieldException e2) {
            String message3 = e2.getMessage();
            Intrinsics.checkNotNull(message3);
            if (StringsKt.contains$default((CharSequence) message3, (CharSequence) "at path", false, 2, (Object) null)) {
                throw e2;
            }
            throw new MissingFieldException(e2.getMissingFields(), e2.getMessage() + " at path: " + this.lexer.path.getPath(), e2);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode writeModeSwitchMode = WriteModeKt.switchMode(this.json, descriptor);
        this.lexer.path.pushDescriptor(descriptor);
        this.lexer.consumeNextToken(writeModeSwitchMode.begin);
        checkLeadingComma();
        int i = WhenMappings.$EnumSwitchMapping$0[writeModeSwitchMode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return new StreamingJsonDecoder(this.json, writeModeSwitchMode, this.lexer, descriptor, this.discriminatorHolder);
        }
        return (this.mode == writeModeSwitchMode && this.json.getConfiguration().getExplicitNulls()) ? this : new StreamingJsonDecoder(this.json, writeModeSwitchMode, this.lexer, descriptor, this.discriminatorHolder);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.json.getConfiguration().getIgnoreUnknownKeys() && descriptor.getElementsCount() == 0) {
            skipLeftoverElements(descriptor);
        }
        if (this.lexer.tryConsumeComma() && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma(this.lexer, "");
            throw new KotlinNothingValueException();
        }
        this.lexer.consumeNextToken(this.mode.end);
        this.lexer.path.popDescriptor();
    }

    private final void skipLeftoverElements(SerialDescriptor descriptor) {
        while (decodeElementIndex(descriptor) != -1) {
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        return ((jsonElementMarker != null ? jsonElementMarker.getIsUnmarkedNull() : false) || JsonReader.tryConsumeNull$default(this.lexer, false, 1, null)) ? false : true;
    }

    private final void checkLeadingComma() {
        if (this.lexer.peekNextToken() != 4) {
            return;
        }
        JsonReader.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        boolean z = this.mode == WriteMode.MAP && (index & 1) == 0;
        if (z) {
            this.lexer.path.resetCurrentMapKey();
        }
        T t = (T) super.decodeSerializableElement(descriptor, index, deserializer, previousValue);
        if (z) {
            this.lexer.path.updateCurrentMapKey(t);
        }
        return t;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        int iDecodeMapIndex;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 2) {
            iDecodeMapIndex = decodeMapIndex();
        } else if (i == 4) {
            iDecodeMapIndex = decodeObjectIndex(descriptor);
        } else {
            iDecodeMapIndex = decodeListIndex();
        }
        if (this.mode != WriteMode.MAP) {
            this.lexer.path.updateDescriptorIndex(iDecodeMapIndex);
        }
        return iDecodeMapIndex;
    }

    private final int decodeMapIndex() {
        int i = this.currentIndex;
        boolean zTryConsumeComma = false;
        boolean z = i % 2 != 0;
        if (!z) {
            this.lexer.consumeNextToken(':');
        } else if (i != -1) {
            zTryConsumeComma = this.lexer.tryConsumeComma();
        }
        if (this.lexer.canConsumeValue()) {
            if (z) {
                if (this.currentIndex != -1) {
                    JsonReader jsonReader = this.lexer;
                    int i2 = jsonReader.currentPosition;
                    if (!zTryConsumeComma) {
                        JsonReader.fail$default(jsonReader, "Expected comma after the key-value pair", i2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    JsonReader jsonReader2 = this.lexer;
                    int i3 = jsonReader2.currentPosition;
                    if (zTryConsumeComma) {
                        JsonReader.fail$default(jsonReader2, "Unexpected leading comma", i3, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i4 = this.currentIndex + 1;
            this.currentIndex = i4;
            return i4;
        }
        if (!zTryConsumeComma || this.json.getConfiguration().getAllowTrailingComma()) {
            return -1;
        }
        JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
        throw new KotlinNothingValueException();
    }

    private final boolean coerceInputValue(SerialDescriptor descriptor, int index) {
        String strPeekString;
        Json json = this.json;
        if (!descriptor.isElementOptional(index)) {
            return false;
        }
        SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(index);
        if (elementDescriptor.isNullable() || !this.lexer.tryConsumeNull(true)) {
            if (!Intrinsics.areEqual(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE)) {
                return false;
            }
            if ((elementDescriptor.isNullable() && this.lexer.tryConsumeNull(false)) || (strPeekString = this.lexer.peekString(this.configuration.getIsLenient())) == null || JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json, strPeekString) != -3) {
                return false;
            }
            this.lexer.consumeString();
        }
        return true;
    }

    private final int decodeObjectIndex(SerialDescriptor descriptor) {
        int jsonNameIndex;
        boolean zTryConsumeComma;
        boolean zTryConsumeComma2 = this.lexer.tryConsumeComma();
        while (true) {
            boolean z = true;
            if (this.lexer.canConsumeValue()) {
                String strDecodeStringKey = decodeStringKey();
                this.lexer.consumeNextToken(':');
                jsonNameIndex = JsonNamesMapKt.getJsonNameIndex(descriptor, this.json, strDecodeStringKey);
                if (jsonNameIndex == -3) {
                    zTryConsumeComma = false;
                } else {
                    if (!this.configuration.getCoerceInputValues() || !coerceInputValue(descriptor, jsonNameIndex)) {
                        break;
                    }
                    zTryConsumeComma = this.lexer.tryConsumeComma();
                    z = false;
                }
                zTryConsumeComma2 = z ? handleUnknown(strDecodeStringKey) : zTryConsumeComma;
            } else {
                if (zTryConsumeComma2 && !this.json.getConfiguration().getAllowTrailingComma()) {
                    JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                    throw new KotlinNothingValueException();
                }
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (jsonElementMarker != null) {
                    return jsonElementMarker.nextUnmarkedIndex$kotlinx_serialization_json();
                }
                return -1;
            }
        }
        JsonElementMarker jsonElementMarker2 = this.elementMarker;
        if (jsonElementMarker2 != null) {
            jsonElementMarker2.mark$kotlinx_serialization_json(jsonNameIndex);
        }
        return jsonNameIndex;
    }

    private final boolean handleUnknown(String key) {
        if (this.configuration.getIgnoreUnknownKeys() || trySkip(this.discriminatorHolder, key)) {
            this.lexer.skipElement(this.configuration.getIsLenient());
        } else {
            this.lexer.failOnUnknownKey(key);
        }
        return this.lexer.tryConsumeComma();
    }

    private final int decodeListIndex() {
        boolean zTryConsumeComma = this.lexer.tryConsumeComma();
        if (this.lexer.canConsumeValue()) {
            int i = this.currentIndex;
            if (i != -1 && !zTryConsumeComma) {
                JsonReader.fail$default(this.lexer, "Expected end of the array or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            int i2 = i + 1;
            this.currentIndex = i2;
            return i2;
        }
        if (!zTryConsumeComma || this.json.getConfiguration().getAllowTrailingComma()) {
            return -1;
        }
        JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return this.lexer.consumeBooleanLenient();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        long jConsumeNumericLiteral = this.lexer.consumeNumericLiteral();
        byte b = (byte) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == b) {
            return b;
        }
        JsonReader.fail$default(this.lexer, "Failed to parse byte for input '" + jConsumeNumericLiteral + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        long jConsumeNumericLiteral = this.lexer.consumeNumericLiteral();
        short s = (short) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == s) {
            return s;
        }
        JsonReader.fail$default(this.lexer, "Failed to parse short for input '" + jConsumeNumericLiteral + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        long jConsumeNumericLiteral = this.lexer.consumeNumericLiteral();
        int i = (int) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == i) {
            return i;
        }
        JsonReader.fail$default(this.lexer, "Failed to parse int for input '" + jConsumeNumericLiteral + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() throws NumberFormatException {
        JsonReader jsonReader = this.lexer;
        String strConsumeStringLenient = jsonReader.consumeStringLenient();
        try {
            float f = Float.parseFloat(strConsumeStringLenient);
            if (this.json.getConfiguration().getAllowSpecialFloatingPointValues() || !(Float.isInfinite(f) || Float.isNaN(f))) {
                return f;
            }
            JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(f));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            JsonReader.fail$default(jsonReader, "Failed to parse type 'float' for input '" + strConsumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() throws NumberFormatException {
        JsonReader jsonReader = this.lexer;
        String strConsumeStringLenient = jsonReader.consumeStringLenient();
        try {
            double d = Double.parseDouble(strConsumeStringLenient);
            if (this.json.getConfiguration().getAllowSpecialFloatingPointValues() || !(Double.isInfinite(d) || Double.isNaN(d))) {
                return d;
            }
            JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(d));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            JsonReader.fail$default(jsonReader, "Failed to parse type 'double' for input '" + strConsumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        String strConsumeStringLenient = this.lexer.consumeStringLenient();
        if (strConsumeStringLenient.length() != 1) {
            JsonReader.fail$default(this.lexer, "Expected single char, but got '" + strConsumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return strConsumeStringLenient.charAt(0);
    }

    private final String decodeStringKey() {
        if (this.configuration.getIsLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeKeyString();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        if (this.configuration.getIsLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(descriptor) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : super.decodeInline(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(enumDescriptor, this.json, decodeString(), " at path " + this.lexer.path.getPath());
    }
}
