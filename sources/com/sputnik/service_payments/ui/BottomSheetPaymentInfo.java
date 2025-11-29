package com.sputnik.service_payments.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.os.BundleKt;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.service_payment.InfoBlock;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentAboutBody;
import com.sputnik.common.entities.localization.entities.service_payment.ServicePaymentAboutPopupLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.databinding.BottomSheetPaymentInfoBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetPaymentInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sputnik/service_payments/ui/BottomSheetPaymentInfo;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/service_payments/databinding/BottomSheetPaymentInfoBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetPaymentInfo extends BaseBottomSheetDialogFragment<BottomSheetPaymentInfoBinding> {
    public LocalizationStorage localizationStorage;

    /* compiled from: BottomSheetPaymentInfo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.BottomSheetPaymentInfo$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetPaymentInfoBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetPaymentInfoBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/service_payments/databinding/BottomSheetPaymentInfoBinding;", 0);
        }

        public final BottomSheetPaymentInfoBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetPaymentInfoBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetPaymentInfoBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BottomSheetPaymentInfo() {
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
        getBinding().subsStopButton.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.service_payments.ui.BottomSheetPaymentInfo$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                BottomSheetPaymentInfo.initViews$lambda$1$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1$lambda$0(BottomSheetPaymentInfo this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.bottomSheetPaymentInfo, R$id.action_bottomSheetPaymentInfo_to_bottonSheetStopPayment, BundleKt.bundleOf(), null, 8, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle stopButton;
        InfoBlock infoBlock;
        List<String> titles;
        InfoBlock infoBlock2;
        List<String> titles2;
        InfoBlock infoBlock3;
        List<String> titles3;
        InfoBlock infoBlock4;
        ServicePaymentAboutPopupLocale servicePaymentAboutPopup;
        BottomSheetPaymentInfoBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        ServicePaymentAboutBody body = (data == null || (servicePaymentAboutPopup = data.getServicePaymentAboutPopup()) == null) ? null : servicePaymentAboutPopup.getBody();
        binding.tvCancelTitle.setText(body != null ? body.getTitle() : null);
        binding.tvSubtitle.setText(body != null ? body.getSubtitle() : null);
        binding.infoLayout.tvTitle.setText((body == null || (infoBlock4 = body.getInfoBlock()) == null) ? null : infoBlock4.getTitle());
        binding.infoLayout.tvDateTitle.setText((body == null || (infoBlock3 = body.getInfoBlock()) == null || (titles3 = infoBlock3.getTitles()) == null) ? null : (String) CollectionsKt.firstOrNull((List) titles3));
        binding.infoLayout.tvPriceTitle.setText((body == null || (infoBlock2 = body.getInfoBlock()) == null || (titles2 = infoBlock2.getTitles()) == null) ? null : titles2.get(1));
        binding.infoLayout.tvAccountTitle.setText((body == null || (infoBlock = body.getInfoBlock()) == null || (titles = infoBlock.getTitles()) == null) ? null : (String) CollectionsKt.lastOrNull((List) titles));
        AppCompatButton appCompatButton = binding.subsStopButton;
        if (body != null && (stopButton = body.getStopButton()) != null) {
            title = stopButton.getTitle();
        }
        appCompatButton.setText(title);
    }
}
