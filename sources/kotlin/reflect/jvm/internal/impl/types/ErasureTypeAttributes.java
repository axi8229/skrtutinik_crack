package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: ErasureTypeAttributes.kt */
/* loaded from: classes4.dex */
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public SimpleType getDefaultType() {
        throw null;
    }

    public TypeUsage getHowThisTypeIsUsed() {
        throw null;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        throw null;
    }

    public int hashCode() {
        throw null;
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage howThisTypeIsUsed, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }
}
