package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: SerializersModuleCollector.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJI\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032 \u0010\f\u001a\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\nH&¢\u0006\u0004\b\b\u0010\rJM\u0010\u0013\u001a\u00020\u0007\"\b\b\u0000\u0010\u000e*\u00020\u0001\"\b\b\u0001\u0010\u000f*\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014JC\u0010\u0017\u001a\u00020\u0007\"\b\b\u0000\u0010\u000e*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00150\nH&¢\u0006\u0004\b\u0017\u0010\rJE\u0010\u001b\u001a\u00020\u0007\"\b\b\u0000\u0010\u000e*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001c\u0010\u001a\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00190\nH&¢\u0006\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleCollector;", "", "T", "Lkotlin/reflect/KClass;", "kClass", "Lkotlinx/serialization/KSerializer;", "serializer", "", "contextual", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "Lkotlin/Function1;", "", "provider", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphic", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/SerializationStrategy;", "defaultSerializerProvider", "polymorphicDefaultSerializer", "", "Lkotlinx/serialization/DeserializationStrategy;", "defaultDeserializerProvider", "polymorphicDefaultDeserializer", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SerializersModuleCollector {
    <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider);

    <T> void contextual(KClass<T> kClass, KSerializer<T> serializer);

    <Base, Sub extends Base> void polymorphic(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer);

    <Base> void polymorphicDefaultDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider);

    <Base> void polymorphicDefaultSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider);

    /* compiled from: SerializersModuleCollector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> void contextual(SerializersModuleCollector serializersModuleCollector, KClass<T> kClass, final KSerializer<T> serializer) {
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializersModuleCollector.contextual(kClass, new Function1<List<? extends KSerializer<?>>, KSerializer<?>>() { // from class: kotlinx.serialization.modules.SerializersModuleCollector.contextual.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final KSerializer<?> invoke(List<? extends KSerializer<?>> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return serializer;
                }
            });
        }
    }
}
