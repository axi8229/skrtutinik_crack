package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: PreviewUtils.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a5\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0014\u0010\u0005\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "asPreviewProviderClass", "(Ljava/lang/String;)Ljava/lang/Class;", "parameterProviderClass", "", "parameterProviderIndex", "", "", "getPreviewProviderParameters", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "classToCheck", "unwrapIfInline", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/sequences/Sequence;", "size", "toArray", "(Lkotlin/sequences/Sequence;I)[Ljava/lang/Object;", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreviewUtils_androidKt {
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            PreviewLogger.INSTANCE.logError$ui_tooling_release("Unable to find PreviewProvider '" + str + '\'', e);
            return null;
        }
    }

    public static final Object[] getPreviewProviderParameters(Class<? extends PreviewParameterProvider<?>> cls, int i) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (cls == null) {
            return new Object[0];
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i2 = 0;
            boolean z = false;
            Constructor<?> constructor = null;
            while (true) {
                if (i2 < length) {
                    Constructor<?> constructor2 = constructors[i2];
                    if (constructor2.getParameterTypes().length == 0) {
                        if (z) {
                            break;
                        }
                        z = true;
                        constructor = constructor2;
                    }
                    i2++;
                } else if (!z) {
                }
            }
            constructor = null;
            if (constructor != null) {
                constructor.setAccessible(true);
                Object objNewInstance = constructor.newInstance(null);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
                PreviewParameterProvider previewParameterProvider = (PreviewParameterProvider) objNewInstance;
                if (i < 0) {
                    return toArray(previewParameterProvider.getValues(), previewParameterProvider.getCount());
                }
                List listListOf = CollectionsKt.listOf(SequencesKt.elementAt(previewParameterProvider.getValues(), i));
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    arrayList.add(unwrapIfInline(it.next()));
                }
                return arrayList.toArray(new Object[0]);
            }
            throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
        } catch (KotlinReflectionNotSupportedError unused) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }

    private static final Object unwrapIfInline(Object obj) throws NoSuchFieldException, SecurityException {
        if (obj != null) {
            for (Annotation annotation : obj.getClass().getAnnotations()) {
                if (annotation instanceof JvmInline) {
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (field.getType().isPrimitive()) {
                            Field declaredField = obj.getClass().getDeclaredField(field.getName());
                            declaredField.setAccessible(true);
                            return declaredField.get(obj);
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }
            }
        }
        return obj;
    }

    private static final Object[] toArray(Sequence<? extends Object> sequence, int i) {
        Iterator<? extends Object> it = sequence.iterator();
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = it.next();
        }
        return objArr;
    }
}
