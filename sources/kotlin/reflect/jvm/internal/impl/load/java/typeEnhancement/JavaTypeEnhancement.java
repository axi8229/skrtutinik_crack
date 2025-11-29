package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
/* loaded from: classes4.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* compiled from: typeEnhancement.kt */
    private static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType kotlinType, int i) {
            this.type = kotlinType;
            this.subtreeSize = i;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    /* compiled from: typeEnhancement.kt */
    private static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType simpleType, int i, boolean z) {
            this.type = simpleType;
            this.subtreeSize = i;
            this.forWarnings = z;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0, z).getType();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14, boolean r15) {
        /*
            r11 = this;
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r12)
            r1 = 0
            if (r0 == 0) goto Le
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r13 = 1
            r12.<init>(r1, r13)
            return r12
        Le:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto Lad
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r9 = r12
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r9 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r9
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getLowerBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r2 = r11
            r4 = r13
            r5 = r14
            r7 = r0
            r8 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r10 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getUpperBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            r10.getSubtreeSize()
            r13.getSubtreeSize()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L43
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r13.getType()
            if (r14 != 0) goto L43
            goto La3
        L43:
            boolean r14 = r10.getForWarnings()
            if (r14 != 0) goto L85
            boolean r14 = r13.getForWarnings()
            if (r14 == 0) goto L50
            goto L85
        L50:
            if (r0 == 0) goto L6c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L5e
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L5e:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L68
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L68:
            r1.<init>(r12, r13)
            goto La3
        L6c:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L76
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L76:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L80
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L80:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r12, r13)
            goto La3
        L85:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 == 0) goto L98
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L92
            r14 = r13
        L92:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r14, r13)
            if (r13 != 0) goto L9f
        L98:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r10.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
        L9f:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r13)
        La3:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            int r13 = r10.getSubtreeSize()
            r12.<init>(r1, r13)
            goto Ldf
        Lad:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto Le0
            r2 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r8 = 8
            r9 = 0
            r6 = 0
            r1 = r11
            r3 = r13
            r4 = r14
            r7 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = enhanceInflexible$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r14 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            boolean r15 = r13.getForWarnings()
            if (r15 == 0) goto Ld3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = r13.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r15)
            goto Ld7
        Ld3:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r13.getType()
        Ld7:
            int r13 = r13.getSubtreeSize()
            r14.<init>(r12, r13)
            r12 = r14
        Ldf:
            return r12
        Le0:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        TypeConstructor constructor;
        boolean z3;
        Result result;
        TypeProjection typeProjectionMakeStarProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        boolean zShouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        boolean z4 = (z2 && z) ? false : true;
        KotlinType kotlinType = null;
        if (!zShouldEnhance && simpleType.getArguments().isEmpty()) {
            return new SimpleResult(null, 1, false);
        }
        ClassifierDescriptor classifierDescriptorMo2742getDeclarationDescriptor = simpleType.getConstructor().mo2742getDeclarationDescriptor();
        if (classifierDescriptorMo2742getDeclarationDescriptor == null) {
            return new SimpleResult(null, 1, false);
        }
        JavaTypeQualifiers javaTypeQualifiersInvoke = function12.invoke(Integer.valueOf(i));
        ClassifierDescriptor classifierDescriptorEnhanceMutability = TypeEnhancementKt.enhanceMutability(classifierDescriptorMo2742getDeclarationDescriptor, javaTypeQualifiersInvoke, typeComponentPosition);
        Boolean enhancedNullability = TypeEnhancementKt.getEnhancedNullability(javaTypeQualifiersInvoke, typeComponentPosition);
        if (classifierDescriptorEnhanceMutability == null || (constructor = classifierDescriptorEnhanceMutability.getTypeConstructor()) == null) {
            constructor = simpleType.getConstructor();
        }
        TypeConstructor typeConstructor = constructor;
        Intrinsics.checkNotNull(typeConstructor);
        int subtreeSize = i + 1;
        List<TypeProjection> arguments = simpleType.getArguments();
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        List<TypeParameterDescriptor> list = parameters;
        Iterator<T> it = arguments.iterator();
        Iterator<T> it2 = list.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arguments, 10), CollectionsKt.collectionSizeOrDefault(list, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
            TypeProjection typeProjection = (TypeProjection) next;
            if (!z4) {
                z3 = z4;
                result = new Result(kotlinType, 0);
            } else {
                z3 = z4;
                if (!typeProjection.isStarProjection()) {
                    result = enhancePossiblyFlexible(typeProjection.getType().unwrap(), function12, subtreeSize, z2);
                } else if (function12.invoke(Integer.valueOf(subtreeSize)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                    UnwrappedType unwrappedTypeUnwrap = typeProjection.getType().unwrap();
                    result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrappedTypeUnwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrappedTypeUnwrap).makeNullableAsSpecified(true)), 1);
                } else {
                    result = new Result(null, 1);
                }
            }
            subtreeSize += result.getSubtreeSize();
            if (result.getType() != null) {
                KotlinType type = result.getType();
                Variance projectionKind = typeProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                typeProjectionMakeStarProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
            } else if (classifierDescriptorEnhanceMutability == null || typeProjection.isStarProjection()) {
                typeProjectionMakeStarProjection = classifierDescriptorEnhanceMutability != null ? TypeUtils.makeStarProjection(typeParameterDescriptor) : null;
            } else {
                KotlinType type2 = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                Variance projectionKind2 = typeProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
                typeProjectionMakeStarProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
            }
            arrayList.add(typeProjectionMakeStarProjection);
            function12 = function1;
            z4 = z3;
            kotlinType = null;
        }
        int i2 = subtreeSize - i;
        if (classifierDescriptorEnhanceMutability == null && enhancedNullability == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    if (((TypeProjection) it3.next()) == null) {
                    }
                }
            }
            return new SimpleResult(null, i2, false);
        }
        Annotations annotations = simpleType.getAnnotations();
        EnhancedTypeAnnotations enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
        if (classifierDescriptorEnhanceMutability == null) {
            enhancedTypeAnnotations = null;
        }
        boolean z5 = false;
        TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) new Annotations[]{annotations, enhancedTypeAnnotations, enhancedNullability != null ? TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS() : null})));
        List<TypeProjection> arguments2 = simpleType.getArguments();
        Iterator it4 = arrayList.iterator();
        Iterator<T> it5 = arguments2.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arrayList, 10), CollectionsKt.collectionSizeOrDefault(arguments2, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            TypeProjection typeProjection2 = (TypeProjection) it5.next();
            TypeProjection typeProjection3 = (TypeProjection) next2;
            if (typeProjection3 != null) {
                typeProjection2 = typeProjection3;
            }
            arrayList2.add(typeProjection2);
        }
        SimpleType simpleTypeSimpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList2, enhancedNullability != null ? enhancedNullability.booleanValue() : simpleType.isMarkedNullable(), null, 16, null);
        if (javaTypeQualifiersInvoke.getDefinitelyNotNull()) {
            simpleTypeSimpleType$default = notNullTypeParameter(simpleTypeSimpleType$default);
        }
        if (enhancedNullability != null && javaTypeQualifiersInvoke.isNullabilityQualifierForWarning()) {
            z5 = true;
        }
        return new SimpleResult(simpleTypeSimpleType$default, i2, z5);
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }
}
