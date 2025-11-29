package kotlinx.serialization.modules;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;

/* compiled from: SerializersModule.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B×\u0001\u0012\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012*\u0010\u0007\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u0002\u0012.\u0010\u000b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bj\u0006\u0012\u0002\b\u0003`\n0\u0002\u0012&\u0010\r\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u0002\u00122\u0010\u0010\u001a.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012 \u0012\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\bj\u0006\u0012\u0002\b\u0003`\u000f0\u0002¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\"\b\b\u0000\u0010\u0014*\u00020\u00132\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\"\b\b\u0000\u0010\u0014*\u00020\u00132\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0017\u0010\u001aJA\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$R$\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R8\u0010\u0007\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R<\u0010\u000b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\t0\bj\u0006\u0012\u0002\b\u0003`\n0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R4\u0010\r\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010%R@\u0010\u0010\u001a.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012 \u0012\u001e\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\bj\u0006\u0012\u0002\b\u0003`\u000f0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010%¨\u0006&"}, d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "class2ContextualFactory", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2DefaultSerializerProvider", "", "polyBase2NamedSerializers", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "polyBase2DefaultDeserializerProvider", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "", "T", "baseClass", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getPolymorphic", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Lkotlinx/serialization/DeserializationStrategy;", "kClass", "", "typeArgumentsSerializers", "getContextual", "(Lkotlin/reflect/KClass;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "collector", "", "dumpTo", "(Lkotlinx/serialization/modules/SerializersModuleCollector;)V", "Ljava/util/Map;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SerialModuleImpl extends SerializersModule {
    private final Map<KClass<?>, ContextualProvider> class2ContextualFactory;
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider;
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider;
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SerialModuleImpl(Map<KClass<?>, ? extends ContextualProvider> class2ContextualFactory, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> polyBase2Serializers, Map<KClass<?>, ? extends Function1<?, ? extends SerializationStrategy<?>>> polyBase2DefaultSerializerProvider, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> polyBase2NamedSerializers, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider) {
        super(null);
        Intrinsics.checkNotNullParameter(class2ContextualFactory, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(polyBase2Serializers, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.class2ContextualFactory = class2ContextualFactory;
        this.polyBase2Serializers = polyBase2Serializers;
        this.polyBase2DefaultSerializerProvider = polyBase2DefaultSerializerProvider;
        this.polyBase2NamedSerializers = polyBase2NamedSerializers;
        this.polyBase2DefaultDeserializerProvider = polyBase2DefaultDeserializerProvider;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> baseClass, T value) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!baseClass.isInstance(value)) {
            return null;
        }
        Map<KClass<?>, KSerializer<?>> map = this.polyBase2Serializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(Reflection.getOrCreateKotlinClass(value.getClass())) : null;
        if (kSerializer == null) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<?, SerializationStrategy<?>> function1 = this.polyBase2DefaultSerializerProvider.get(baseClass);
        Function1<?, SerializationStrategy<?>> function12 = TypeIntrinsics.isFunctionOfArity(function1, 1) ? function1 : null;
        if (function12 != null) {
            return (SerializationStrategy) function12.invoke(value);
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> DeserializationStrategy<T> getPolymorphic(KClass<? super T> baseClass, String serializedClassName) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Map<String, KSerializer<?>> map = this.polyBase2NamedSerializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(serializedClassName) : null;
        if (kSerializer == null) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<String, DeserializationStrategy<?>> function1 = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        Function1<String, DeserializationStrategy<?>> function12 = TypeIntrinsics.isFunctionOfArity(function1, 1) ? function1 : null;
        if (function12 != null) {
            return (DeserializationStrategy) function12.invoke(serializedClassName);
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.class2ContextualFactory.get(kClass);
        KSerializer<?> kSerializerInvoke = contextualProvider != null ? contextualProvider.invoke(typeArgumentsSerializers) : null;
        if (kSerializerInvoke != null) {
            return (KSerializer<T>) kSerializerInvoke;
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public void dumpTo(SerializersModuleCollector collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        for (Map.Entry<KClass<?>, ContextualProvider> entry : this.class2ContextualFactory.entrySet()) {
            KClass<?> key = entry.getKey();
            ContextualProvider value = entry.getValue();
            if (value instanceof ContextualProvider.Argless) {
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> serializer = ((ContextualProvider.Argless) value).getSerializer();
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.contextual(key, serializer);
            } else if (value instanceof ContextualProvider.WithTypeArguments) {
                collector.contextual(key, ((ContextualProvider.WithTypeArguments) value).getProvider());
            }
        }
        for (Map.Entry<KClass<?>, Map<KClass<?>, KSerializer<?>>> entry2 : this.polyBase2Serializers.entrySet()) {
            KClass<?> key2 = entry2.getKey();
            for (Map.Entry<KClass<?>, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                KClass<?> key3 = entry3.getKey();
                KSerializer<?> value2 = entry3.getValue();
                Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.polymorphic(key2, key3, value2);
            }
        }
        for (Map.Entry<KClass<?>, Function1<?, SerializationStrategy<?>>> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            KClass<?> key4 = entry4.getKey();
            Function1<?, SerializationStrategy<?>> value3 = entry4.getValue();
            Intrinsics.checkNotNull(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            collector.polymorphicDefaultSerializer(key4, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value3, 1));
        }
        for (Map.Entry<KClass<?>, Function1<String, DeserializationStrategy<?>>> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            KClass<?> key5 = entry5.getKey();
            Function1<String, DeserializationStrategy<?>> value4 = entry5.getValue();
            Intrinsics.checkNotNull(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            collector.polymorphicDefaultDeserializer(key5, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value4, 1));
        }
    }
}
