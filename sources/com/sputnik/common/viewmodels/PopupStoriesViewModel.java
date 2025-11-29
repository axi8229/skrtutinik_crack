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
import com.sputnik.common.entities.popup.Appearance;
import com.sputnik.common.entities.popup.Background;
import com.sputnik.common.entities.popup.Bar;
import com.sputnik.common.entities.popup.Button;
import com.sputnik.common.entities.popup.Image;
import com.sputnik.common.entities.popup.PopupStory;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.popup.Subtitle;
import com.sputnik.common.entities.popup.Title;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.usecases.popups.GetPopupStoriesUseCase;
import com.sputnik.domain.usecases.popups.SendPopupStoriesActionUseCase;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: PopupStoriesViewModel.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B=\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u00130\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010\u001fJ'\u0010!\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u001d¢\u0006\u0004\b#\u0010\u001fJ\u001f\u0010'\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u001dH\u0014¢\u0006\u0004\b+\u0010\u001fJ\r\u0010,\u001a\u00020\u001d¢\u0006\u0004\b,\u0010\u001fJ\u001d\u0010-\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b-\u0010.J\u001d\u00100\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b3\u00104J\u001d\u00105\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b5\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00107R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00108R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00109R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010:R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020;0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=¨\u0006?"}, d2 = {"Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/PopupStoriesDataState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/domain/usecases/popups/GetPopupStoriesUseCase;", "getPopupStoriesUseCase", "Lcom/sputnik/domain/usecases/popups/SendPopupStoriesActionUseCase;", "sendPopupStoryActionUseCase", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "Lcom/sputnik/common/entities/popup/PopupStoryStructure;", "domainPopupStoriesToPopupStoriesMapper", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;Lcom/sputnik/domain/usecases/popups/GetPopupStoriesUseCase;Lcom/sputnik/domain/usecases/popups/SendPopupStoriesActionUseCase;Lcom/sputnik/domain/common/NullableInputListMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getPopupStoriesFromServer", "()Landroidx/lifecycle/LiveData;", "", "popupId", "storyId", "action", "sendStoryActionToServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadPopupStoriesIfNeeded", "()V", "loadPopupStories", "sendStoryAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clearServerStatus", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/graphics/Bitmap;", "image", "cacheImage", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "getCachedImage", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "onCleared", "markStoriesAsShowed", "markStoryAsShowed", "(Ljava/lang/String;Ljava/lang/String;)V", "", "isStoryShowed", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "getStoryPosition", "()Ljava/lang/Integer;", "updateStoryPosition", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/domain/usecases/popups/GetPopupStoriesUseCase;", "Lcom/sputnik/domain/usecases/popups/SendPopupStoriesActionUseCase;", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/common/entities/popup/PopupStory;", "testStoriesList", "Ljava/util/List;", "testStory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PopupStoriesViewModel extends BaseViewModel<PopupStoriesDataState> {
    private final IConfig config;
    private final NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> domainPopupStoriesToPopupStoriesMapper;
    private final GetPopupStoriesUseCase getPopupStoriesUseCase;
    private final PrefManager prefManager;
    private final SendPopupStoriesActionUseCase sendPopupStoryActionUseCase;
    private final List<PopupStory> testStoriesList;
    private final List<PopupStory> testStory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupStoriesViewModel(PrefManager prefManager, IConfig config, GetPopupStoriesUseCase getPopupStoriesUseCase, SendPopupStoriesActionUseCase sendPopupStoryActionUseCase, NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> domainPopupStoriesToPopupStoriesMapper) {
        super(new PopupStoriesDataState(null, null, null, false, 0, false, null, 0, KotlinVersion.MAX_COMPONENT_VALUE, null), "javaClass");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(getPopupStoriesUseCase, "getPopupStoriesUseCase");
        Intrinsics.checkNotNullParameter(sendPopupStoryActionUseCase, "sendPopupStoryActionUseCase");
        Intrinsics.checkNotNullParameter(domainPopupStoriesToPopupStoriesMapper, "domainPopupStoriesToPopupStoriesMapper");
        this.prefManager = prefManager;
        this.config = config;
        this.getPopupStoriesUseCase = getPopupStoriesUseCase;
        this.sendPopupStoryActionUseCase = sendPopupStoryActionUseCase;
        this.domainPopupStoriesToPopupStoriesMapper = domainPopupStoriesToPopupStoriesMapper;
        loadPopupStories();
        final int iMaxMemory = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
        Log.e("cache_size", String.valueOf(iMaxMemory));
        LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(iMaxMemory) { // from class: com.sputnik.common.viewmodels.PopupStoriesViewModel$memoryCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                return bitmap.getByteCount() / 1024;
            }
        };
        PopupStoriesDataState currentState = getCurrentState();
        PopupStoriesDataState popupStoriesDataStateCopy = currentState.copy((249 & 1) != 0 ? currentState.isLoaded : null, (249 & 2) != 0 ? currentState.serverState : null, (249 & 4) != 0 ? currentState.stories : null, (249 & 8) != 0 ? currentState.isStoriesShowed : false, (249 & 16) != 0 ? currentState.currentStory : 0, (249 & 32) != 0 ? currentState.isPaused : false, (249 & 64) != 0 ? currentState.memoryCache : lruCache, (249 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(popupStoriesDataStateCopy, this, null), 3, null);
        getState().setValue(popupStoriesDataStateCopy);
        this.testStoriesList = CollectionsKt.listOf((Object[]) new PopupStory[]{new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("6E6D7A", "FFFFFF"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/5/85c84c27-ddaa-40ca-a034-dc073b7e6ff5.png"), new Title("Для вас подписка \"Семья\"\nна 30 дней за 1₽", "FFFFFF", "на 30 дней за 1₽", "0EA7FF"), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить за 1 руб.", "sputnik://profile", "ffffff", "gradient", null, 16, null), new Button("Подробнее", "sputnik://about/app", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Подключите сегодня и пользуйтесь \n30 дней премиум-функциями! ", "FFFFFF"), new Background("https://i.pinimg.com/564x/61/25/59/6125595537c8fb5fc9c7e6cb256155e9.jpg", "0d0c21")), false, 8, null), new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("6E6D7A", "FFFFFF"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/6/9e780312-f6ca-4dfb-8182-2f367fd7ffe7.png"), new Title("Просмотр и скачивание видеоархива", "FFFFFF", null, null), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить за 1 руб.", "sputnik://market", "ffffff", "712F79", null, 16, null), new Button("Подробнее", "sputnik://market/services", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Смотрите и скачивайте видеозаписи\nс камеры домофона за трое суток", "FFFFFF"), new Background("https://wallpapers.com/images/featured/mobile-58g8gv3r23zg29kw.jpg", "0d0c21")), false, 8, null), new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("6E6D7A", "FFFFFF"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/6/9e780312-f6ca-4dfb-8182-2f367fd7ffe7.png"), new Title("История посещений \nза 30 дней", "FFFFFF", null, null), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить за 1 руб.", "sputnik://market/standard", "ffffff", "48639C", null, 16, null), new Button("Подробнее", "sputnik://market/standard/payment", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Просматривайте журнал звонков\nза 30 дней", "FFFFFF"), new Background("https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?cs=srgb&dl=pexels-pixabay-531880.jpg&fm=jpg", "0d0c21")), false, 8, null), new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("6E6D7A", "FFFFFF"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/5/85c84c27-ddaa-40ca-a034-dc073b7e6ff5.png"), new Title("Уникальный код для домофона", "FFFFFF", null, null), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить за 1 руб.", "sputnik://visits", "ffffff", "F7996E", null, 16, null), new Button("Подробнее", "sputnik://service_payments", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Создавайте коды для домофона\nна всю семью, курьерам и гостям", "FFFFFF"), new Background("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeOLnBT7cevvNx5T_p1E2euGVSx_c6dMYCig&s", "0d0c21")), false, 8, null), new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("6E6D7A", "FFFFFF"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/5/85c84c27-ddaa-40ca-a034-dc073b7e6ff5.png"), new Title("Быстрая загрузка приложения", "FFFFFF", null, null), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить за 1 руб.", "sputnik://onboarding/our_home", "ffffff", "gradient", null, 16, null), new Button("Подробнее", "sputnik://faq", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Не ждите пока загрузится приложение, пользуйтесь нужными функциями сразу", "FFFFFF"), new Background("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAcHr9dJcYUZrhlOF4GzmVPSUjaNErG1MlBA&s", "0d0c21")), false, 8, null), new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("0EA7FF", "000050"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/5/85c84c27-ddaa-40ca-a034-dc073b7e6ff5.png"), new Title("Для вас подписка \"Семья\"\nна 30 дней за 1₽", "000000", "на 30 дней за 1₽", "0EA7FF"), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить", "family", "ffffff", "gradient", null, 16, null), new Button("Подробнее", "notifications", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Подключите до конца февраля и используйте целый месяц \u2028все преимущества!  ", "000000"), new Background("", "FFFFFF")), false, 8, null)});
        this.testStory = CollectionsKt.listOf(new PopupStory(UUID.randomUUID().getLeastSignificantBits(), 1L, new Appearance(new Bar("0EA7FF", "000050"), new Image("https://storage.yandexcloud.net/sputnik-systems-citizen-app-test/uploads/popup/story/image/5/85c84c27-ddaa-40ca-a034-dc073b7e6ff5.png"), new Title("Дарим 1 месяц подписки \nза смену способа оплаты!", "000000", null, null), CollectionsKt.listOf((Object[]) new Button[]{new Button("Подключить", "market/standard/payment", "ffffff", "gradient", null, 16, null), new Button("Подробнее", "market/standard", "6E6D7A", "clear", null, 16, null), new Button("Подробнее", "market/standard", "6E6D7A", "clear", null, 16, null)}), new Subtitle("Оплатите подписку за 1 руб. \nчерез банковскую карту \nи получите 30 дней бесплатно", "000000"), new Background("", "FFFFFF")), false, 8, null));
    }

    private final LiveData<Resource<List<DomainPopupStoryStructure>>> getPopupStoriesFromServer() {
        return FlowLiveDataConversions.asLiveData$default(GetPopupStoriesUseCase.invoke$default(this.getPopupStoriesUseCase, 0, 1, null), null, 0L, 3, null);
    }

    private final LiveData<Resource<Object>> sendStoryActionToServer(String popupId, String storyId, String action) {
        return FlowLiveDataConversions.asLiveData$default(this.sendPopupStoryActionUseCase.invoke(popupId, storyId, action), null, 0L, 3, null);
    }

    public final void loadPopupStoriesIfNeeded() {
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            loadPopupStories();
        }
    }

    public final void clearServerStatus() {
        PopupStoriesDataState currentState = getCurrentState();
        PopupStoriesDataState popupStoriesDataStateCopy = currentState.copy((249 & 1) != 0 ? currentState.isLoaded : null, (249 & 2) != 0 ? currentState.serverState : Resource.Status.NONE, (249 & 4) != 0 ? currentState.stories : null, (249 & 8) != 0 ? currentState.isStoriesShowed : false, (249 & 16) != 0 ? currentState.currentStory : 0, (249 & 32) != 0 ? currentState.isPaused : false, (249 & 64) != 0 ? currentState.memoryCache : null, (249 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(popupStoriesDataStateCopy, this, null), 3, null);
        getState().setValue(popupStoriesDataStateCopy);
    }

    public void loadPopupStories() {
        PopupStoriesDataState currentState = getCurrentState();
        PopupStoriesDataState popupStoriesDataStateCopy = currentState.copy((249 & 1) != 0 ? currentState.isLoaded : null, (249 & 2) != 0 ? currentState.serverState : null, (249 & 4) != 0 ? currentState.stories : null, (249 & 8) != 0 ? currentState.isStoriesShowed : false, (249 & 16) != 0 ? currentState.currentStory : 0, (249 & 32) != 0 ? currentState.isPaused : false, (249 & 64) != 0 ? currentState.memoryCache : null, (249 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(popupStoriesDataStateCopy, this, null), 3, null);
        getState().setValue(popupStoriesDataStateCopy);
        subscribeOnDataSource(getPopupStoriesFromServer(), new Function2<Resource<? extends List<? extends DomainPopupStoryStructure>>, PopupStoriesDataState, PopupStoriesDataState>() { // from class: com.sputnik.common.viewmodels.PopupStoriesViewModel.loadPopupStories.2

            /* compiled from: PopupStoriesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.PopupStoriesViewModel$loadPopupStories$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ PopupStoriesDataState invoke(Resource<? extends List<? extends DomainPopupStoryStructure>> resource, PopupStoriesDataState popupStoriesDataState) {
                return invoke2((Resource<? extends List<DomainPopupStoryStructure>>) resource, popupStoriesDataState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final PopupStoriesDataState invoke2(Resource<? extends List<DomainPopupStoryStructure>> serverData, PopupStoriesDataState state) {
                List map;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((249 & 1) != 0 ? state.isLoaded : null, (249 & 2) != 0 ? state.serverState : Resource.Status.LOADING, (249 & 4) != 0 ? state.stories : null, (249 & 8) != 0 ? state.isStoriesShowed : false, (249 & 16) != 0 ? state.currentStory : 0, (249 & 32) != 0 ? state.isPaused : false, (249 & 64) != 0 ? state.memoryCache : null, (249 & 128) != 0 ? state.cacheSize : 0);
                }
                if (i == 3) {
                    return state.copy((249 & 1) != 0 ? state.isLoaded : null, (249 & 2) != 0 ? state.serverState : Resource.Status.ERROR, (249 & 4) != 0 ? state.stories : null, (249 & 8) != 0 ? state.isStoriesShowed : false, (249 & 16) != 0 ? state.currentStory : 0, (249 & 32) != 0 ? state.isPaused : false, (249 & 64) != 0 ? state.memoryCache : null, (249 & 128) != 0 ? state.cacheSize : 0);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List<DomainPopupStoryStructure> data = serverData.getData();
                return state.copy((249 & 1) != 0 ? state.isLoaded : null, (249 & 2) != 0 ? state.serverState : status, (249 & 4) != 0 ? state.stories : (data == null || (map = PopupStoriesViewModel.this.domainPopupStoriesToPopupStoriesMapper.map(data)) == null) ? null : CollectionsKt.sortedWith(map, new Comparator() { // from class: com.sputnik.common.viewmodels.PopupStoriesViewModel$loadPopupStories$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((PopupStoryStructure) t).getPriority()), Long.valueOf(((PopupStoryStructure) t2).getPriority()));
                    }
                }), (249 & 8) != 0 ? state.isStoriesShowed : false, (249 & 16) != 0 ? state.currentStory : 0, (249 & 32) != 0 ? state.isPaused : false, (249 & 64) != 0 ? state.memoryCache : null, (249 & 128) != 0 ? state.cacheSize : 0);
            }
        });
    }

    public final void markStoriesAsShowed() {
        PopupStoriesDataState currentState = getCurrentState();
        PopupStoriesDataState popupStoriesDataStateCopy = currentState.copy((249 & 1) != 0 ? currentState.isLoaded : null, (249 & 2) != 0 ? currentState.serverState : null, (249 & 4) != 0 ? currentState.stories : null, (249 & 8) != 0 ? currentState.isStoriesShowed : true, (249 & 16) != 0 ? currentState.currentStory : 0, (249 & 32) != 0 ? currentState.isPaused : false, (249 & 64) != 0 ? currentState.memoryCache : null, (249 & 128) != 0 ? currentState.cacheSize : 0);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(popupStoriesDataStateCopy, this, null), 3, null);
        getState().setValue(popupStoriesDataStateCopy);
    }

    public void sendStoryAction(String popupId, String storyId, String action) {
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(action, "action");
        subscribeOnDataSource(sendStoryActionToServer(popupId, storyId, action), new Function2<Resource<? extends Object>, PopupStoriesDataState, PopupStoriesDataState>() { // from class: com.sputnik.common.viewmodels.PopupStoriesViewModel.sendStoryAction.1
            @Override // kotlin.jvm.functions.Function2
            public final PopupStoriesDataState invoke(Resource<? extends Object> serverData, PopupStoriesDataState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                Exception error = serverData.getError();
                LogUtilsKt.writeLog(String.valueOf(error != null ? error.getMessage() : null));
                Exception error2 = serverData.getError();
                if (error2 != null) {
                    error2.printStackTrace();
                }
                return state;
            }
        });
    }

    public final void cacheImage(String name, Bitmap image) {
        Map<String, Bitmap> mapSnapshot;
        Intrinsics.checkNotNullParameter(image, "image");
        Log.e("cache", "put " + name);
        LruCache<String, Bitmap> memoryCache = getCurrentState().getMemoryCache();
        if (memoryCache != null) {
            memoryCache.put(name, image);
        }
        PopupStoriesDataState currentState = getCurrentState();
        LruCache<String, Bitmap> memoryCache2 = getCurrentState().getMemoryCache();
        PopupStoriesDataState popupStoriesDataStateCopy = currentState.copy((249 & 1) != 0 ? currentState.isLoaded : null, (249 & 2) != 0 ? currentState.serverState : null, (249 & 4) != 0 ? currentState.stories : null, (249 & 8) != 0 ? currentState.isStoriesShowed : false, (249 & 16) != 0 ? currentState.currentStory : 0, (249 & 32) != 0 ? currentState.isPaused : false, (249 & 64) != 0 ? currentState.memoryCache : null, (249 & 128) != 0 ? currentState.cacheSize : (memoryCache2 == null || (mapSnapshot = memoryCache2.snapshot()) == null) ? 0 : mapSnapshot.size());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(popupStoriesDataStateCopy, this, null), 3, null);
        getState().setValue(popupStoriesDataStateCopy);
    }

    public final Bitmap getCachedImage(String name) {
        LruCache<String, Bitmap> memoryCache = getCurrentState().getMemoryCache();
        if (memoryCache != null) {
            return memoryCache.get(name);
        }
        return null;
    }

    @Override // com.sputnik.common.base.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        LruCache<String, Bitmap> memoryCache = getCurrentState().getMemoryCache();
        if (memoryCache != null) {
            memoryCache.evictAll();
        }
    }

    public final void markStoryAsShowed(String popupId, String storyId) {
        PopupStoryStructure popupStoryStructure;
        PopupStory popupStory;
        PopupStoryStructure popupStoryStructure2;
        List<PopupStory> popupStories;
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        try {
            List<PopupStoryStructure> stories = getCurrentState().getStories();
            if (stories != null) {
                Iterator<T> it = stories.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it.next();
                        if (Intrinsics.areEqual(String.valueOf(((PopupStoryStructure) next2).getId()), popupId)) {
                            break;
                        }
                    }
                }
                popupStoryStructure = (PopupStoryStructure) next2;
            } else {
                popupStoryStructure = null;
            }
            List<PopupStoryStructure> stories2 = getCurrentState().getStories();
            Integer numValueOf = stories2 != null ? Integer.valueOf(CollectionsKt.indexOf((List<? extends PopupStoryStructure>) stories2, popupStoryStructure)) : null;
            PopupStoriesDataState currentState = getCurrentState();
            List<PopupStoryStructure> stories3 = currentState.getStories();
            List mutableList = stories3 != null ? CollectionsKt.toMutableList((Collection) stories3) : null;
            if (numValueOf != null) {
                if (mutableList == null || (popupStoryStructure2 = (PopupStoryStructure) mutableList.get(numValueOf.intValue())) == null || (popupStories = popupStoryStructure2.getPopupStories()) == null) {
                    popupStory = null;
                } else {
                    Iterator<T> it2 = popupStories.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it2.next();
                            if (Intrinsics.areEqual(String.valueOf(((PopupStory) next).getId()), storyId)) {
                                break;
                            }
                        }
                    }
                    popupStory = (PopupStory) next;
                }
                if (popupStory != null) {
                    popupStory.setShowed(true);
                }
            }
            PopupStoriesDataState popupStoriesDataStateCopy = currentState.copy((249 & 1) != 0 ? currentState.isLoaded : null, (249 & 2) != 0 ? currentState.serverState : null, (249 & 4) != 0 ? currentState.stories : mutableList, (249 & 8) != 0 ? currentState.isStoriesShowed : false, (249 & 16) != 0 ? currentState.currentStory : 0, (249 & 32) != 0 ? currentState.isPaused : false, (249 & 64) != 0 ? currentState.memoryCache : null, (249 & 128) != 0 ? currentState.cacheSize : 0);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(popupStoriesDataStateCopy, this, null), 3, null);
            getState().setValue(popupStoriesDataStateCopy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean isStoryShowed(String popupId, String storyId) {
        Object obj;
        Object next;
        List<PopupStory> popupStories;
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        List<PopupStoryStructure> stories = getCurrentState().getStories();
        if (stories == null) {
            return false;
        }
        Iterator<T> it = stories.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(String.valueOf(((PopupStoryStructure) next).getId()), popupId)) {
                break;
            }
        }
        PopupStoryStructure popupStoryStructure = (PopupStoryStructure) next;
        if (popupStoryStructure == null || (popupStories = popupStoryStructure.getPopupStories()) == null) {
            return false;
        }
        Iterator<T> it2 = popupStories.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(String.valueOf(((PopupStory) next2).getId()), storyId)) {
                obj = next2;
                break;
            }
        }
        PopupStory popupStory = (PopupStory) obj;
        return popupStory != null && popupStory.getShowed();
    }

    public final Integer getStoryPosition() {
        return Integer.valueOf(getCurrentState().getCurrentStory());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateStoryPosition(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "storyId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.sputnik.common.base.VMState r2 = r16.getCurrentState()
            com.sputnik.common.viewmodels.PopupStoriesDataState r2 = (com.sputnik.common.viewmodels.PopupStoriesDataState) r2
            java.util.List r2 = r2.getStories()
            if (r2 == 0) goto L6f
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L20:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L3d
            java.lang.Object r3 = r2.next()
            r5 = r3
            com.sputnik.common.entities.popup.PopupStoryStructure r5 = (com.sputnik.common.entities.popup.PopupStoryStructure) r5
            long r5 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L20
            goto L3e
        L3d:
            r3 = r4
        L3e:
            com.sputnik.common.entities.popup.PopupStoryStructure r3 = (com.sputnik.common.entities.popup.PopupStoryStructure) r3
            if (r3 == 0) goto L6f
            java.util.List r2 = r3.getPopupStories()
            if (r2 == 0) goto L6f
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L4e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L6a
            java.lang.Object r3 = r2.next()
            r5 = r3
            com.sputnik.common.entities.popup.PopupStory r5 = (com.sputnik.common.entities.popup.PopupStory) r5
            long r5 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r5 == 0) goto L4e
            goto L6b
        L6a:
            r3 = r4
        L6b:
            com.sputnik.common.entities.popup.PopupStory r3 = (com.sputnik.common.entities.popup.PopupStory) r3
            if (r3 != 0) goto L73
        L6f:
            r1 = r16
            goto Led
        L73:
            com.sputnik.common.base.VMState r1 = r16.getCurrentState()
            com.sputnik.common.viewmodels.PopupStoriesDataState r1 = (com.sputnik.common.viewmodels.PopupStoriesDataState) r1
            java.util.List r1 = r1.getStories()
            if (r1 == 0) goto Lb5
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L85:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto La1
            java.lang.Object r2 = r1.next()
            r5 = r2
            com.sputnik.common.entities.popup.PopupStoryStructure r5 = (com.sputnik.common.entities.popup.PopupStoryStructure) r5
            long r5 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L85
            goto La2
        La1:
            r2 = r4
        La2:
            com.sputnik.common.entities.popup.PopupStoryStructure r2 = (com.sputnik.common.entities.popup.PopupStoryStructure) r2
            if (r2 == 0) goto Lb5
            java.util.List r0 = r2.getPopupStories()
            if (r0 == 0) goto Lb5
            int r0 = r0.indexOf(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto Lb6
        Lb5:
            r0 = r4
        Lb6:
            if (r0 == 0) goto Leb
            int r0 = r0.intValue()
            com.sputnik.common.base.VMState r1 = r16.getCurrentState()
            r5 = r1
            com.sputnik.common.viewmodels.PopupStoriesDataState r5 = (com.sputnik.common.viewmodels.PopupStoriesDataState) r5
            int r10 = r0 + 1
            r14 = 239(0xef, float:3.35E-43)
            r15 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            com.sputnik.common.viewmodels.PopupStoriesDataState r0 = com.sputnik.common.viewmodels.PopupStoriesDataState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            kotlinx.coroutines.CoroutineScope r5 = androidx.lifecycle.ViewModelKt.getViewModelScope(r16)
            com.sputnik.common.base.BaseViewModel$updateState$1 r8 = new com.sputnik.common.base.BaseViewModel$updateState$1
            r1 = r16
            r8.<init>(r0, r1, r4)
            r9 = 3
            r10 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
            androidx.lifecycle.MediatorLiveData r2 = r16.getState()
            r2.setValue(r0)
            goto Led
        Leb:
            r1 = r16
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.PopupStoriesViewModel.updateStoryPosition(java.lang.String, java.lang.String):void");
    }
}
