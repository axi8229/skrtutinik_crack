package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.profile.UpdateUseNameUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: SettingsProfileViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB3\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/viewmodels/SettingsProfileViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/SettingsProfileViewState;", "", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "avatar", "lastNameError", "Lcom/sputnik/domain/usecases/profile/UpdateUseNameUseCase;", "updateUseNameUseCase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/usecases/profile/UpdateUseNameUseCase;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "updateUseNameToServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/common/viewmodels/EditModeData;", "editModeData", "handleEditMode", "(Lcom/sputnik/common/viewmodels/EditModeData;)V", "saveProfileData", "(Ljava/lang/String;)V", "handleName", "Ljava/lang/String;", "Lcom/sputnik/domain/usecases/profile/UpdateUseNameUseCase;", "Factory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsProfileViewModel extends BaseViewModel<SettingsProfileViewState> {
    private final String lastNameError;
    private final UpdateUseNameUseCase updateUseNameUseCase;

    public /* synthetic */ SettingsProfileViewModel(String str, String str2, String str3, UpdateUseNameUseCase updateUseNameUseCase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, updateUseNameUseCase);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsProfileViewModel(String str, String str2, String str3, UpdateUseNameUseCase updateUseNameUseCase) {
        super(new SettingsProfileViewState(null, str, str2, null, null, 25, null), "javaClass");
        Intrinsics.checkNotNullParameter(updateUseNameUseCase, "updateUseNameUseCase");
        this.lastNameError = str3;
        this.updateUseNameUseCase = updateUseNameUseCase;
    }

    /* compiled from: SettingsProfileViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB3\b\u0007\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "avatar", "lastNameError", "updateUseNameUseCase", "Lcom/sputnik/domain/usecases/profile/UpdateUseNameUseCase;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/usecases/profile/UpdateUseNameUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AssistFactory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        private final String avatar;
        private final String lastNameError;
        private final String name;
        private final UpdateUseNameUseCase updateUseNameUseCase;

        public Factory(String str, String str2, String str3, UpdateUseNameUseCase updateUseNameUseCase) {
            Intrinsics.checkNotNullParameter(updateUseNameUseCase, "updateUseNameUseCase");
            this.name = str;
            this.avatar = str2;
            this.lastNameError = str3;
            this.updateUseNameUseCase = updateUseNameUseCase;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!Intrinsics.areEqual(modelClass, SettingsProfileViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return new SettingsProfileViewModel(this.name, this.avatar, this.lastNameError, this.updateUseNameUseCase);
        }

        /* compiled from: SettingsProfileViewModel.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "", "create", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "avatar", "lastNameError", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface AssistFactory {
            Factory create(String name, String avatar, String lastNameError);

            /* compiled from: SettingsProfileViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class DefaultImpls {
                public static /* synthetic */ Factory create$default(AssistFactory assistFactory, String str, String str2, String str3, int i, Object obj) {
                    if (obj != null) {
                        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
                    }
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    if ((i & 2) != 0) {
                        str2 = null;
                    }
                    return assistFactory.create(str, str2, str3);
                }
            }
        }
    }

    private final LiveData<Resource<Unit>> updateUseNameToServer(String name) {
        return FlowLiveDataConversions.asLiveData$default(this.updateUseNameUseCase.invoke(name), null, 0L, 3, null);
    }

    public void saveProfileData(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!StringsKt.isBlank(name)) {
            SettingsProfileViewState settingsProfileViewStateCopy$default = SettingsProfileViewState.copy$default(getCurrentState(), null, null, null, null, new Event(Boolean.FALSE), 15, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(settingsProfileViewStateCopy$default, this, null), 3, null);
            getState().setValue(settingsProfileViewStateCopy$default);
            subscribeOnDataSource(updateUseNameToServer(name), new Function2<Resource<? extends Unit>, SettingsProfileViewState, SettingsProfileViewState>() { // from class: com.sputnik.common.viewmodels.SettingsProfileViewModel.saveProfileData.2

                /* compiled from: SettingsProfileViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: com.sputnik.common.viewmodels.SettingsProfileViewModel$saveProfileData$2$WhenMappings */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[Resource.Status.values().length];
                        try {
                            iArr[Resource.Status.LOADING.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[Resource.Status.NONE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[Resource.Status.ERROR.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SettingsProfileViewState invoke(Resource<? extends Unit> resource, SettingsProfileViewState settingsProfileViewState) {
                    return invoke2((Resource<Unit>) resource, settingsProfileViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final SettingsProfileViewState invoke2(Resource<Unit> data, SettingsProfileViewState state) {
                    Unit unit;
                    String message;
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(state, "state");
                    int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                    if (i != 1 && i != 2) {
                        if (i == 3) {
                            DomainEmpty errorMsg = data.getErrorMsg();
                            if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                                unit = null;
                            } else {
                                SettingsProfileViewModel.this.notifyErrorMessage(message.toString());
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                SettingsProfileViewModel settingsProfileViewModel = SettingsProfileViewModel.this;
                                Exception error = data.getError();
                                Intrinsics.checkNotNull(error);
                                settingsProfileViewModel.notifySimpleError(error);
                            }
                        } else {
                            return SettingsProfileViewState.copy$default(state, Resource.Status.SUCCESS, null, null, new EditModeData(false, false, 3, null), new Event(Boolean.TRUE), 6, null);
                        }
                    }
                    return null;
                }
            });
            return;
        }
        String str = this.lastNameError;
        if (str != null) {
            notifyErrorMessage(str);
        }
    }

    public void handleEditMode(EditModeData editModeData) {
        Intrinsics.checkNotNullParameter(editModeData, "editModeData");
        SettingsProfileViewState settingsProfileViewStateCopy$default = SettingsProfileViewState.copy$default(getCurrentState(), null, null, null, editModeData, null, 23, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(settingsProfileViewStateCopy$default, this, null), 3, null);
        getState().setValue(settingsProfileViewStateCopy$default);
    }

    public void handleName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        SettingsProfileViewState settingsProfileViewStateCopy$default = SettingsProfileViewState.copy$default(getCurrentState(), null, name, null, null, null, 29, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(settingsProfileViewStateCopy$default, this, null), 3, null);
        getState().setValue(settingsProfileViewStateCopy$default);
    }
}
