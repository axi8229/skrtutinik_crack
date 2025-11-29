package npi.spay;

import coil.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Qk extends Lambda implements Function1 {
    public final /* synthetic */ ImageRequest.Listener a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qk(ImageRequest.Listener listener) {
        super(1);
        this.a = listener;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ImageRequest.Builder loadImage = (ImageRequest.Builder) obj;
        Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
        loadImage.listener(this.a);
        return Unit.INSTANCE;
    }
}
