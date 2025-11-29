package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.modules.SerializersModuleCollector;

/* compiled from: PolymorphismValidator.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJI\u0010\u0017\u001a\u00020\f\"\b\b\u0000\u0010\u0011*\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\n2 \u0010\u0016\u001a\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JM\u0010\u001d\u001a\u00020\f\"\b\b\u0000\u0010\u0019*\u00020\u0010\"\b\b\u0001\u0010\u001a*\u00028\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJC\u0010!\u001a\u00020\f\"\b\b\u0000\u0010\u0019*\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001f0\u0013H\u0016¢\u0006\u0004\b!\u0010\u0018JE\u0010$\u001a\u00020\f\"\b\b\u0000\u0010\u0019*\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u001c\u0010#\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\"0\u0013H\u0016¢\u0006\u0004\b$\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&¨\u0006'"}, d2 = {"Lkotlinx/serialization/json/internal/PolymorphismValidator;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "", "useArrayPolymorphism", "", "discriminator", "<init>", "(ZLjava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlin/reflect/KClass;", "actualClass", "", "checkKind", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "checkDiscriminatorCollisions", "", "T", "kClass", "Lkotlin/Function1;", "", "Lkotlinx/serialization/KSerializer;", "provider", "contextual", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Base", "Sub", "baseClass", "actualSerializer", "polymorphic", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/SerializationStrategy;", "defaultSerializerProvider", "polymorphicDefaultSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "defaultDeserializerProvider", "polymorphicDefaultDeserializer", "Z", "Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PolymorphismValidator implements SerializersModuleCollector {
    private final String discriminator;
    private final boolean useArrayPolymorphism;

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
    }

    public PolymorphismValidator(boolean z, String discriminator) {
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        this.useArrayPolymorphism = z;
        this.discriminator = discriminator;
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(KClass<T> kClass, KSerializer<T> kSerializer) {
        SerializersModuleCollector.DefaultImpls.contextual(this, kClass, kSerializer);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void polymorphic(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        SerialDescriptor descriptor = actualSerializer.getDescriptor();
        checkKind(descriptor, actualClass);
        if (this.useArrayPolymorphism) {
            return;
        }
        checkDiscriminatorCollisions(descriptor, actualClass);
    }

    private final void checkKind(SerialDescriptor descriptor, KClass<?> actualClass) {
        SerialKind kind = descriptor.getKind();
        if ((kind instanceof PolymorphicKind) || Intrinsics.areEqual(kind, SerialKind.CONTEXTUAL.INSTANCE)) {
            throw new IllegalArgumentException("Serializer for " + actualClass.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.useArrayPolymorphism) {
            return;
        }
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE) || Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE) || (kind instanceof PrimitiveKind) || (kind instanceof SerialKind.ENUM)) {
            throw new IllegalArgumentException("Serializer for " + actualClass.getSimpleName() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    private final void checkDiscriminatorCollisions(SerialDescriptor descriptor, KClass<?> actualClass) {
        int elementsCount = descriptor.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            String elementName = descriptor.getElementName(i);
            if (Intrinsics.areEqual(elementName, this.discriminator)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + actualClass + " has property '" + elementName + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }
}
