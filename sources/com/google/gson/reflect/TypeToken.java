package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    protected TypeToken() {
        Type typeTokenTypeArgument = getTypeTokenTypeArgument();
        this.type = typeTokenTypeArgument;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(typeTokenTypeArgument);
        this.hashCode = typeTokenTypeArgument.hashCode();
    }

    private TypeToken(Type type) {
        Type typeCanonicalize = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.type = typeCanonicalize;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(typeCanonicalize);
        this.hashCode = typeCanonicalize.hashCode();
    }

    private Type getTypeTokenTypeArgument() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                return C$Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.type, ((TypeToken) obj).type);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        return new TypeToken<>(C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr));
    }
}
