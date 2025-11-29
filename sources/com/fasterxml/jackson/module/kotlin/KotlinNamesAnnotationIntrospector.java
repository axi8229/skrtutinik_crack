package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: KotlinNamesAnnotationIntrospector.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020 H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020!H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinNamesAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector;", "module", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "ignoredClassesForImplyingJsonCreator", "", "Lkotlin/reflect/KClass;", "(Lcom/fasterxml/jackson/module/kotlin/KotlinModule;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;Ljava/util/Set;)V", "getCache", "()Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "getIgnoredClassesForImplyingJsonCreator", "()Ljava/util/Set;", "getModule", "()Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "findImplicitPropertyName", "", "member", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "findKotlinParameterName", RemoteMessageConst.MessageBody.PARAM, "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;", "findRenameByField", "Lcom/fasterxml/jackson/databind/PropertyName;", "config", "Lcom/fasterxml/jackson/databind/cfg/MapperConfig;", "field", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;", "implName", "hasCreatorAnnotation", "", "Lcom/fasterxml/jackson/databind/introspect/Annotated;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class KotlinNamesAnnotationIntrospector extends NopAnnotationIntrospector {
    private final ReflectionCache cache;
    private final Set<KClass<?>> ignoredClassesForImplyingJsonCreator;
    private final KotlinModule module;

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinNamesAnnotationIntrospector(KotlinModule module, ReflectionCache cache, Set<? extends KClass<?>> ignoredClassesForImplyingJsonCreator) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(ignoredClassesForImplyingJsonCreator, "ignoredClassesForImplyingJsonCreator");
        this.module = module;
        this.cache = cache;
        this.ignoredClassesForImplyingJsonCreator = ignoredClassesForImplyingJsonCreator;
    }

    public final ReflectionCache getCache() {
        return this.cache;
    }

    public final Set<KClass<?>> getIgnoredClassesForImplyingJsonCreator() {
        return this.ignoredClassesForImplyingJsonCreator;
    }

    public final KotlinModule getModule() {
        return this.module;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findImplicitPropertyName(AnnotatedMember member) {
        String strSubstringAfter$default;
        Intrinsics.checkNotNullParameter(member, "member");
        if (!(member instanceof AnnotatedMethod)) {
            if (member instanceof AnnotatedParameter) {
                return findKotlinParameterName((AnnotatedParameter) member);
            }
            return null;
        }
        AnnotatedMethod annotatedMethod = (AnnotatedMethod) member;
        String name = annotatedMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name, "member.name");
        if (!StringsKt.contains$default((CharSequence) name, '-', false, 2, (Object) null) || annotatedMethod.getParameterCount() != 0) {
            return null;
        }
        String name2 = annotatedMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "member.name");
        if (StringsKt.startsWith$default(name2, "get", false, 2, (Object) null)) {
            String name3 = annotatedMethod.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "member.name");
            strSubstringAfter$default = StringsKt.substringAfter$default(name3, "get", (String) null, 2, (Object) null);
        } else {
            String name4 = annotatedMethod.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "member.name");
            if (StringsKt.startsWith$default(name4, "is", false, 2, (Object) null)) {
                String name5 = annotatedMethod.getName();
                Intrinsics.checkNotNullExpressionValue(name5, "member.name");
                strSubstringAfter$default = StringsKt.substringAfter$default(name5, "is", (String) null, 2, (Object) null);
            } else {
                strSubstringAfter$default = null;
            }
        }
        if (strSubstringAfter$default == null) {
            return null;
        }
        if (strSubstringAfter$default.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char cCharAt = strSubstringAfter$default.charAt(0);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            sb.append(CharsKt.lowercase(cCharAt, locale).toString());
            String strSubstring = strSubstringAfter$default.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            sb.append(strSubstring);
            strSubstringAfter$default = sb.toString();
        }
        if (strSubstringAfter$default == null) {
            return null;
        }
        return StringsKt.substringBefore$default(strSubstringAfter$default, '-', (String) null, 2, (Object) null);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRenameByField(MapperConfig<?> config, AnnotatedField field, PropertyName implName) {
        String strStdManglePropertyName;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(implName, "implName");
        String origSimple = implName.getSimpleName();
        Class<?> declaringClass = field.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "field.declaringClass");
        if (KotlinModuleKt.isKotlinClass(declaringClass)) {
            Intrinsics.checkNotNullExpressionValue(origSimple, "origSimple");
            if (StringsKt.startsWith$default(origSimple, "is", false, 2, (Object) null) && (strStdManglePropertyName = BeanUtil.stdManglePropertyName(origSimple, 2)) != null && !strStdManglePropertyName.equals(origSimple)) {
                return PropertyName.construct(strStdManglePropertyName);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasCreatorAnnotation(com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r9) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.hasCreatorAnnotation(com.fasterxml.jackson.databind.introspect.AnnotatedConstructor):boolean");
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean hasCreatorAnnotation(Annotated member) {
        Intrinsics.checkNotNullParameter(member, "member");
        if (member instanceof AnnotatedConstructor) {
            AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) member;
            if (KotlinNamesAnnotationIntrospectorKt.isKotlinConstructorWithParameters(annotatedConstructor)) {
                return this.cache.checkConstructorIsCreatorAnnotated(annotatedConstructor, new Function1<AnnotatedConstructor, Boolean>() { // from class: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.hasCreatorAnnotation.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(AnnotatedConstructor it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(KotlinNamesAnnotationIntrospector.this.hasCreatorAnnotation(it));
                    }
                });
            }
        }
        return false;
    }

    private final String findKotlinParameterName(AnnotatedParameter param) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        List<KParameter> parameters;
        KParameter kParameter;
        List<KParameter> parameters2;
        List<KParameter> parameters3;
        KParameter kParameter2;
        KFunction kotlinFunction;
        List<KParameter> parameters4;
        KParameter kParameter3;
        List<KParameter> parameters5;
        Class<?> declaringClass = param.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "param.declaringClass");
        if (!KotlinModuleKt.isKotlinClass(declaringClass)) {
            return null;
        }
        Member member = param.getOwner().getMember();
        int size = 0;
        if (member instanceof Constructor) {
            Constructor constructor = (Constructor) member;
            int length = constructor.getParameterTypes().length;
            try {
                KFunction kotlinFunction2 = ReflectJvmMapping.getKotlinFunction(constructor);
                if (kotlinFunction2 != null && (parameters5 = kotlinFunction2.getParameters()) != null) {
                    size = parameters5.size();
                }
            } catch (UnsupportedOperationException | KotlinReflectionInternalError unused) {
            }
            if (size <= 0 || size != length || (kotlinFunction = ReflectJvmMapping.getKotlinFunction(constructor)) == null || (parameters4 = kotlinFunction.getParameters()) == null || (kParameter3 = parameters4.get(param.getIndex())) == null) {
                return null;
            }
            return kParameter3.getName();
        }
        if (!(member instanceof Method)) {
            return null;
        }
        try {
            KFunction<?> kotlinFunction3 = ReflectJvmMapping.getKotlinFunction((Method) member);
            int index = ((kotlinFunction3 != null && (parameters = kotlinFunction3.getParameters()) != null && (kParameter = (KParameter) CollectionsKt.firstOrNull((List) parameters)) != null) ? kParameter.getKind() : null) != KParameter.Kind.VALUE ? param.getIndex() + 1 : param.getIndex();
            if (kotlinFunction3 != null && (parameters2 = kotlinFunction3.getParameters()) != null) {
                size = parameters2.size();
            }
            if (size > index && kotlinFunction3 != null && (parameters3 = kotlinFunction3.getParameters()) != null && (kParameter2 = parameters3.get(index)) != null) {
                return kParameter2.getName();
            }
            return null;
        } catch (KotlinReflectionInternalError unused2) {
            return null;
        }
    }
}
