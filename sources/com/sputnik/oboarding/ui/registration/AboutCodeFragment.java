package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.login.AboutCodeBody;
import com.sputnik.common.entities.localization.entities.login.AboutCodeLocale;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.databinding.FragmentRegAboutCodeBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

/* compiled from: AboutCodeFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/AboutCodeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegAboutCodeBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegAboutCodeBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AboutCodeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AboutCodeFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegAboutCodeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public LocalizationStorage localizationStorage;

    public AboutCodeFragment() {
        super(R$layout.fragment_reg_about_code);
        this.binding = new ViewBindingFragmentDelegate(this, AboutCodeFragment$binding$2.INSTANCE);
    }

    private final FragmentRegAboutCodeBinding getBinding() {
        return (FragmentRegAboutCodeBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        localize();
        ConstraintLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    private final void initView() {
        getBinding().btnAccept.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.AboutCodeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutCodeFragment.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(AboutCodeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    private final void localize() {
        AboutCodeLocale aboutCode;
        FragmentRegAboutCodeBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        AboutCodeBody body = (data == null || (aboutCode = data.getAboutCode()) == null) ? null : aboutCode.getBody();
        Intrinsics.checkNotNull(body);
        binding.tvAboutCode.setText(body.getTitle());
        SpannableString spannableString = new SpannableString(Util.format(body.getSubtitle().getTitle(), body.getSubtitle().getParam1(), body.getSubtitle().getParam2()));
        String param1 = body.getSubtitle().getParam1();
        Context contextRequireContext = requireContext();
        int i = R$color.sputnik_pink;
        SpansKt.addColorSpan(spannableString, param1, ContextCompat.getColor(contextRequireContext, i));
        SpansKt.addColorSpan(spannableString, body.getSubtitle().getParam2(), ContextCompat.getColor(requireContext(), i));
        binding.tvAboutCodeInfo.setText(spannableString);
        binding.btnAccept.setText(body.getOkButton().getTitle());
    }
}
