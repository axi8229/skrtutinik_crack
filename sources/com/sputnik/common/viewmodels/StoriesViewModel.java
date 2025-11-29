package com.sputnik.common.viewmodels;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.stories.Story;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: StoriesViewModel.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B=\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JI\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u00150\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010!J!\u0010&\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001fH\u0014¢\u0006\u0004\b*\u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010-R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010.R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010/¨\u00060"}, d2 = {"Lcom/sputnik/common/viewmodels/StoriesViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/StoriesDataState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/domain/usecases/stories/GetOnBoardingStoriesUseCase;", "getOnBoardingStoriesUseCase", "Lcom/sputnik/domain/usecases/stories/GetStoriesUseCase;", "getStoriesUseCase", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/domain/entities/stories/DomainStory;", "Lcom/sputnik/common/entities/stories/Story;", "domainStoriesToStoriesMapper", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;Lcom/sputnik/domain/usecases/stories/GetOnBoardingStoriesUseCase;Lcom/sputnik/domain/usecases/stories/GetStoriesUseCase;Lcom/sputnik/domain/common/NullableInputListMapper;)V", "", "locale", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getStoriesFromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "platform", "app", "", "version", "getOnBoardingStoriesFromServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroidx/lifecycle/LiveData;", "", "loadOnboardingStories", "()V", "loadStories", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/graphics/Bitmap;", "image", "cacheImage", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "getCachedImage", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "onCleared", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/domain/usecases/stories/GetOnBoardingStoriesUseCase;", "Lcom/sputnik/domain/usecases/stories/GetStoriesUseCase;", "Lcom/sputnik/domain/common/NullableInputListMapper;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StoriesViewModel extends BaseViewModel<StoriesDataState> {
    private final IConfig config;
    private final NullableInputListMapper<DomainStory, Story> domainStoriesToStoriesMapper;
    private final GetOnBoardingStoriesUseCase getOnBoardingStoriesUseCase;
    private final GetStoriesUseCase getStoriesUseCase;
    private final PrefManager prefManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoriesViewModel(PrefManager prefManager, IConfig config, GetOnBoardingStoriesUseCase getOnBoardingStoriesUseCase, GetStoriesUseCase getStoriesUseCase, NullableInputListMapper<DomainStory, Story> domainStoriesToStoriesMapper) {
        super(new StoriesDataState(null, null, null, null, 0, false, null, 0, KotlinVersion.MAX_COMPONENT_VALUE, null), "javaClass");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(getOnBoardingStoriesUseCase, "getOnBoardingStoriesUseCase");
        Intrinsics.checkNotNullParameter(getStoriesUseCase, "getStoriesUseCase");
        Intrinsics.checkNotNullParameter(domainStoriesToStoriesMapper, "domainStoriesToStoriesMapper");
        this.prefManager = prefManager;
        this.config = config;
        this.getOnBoardingStoriesUseCase = getOnBoardingStoriesUseCase;
        this.getStoriesUseCase = getStoriesUseCase;
        this.domainStoriesToStoriesMapper = domainStoriesToStoriesMapper;
        final int iMaxMemory = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
        Log.e("cache_size", String.valueOf(iMaxMemory));
        LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(iMaxMemory) { // from class: com.sputnik.common.viewmodels.StoriesViewModel$memoryCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                return bitmap.getByteCount() / 1024;
            }
        };
        StoriesDataState currentState = getCurrentState();
        StoriesDataState storiesDataStateCopy = currentState.copy((241 & 1) != 0 ? currentState.isLoaded : null, (241 & 2) != 0 ? currentState.onBoardingIsLoaded : null, (241 & 4) != 0 ? currentState.serverState : null, (241 & 8) != 0 ? currentState.stories : null, (241 & 16) != 0 ? currentState.currentStory : 0, (241 & 32) != 0 ? currentState.isPaused : false, (241 & 64) != 0 ? currentState.memoryCache : lruCache, (241 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(storiesDataStateCopy, this, null), 3, null);
        getState().setValue(storiesDataStateCopy);
    }

    private final LiveData<Resource<List<DomainStory>>> getStoriesFromServer(String locale) {
        LiveData<Resource<List<DomainStory>>> liveDataAsLiveData$default = FlowLiveDataConversions.asLiveData$default(GetStoriesUseCase.invoke$default(this.getStoriesUseCase, this.prefManager.getJwtToken(), locale, 0, 4, null), null, 0L, 3, null);
        Log.e("jwt", this.prefManager.getJwtToken());
        return liveDataAsLiveData$default;
    }

    static /* synthetic */ LiveData getOnBoardingStoriesFromServer$default(StoriesViewModel storiesViewModel, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = storiesViewModel.config.getPlatformKeyName();
        }
        if ((i2 & 2) != 0) {
            str2 = "default";
        }
        if ((i2 & 4) != 0) {
            str3 = storiesViewModel.prefManager.getCurLocale();
        }
        if ((i2 & 8) != 0) {
            i = 1;
        }
        return storiesViewModel.getOnBoardingStoriesFromServer(str, str2, str3, i);
    }

    private final LiveData<Resource<List<DomainStory>>> getOnBoardingStoriesFromServer(String platform, String app, String locale, int version) {
        return FlowLiveDataConversions.asLiveData$default(this.getOnBoardingStoriesUseCase.invoke(platform, app, locale, version), null, 0L, 3, null);
    }

    public void loadOnboardingStories() {
        StoriesDataState currentState = getCurrentState();
        StoriesDataState storiesDataStateCopy = currentState.copy((241 & 1) != 0 ? currentState.isLoaded : null, (241 & 2) != 0 ? currentState.onBoardingIsLoaded : null, (241 & 4) != 0 ? currentState.serverState : null, (241 & 8) != 0 ? currentState.stories : null, (241 & 16) != 0 ? currentState.currentStory : 0, (241 & 32) != 0 ? currentState.isPaused : false, (241 & 64) != 0 ? currentState.memoryCache : null, (241 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(storiesDataStateCopy, this, null), 3, null);
        getState().setValue(storiesDataStateCopy);
        subscribeOnDataSource(getOnBoardingStoriesFromServer$default(this, null, null, null, 0, 15, null), new Function2<Resource<? extends List<? extends DomainStory>>, StoriesDataState, StoriesDataState>() { // from class: com.sputnik.common.viewmodels.StoriesViewModel.loadOnboardingStories.2

            /* compiled from: StoriesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.StoriesViewModel$loadOnboardingStories$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
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
            public /* bridge */ /* synthetic */ StoriesDataState invoke(Resource<? extends List<? extends DomainStory>> resource, StoriesDataState storiesDataState) {
                return invoke2((Resource<? extends List<DomainStory>>) resource, storiesDataState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StoriesDataState invoke2(Resource<? extends List<DomainStory>> serverData, StoriesDataState state) {
                List map;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((241 & 1) != 0 ? state.isLoaded : null, (241 & 2) != 0 ? state.onBoardingIsLoaded : null, (241 & 4) != 0 ? state.serverState : Resource.Status.LOADING, (241 & 8) != 0 ? state.stories : null, (241 & 16) != 0 ? state.currentStory : 0, (241 & 32) != 0 ? state.isPaused : false, (241 & 64) != 0 ? state.memoryCache : null, (241 & 128) != 0 ? state.cacheSize : 0);
                }
                if (i == 3) {
                    return state.copy((241 & 1) != 0 ? state.isLoaded : null, (241 & 2) != 0 ? state.onBoardingIsLoaded : null, (241 & 4) != 0 ? state.serverState : Resource.Status.ERROR, (241 & 8) != 0 ? state.stories : null, (241 & 16) != 0 ? state.currentStory : 0, (241 & 32) != 0 ? state.isPaused : false, (241 & 64) != 0 ? state.memoryCache : null, (241 & 128) != 0 ? state.cacheSize : 0);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List<DomainStory> data = serverData.getData();
                return state.copy((241 & 1) != 0 ? state.isLoaded : null, (241 & 2) != 0 ? state.onBoardingIsLoaded : new Event(Boolean.TRUE), (241 & 4) != 0 ? state.serverState : status, (241 & 8) != 0 ? state.stories : (data == null || (map = StoriesViewModel.this.domainStoriesToStoriesMapper.map(data)) == null) ? null : CollectionsKt.sortedWith(map, new Comparator() { // from class: com.sputnik.common.viewmodels.StoriesViewModel$loadOnboardingStories$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Story) t).getOrder(), ((Story) t2).getOrder());
                    }
                }), (241 & 16) != 0 ? state.currentStory : 0, (241 & 32) != 0 ? state.isPaused : false, (241 & 64) != 0 ? state.memoryCache : null, (241 & 128) != 0 ? state.cacheSize : 0);
            }
        });
    }

    public void loadStories() {
        StoriesDataState currentState = getCurrentState();
        StoriesDataState storiesDataStateCopy = currentState.copy((241 & 1) != 0 ? currentState.isLoaded : null, (241 & 2) != 0 ? currentState.onBoardingIsLoaded : null, (241 & 4) != 0 ? currentState.serverState : null, (241 & 8) != 0 ? currentState.stories : null, (241 & 16) != 0 ? currentState.currentStory : 0, (241 & 32) != 0 ? currentState.isPaused : false, (241 & 64) != 0 ? currentState.memoryCache : null, (241 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(storiesDataStateCopy, this, null), 3, null);
        getState().setValue(storiesDataStateCopy);
        subscribeOnDataSource(getStoriesFromServer(this.prefManager.getCurLocale()), new Function2<Resource<? extends List<? extends DomainStory>>, StoriesDataState, StoriesDataState>() { // from class: com.sputnik.common.viewmodels.StoriesViewModel.loadStories.2

            /* compiled from: StoriesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.StoriesViewModel$loadStories$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
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
            public /* bridge */ /* synthetic */ StoriesDataState invoke(Resource<? extends List<? extends DomainStory>> resource, StoriesDataState storiesDataState) {
                return invoke2((Resource<? extends List<DomainStory>>) resource, storiesDataState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StoriesDataState invoke2(Resource<? extends List<DomainStory>> serverData, StoriesDataState state) {
                List map;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((241 & 1) != 0 ? state.isLoaded : null, (241 & 2) != 0 ? state.onBoardingIsLoaded : null, (241 & 4) != 0 ? state.serverState : Resource.Status.LOADING, (241 & 8) != 0 ? state.stories : null, (241 & 16) != 0 ? state.currentStory : 0, (241 & 32) != 0 ? state.isPaused : false, (241 & 64) != 0 ? state.memoryCache : null, (241 & 128) != 0 ? state.cacheSize : 0);
                }
                Unit unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    List<DomainStory> data = serverData.getData();
                    return state.copy((241 & 1) != 0 ? state.isLoaded : new Event(Boolean.TRUE), (241 & 2) != 0 ? state.onBoardingIsLoaded : null, (241 & 4) != 0 ? state.serverState : status, (241 & 8) != 0 ? state.stories : (data == null || (map = StoriesViewModel.this.domainStoriesToStoriesMapper.map(data)) == null) ? null : CollectionsKt.sortedWith(map, new Comparator() { // from class: com.sputnik.common.viewmodels.StoriesViewModel$loadStories$2$invoke$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((Story) t).getOrder(), ((Story) t2).getOrder());
                        }
                    }), (241 & 16) != 0 ? state.currentStory : 0, (241 & 32) != 0 ? state.isPaused : false, (241 & 64) != 0 ? state.memoryCache : null, (241 & 128) != 0 ? state.cacheSize : 0);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null) {
                    StoriesViewModel.this.notifyErrorMessage(errorMsg.getError());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    StoriesViewModel storiesViewModel = StoriesViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    storiesViewModel.notifySimpleError(error);
                }
                return state.copy((241 & 1) != 0 ? state.isLoaded : new Event(Boolean.TRUE), (241 & 2) != 0 ? state.onBoardingIsLoaded : null, (241 & 4) != 0 ? state.serverState : Resource.Status.ERROR, (241 & 8) != 0 ? state.stories : null, (241 & 16) != 0 ? state.currentStory : 0, (241 & 32) != 0 ? state.isPaused : false, (241 & 64) != 0 ? state.memoryCache : null, (241 & 128) != 0 ? state.cacheSize : 0);
            }
        });
    }

    public void cacheImage(String name, Bitmap image) {
        Map<String, Bitmap> mapSnapshot;
        Intrinsics.checkNotNullParameter(image, "image");
        Log.e("cache", "put " + name);
        LruCache<String, Bitmap> memoryCache = getCurrentState().getMemoryCache();
        if (memoryCache != null) {
            memoryCache.put(name, image);
        }
        StoriesDataState currentState = getCurrentState();
        LruCache<String, Bitmap> memoryCache2 = getCurrentState().getMemoryCache();
        StoriesDataState storiesDataStateCopy = currentState.copy((241 & 1) != 0 ? currentState.isLoaded : null, (241 & 2) != 0 ? currentState.onBoardingIsLoaded : null, (241 & 4) != 0 ? currentState.serverState : null, (241 & 8) != 0 ? currentState.stories : null, (241 & 16) != 0 ? currentState.currentStory : 0, (241 & 32) != 0 ? currentState.isPaused : false, (241 & 64) != 0 ? currentState.memoryCache : null, (241 & 128) != 0 ? currentState.cacheSize : (memoryCache2 == null || (mapSnapshot = memoryCache2.snapshot()) == null) ? 0 : mapSnapshot.size());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(storiesDataStateCopy, this, null), 3, null);
        getState().setValue(storiesDataStateCopy);
    }

    public Bitmap getCachedImage(String name) {
        LruCache<String, Bitmap> memoryCache = getCurrentState().getMemoryCache();
        if (memoryCache != null) {
            return memoryCache.get(name);
        }
        return null;
    }

    @Override // com.sputnik.common.base.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
    }
}
