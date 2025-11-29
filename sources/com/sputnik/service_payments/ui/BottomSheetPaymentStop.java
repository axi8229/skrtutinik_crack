package com.sputnik.service_payments.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWithParam;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentCancelPopupBody;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentCancelPopupLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.service_payments.R$color;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.databinding.BottomSheetStopPaymentBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetPaymentStop.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/service_payments/ui/BottomSheetPaymentStop;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/service_payments/databinding/BottomSheetStopPaymentBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetPaymentStop extends BaseBottomSheetDialogFragment<BottomSheetStopPaymentBinding> {
    public LocalizationStorage localizationStorage;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1(View view) {
    }

    /* compiled from: BottomSheetPaymentStop.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.BottomSheetPaymentStop$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetStopPaymentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetStopPaymentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/service_payments/databinding/BottomSheetStopPaymentBinding;", 0);
        }

        public final BottomSheetStopPaymentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetStopPaymentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetStopPaymentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BottomSheetPaymentStop() {
        super(AnonymousClass1.INSTANCE);
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetStopPaymentBinding binding = getBinding();
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.BottomSheetPaymentStop$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPaymentStop.initViews$lambda$2$lambda$0(this.f$0, view);
            }
        });
        binding.subsStopButton.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.BottomSheetPaymentStop$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPaymentStop.initViews$lambda$2$lambda$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$0(BottomSheetPaymentStop this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).popBackStack(R$id.fragmentPayments, false);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle stopButton;
        TextTitle continueUseButton;
        TextWithParam subtitle;
        TextWithParam subtitle2;
        ServicePaymentCancelPopupLocale servicePaymentCancelPopup;
        BottomSheetStopPaymentBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        ServicePaymentCancelPopupBody body = (data == null || (servicePaymentCancelPopup = data.getServicePaymentCancelPopup()) == null) ? null : servicePaymentCancelPopup.getBody();
        binding.tvCancelTitle.setText(body != null ? body.getTitle() : null);
        binding.tvSubtitle.setText(ViewUtilsKt.highlightText(String.valueOf((body == null || (subtitle2 = body.getSubtitle()) == null) ? null : subtitle2.getText()), String.valueOf((body == null || (subtitle = body.getSubtitle()) == null) ? null : subtitle.getParam()), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        binding.btnApply.setText((body == null || (continueUseButton = body.getContinueUseButton()) == null) ? null : continueUseButton.getTitle());
        AppCompatButton appCompatButton = binding.subsStopButton;
        if (body != null && (stopButton = body.getStopButton()) != null) {
            title = stopButton.getTitle();
        }
        appCompatButton.setText(title);
    }
}
