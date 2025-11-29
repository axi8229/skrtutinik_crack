package sputnik.axmor.com.sputnik.ui.main.profile.adapter;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.subscriptions.services.ServiceAppearance;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.DpUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ServiceItemBinding;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: ServicesAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/adapter/ServicesAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/market/service/Service;", "originText", "", "onItemClicked", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "Lcom/sputnik/common/base/CustomViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServicesAdapter extends BaseAdapter<Service> {
    private final String originText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServicesAdapter(String str, Function1<? super Service, Unit> onItemClicked) {
        super(R.layout.service_item, onItemClicked, 1, new ServicesDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.originText = str;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder<Service> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CustomViewHolder<Service> customViewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
        ViewDataBinding binding = customViewHolderOnCreateViewHolder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ServiceItemBinding");
        ((ServiceItemBinding) binding).originImage.setText(this.originText);
        return customViewHolderOnCreateViewHolder;
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CustomViewHolder<Service> holder, int position) {
        int i;
        int i2;
        int i3;
        String strValueOf;
        ServiceAppearance appearance;
        Badge badge;
        ServiceAppearance appearance2;
        Badge badge2;
        String color;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ServiceItemBinding");
        ServiceItemBinding serviceItemBinding = (ServiceItemBinding) binding;
        Service service = getCurrentList().get(position);
        String serviceConfigIdentifier = service.getServiceConfigIdentifier();
        AndroidConstants.ServicesNames servicesNames = AndroidConstants.ServicesNames.INSTANCE;
        if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getDIGITAL_KEY_IDENTIFIER())) {
            i = R.drawable.ic_codes_profile;
        } else if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getFR_SUBS_IDENTIFIER())) {
            i = R.drawable.ic_face_outline;
        } else if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getVIDEO_ARCHIVE_3d_IDENTIFIER())) {
            i = R.drawable.ic_video_archive_profile;
        } else if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getBLE_IDENTIFIER())) {
            i = R.drawable.ic_bluetooth;
        } else if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getMOBILE_PACK())) {
            i = R.drawable.ic_home_outline;
        } else {
            i = Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getALICE_IDENTIFIER()) ? R.drawable.ic_alice_profile : R.drawable.ic_video_outline;
        }
        if (Intrinsics.areEqual(service.getServiceConfigIdentifier(), servicesNames.getALICE_IDENTIFIER())) {
            ImageView imageView = serviceItemBinding.ivIcon;
            BaseOpenDoorWidget.Companion companion = BaseOpenDoorWidget.INSTANCE;
            imageView.setPadding(DpUtilsKt.dpToPx(companion.getContext(), 2), DpUtilsKt.dpToPx(companion.getContext(), 2), DpUtilsKt.dpToPx(companion.getContext(), 2), DpUtilsKt.dpToPx(companion.getContext(), 2));
        }
        serviceItemBinding.ivIcon.setImageResource(i);
        Service.Badge badge3 = service.getBadge();
        String color2 = badge3 != null ? badge3.getColor() : null;
        if (Intrinsics.areEqual(color2, "blue")) {
            i2 = R.drawable.bg_badge_outline_4_blue;
        } else {
            Intrinsics.areEqual(color2, "green");
            i2 = R.drawable.bg_badge_outline_4_green;
        }
        Service.Badge badge4 = service.getBadge();
        String color3 = badge4 != null ? badge4.getColor() : null;
        if (Intrinsics.areEqual(color3, "blue")) {
            i3 = R.color.sputnik_blue;
        } else {
            Intrinsics.areEqual(color3, "green");
            i3 = R.color.sputnik_green;
        }
        BaseOpenDoorWidget.Companion companion2 = BaseOpenDoorWidget.INSTANCE;
        int color4 = ContextCompat.getColor(companion2.getContext(), i3);
        Service.Badge badge5 = service.getBadge();
        if (badge5 != null && (color = badge5.getColor()) != null && StringsKt.contains$default((CharSequence) color, (CharSequence) "gradient", false, 2, (Object) null)) {
            TextView textView = serviceItemBinding.serviceImageSub;
            Service.Badge badge6 = service.getBadge();
            String title = badge6 != null ? badge6.getTitle() : null;
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            Service.Badge badge7 = service.getBadge();
            String color5 = badge7 != null ? badge7.getColor() : null;
            if (Intrinsics.areEqual(color5, "gradient_violet")) {
                serviceItemBinding.serviceImageSub.setBackground(ContextCompat.getDrawable(companion2.getContext(), R.drawable.bg_badge_outlined_violet_gradient));
                TextPaint paint = serviceItemBinding.serviceImageSub.getPaint();
                Service.Badge badge8 = service.getBadge();
                title = badge8 != null ? badge8.getTitle() : null;
                serviceItemBinding.serviceImageSub.getPaint().setShader(new LinearGradient(0.0f, 0.0f, paint.measureText(title != null ? title : ""), serviceItemBinding.serviceImageSub.getTextSize(), new int[]{Color.parseColor("#5D14BA"), Color.parseColor("#BB00EA")}, (float[]) null, Shader.TileMode.CLAMP));
                return;
            }
            if (Intrinsics.areEqual(color5, "gradient_blue")) {
                serviceItemBinding.serviceImageSub.setBackground(ContextCompat.getDrawable(companion2.getContext(), R.drawable.bg_badge_outlined_blue_gradient));
                TextPaint paint2 = serviceItemBinding.serviceImageSub.getPaint();
                Service.Badge badge9 = service.getBadge();
                title = badge9 != null ? badge9.getTitle() : null;
                serviceItemBinding.serviceImageSub.getPaint().setShader(new LinearGradient(0.0f, 0.0f, paint2.measureText(title != null ? title : ""), serviceItemBinding.serviceImageSub.getTextSize(), new int[]{Color.parseColor("#00D1FF"), Color.parseColor("#15759E")}, (float[]) null, Shader.TileMode.CLAMP));
                return;
            }
            return;
        }
        serviceItemBinding.serviceImageSub.setBackground(ContextCompat.getDrawable(companion2.getContext(), i2));
        serviceItemBinding.serviceImageSub.setTextColor(color4);
        TextView textView2 = serviceItemBinding.serviceImageSub;
        Boolean isCompanyService = service.getIsCompanyService();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isCompanyService, bool)) {
            strValueOf = this.originText;
        } else {
            Origin origin = service.getOrigin();
            strValueOf = String.valueOf((origin == null || (appearance = origin.getAppearance()) == null || (badge = appearance.getBadge()) == null) ? null : badge.getTitle());
        }
        textView2.setText(strValueOf);
        if (Intrinsics.areEqual(service.getIsCompanyService(), bool)) {
            if (this.originText == null) {
                TextView serviceImageSub = serviceItemBinding.serviceImageSub;
                Intrinsics.checkNotNullExpressionValue(serviceImageSub, "serviceImageSub");
                ViewKt.gone(serviceImageSub);
                return;
            }
            return;
        }
        Origin origin2 = service.getOrigin();
        if (origin2 != null && (appearance2 = origin2.getAppearance()) != null && (badge2 = appearance2.getBadge()) != null) {
            title = badge2.getTitle();
        }
        if (title == null) {
            TextView serviceImageSub2 = serviceItemBinding.serviceImageSub;
            Intrinsics.checkNotNullExpressionValue(serviceImageSub2, "serviceImageSub");
            ViewKt.gone(serviceImageSub2);
        }
    }
}
