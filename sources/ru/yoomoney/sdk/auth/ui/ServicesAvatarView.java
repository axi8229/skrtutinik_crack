package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.api.account.model.Service;
import ru.yoomoney.sdk.auth.utils.PicassoExtensionsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u0014\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/ui/ServicesAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemSize", "", "marginSize", "createImageView", "Landroid/widget/ImageView;", "setIcons", "", "drawables", "", "setServices", "services", "Lru/yoomoney/sdk/auth/api/account/model/Service;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServicesAvatarView extends ConstraintLayout {
    private final int itemSize;
    private final int marginSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServicesAvatarView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView createImageView() {
        int iGenerateViewId = View.generateViewId();
        ImageView imageView = new ImageView(getContext());
        imageView.setId(iGenerateViewId);
        int i = this.itemSize;
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(i, i));
        addView(imageView);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.connect(iGenerateViewId, 7, 0, 7, (getChildCount() - 1) * this.marginSize);
        constraintSet.connect(iGenerateViewId, 3, 0, 3);
        constraintSet.applyTo(this);
        return imageView;
    }

    public final void setIcons(List<Integer> drawables) {
        Intrinsics.checkNotNullParameter(drawables, "drawables");
        removeAllViews();
        Iterator it = CollectionsKt.reversed(drawables).iterator();
        while (it.hasNext()) {
            createImageView().setImageResource(((Number) it.next()).intValue());
        }
    }

    public final void setServices(List<Service> services) {
        Intrinsics.checkNotNullParameter(services, "services");
        removeAllViews();
        for (Service service : CollectionsKt.reversed(services)) {
            ImageView imageViewCreateImageView = createImageView();
            RequestCreator requestCreatorLoad = Picasso.get().load(Uri.parse(service.getLogoUrl()));
            Intrinsics.checkNotNullExpressionValue(requestCreatorLoad, "load(...)");
            PicassoExtensionsKt.cropToCircle(requestCreatorLoad).into(imageViewCreateImageView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServicesAvatarView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.image_size_small);
        this.itemSize = dimensionPixelSize;
        this.marginSize = getResources().getDimensionPixelSize(R.dimen.ym_spaceM);
        setLayoutParams(new ViewGroup.LayoutParams(-1, dimensionPixelSize));
    }

    public /* synthetic */ ServicesAvatarView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
