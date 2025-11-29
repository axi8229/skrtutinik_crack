package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;

/* compiled from: AnnotationLoader.kt */
/* loaded from: classes4.dex */
public interface AnnotationLoader<A> {
    List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> loadClassAnnotations(ProtoContainer.Class r1);

    List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf$EnumEntry protoBuf$EnumEntry);

    List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property);

    List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property);

    List<A> loadTypeAnnotations(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver);

    List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter protoBuf$TypeParameter, NameResolver nameResolver);

    List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter);
}
