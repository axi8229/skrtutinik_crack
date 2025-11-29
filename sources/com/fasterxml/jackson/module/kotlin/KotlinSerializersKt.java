package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinSerializers.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0002¨\u0006\u0003"}, d2 = {"getStaticJsonValueGetter", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "jackson-module-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class KotlinSerializersKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Method getStaticJsonValueGetter(Class<?> cls) throws SecurityException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "this.declaredMethods");
        for (Method method : declaredMethods) {
            if (Modifier.isStatic(method.getModifiers())) {
                Annotation[] annotations = method.getAnnotations();
                Intrinsics.checkNotNullExpressionValue(annotations, "method.annotations");
                for (Annotation annotation : annotations) {
                    if (annotation instanceof JsonValue) {
                        return method;
                    }
                }
            }
        }
        return null;
    }
}
