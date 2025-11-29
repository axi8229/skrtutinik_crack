package androidx.navigation.serialization;

import androidx.navigation.NavType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* compiled from: RouteSerializer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a=\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00050\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001ac\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00050\u00032&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "T", "route", "", "", "Landroidx/navigation/NavType;", "typeMap", "generateRouteWithArgs", "(Ljava/lang/Object;Ljava/util/Map;)Ljava/lang/String;", "Lkotlinx/serialization/KSerializer;", "", "generateHashCode", "(Lkotlinx/serialization/KSerializer;)I", "Lkotlin/Function3;", "", "operation", "forEachIndexedName", "(Lkotlinx/serialization/KSerializer;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)V", "forEachIndexed", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RouteSerializerKt {
    public static final <T> String generateRouteWithArgs(T route, Map<String, ? extends NavType<Object>> typeMap) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        KSerializer kSerializerSerializer = SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()));
        final Map<String, List<String>> mapEncodeToArgMap = new RouteEncoder(kSerializerSerializer, typeMap).encodeToArgMap(route);
        final RouteBuilder routeBuilder = new RouteBuilder(kSerializerSerializer);
        forEachIndexedName(kSerializerSerializer, typeMap, new Function3<Integer, String, NavType<Object>, Unit>() { // from class: androidx.navigation.serialization.RouteSerializerKt.generateRouteWithArgs.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, NavType<Object> navType) {
                invoke(num.intValue(), str, navType);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, String argName, NavType<Object> navType) {
                Intrinsics.checkNotNullParameter(argName, "argName");
                Intrinsics.checkNotNullParameter(navType, "navType");
                List<String> list = mapEncodeToArgMap.get(argName);
                Intrinsics.checkNotNull(list);
                routeBuilder.appendArg(i, argName, navType, list);
            }
        });
        return routeBuilder.build();
    }

    public static final <T> int generateHashCode(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        int iHashCode = kSerializer.getDescriptor().getSerialName().hashCode();
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            iHashCode = (iHashCode * 31) + kSerializer.getDescriptor().getElementName(i).hashCode();
        }
        return iHashCode;
    }

    private static final <T> void forEachIndexedName(KSerializer<T> kSerializer, Map<String, ? extends NavType<Object>> map, Function3<? super Integer, ? super String, ? super NavType<Object>, Unit> function3) {
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            String elementName = kSerializer.getDescriptor().getElementName(i);
            NavType<Object> navType = map.get(elementName);
            if (navType == null) {
                throw new IllegalStateException(("Cannot locate NavType for argument [" + elementName + ']').toString());
            }
            function3.invoke(Integer.valueOf(i), elementName, navType);
        }
    }
}
