package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoader.kt */
/* loaded from: classes4.dex */
public interface AnnotationAndConstantLoader<A, C> extends AnnotationLoader<A> {
    C loadAnnotationDefaultValue(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property, KotlinType kotlinType);

    C loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property, KotlinType kotlinType);
}
