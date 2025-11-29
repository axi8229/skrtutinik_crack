package com.ryanharter.auto.value.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface GenerateTypeAdapter {

    /* renamed from: com.ryanharter.auto.value.gson.GenerateTypeAdapter$1, reason: invalid class name */
    static class AnonymousClass1 implements TypeAdapterFactory {
        private final Class<?> typeArrayClass = Array.newInstance((Class<?>) Type.class, 0).getClass();
        private final Map<Class<?>, Constructor<? extends TypeAdapter>> adapters = Collections.synchronizedMap(new LinkedHashMap());

        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Class<? super T> rawType = typeToken.getRawType();
            if (!rawType.isAnnotationPresent(GenerateTypeAdapter.class)) {
                return null;
            }
            Class<? super Object> superclass = rawType.getSuperclass();
            if (superclass.isAnnotationPresent(GenerateTypeAdapter.class)) {
                return gson.getAdapter(superclass);
            }
            Constructor<? extends TypeAdapter> constructorFindConstructorForClass = findConstructorForClass(rawType);
            if (constructorFindConstructorForClass == null) {
                return null;
            }
            try {
                if (constructorFindConstructorForClass.getParameterTypes().length == 1) {
                    return constructorFindConstructorForClass.newInstance(gson);
                }
                return constructorFindConstructorForClass.newInstance(gson, ((ParameterizedType) typeToken.getType()).getActualTypeArguments());
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to invoke " + constructorFindConstructorForClass, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Unable to invoke " + constructorFindConstructorForClass, e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Could not create generated TypeAdapter instance for type " + rawType, cause);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor<? extends TypeAdapter> findConstructorForClass(Class<?> cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Constructor<? extends TypeAdapter> constructorFindConstructorForClass;
            Constructor<? extends TypeAdapter> constructor = this.adapters.get(cls);
            if (constructor != null) {
                return constructor;
            }
            String name = cls.getName();
            if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("kotlin.")) {
                return null;
            }
            try {
                try {
                    String strReplace = cls.getName().replace("$", "_");
                    Class<?> clsLoadClass = cls.getClassLoader().loadClass(strReplace + "_GsonTypeAdapter");
                    try {
                        constructorFindConstructorForClass = clsLoadClass.getDeclaredConstructor(Gson.class);
                        constructorFindConstructorForClass.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                        constructorFindConstructorForClass = clsLoadClass.getDeclaredConstructor(Gson.class, this.typeArrayClass);
                        constructorFindConstructorForClass.setAccessible(true);
                    }
                } catch (ClassNotFoundException unused2) {
                    constructorFindConstructorForClass = findConstructorForClass(cls.getSuperclass());
                    if (constructorFindConstructorForClass != null) {
                        constructorFindConstructorForClass.setAccessible(true);
                    }
                }
                this.adapters.put(cls, constructorFindConstructorForClass);
                return constructorFindConstructorForClass;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e);
            }
        }
    }
}
