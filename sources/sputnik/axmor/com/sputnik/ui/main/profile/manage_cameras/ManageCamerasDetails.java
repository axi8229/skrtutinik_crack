package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.CamerasSettingsBody;
import com.sputnik.common.entities.localization.CamerasSettingsLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ManageCamerasLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.domain.common.Event;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSettingsCamerasBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewState;

/* compiled from: ManageCamerasDetails.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasDetails;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewState;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentSettingsCamerasBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSettingsCamerasBinding;", "binding", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "manageCameraViewModelFactory", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "getManageCameraViewModelFactory", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "setManageCameraViewModelFactory", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel$delegate", "Lkotlin/Lazy;", "getManageCamerasViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel", "Lcom/sputnik/common/entities/camera/Camera;", "camera$delegate", "getCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "camera", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageCamerasDetails extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ManageCamerasDetails.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSettingsCamerasBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: camera$delegate, reason: from kotlin metadata */
    private final Lazy camera;
    public LocalizationStorage localizationScreen;
    public ManageCamerasViewModel.Factory.AssistFactory manageCameraViewModelFactory;

    /* renamed from: manageCamerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSettingsCamerasBinding getBinding() {
        return (FragmentSettingsCamerasBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final ManageCamerasViewModel.Factory.AssistFactory getManageCameraViewModelFactory() {
        ManageCamerasViewModel.Factory.AssistFactory assistFactory = this.manageCameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("manageCameraViewModelFactory");
        return null;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ManageCamerasViewModel getManageCamerasViewModel() {
        return (ManageCamerasViewModel) this.manageCamerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Camera getCamera() {
        return (Camera) this.camera.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ManageCamerasViewModel manageCamerasViewModel = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        manageCamerasViewModel.observeState(viewLifecycleOwner, new C26891(this));
        ManageCamerasViewModel manageCamerasViewModel2 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        manageCamerasViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ManageCamerasDetails manageCamerasDetails = ManageCamerasDetails.this;
                ScrollView root = manageCamerasDetails.getBinding().root;
                Intrinsics.checkNotNullExpressionValue(root, "root");
                ViewKt.renderNotifications(manageCamerasDetails, root, it);
            }
        });
        ManageCamerasViewModel manageCamerasViewModel3 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        manageCamerasViewModel3.observeSubState(viewLifecycleOwner3, new Function1<ManageCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedTitle();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.peekContent().booleanValue()) {
                    FragmentKt.findNavController(ManageCamerasDetails.this).navigateUp();
                }
            }
        });
    }

    /* compiled from: ManageCamerasDetails.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C26891 extends FunctionReferenceImpl implements Function1<ManageCamerasViewState, Unit> {
        C26891(Object obj) {
            super(1, obj, ManageCamerasDetails.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManageCamerasViewState manageCamerasViewState) {
            invoke2(manageCamerasViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManageCamerasViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ManageCamerasDetails) this.receiver).renderUi(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireActivity().getWindow().setSoftInputMode(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(ManageCamerasViewState data) {
        if (Intrinsics.areEqual(getBinding().etName.getText().toString(), data.getCurCameraObject().getTitle())) {
            return;
        }
        getBinding().etName.setText(data.getCurCameraObject().getTitle());
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws InterruptedException {
        getManageCamerasViewModel().handleCurrentCamera(getCamera());
        getManageCamerasViewModel().handleTitle(getCamera().getTitle());
        AppCompatButton btnSave = getBinding().btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave, "btnSave");
        SafeClickListenerKt.setSafeOnClickListener$default(btnSave, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails.initViews.1
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
                ManageCamerasDetails.this.getManageCamerasViewModel().handleSaveTitle();
                it.setEnabled(false);
                ViewKt.hideKeyboard(it);
            }
        }, 1, null);
        EditText etName = getBinding().etName;
        Intrinsics.checkNotNullExpressionValue(etName, "etName");
        etName.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$initViews$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String strValueOf = String.valueOf(s);
                this.this$0.getBinding().btnSave.setEnabled(!Intrinsics.areEqual(strValueOf, this.this$0.getCamera().getTitle()));
                this.this$0.getManageCamerasViewModel().handleTitle(strValueOf);
            }
        });
        Glide glide = Glide.get(requireContext());
        Intrinsics.checkNotNullExpressionValue(glide, "get(...)");
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass3(glide, null), 1, null);
        Glide.with(this).load(getCamera().getPreviewUrl()).dontAnimate().dontTransform().transform(new CenterCrop(), new RoundedCorners(30)).error(R.drawable.ic_camera).listener(new RequestListener<Drawable>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails.initViews.4
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(getBinding().ivMainCamera);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        LinearLayout layoutName = getBinding().layoutName;
        Intrinsics.checkNotNullExpressionValue(layoutName, "layoutName");
        ViewKt.addSystemWindowInsetToPadding$default(layoutName, true, false, true, true, 2, null);
        AppCompatButton btnSave2 = getBinding().btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave2, "btnSave");
        ViewKt.addSystemWindowInsetToMargin$default(btnSave2, false, false, false, true, 7, null);
    }

    /* compiled from: ManageCamerasDetails.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$initViews$3", f = "ManageCamerasDetails.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$initViews$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Glide $instance;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Glide glide, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$instance = glide;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$instance, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ManageCamerasDetails.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$initViews$3$1", f = "ManageCamerasDetails.kt", l = {}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$initViews$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Glide $instance;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Glide glide, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$instance = glide;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$instance, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Glide glide = this.$instance;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ManageCamerasDetails$initViews$3$1$1$1(glide, null), 3, null);
                glide.clearMemory();
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(this.$instance, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        CamerasSettingsLocale cameraSettings;
        CamerasSettingsBody body;
        TextTitle saveButton;
        CamerasSettingsLocale cameraSettings2;
        CamerasSettingsBody body2;
        TextTitle doorField;
        CamerasSettingsLocale cameraSettings3;
        TextTitle navigation;
        FragmentSettingsCamerasBinding binding = getBinding();
        binding.tvAddressTitle.setText(getCamera().getAddress());
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        toolbar.setTitle((data == null || (cameraSettings3 = data.getCameraSettings()) == null || (navigation = cameraSettings3.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView = binding.tvDoorTitle;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText((data2 == null || (cameraSettings2 = data2.getCameraSettings()) == null || (body2 = cameraSettings2.getBody()) == null || (doorField = body2.getDoorField()) == null) ? null : doorField.getTitle());
        AppCompatButton appCompatButton = binding.btnSave;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 != null && (cameraSettings = data3.getCameraSettings()) != null && (body = cameraSettings.getBody()) != null && (saveButton = body.getSaveButton()) != null) {
            title = saveButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    public ManageCamerasDetails() {
        super(R.layout.fragment_settings_cameras);
        this.binding = new ViewBindingFragmentDelegate(this, ManageCamerasDetails$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.manageCamerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ManageCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$manageCamerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ManageCamerasLocale manageCameras;
                ManageCamerasViewModel.Factory.AssistFactory manageCameraViewModelFactory = this.this$0.getManageCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return manageCameraViewModelFactory.create((data == null || (manageCameras = data.getManageCameras()) == null) ? null : manageCameras.getErrorInWidget());
            }
        });
        this.camera = LazyKt.lazy(new Function0<Camera>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasDetails$camera$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Camera invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("camera") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.sputnik.common.entities.camera.Camera");
                return (Camera) obj;
            }
        });
    }
}
