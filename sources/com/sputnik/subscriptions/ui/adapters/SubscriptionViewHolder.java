package com.sputnik.subscriptions.ui.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.subscriptions.Badge;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.DetailedLayout;
import com.sputnik.common.entities.subscriptions.IncludedServices;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.Service;
import com.sputnik.common.entities.subscriptions.ServiceAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.TextViewWithPoint;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes;
import com.sputnik.domain.utils.DateUtilsKt;
import com.sputnik.subscriptions.R$color;
import com.sputnik.subscriptions.R$drawable;
import com.sputnik.subscriptions.databinding.ItemSubscriptionBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionsAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sputnik/subscriptions/ui/adapters/SubscriptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/sputnik/subscriptions/databinding/ItemSubscriptionBinding;", "(Lcom/sputnik/subscriptions/databinding/ItemSubscriptionBinding;)V", "bind", "", "item", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "onItemClick", "Lkotlin/Function1;", "onButtonClick", "activeUntilTitle", "", "buttonText", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionViewHolder extends RecyclerView.ViewHolder {
    private final ItemSubscriptionBinding binding;

    /* compiled from: SubscriptionsAdapter.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServiceAppearance.ServiceBadges.values().length];
            try {
                iArr[ServiceAppearance.ServiceBadges.f24new.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServiceAppearance.ServiceBadges.beta.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionViewHolder(ItemSubscriptionBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(final BaseSubscription item, Function1<? super BaseSubscription, Unit> onItemClick, final Function1<? super BaseSubscription, Unit> onButtonClick, String activeUntilTitle, String buttonText) {
        int i;
        String description;
        Plan.Promo promo;
        Plan.Promo promo2;
        String linkText;
        Plan.Promo promo3;
        List<Plan> plans;
        List<Plan> plans2;
        Plan plan;
        List<Plan> plans3;
        Plan plan2;
        Plan.Promo promo4;
        DetailedLayout detailedLayout;
        IncludedServices includedServices;
        List<Service> services;
        Badge badge;
        Badge badge2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
        Intrinsics.checkNotNullParameter(activeUntilTitle, "activeUntilTitle");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        ItemSubscriptionBinding itemSubscriptionBinding = this.binding;
        SubscriptionAppearance appearance = item.getAppearance();
        String link = null;
        String color = (appearance == null || (badge2 = appearance.getBadge()) == null) ? null : badge2.getColor();
        if (Intrinsics.areEqual(color, "blue")) {
            i = R$color.sputnik_blue;
        } else {
            i = Intrinsics.areEqual(color, "green") ? R$color.sputnik_green : R$color.sputnik_green;
        }
        SubscriptionAppearance appearance2 = item.getAppearance();
        String color2 = (appearance2 == null || (badge = appearance2.getBadge()) == null) ? null : badge.getColor();
        if (!Intrinsics.areEqual(color2, "blue")) {
            Intrinsics.areEqual(color2, "green");
        }
        ContextCompat.getColor(this.itemView.getContext(), i);
        ColorStateList colorStateList = ContextCompat.getColorStateList(this.itemView.getContext(), i);
        TextView textView = itemSubscriptionBinding.tvSubscriptionTitle;
        SubscriptionAppearance appearance3 = item.getAppearance();
        textView.setText(appearance3 != null ? appearance3.getTitle() : null);
        textView.setBackgroundTintList(colorStateList);
        TextView textView2 = itemSubscriptionBinding.tvSubscriptionDetails;
        Intrinsics.checkNotNull(textView2);
        SubscriptionTypes type = item.getType();
        SubscriptionTypes subscriptionTypes = SubscriptionTypes.active_subscription;
        ViewBindingUtilsKt.visibilityGoneBasedOn(textView2, type == subscriptionTypes);
        String expires = item.getExpires();
        textView2.setText(activeUntilTitle + " " + (expires != null ? DateUtilsKt.toDMMYFormat(expires, AndroidConstants.INSTANCE.getPhoneLocale()) : null));
        LinearLayout linearLayout = itemSubscriptionBinding.layoutService;
        Intrinsics.checkNotNull(linearLayout);
        ViewBindingUtilsKt.visibilityGoneBasedOn(linearLayout, item.getType() != subscriptionTypes);
        TextView textView3 = itemSubscriptionBinding.tvHeader;
        Intrinsics.checkNotNull(textView3);
        ViewBindingUtilsKt.visibilityGoneBasedOn(textView3, item.getType() != subscriptionTypes);
        SubscriptionAppearance appearance4 = item.getAppearance();
        textView3.setText(appearance4 != null ? appearance4.getDescription() : null);
        LinearLayout linearLayout2 = itemSubscriptionBinding.layoutService;
        SubscriptionAppearance appearance5 = item.getAppearance();
        if (appearance5 != null && (detailedLayout = appearance5.getDetailedLayout()) != null && (includedServices = detailedLayout.getIncludedServices()) != null && (services = includedServices.getServices()) != null) {
            int i2 = 0;
            for (Object obj : services) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Service service = (Service) obj;
                Context context = linearLayout2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                TextViewWithPoint textViewWithPoint = new TextViewWithPoint(context, null, 0, 6, null);
                ServiceAppearance appearance6 = service.getAppearance();
                textViewWithPoint.setTitle(appearance6 != null ? appearance6.getTitle() : null);
                textViewWithPoint.setPointEnabled(true);
                Resources resources = textViewWithPoint.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                textViewWithPoint.setPadding(DpUtilsKt.convertPxToDb(20.0f, resources), 0, 0, 0);
                ServiceAppearance appearance7 = service.getAppearance();
                ServiceAppearance.ServiceBadges badge3 = appearance7 != null ? appearance7.getBadge() : null;
                int i4 = badge3 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[badge3.ordinal()];
                if (i4 == 1) {
                    textViewWithPoint.setSpecialIcon(R$drawable.ic_new_market);
                } else if (i4 == 2) {
                    textViewWithPoint.setSpecialIcon(R$drawable.ic_beta_market);
                }
                linearLayout2.addView(textViewWithPoint);
                i2 = i3;
            }
        }
        TextView textView4 = itemSubscriptionBinding.btnSubscribe;
        Intrinsics.checkNotNull(textView4);
        ViewBindingUtilsKt.visibilityGoneBasedOn(textView4, item.getType() != SubscriptionTypes.active_subscription);
        SubscriptionDetails subscriptionDetails = item.getSubscriptionDetails();
        Integer discountPrice = (subscriptionDetails == null || (plans3 = subscriptionDetails.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans3)) == null || (promo4 = plan2.getPromo()) == null) ? null : promo4.getDiscountPrice();
        SubscriptionDetails subscriptionDetails2 = item.getSubscriptionDetails();
        Integer price = (subscriptionDetails2 == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null) ? null : plan.getPrice();
        if (discountPrice != null) {
            String strOrEmpty = price != null ? StringUtilsKt.orEmpty(price) : null;
            String strOrEmpty2 = StringUtilsKt.orEmpty(discountPrice);
            SubscriptionAppearance appearance8 = item.getAppearance();
            String safe = StringUtilsKt.formatSafe(buttonText, strOrEmpty + " " + strOrEmpty2 + " " + (appearance8 != null ? appearance8.getPriceText() : null));
            TextView btnSubscribe = itemSubscriptionBinding.btnSubscribe;
            Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
            ViewUtilsKt.strikeThrouth(btnSubscribe, safe, String.valueOf(price), Integer.valueOf(ContextCompat.getColor(textView4.getContext(), R$color.track_gray)));
        } else {
            TextView textView5 = itemSubscriptionBinding.btnSubscribe;
            SubscriptionAppearance appearance9 = item.getAppearance();
            textView5.setText(StringUtilsKt.formatSafe(buttonText, String.valueOf(appearance9 != null ? appearance9.getPriceVerbose() : null)));
        }
        SafeClickListenerKt.setSafeOnClickListener$default(textView4, 0L, new Function1<View, Unit>() { // from class: com.sputnik.subscriptions.ui.adapters.SubscriptionViewHolder$bind$1$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onButtonClick.invoke(item);
            }
        }, 1, null);
        SubscriptionDetails subscriptionDetails3 = item.getSubscriptionDetails();
        Plan plan3 = (subscriptionDetails3 == null || (plans = subscriptionDetails3.getPlans()) == null) ? null : (Plan) CollectionsKt.firstOrNull((List) plans);
        ConstraintLayout constraintLayout = itemSubscriptionBinding.layoutAttention;
        Intrinsics.checkNotNull(constraintLayout);
        ViewBindingUtilsKt.visibilityBasedOn(constraintLayout, Boolean.valueOf((plan3 != null ? plan3.getPromo() : null) != null));
        TextView tvAttention = itemSubscriptionBinding.tvAttention;
        Intrinsics.checkNotNullExpressionValue(tvAttention, "tvAttention");
        if (plan3 == null || (promo3 = plan3.getPromo()) == null || (description = promo3.getDescription()) == null) {
            description = "";
        }
        String str = (plan3 == null || (promo2 = plan3.getPromo()) == null || (linkText = promo2.getLinkText()) == null) ? "" : linkText;
        if (plan3 != null && (promo = plan3.getPromo()) != null) {
            link = promo.getLink();
        }
        ViewUtilsKt.highlightText(tvAttention, description, new HighlightedText(str, ContextCompat.getColor(constraintLayout.getContext(), R$color.sputnik_black), link, null, 0, 0, 56, null));
    }
}
