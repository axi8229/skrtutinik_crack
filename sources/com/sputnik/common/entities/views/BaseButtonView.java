package com.sputnik.common.entities.views;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$layout;
import com.sputnik.common.entities.views.BaseView;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.domain.entities.buttons.ColorsButton;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseButtonView.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/sputnik/common/entities/views/BaseButtonView;", "Lcom/sputnik/common/entities/views/BaseView;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "deeplink", "Lcom/sputnik/domain/entities/buttons/ColorsButton;", RemoteMessageConst.Notification.COLOR, "", "needSeparateToBottom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/buttons/ColorsButton;Z)V", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/View;", "getView", "(Landroid/view/LayoutInflater;)Landroid/view/View;", "Ljava/lang/String;", "getDeeplink", "()Ljava/lang/String;", "Lcom/sputnik/domain/entities/buttons/ColorsButton;", "Z", "getNeedSeparateToBottom", "()Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseButtonView extends BaseView {
    private final ColorsButton color;
    private final String deeplink;
    private final boolean needSeparateToBottom;
    private final String title;

    /* compiled from: BaseButtonView.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorsButton.values().length];
            try {
                iArr[ColorsButton.blue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorsButton.red.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorsButton.green.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorsButton.transparent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public /* synthetic */ BaseButtonView(String str, String str2, ColorsButton colorsButton, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? ColorsButton.blue : colorsButton, (i & 8) != 0 ? false : z);
    }

    public final boolean getNeedSeparateToBottom() {
        return this.needSeparateToBottom;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseButtonView(String title, String deeplink, ColorsButton color, boolean z) {
        super(BaseView.Types.button);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        Intrinsics.checkNotNullParameter(color, "color");
        this.title = title;
        this.deeplink = deeplink;
        this.color = color;
        this.needSeparateToBottom = z;
    }

    @Override // com.sputnik.common.entities.views.BaseView
    public View getView(LayoutInflater layoutInflater) {
        int i;
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.color.ordinal()];
        if (i2 == 1) {
            i = R$layout.layout_button_blue;
        } else if (i2 == 2) {
            i = R$layout.layout_button_pink;
        } else if (i2 == 3) {
            i = R$layout.layout_button_green;
        } else if (i2 == 4) {
            i = R$layout.layout_button_transparent;
        } else {
            i = R$layout.layout_button_transparent;
        }
        View viewInflate = layoutInflater.inflate(i, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatButton");
        AppCompatButton appCompatButton = (AppCompatButton) viewInflate;
        appCompatButton.setText(this.title);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Resources resources = appCompatButton.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int iConvertPxToDb = DpUtilsKt.convertPxToDb(16.0f, resources);
        Resources resources2 = appCompatButton.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        int iConvertPxToDb2 = DpUtilsKt.convertPxToDb(20.0f, resources2);
        layoutParams.setMargins(iConvertPxToDb2, iConvertPxToDb, iConvertPxToDb2, 0);
        appCompatButton.setLayoutParams(layoutParams);
        return appCompatButton;
    }
}
