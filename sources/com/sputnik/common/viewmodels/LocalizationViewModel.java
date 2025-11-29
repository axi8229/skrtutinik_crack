package com.sputnik.common.viewmodels;

import android.util.Log;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.localization.DomainLocalization;
import com.sputnik.domain.entities.prefs.VersionModel;
import com.sputnik.domain.usecases.localization.GetLocalizationUseCase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: LocalizationViewModel.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B=\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a0\u00190\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010$\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001eH\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010+\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b+\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010.R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010/R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/LocalizationViewState;", "", "Lcom/sputnik/domain/usecases/localization/GetLocalizationUseCase;", "getLocalizationUseCase", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/localization/DomainLocalization;", "Lcom/sputnik/common/entities/localization/Localization;", "domainLocalizationToLocalizationMapper", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "<init>", "(Lcom/sputnik/domain/usecases/localization/GetLocalizationUseCase;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "version", "", "platform", "app", "locale", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getLocalizationFromServer", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "index", "", "handleNewIndex", "(I)V", "", "filePath", RemoteMessageConst.Notification.TAG, "tryLoad", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "handleCurrentTag", "(Ljava/lang/String;)V", "handleChangingLanguage", "()V", "getLocalizations", "loadLocalization", "Lcom/sputnik/domain/usecases/localization/GetLocalizationUseCase;", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/common/localization/LocalizationStorage;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalizationViewModel extends BaseViewModel<LocalizationViewState> {
    private final IConfig config;
    private final ListMapper<DomainLocalization, Localization> domainLocalizationToLocalizationMapper;
    private final GetLocalizationUseCase getLocalizationUseCase;
    private final Job job;
    private final LocalizationStorage localizationStorage;
    private final PrefManager prefManager;

    public LocalizationViewModel(GetLocalizationUseCase getLocalizationUseCase, PrefManager prefManager, IConfig config, ListMapper<DomainLocalization, Localization> domainLocalizationToLocalizationMapper, LocalizationStorage localizationStorage) {
        Intrinsics.checkNotNullParameter(getLocalizationUseCase, "getLocalizationUseCase");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(domainLocalizationToLocalizationMapper, "domainLocalizationToLocalizationMapper");
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        LocalizationViewState localizationViewState = new LocalizationViewState(null, null, null, 0, prefManager.getCurLocale(), 15, null);
        String name = LocalizationViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(localizationViewState, name);
        this.getLocalizationUseCase = getLocalizationUseCase;
        this.prefManager = prefManager;
        this.config = config;
        this.domainLocalizationToLocalizationMapper = domainLocalizationToLocalizationMapper;
        this.localizationStorage = localizationStorage;
        this.job = BuildersKt.launch(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), CoroutineStart.LAZY, new LocalizationViewModel$job$1(this, null));
        getLocalizations();
    }

    static /* synthetic */ LiveData getLocalizationFromServer$default(LocalizationViewModel localizationViewModel, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3;
        }
        if ((i2 & 2) != 0) {
            str = localizationViewModel.config.getPlatformKeyName();
        }
        if ((i2 & 4) != 0) {
            str2 = "default";
        }
        if ((i2 & 8) != 0) {
            str3 = localizationViewModel.prefManager.getCurLocale();
        }
        return localizationViewModel.getLocalizationFromServer(i, str, str2, str3);
    }

    private final LiveData<Resource<List<DomainLocalization>>> getLocalizationFromServer(int version, String platform, String app, String locale) {
        return FlowLiveDataConversions.asLiveData$default(this.getLocalizationUseCase.invoke(version, platform, app, locale), null, 0L, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNewIndex(int index) {
        if (getCurrentState().getCurLoaderIndex() == 4) {
            LocalizationViewState localizationViewStateCopy$default = LocalizationViewState.copy$default(getCurrentState(), null, null, null, 0, null, 23, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(localizationViewStateCopy$default, this, null), 3, null);
            getState().setValue(localizationViewStateCopy$default);
        } else {
            LocalizationViewState localizationViewStateCopy$default2 = LocalizationViewState.copy$default(getCurrentState(), null, null, null, index, null, 23, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(localizationViewStateCopy$default2, this, null), 3, null);
            getState().setValue(localizationViewStateCopy$default2);
        }
    }

    public void handleChangingLanguage() {
        this.job.start();
    }

    public void getLocalizations() {
        subscribeOnDataSource(getLocalizationFromServer$default(this, 0, null, null, null, 15, null), new Function2<Resource<? extends List<? extends DomainLocalization>>, LocalizationViewState, LocalizationViewState>() { // from class: com.sputnik.common.viewmodels.LocalizationViewModel.getLocalizations.1

            /* compiled from: LocalizationViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.LocalizationViewModel$getLocalizations$1$WhenMappings */
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
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LocalizationViewState invoke(Resource<? extends List<? extends DomainLocalization>> resource, LocalizationViewState localizationViewState) {
                return invoke2((Resource<? extends List<DomainLocalization>>) resource, localizationViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final LocalizationViewState invoke2(Resource<? extends List<DomainLocalization>> serverData, LocalizationViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return LocalizationViewState.copy$default(state, Resource.Status.LOADING, null, null, 0, null, 30, null);
                }
                if (i == 3) {
                    return LocalizationViewState.copy$default(state, Resource.Status.ERROR, null, null, 0, null, 30, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                List<DomainLocalization> data = serverData.getData();
                Intrinsics.checkNotNull(data);
                return LocalizationViewState.copy$default(state, Resource.Status.SUCCESS, null, LocalizationViewModel.this.domainLocalizationToLocalizationMapper.map(data), 0, null, 26, null);
            }
        });
    }

    public void handleCurrentTag(String tag) {
        if (tag != null) {
            LocalizationViewState localizationViewStateCopy$default = LocalizationViewState.copy$default(getCurrentState(), null, null, null, 0, tag, 15, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(localizationViewStateCopy$default, this, null), 3, null);
            getState().setValue(localizationViewStateCopy$default);
        }
    }

    public void loadLocalization(final String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        LocalizationViewState localizationViewStateCopy$default = LocalizationViewState.copy$default(getCurrentState(), null, new Event(Boolean.FALSE), null, 0, null, 29, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(localizationViewStateCopy$default, this, null), 3, null);
        getState().setValue(localizationViewStateCopy$default);
        subscribeOnDataSource(getLocalizationFromServer$default(this, 0, null, null, null, 15, null), new Function2<Resource<? extends List<? extends DomainLocalization>>, LocalizationViewState, LocalizationViewState>() { // from class: com.sputnik.common.viewmodels.LocalizationViewModel.loadLocalization.2

            /* compiled from: LocalizationViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.LocalizationViewModel$loadLocalization$2$WhenMappings */
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
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LocalizationViewState invoke(Resource<? extends List<? extends DomainLocalization>> resource, LocalizationViewState localizationViewState) {
                return invoke2((Resource<? extends List<DomainLocalization>>) resource, localizationViewState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final LocalizationViewState invoke2(Resource<? extends List<DomainLocalization>> serverData, LocalizationViewState state) {
                DomainLocalization domainLocalization;
                Object next;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return LocalizationViewState.copy$default(state, Resource.Status.LOADING, null, null, 0, null, 30, null);
                }
                if (i == 3) {
                    return LocalizationViewState.copy$default(state, Resource.Status.ERROR, new Event(Boolean.TRUE), null, 0, null, 28, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                List<DomainLocalization> data = serverData.getData();
                Intrinsics.checkNotNull(data);
                String str = locale;
                Iterator<T> it = data.iterator();
                while (true) {
                    domainLocalization = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((DomainLocalization) next).getTag(), str)) {
                        break;
                    }
                }
                DomainLocalization domainLocalization2 = (DomainLocalization) next;
                if (domainLocalization2 != null) {
                    LocalizationViewModel localizationViewModel = LocalizationViewModel.this;
                    Long createdAt = domainLocalization2.getCreatedAt();
                    String file = domainLocalization2.getFile();
                    Intrinsics.checkNotNull(file);
                    String tag = domainLocalization2.getTag();
                    Intrinsics.checkNotNull(tag);
                    localizationViewModel.tryLoad(createdAt, file, tag);
                } else {
                    List<DomainLocalization> data2 = serverData.getData();
                    if (data2 != null) {
                        Iterator<T> it2 = data2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next2 = it2.next();
                            if (Intrinsics.areEqual(((DomainLocalization) next2).getTag(), "en")) {
                                domainLocalization = next2;
                                break;
                            }
                        }
                        domainLocalization = domainLocalization;
                    }
                    if (domainLocalization != null) {
                        LocalizationViewModel.this.tryLoad(domainLocalization.getCreatedAt(), domainLocalization.getFile(), StringUtilsKt.orEmpty(domainLocalization.getTag()));
                    }
                }
                return LocalizationViewState.copy$default(state, Resource.Status.SUCCESS, null, null, 0, null, 30, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryLoad(Long version, String filePath, String tag) {
        Object next;
        File file = new File(this.localizationStorage.getContext().getFilesDir(), "new_localization_file_" + tag);
        Iterator<T> it = this.prefManager.getLocalesVersions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((VersionModel) next).getLocale(), tag)) {
                    break;
                }
            }
        }
        VersionModel versionModel = (VersionModel) next;
        Log.e("tryLoad", (versionModel != null ? versionModel.getVersion() : null) + " != " + version);
        BuildersKt__Builders_commonKt.launch$default(this.localizationStorage.getScope(), Dispatchers.getMain(), null, new C06551(file, !Intrinsics.areEqual(versionModel != null ? versionModel.getVersion() : null, version), this, filePath, versionModel, tag, version, null), 2, null);
    }

    /* compiled from: LocalizationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.LocalizationViewModel$tryLoad$1", f = "LocalizationViewModel.kt", l = {159}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.LocalizationViewModel$tryLoad$1, reason: invalid class name and case insensitive filesystem */
    static final class C06551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VersionModel $curLocale;
        final /* synthetic */ String $filePath;
        final /* synthetic */ File $localizationFile;
        final /* synthetic */ boolean $needUpdate;
        final /* synthetic */ String $tag;
        final /* synthetic */ Long $version;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ LocalizationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06551(File file, boolean z, LocalizationViewModel localizationViewModel, String str, VersionModel versionModel, String str2, Long l, Continuation<? super C06551> continuation) {
            super(2, continuation);
            this.$localizationFile = file;
            this.$needUpdate = z;
            this.this$0 = localizationViewModel;
            this.$filePath = str;
            this.$curLocale = versionModel;
            this.$tag = str2;
            this.$version = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06551 c06551 = new C06551(this.$localizationFile, this.$needUpdate, this.this$0, this.$filePath, this.$curLocale, this.$tag, this.$version, continuation);
            c06551.L$0 = obj;
            return c06551;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            VersionModel versionModel;
            LocalizationViewModel localizationViewModel;
            Object objAwait;
            File file;
            String str;
            Long l;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (this.$localizationFile.exists() && !this.$needUpdate) {
                    this.this$0.localizationStorage.readData(this.$localizationFile);
                    LocalizationViewModel localizationViewModel2 = this.this$0;
                    LocalizationViewState localizationViewStateCopy$default = LocalizationViewState.copy$default(localizationViewModel2.getCurrentState(), null, new Event(Boxing.boxBoolean(true)), null, 0, null, 29, null);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(localizationViewModel2), null, null, new BaseViewModel$updateState$1(localizationViewStateCopy$default, localizationViewModel2, null), 3, null);
                    localizationViewModel2.getState().setValue(localizationViewStateCopy$default);
                    Log.e("tryLoad", "READED");
                } else {
                    String str2 = this.$filePath;
                    if (str2 != null) {
                        versionModel = this.$curLocale;
                        localizationViewModel = this.this$0;
                        String str3 = this.$tag;
                        Long l2 = this.$version;
                        File file2 = this.$localizationFile;
                        Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new LocalizationViewModel$tryLoad$1$2$res$1(localizationViewModel, str2, file2, null), 2, null);
                        this.L$0 = versionModel;
                        this.L$1 = localizationViewModel;
                        this.L$2 = str3;
                        this.L$3 = l2;
                        this.L$4 = file2;
                        this.label = 1;
                        objAwait = deferredAsync$default.await(this);
                        if (objAwait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        file = file2;
                        str = str3;
                        l = l2;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$4;
            Long l3 = (Long) this.L$3;
            String str4 = (String) this.L$2;
            LocalizationViewModel localizationViewModel3 = (LocalizationViewModel) this.L$1;
            VersionModel versionModel2 = (VersionModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            localizationViewModel = localizationViewModel3;
            versionModel = versionModel2;
            l = l3;
            str = str4;
            objAwait = obj;
            Log.e("downloaded", ((Deferred) objAwait).toString());
            if (versionModel != null) {
                PrefManager prefManager = localizationViewModel.prefManager;
                List<VersionModel> localesVersions = localizationViewModel.prefManager.getLocalesVersions();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(localesVersions, 10));
                for (VersionModel versionModel3 : localesVersions) {
                    if (Intrinsics.areEqual(versionModel3.getLocale(), versionModel.getLocale())) {
                        versionModel3.setVersion(l);
                    }
                    arrayList.add(versionModel3);
                }
                prefManager.updateLocaleVersions(arrayList);
            } else {
                localizationViewModel.prefManager.updateLocaleVersions(CollectionsKt.plus((Collection<? extends VersionModel>) localizationViewModel.prefManager.getLocalesVersions(), new VersionModel(str, l, (List) null, 4, (DefaultConstructorMarker) null)));
            }
            localizationViewModel.localizationStorage.readData(file);
            LocalizationViewState localizationViewStateCopy$default2 = LocalizationViewState.copy$default(localizationViewModel.getCurrentState(), null, new Event(Boxing.boxBoolean(true)), null, 0, null, 29, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(localizationViewModel), null, null, new BaseViewModel$updateState$1(localizationViewStateCopy$default2, localizationViewModel, null), 3, null);
            localizationViewModel.getState().setValue(localizationViewStateCopy$default2);
            Boxing.boxInt(Log.e("tryLoad", "READED AFTER DOWNLOADED"));
            return Unit.INSTANCE;
        }
    }
}
