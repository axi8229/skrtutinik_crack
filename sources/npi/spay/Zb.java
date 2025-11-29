package npi.spay;

import androidx.appcompat.widget.AppCompatImageView;
import coil.request.ImageRequest;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Zb implements FlowCollector {
    public final /* synthetic */ T9 a;
    public final /* synthetic */ C1591fc b;

    public Zb(T9 t9, C1591fc c1591fc) {
        this.a = t9;
        this.b = c1591fc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ListOfCardsResponseBody.PromoInfo.BannerData bannerData = (ListOfCardsResponseBody.PromoInfo.BannerData) obj;
        this.a.c.setText(bannerData.getText());
        String iconUrl = bannerData.getIconUrl();
        if (iconUrl != null && iconUrl.length() != 0) {
            AppCompatImageView targetView = this.a.b;
            Intrinsics.checkNotNullExpressionValue(targetView, "spayLnmcAcivImage");
            C1884r7 c1884r7 = this.b.d;
            if (c1884r7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coilImpl");
                c1884r7 = null;
            }
            String iconUrl2 = bannerData.getIconUrl();
            Yj imageRequestListener = new Yj();
            Intrinsics.checkNotNullParameter(targetView, "<this>");
            Intrinsics.checkNotNullParameter(imageRequestListener, "imageRequestListener");
            if (c1884r7 != null) {
                Qk imageRequestBuilder = new Qk(imageRequestListener);
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
                ImageRequest.Builder loadImage = new ImageRequest.Builder(c1884r7.a).data(iconUrl2).target(targetView);
                Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                loadImage.listener(imageRequestListener);
                Unit unit = Unit.INSTANCE;
                c1884r7.b.enqueue(loadImage.build());
            }
        }
        return Unit.INSTANCE;
    }
}
