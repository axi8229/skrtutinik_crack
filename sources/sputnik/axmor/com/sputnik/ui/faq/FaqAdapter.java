package sputnik.axmor.com.sputnik.ui.faq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.base.BaseAdapter;
import com.sputnik.common.base.CustomViewHolder;
import com.sputnik.common.entities.faq.FaqQuestion;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ItemFaqBinding;

/* compiled from: FaqAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lsputnik/axmor/com/sputnik/ui/faq/FaqAdapter;", "Lcom/sputnik/common/base/BaseAdapter;", "Lcom/sputnik/common/entities/faq/FaqQuestion;", "Lkotlin/Function1;", "", "onItemClick", "", "locale", "onButtonClicked", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lsputnik/axmor/com/databinding/ItemFaqBinding;", "binding", "item", "handleClick", "(Lsputnik/axmor/com/databinding/ItemFaqBinding;Lcom/sputnik/common/entities/faq/FaqQuestion;)V", "Lcom/sputnik/common/base/CustomViewHolder;", "holder", "", "position", "onBindViewHolder", "(Lcom/sputnik/common/base/CustomViewHolder;I)V", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "getOnButtonClicked", "()Lkotlin/jvm/functions/Function1;", "setOnButtonClicked", "(Lkotlin/jvm/functions/Function1;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaqAdapter extends BaseAdapter<FaqQuestion> {
    private String locale;
    private Function1<? super String, Unit> onButtonClicked;
    private final Function1<FaqQuestion, Unit> onItemClick;

    public /* synthetic */ FaqAdapter(Function1 function1, String str, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? AndroidConstants.INSTANCE.getPhoneLocale() : str, function12);
    }

    public final void setLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.locale = str;
    }

    public final Function1<String, Unit> getOnButtonClicked() {
        return this.onButtonClicked;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaqAdapter(Function1<? super FaqQuestion, Unit> onItemClick, String locale, Function1<? super String, Unit> onButtonClicked) {
        super(R.layout.item_faq, onItemClick, 1, new FaqDiffCallback());
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(onButtonClicked, "onButtonClicked");
        this.onItemClick = onItemClick;
        this.locale = locale;
        this.onButtonClicked = onButtonClicked;
    }

    private final void handleClick(ItemFaqBinding binding, FaqQuestion item) {
        TextView textView;
        this.onItemClick.invoke(item);
        if (item != null) {
            if (item.getIsExpanded()) {
                ConstraintLayout layoutExpand = binding.layoutExpand;
                Intrinsics.checkNotNullExpressionValue(layoutExpand, "layoutExpand");
                ViewKt.gone(layoutExpand);
            } else {
                ConstraintLayout layoutExpand2 = binding.layoutExpand;
                Intrinsics.checkNotNullExpressionValue(layoutExpand2, "layoutExpand");
                ViewKt.visible(layoutExpand2);
                FaqQuestion.FaqButton button = item.getButton();
                if ((button != null ? button.getDeeplink() : null) != null) {
                    AppCompatButton btnAnswer = binding.btnAnswer;
                    Intrinsics.checkNotNullExpressionValue(btnAnswer, "btnAnswer");
                    ViewKt.visible(btnAnswer);
                }
                if (item.getAnswer() != null && (!StringsKt.isBlank(r0)) && (textView = binding.tvAnswer) != null) {
                    Intrinsics.checkNotNull(textView);
                    ViewKt.visible(textView);
                }
            }
            binding.ivArrow.setRotation(item.getIsExpanded() ? 0.0f : 180.0f);
            item.setExpanded(!item.getIsExpanded());
        }
    }

    @Override // com.sputnik.common.base.BaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CustomViewHolder<FaqQuestion> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder((CustomViewHolder) holder, position);
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemFaqBinding");
        ItemFaqBinding itemFaqBinding = (ItemFaqBinding) binding;
        final FaqQuestion faqQuestion = getCurrentList().get(position);
        final Context context = holder.itemView.getContext();
        ConstraintLayout layoutExpand = itemFaqBinding.layoutExpand;
        Intrinsics.checkNotNullExpressionValue(layoutExpand, "layoutExpand");
        ViewBindingUtilsKt.visibilityBasedOn(layoutExpand, Boolean.valueOf(faqQuestion.getIsExpanded()));
        itemFaqBinding.tvQuestion.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaqAdapter.onBindViewHolder$lambda$5$lambda$2(this.f$0, holder, faqQuestion, view);
            }
        });
        itemFaqBinding.ivArrow.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaqAdapter.onBindViewHolder$lambda$5$lambda$3(this.f$0, holder, faqQuestion, view);
            }
        });
        if (faqQuestion.getLink() != null) {
            itemFaqBinding.tvAnswer.setText(ViewUtilsKt.highlightText("%1s", String.valueOf(faqQuestion.getAnswer()), ContextCompat.getColor(context, R.color.sputnik_header_black)));
            itemFaqBinding.tvAnswer.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaqAdapter.onBindViewHolder$lambda$5$lambda$4(faqQuestion, context, view);
                }
            });
        }
        AppCompatButton appCompatButton = itemFaqBinding.btnAnswer;
        FaqQuestion.FaqButton button = faqQuestion.getButton();
        appCompatButton.setText(button != null ? button.getTitle() : null);
        AppCompatButton btnAnswer = itemFaqBinding.btnAnswer;
        Intrinsics.checkNotNullExpressionValue(btnAnswer, "btnAnswer");
        FaqQuestion.FaqButton button2 = faqQuestion.getButton();
        ViewBindingUtilsKt.visibilityBasedOn(btnAnswer, Boolean.valueOf((button2 != null ? button2.getDeeplink() : null) != null && faqQuestion.getIsExpanded()));
        TextView tvAnswer = itemFaqBinding.tvAnswer;
        Intrinsics.checkNotNullExpressionValue(tvAnswer, "tvAnswer");
        ViewBindingUtilsKt.visibilityBasedOn(tvAnswer, Boolean.valueOf(faqQuestion.getIsExpanded()));
        AppCompatButton btnAnswer2 = itemFaqBinding.btnAnswer;
        Intrinsics.checkNotNullExpressionValue(btnAnswer2, "btnAnswer");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAnswer2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqAdapter$onBindViewHolder$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FaqQuestion.FaqButton button3;
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<String, Unit> onButtonClicked = this.this$0.getOnButtonClicked();
                FaqQuestion faqQuestion2 = faqQuestion;
                String deeplink = (faqQuestion2 == null || (button3 = faqQuestion2.getButton()) == null) ? null : button3.getDeeplink();
                Intrinsics.checkNotNull(deeplink);
                onButtonClicked.invoke(deeplink);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5$lambda$2(FaqAdapter this$0, CustomViewHolder holder, FaqQuestion faqQuestion, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemFaqBinding");
        Intrinsics.checkNotNull(faqQuestion);
        this$0.handleClick((ItemFaqBinding) binding, faqQuestion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5$lambda$3(FaqAdapter this$0, CustomViewHolder holder, FaqQuestion faqQuestion, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        ViewDataBinding binding = holder.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ItemFaqBinding");
        Intrinsics.checkNotNull(faqQuestion);
        this$0.handleClick((ItemFaqBinding) binding, faqQuestion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5$lambda$4(FaqQuestion faqQuestion, Context context, View view) {
        if ((faqQuestion != null ? faqQuestion.getLink() : null) != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(faqQuestion != null ? faqQuestion.getLink() : null));
            context.startActivity(intent);
        }
    }
}
