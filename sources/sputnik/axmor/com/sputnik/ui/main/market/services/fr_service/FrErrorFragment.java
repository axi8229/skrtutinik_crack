package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.FaceRecognitionErrorBody;
import com.sputnik.common.entities.localization.FaceRecognitionErrorLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentFrErrorBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.Metrics;

/* compiled from: FrErrorFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/FrErrorFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentFrErrorBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentFrErrorBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrErrorFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FrErrorFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentFrErrorBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public LocalizationStorage localizationScreen;

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
    }

    public FrErrorFragment() {
        super(R.layout.fragment_fr_error);
        this.binding = new ViewBindingFragmentDelegate(this, FrErrorFragment$binding$2.INSTANCE);
    }

    private final FragmentFrErrorBinding getBinding() {
        return (FragmentFrErrorBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar title = getBinding().title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        ToolbarKt.setupWithNavController$default(title, FragmentKt.findNavController(this), null, 2, null);
        getBinding().frSettingsCheckButtonEnd.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.FrErrorFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Resources.NotFoundException {
                FrErrorFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding(scrollView, true, true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(FrErrorFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), Metrics.FaceRecognizerErrorEventName.INSTANCE.getParentScreen(), "cancel", null, 4, null);
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.errorFrFragment, R.id.action_errorFrFragment_to_shotFragment, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FaceRecognitionErrorLocale faceRecognitionError;
        TextTitle doneButton;
        FragmentFrErrorBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (faceRecognitionError = data.getFaceRecognitionError()) == null) {
            return;
        }
        Toolbar toolbar = binding.title;
        TextTitle navigation = faceRecognitionError.getNavigation();
        String title = null;
        toolbar.setTitle(navigation != null ? navigation.getTitle() : null);
        TextView textView = binding.tvAllDone;
        FaceRecognitionErrorBody body = faceRecognitionError.getBody();
        textView.setText(body != null ? body.getTitle() : null);
        TextView textView2 = binding.tvInfoResult;
        FaceRecognitionErrorBody body2 = faceRecognitionError.getBody();
        textView2.setText(body2 != null ? body2.getBottomLabel() : null);
        AppCompatButton appCompatButton = binding.frSettingsCheckButtonEnd;
        FaceRecognitionErrorBody body3 = faceRecognitionError.getBody();
        if (body3 != null && (doneButton = body3.getDoneButton()) != null) {
            title = doneButton.getTitle();
        }
        appCompatButton.setText(title);
    }
}
