package ru.yoomoney.sdk.auth.utils;

import com.squareup.picasso.RequestCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"cropToCircle", "Lcom/squareup/picasso/RequestCreator;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PicassoExtensionsKt {
    public static final RequestCreator cropToCircle(RequestCreator requestCreator) {
        Intrinsics.checkNotNullParameter(requestCreator, "<this>");
        RequestCreator requestCreatorTransform = requestCreator.transform(new CircleImageTransformation());
        Intrinsics.checkNotNullExpressionValue(requestCreatorTransform, "transform(...)");
        return requestCreatorTransform;
    }
}
