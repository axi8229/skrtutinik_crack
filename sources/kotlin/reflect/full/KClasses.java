package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: KClasses.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"6\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"(\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\t\u0010\n\",\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\r*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000e\u0010\u000f\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\r*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u000f\">\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00150\r\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0016\u0010\u000f\">\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00150\r\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0019\u0010\u000f\"\u001c\u0010\u001e\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001c\u0010 \u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"", "T", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KFunction;", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "getPrimaryConstructor$annotations", "(Lkotlin/reflect/KClass;)V", "primaryConstructor", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "getCompanionObject$annotations", "companionObject", "", "getFunctions", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "getFunctions$annotations", "functions", "getDeclaredFunctions", "getDeclaredFunctions$annotations", "declaredFunctions", "Lkotlin/reflect/KProperty1;", "getMemberProperties", "getMemberProperties$annotations", "memberProperties", "getDeclaredMemberProperties", "getDeclaredMemberProperties$annotations", "declaredMemberProperties", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "isExtension", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KClasses {
    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> kClass) {
        T next;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator<T> it = ((KClassImpl) kClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            KFunction kFunction = (KFunction) next;
            Intrinsics.checkNotNull(kFunction, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
            Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                break;
            }
        }
        return (KFunction) next;
    }

    public static final KClass<?> getCompanionObject(KClass<?> kClass) {
        Object next;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator<T> it = kClass.getNestedClasses().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            KClass kClass2 = (KClass) next;
            Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            if (((KClassImpl) kClass2).getDescriptor().isCompanionObject()) {
                break;
            }
        }
        return (KClass) next;
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallable<?>> members = kClass.getMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : members) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredMembers) {
            if (obj instanceof KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> allNonStaticMembers = ((KClassImpl) kClass).getData().getValue().getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection<KCallableImpl<?>> declaredNonStaticMembers = ((KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (T t : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    private static final boolean isExtension(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }
}
