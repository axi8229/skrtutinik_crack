package kotlinx.serialization.json;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Json.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/json/Json;", RemoteMessageConst.FROM, "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonBuilder;", "", "builderAction", "Json", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/json/Json;", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JsonKt {
    public static /* synthetic */ Json Json$default(Json json, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            json = Json.INSTANCE;
        }
        return Json(json, function1);
    }

    public static final Json Json(Json from, Function1<? super JsonBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonBuilder jsonBuilder = new JsonBuilder(from);
        builderAction.invoke(jsonBuilder);
        return new JsonImpl(jsonBuilder.build$kotlinx_serialization_json(), jsonBuilder.getSerializersModule());
    }
}
