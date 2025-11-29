package spay.sdk.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import coil.request.ImageRequest;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.C0;
import npi.spay.C1560e6;
import npi.spay.C1884r7;
import npi.spay.C1955u3;
import npi.spay.EnumC1577en;
import npi.spay.EnumC1877r0;
import npi.spay.Ik;
import npi.spay.Im;
import npi.spay.K5;
import okio.ByteString;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.RedirectActivity;
import spay.sdk.SPaySdkApp;
import spay.sdk.api.PaymentResult;
import spay.sdk.b;
import spay.sdk.d;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\r\u001a\u00020\tH\u0007JT\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0007JT\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0015H\u0007¨\u0006!"}, d2 = {"Lspay/sdk/view/SPayButton;", "Landroid/widget/FrameLayout;", "", "dpRadius", "", "setCornerRadius", "Landroid/content/Context;", "context", "Lkotlin/Pair;", "", "", "", "checkPermissions", "isReadyForSPaySdk", "authorization", "merchantLogin", "orderId", "orderNumber", "appPackage", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "Lkotlin/Function1;", "Lspay/sdk/api/PaymentResult;", "callback", "payWithOrderId", "apiKey", "bankInvoiceId", "payWithBankInvoiceId", "paymentResult", "completePayment", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SPayButton extends FrameLayout {
    public final View a;
    public final C1884r7 b;
    public final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SPayButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = View.inflate(context, R$layout.spay_button, this);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(context, R.layout.spay_button, this)");
        this.a = viewInflate;
        SPaySdkApp.Companion companion = SPaySdkApp.INSTANCE;
        Im sdkComponent = companion.getInstance().getSdkComponent();
        this.b = sdkComponent != null ? ((Ik) sdkComponent).a() : null;
        Im sdkComponent2 = companion.getInstance().getSdkComponent();
        C1955u3 c1955u3B = sdkComponent2 != null ? ((Ik) sdkComponent2).b() : null;
        this.c = "PHN2ZyB3aWR0aD0iNDgiIGhlaWdodD0iMTgiIHZpZXdCb3g9IjAgMCA0OCAxOCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTI0LjkzMDMgMTAuNDQ5OVYxMy45MTUxSDIyLjk4MjdWMi43OTA3MUgyNi42MDk4QzMwLjA1MTUgMi43OTA3MSAzMS41MTQxIDQuMDQ2OTMgMzEuNTE0MSA2LjU1Njg4QzMxLjUxNDEgOS4xNDY0MyAyOS44MDA1IDEwLjQ0OTkgMjYuNjA5OCAxMC40NDk5SDI0LjkzMDNaTTI0LjkzMDMgNC42MTkwN1Y4LjYyNDA0SDI2Ljc1MTFDMjguNTU3MyA4LjYyNDA0IDI5LjQ5MDkgOC4wMTk1NyAyOS40OTA5IDYuNTA5NjJDMjkuNDkwOSA1LjE0Mzk0IDI4LjY4MTcgNC42MTkwNyAyNi43ODA0IDQuNjE5MDdIMjQuOTMwM1oiIGZpbGw9IndoaXRlIi8+CjxwYXRoIGQ9Ik0zMi41NDIxIDYuNTIzNzhDMzMuMDU2NCA2LjEyNTc3IDMzLjk5IDUuODA5ODUgMzUuMzMwNiA1LjgwOTg1QzM3LjYwNDggNS44MDk4NSAzOC43MjYxIDYuNjAzMzggMzguNzI2MSA4LjY3MDU1VjEzLjkxNDNIMzcuMDEyNVYxMi40ODRDMzYuNjM5NiAxMy40MDY5IDM1LjY4ODkgMTQuMDQxMiAzNC40NDMzIDE0LjA0MTJDMzIuODcxMSAxNC4wNDEyIDMxLjkzNTEgMTMuMTM1NyAzMS45MzUxIDExLjU3ODVDMzEuOTM1MSA5Ljc2NzU2IDMzLjIyNyA5LjI1NzYxIDM1LjE0MjkgOS4yNTc2MUgzNi45MDI4VjguOTA2ODZDMzYuOTAyOCA3Ljc3NzUxIDM2LjM3MzkgNy40MjkyNSAzNS4zMzA2IDcuNDI5MjVDMzMuODk3MyA3LjQyOTI1IDMzLjA3MzQgOC4wMDEzOSAzMi41NDIxIDguODQ0NjdWNi41MjM3OFpNMzYuOTAyOCAxMS4xMTgzVjEwLjQ2NjZIMzUuMzYyM0MzNC4yODczIDEwLjQ2NjYgMzMuNzczIDEwLjY3MyAzMy43NzMgMTEuMzg5NEMzMy43NzMgMTEuOTkzOSAzNC4yMDkzIDEyLjM3NDUgMzUuMDE4NiAxMi4zNzQ1QzM2LjI0OTYgMTIuMzcyIDM2LjgyNDggMTEuNjU4MSAzNi45MDI4IDExLjExODNaIiBmaWxsPSJ3aGl0ZSIvPgo8cGF0aCBkPSJNMzkuNjI4NCA1Ljk2OTc2SDQxLjY2ODZMNDMuODAxNCAxMS40Mkw0NS41NDQyIDUuOTY5NzZINDcuNDc0N0w0NC4zNTk2IDE0Ljc1ODNDNDMuNjc0NyAxNi42NjYzIDQyLjk3MjcgMTcuMDk0MSA0MS45NDY1IDE3LjA5NDFDNDEuNDYzOCAxNy4wOTQxIDQwLjkzNDkgMTYuOTUyMyA0MC43MDA5IDE2Ljc0MzRWMTUuMDEyQzQwLjkzNDkgMTUuMjUwOCA0MS4yOTMyIDE1LjQxIDQxLjYzNDUgMTUuNDFDNDIuMTk1MSAxNS40MSA0Mi42MTQzIDE1LjAyOTQgNDIuOTExNyAxMy45NDc0TDM5LjYyODQgNS45Njk3NloiIGZpbGw9IndoaXRlIi8+CjxwYXRoIGQ9Ik01LjE1OTY3IDYuNTMyODlWOC45NzMxOUw4LjMzMDg4IDExLjAwMDVMMTUuOTE4OSA1LjI5NDA4QzE1LjY1MDcgNC42ODk2MSAxNS4zMTQ0IDQuMTI0OTMgMTQuOTE5NSAzLjYwNTAzTDguMzMwODggOC41NjAyNUw1LjE1OTY3IDYuNTMyODlaIiBmaWxsPSJ3aGl0ZSIvPgo8cGF0aCBkPSJNMTQuNzMyMyA4LjYyMzE5QzE0LjczNDggOC42ODA0IDE0LjczNDggOC43NDAxIDE0LjczNDggOC43OTczMkMxNC43MzQ4IDEyLjQwMTggMTEuODYwOSAxNS4zMzIxIDguMzMxNDIgMTUuMzMyMUM0LjgwMTkgMTUuMzMyMSAxLjkyNTY0IDEyLjQwMTggMS45MjU2NCA4Ljc5NzMyQzEuOTI1NjQgNS4xOTI4NCA0Ljc5OTQ2IDIuMjYyNDkgOC4zMjg5OCAyLjI2MjQ5QzkuNjY3MTggMi4yNjI0OSAxMC45MTAzIDIuNjgyODkgMTEuOTM4OSAzLjQwNDI4TDEzLjU1NzQgMi4xODUzOEMxMi4xMjkxIDEuMDA2MjcgMTAuMzA4MiAwLjI5OTgwNSA4LjMyNjU1IDAuMjk5ODA1QzMuNzI2OTYgMC4yOTk4MDUgMCA0LjEwNTc4IDAgOC43OTk4QzAgMTMuNDkzOCAzLjcyOTQgMTcuMjk5OCA4LjMyNjU1IDE3LjI5OThDMTIuOTI2MSAxNy4yOTk4IDE2LjY1MzEgMTMuNDkzOCAxNi42NTMxIDguNzk5OEMxNi42NTMxIDguMjc5OSAxNi42MDY4IDcuNzY5OTUgMTYuNTE5IDcuMjc3NDJMMTQuNzMyMyA4LjYyMzE5WiIgZmlsbD0id2hpdGUiLz4KPC9zdmc+Cg==";
        a();
        if (c1955u3B != null) {
            c1955u3B.a(new C1560e6(EnumC1577en.LC_PAY_BUTTON_INITED, EnumC1877r0.MERCHANT_VIEW, C0.LC, null, null, null, null, 120));
        }
    }

    public final void a() {
        ByteString byteStringDecodeBase64;
        CardView cardView = (CardView) this.a.findViewById(R$id.f40spay_v_btn_pay);
        AppCompatImageView targetView = (AppCompatImageView) this.a.findViewById(R$id.spay_aciv_bank_logo_clear);
        C1884r7 c1884r7 = this.b;
        if (c1884r7 != null) {
            String str = this.c;
            Intrinsics.checkNotNullExpressionValue(targetView, "acivBankLogoClear");
            K5 imageRequestBuilder = K5.a;
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ByteBuffer byteBufferAsByteBuffer = (str == null || (byteStringDecodeBase64 = ByteString.INSTANCE.decodeBase64(str)) == null) ? null : byteStringDecodeBase64.asByteBuffer();
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            ImageRequest.Builder builderTarget = new ImageRequest.Builder(c1884r7.a).data(byteBufferAsByteBuffer).target(targetView);
            imageRequestBuilder.getClass();
            Intrinsics.checkNotNullParameter(builderTarget, "$this$null");
            Unit unit = Unit.INSTANCE;
            c1884r7.b.enqueue(builderTarget.build());
        }
        cardView.setOnClickListener(new View.OnClickListener() { // from class: spay.sdk.view.SPayButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SPayButton.a(this.f$0, view);
            }
        });
    }

    public final Pair<Boolean, List<String>> checkPermissions(Context context) {
        d dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } finally {
            }
        }
        return dVar.a(context);
    }

    @Deprecated
    public final void completePayment(PaymentResult paymentResult) {
        d dVar;
        Intrinsics.checkNotNullParameter(paymentResult, "paymentResult");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } finally {
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        dVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentResult, "paymentResult");
        context.startActivity(new Intent(context, (Class<?>) RedirectActivity.class).putExtra("PAYMENT_RESULT", paymentResult));
    }

    @Deprecated
    public final boolean isReadyForSPaySdk() {
        d dVar;
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } finally {
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dVar.b(context);
    }

    @Deprecated
    public final void payWithBankInvoiceId(String apiKey, String merchantLogin, String bankInvoiceId, String orderNumber, String appPackage, String language, Function1<? super PaymentResult, Unit> callback) {
        d dVar;
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        dVar.a(context, apiKey, merchantLogin, bankInvoiceId, orderNumber, appPackage, language, callback);
    }

    @Deprecated
    public final void payWithOrderId(String authorization, String merchantLogin, String orderId, String orderNumber, String appPackage, String language, Function1<? super PaymentResult, Unit> callback) {
        d dVar;
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        dVar.a(context, authorization, merchantLogin, orderId, orderNumber, appPackage, language, callback);
    }

    public final void setCornerRadius(int dpRadius) {
        ((CardView) this.a.findViewById(R$id.f40spay_v_btn_pay)).setRadius((int) (dpRadius * Resources.getSystem().getDisplayMetrics().density));
    }

    public static final void a(SPayButton this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.performClick();
    }
}
