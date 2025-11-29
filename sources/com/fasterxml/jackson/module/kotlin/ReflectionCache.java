package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ReflectJvmMapping;

/* compiled from: ReflectionCache.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\n2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u001dJ\"\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b0\u001dJ+\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u00122\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001d¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007J\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\rJ\u0014\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0015J\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\u0006\u0010#\u001a\u00020$R&\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "", "reflectionCacheSize", "", "(I)V", "javaClassToKotlin", "Lcom/fasterxml/jackson/databind/util/LRUMap;", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "javaConstructorIsCreatorAnnotated", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "", "javaConstructorToKotlin", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/KFunction;", "javaConstructorToValueCreator", "Lcom/fasterxml/jackson/module/kotlin/ConstructorValueCreator;", "javaMemberIsRequired", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "javaMethodToKotlin", "Ljava/lang/reflect/Method;", "javaMethodToValueCreator", "Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "kotlinGeneratedMethod", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "checkConstructorIsCreatorAnnotated", "key", "calc", "Lkotlin/Function1;", "isKotlinGeneratedMethod", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "kotlinFromJava", "valueCreatorFromJava", "Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "_withArgsCreator", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;", "BooleanTriState", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ReflectionCache {
    private final LRUMap<Class<Object>, KClass<Object>> javaClassToKotlin;
    private final LRUMap<AnnotatedConstructor, Boolean> javaConstructorIsCreatorAnnotated;
    private final LRUMap<Constructor<Object>, KFunction<Object>> javaConstructorToKotlin;
    private final LRUMap<Constructor<Object>, ConstructorValueCreator<?>> javaConstructorToValueCreator;
    private final LRUMap<AnnotatedMember, BooleanTriState> javaMemberIsRequired;
    private final LRUMap<Method, KFunction<?>> javaMethodToKotlin;
    private final LRUMap<Method, MethodValueCreator<?>> javaMethodToValueCreator;
    private final LRUMap<AnnotatedMethod, Boolean> kotlinGeneratedMethod;

    /* compiled from: ReflectionCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/Boolean;)V", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "Companion", "Empty", "False", "True", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class BooleanTriState {
        private final Boolean value;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final True TRUE = new True();
        private static final False FALSE = new False();
        private static final Empty EMPTY = new Empty();

        public /* synthetic */ BooleanTriState(Boolean bool, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool);
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "()V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class True extends BooleanTriState {
            public True() {
                super(Boolean.TRUE, null);
            }
        }

        private BooleanTriState(Boolean bool) {
            this.value = bool;
        }

        public final Boolean getValue() {
            return this.value;
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "()V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class False extends BooleanTriState {
            public False() {
                super(Boolean.FALSE, null);
            }
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "()V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Empty extends BooleanTriState {
            public Empty() {
                super(null, 0 == true ? 1 : 0);
            }
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Companion;", "", "()V", "EMPTY", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "FALSE", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "TRUE", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "fromBoolean", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/Boolean;)Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BooleanTriState fromBoolean(Boolean value) {
                if (value == null) {
                    return BooleanTriState.EMPTY;
                }
                if (Intrinsics.areEqual(value, Boolean.TRUE)) {
                    return BooleanTriState.TRUE;
                }
                if (Intrinsics.areEqual(value, Boolean.FALSE)) {
                    return BooleanTriState.FALSE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public ReflectionCache(int i) {
        this.javaClassToKotlin = new LRUMap<>(i, i);
        this.javaConstructorToKotlin = new LRUMap<>(i, i);
        this.javaMethodToKotlin = new LRUMap<>(i, i);
        this.javaConstructorToValueCreator = new LRUMap<>(i, i);
        this.javaMethodToValueCreator = new LRUMap<>(i, i);
        this.javaConstructorIsCreatorAnnotated = new LRUMap<>(i, i);
        this.javaMemberIsRequired = new LRUMap<>(i, i);
        this.kotlinGeneratedMethod = new LRUMap<>(i, i);
    }

    public final KClass<Object> kotlinFromJava(Class<Object> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KClass<Object> kClass = this.javaClassToKotlin.get(key);
        if (kClass != null) {
            return kClass;
        }
        KClass<Object> kotlinClass = JvmClassMappingKt.getKotlinClass(key);
        KClass<Object> kClassPutIfAbsent = this.javaClassToKotlin.putIfAbsent(key, kotlinClass);
        return kClassPutIfAbsent == null ? kotlinClass : kClassPutIfAbsent;
    }

    public final KFunction<Object> kotlinFromJava(Constructor<Object> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KFunction<Object> kFunction = this.javaConstructorToKotlin.get(key);
        if (kFunction != null) {
            return kFunction;
        }
        KFunction<Object> kotlinFunction = ReflectJvmMapping.getKotlinFunction(key);
        if (kotlinFunction == null) {
            return null;
        }
        KFunction<Object> kFunctionPutIfAbsent = this.javaConstructorToKotlin.putIfAbsent(key, kotlinFunction);
        return kFunctionPutIfAbsent == null ? kotlinFunction : kFunctionPutIfAbsent;
    }

    public final KFunction<?> kotlinFromJava(Method key) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(key, "key");
        KFunction<?> kFunction = this.javaMethodToKotlin.get(key);
        if (kFunction != null) {
            return kFunction;
        }
        KFunction<?> kotlinFunction = ReflectJvmMapping.getKotlinFunction(key);
        if (kotlinFunction == null) {
            return null;
        }
        KFunction<?> kFunctionPutIfAbsent = this.javaMethodToKotlin.putIfAbsent(key, kotlinFunction);
        return kFunctionPutIfAbsent == null ? kotlinFunction : kFunctionPutIfAbsent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        if (r3 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fasterxml.jackson.module.kotlin.ValueCreator<?> valueCreatorFromJava(com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r3) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r2 = this;
            java.lang.String r0 = "_withArgsCreator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3 instanceof com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            r1 = 0
            if (r0 == 0) goto L3f
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r3 = (com.fasterxml.jackson.databind.introspect.AnnotatedConstructor) r3
            java.lang.reflect.Constructor r3 = r3.getAnnotated()
            if (r3 == 0) goto L37
            com.fasterxml.jackson.databind.util.LRUMap<java.lang.reflect.Constructor<java.lang.Object>, com.fasterxml.jackson.module.kotlin.ConstructorValueCreator<?>> r0 = r2.javaConstructorToValueCreator
            java.lang.Object r0 = r0.get(r3)
            com.fasterxml.jackson.module.kotlin.ConstructorValueCreator r0 = (com.fasterxml.jackson.module.kotlin.ConstructorValueCreator) r0
            if (r0 != 0) goto L35
            kotlin.reflect.KFunction r0 = r2.kotlinFromJava(r3)
            if (r0 != 0) goto L23
            goto L6d
        L23:
            com.fasterxml.jackson.module.kotlin.ConstructorValueCreator r1 = new com.fasterxml.jackson.module.kotlin.ConstructorValueCreator
            r1.<init>(r0)
            com.fasterxml.jackson.databind.util.LRUMap<java.lang.reflect.Constructor<java.lang.Object>, com.fasterxml.jackson.module.kotlin.ConstructorValueCreator<?>> r0 = r2.javaConstructorToValueCreator
            java.lang.Object r3 = r0.putIfAbsent(r3, r1)
            com.fasterxml.jackson.module.kotlin.ConstructorValueCreator r3 = (com.fasterxml.jackson.module.kotlin.ConstructorValueCreator) r3
            if (r3 != 0) goto L33
            goto L6d
        L33:
            r1 = r3
            goto L6d
        L35:
            r1 = r0
            goto L6d
        L37:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.reflect.Constructor<kotlin.Any>"
            r3.<init>(r0)
            throw r3
        L3f:
            boolean r0 = r3 instanceof com.fasterxml.jackson.databind.introspect.AnnotatedMethod
            if (r0 == 0) goto L76
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r3 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r3
            java.lang.reflect.Method r3 = r3.getAnnotated()
            if (r3 == 0) goto L6e
            com.fasterxml.jackson.databind.util.LRUMap<java.lang.reflect.Method, com.fasterxml.jackson.module.kotlin.MethodValueCreator<?>> r0 = r2.javaMethodToValueCreator
            java.lang.Object r0 = r0.get(r3)
            com.fasterxml.jackson.module.kotlin.MethodValueCreator r0 = (com.fasterxml.jackson.module.kotlin.MethodValueCreator) r0
            if (r0 != 0) goto L35
            kotlin.reflect.KFunction r0 = r2.kotlinFromJava(r3)
            if (r0 != 0) goto L5c
            goto L6d
        L5c:
            com.fasterxml.jackson.module.kotlin.MethodValueCreator$Companion r1 = com.fasterxml.jackson.module.kotlin.MethodValueCreator.INSTANCE
            com.fasterxml.jackson.module.kotlin.MethodValueCreator r0 = r1.of(r0)
            com.fasterxml.jackson.databind.util.LRUMap<java.lang.reflect.Method, com.fasterxml.jackson.module.kotlin.MethodValueCreator<?>> r1 = r2.javaMethodToValueCreator
            java.lang.Object r3 = r1.putIfAbsent(r3, r0)
            com.fasterxml.jackson.module.kotlin.MethodValueCreator r3 = (com.fasterxml.jackson.module.kotlin.MethodValueCreator) r3
            if (r3 != 0) goto L33
            goto L35
        L6d:
            return r1
        L6e:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.reflect.Method"
            r3.<init>(r0)
            throw r3
        L76:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.reflect.AnnotatedElement r3 = r3.getAnnotated()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.String r1 = "Expected a constructor or method to create a Kotlin object, instead found "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.ReflectionCache.valueCreatorFromJava(com.fasterxml.jackson.databind.introspect.AnnotatedWithParams):com.fasterxml.jackson.module.kotlin.ValueCreator");
    }

    public final boolean checkConstructorIsCreatorAnnotated(AnnotatedConstructor key, Function1<? super AnnotatedConstructor, Boolean> calc) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(calc, "calc");
        Boolean bool = this.javaConstructorIsCreatorAnnotated.get(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolInvoke = calc.invoke(key);
        boolean zBooleanValue = boolInvoke.booleanValue();
        Boolean boolPutIfAbsent = this.javaConstructorIsCreatorAnnotated.putIfAbsent(key, boolInvoke);
        return boolPutIfAbsent == null ? zBooleanValue : boolPutIfAbsent.booleanValue();
    }

    public final Boolean javaMemberIsRequired(AnnotatedMember key, Function1<? super AnnotatedMember, Boolean> calc) {
        Boolean value;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(calc, "calc");
        BooleanTriState booleanTriState = this.javaMemberIsRequired.get(key);
        Boolean value2 = booleanTriState == null ? null : booleanTriState.getValue();
        if (value2 != null) {
            return value2;
        }
        Boolean boolInvoke = calc.invoke(key);
        BooleanTriState booleanTriStatePutIfAbsent = this.javaMemberIsRequired.putIfAbsent(key, BooleanTriState.INSTANCE.fromBoolean(boolInvoke));
        return (booleanTriStatePutIfAbsent == null || (value = booleanTriStatePutIfAbsent.getValue()) == null) ? boolInvoke : value;
    }

    public final boolean isKotlinGeneratedMethod(AnnotatedMethod key, Function1<? super AnnotatedMethod, Boolean> calc) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(calc, "calc");
        Boolean bool = this.kotlinGeneratedMethod.get(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolInvoke = calc.invoke(key);
        boolean zBooleanValue = boolInvoke.booleanValue();
        Boolean boolPutIfAbsent = this.kotlinGeneratedMethod.putIfAbsent(key, boolInvoke);
        return boolPutIfAbsent == null ? zBooleanValue : boolPutIfAbsent.booleanValue();
    }
}
