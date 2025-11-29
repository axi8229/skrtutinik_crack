package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.login.RegisterPopupBodyLocale;
import com.sputnik.common.entities.localization.entities.login.RegisterPopupLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.BottomSheetRegRegistrationBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadyToConnectBottomSheet.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/ReadyToConnectBottomSheet;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/oboarding/databinding/BottomSheetRegRegistrationBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "localize", "initViews", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReadyToConnectBottomSheet extends BaseBottomSheetDialogFragment<BottomSheetRegRegistrationBinding> {
    public Analytics analytics;
    public LocalizationStorage localizationStorage;

    /* compiled from: ReadyToConnectBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ReadyToConnectBottomSheet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetRegRegistrationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetRegRegistrationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/oboarding/databinding/BottomSheetRegRegistrationBinding;", 0);
        }

        public final BottomSheetRegRegistrationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetRegRegistrationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetRegRegistrationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ReadyToConnectBottomSheet() {
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

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle laterButton;
        TextTitle connectButton;
        RegisterPopupLocale registerPopup;
        BottomSheetRegRegistrationBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        RegisterPopupBodyLocale body = (data == null || (registerPopup = data.getRegisterPopup()) == null) ? null : registerPopup.getBody();
        binding.tvTitle.setText(body != null ? body.getTitle() : null);
        binding.tvNotice.setText(body != null ? body.getSubtitle() : null);
        binding.btnApply.setText((body == null || (connectButton = body.getConnectButton()) == null) ? null : connectButton.getTitle());
        AppCompatButton appCompatButton = binding.tvSetupLater;
        if (body != null && (laterButton = body.getLaterButton()) != null) {
            title = laterButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetRegRegistrationBinding binding = getBinding();
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ReadyToConnectBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ReadyToConnectBottomSheet.initViews$lambda$3$lambda$1(this.f$0, view);
            }
        });
        binding.tvSetupLater.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ReadyToConnectBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ReadyToConnectBottomSheet.initViews$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3$lambda$1(ReadyToConnectBottomSheet this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepTwoJoinEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.readyToConnectBottomSheet, R$id.action_readyToConnectBottomSheet_to_connectToIntecomFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3$lambda$2(ReadyToConnectBottomSheet this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationSetupLaterEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.readyToConnectBottomSheet, R$id.action_readyToConnectBottomSheet_to_noIntercomDialog, null, null, 12, null);
    }
}
