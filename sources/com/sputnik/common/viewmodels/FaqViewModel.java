package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.faq.FaqItem;
import com.sputnik.common.entities.faq.FaqQuestion;
import com.sputnik.common.mappers.faq.DomainFaqToFaqMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.faq.DomainFaqObject;
import com.sputnik.domain.entities.faq.DomainFaqQuestion;
import com.sputnik.domain.usecases.support.GetFaq2UseCase;
import com.sputnik.domain.usecases.support.GetFaqUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: FaqViewModel.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0018¢\u0006\u0004\b$\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010'R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010)¨\u0006*"}, d2 = {"Lcom/sputnik/common/viewmodels/FaqViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/FaqViewState;", "", "Lcom/sputnik/domain/usecases/support/GetFaqUseCase;", "getFaqUseCase", "Lcom/sputnik/domain/usecases/support/GetFaq2UseCase;", "getFaq2UseCase", "Lcom/sputnik/common/mappers/faq/DomainFaqToFaqMapper;", "domainNotificationToNotificationMapper", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/domain/usecases/support/GetFaqUseCase;Lcom/sputnik/domain/usecases/support/GetFaq2UseCase;Lcom/sputnik/common/mappers/faq/DomainFaqToFaqMapper;Lcom/sputnik/data/IConfig;Lcom/sputnik/data/local/PrefManager;)V", "", "locale", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/faq/DomainFaqObject;", "getFaq2FromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadFaqIfNeeded", "()V", "loadFaq2", "logout", "Lcom/sputnik/common/entities/faq/FaqItem;", "item", "select", "(Lcom/sputnik/common/entities/faq/FaqItem;)V", "Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;", "selectCategory", "(Lcom/sputnik/common/entities/faq/FaqItem$FaqGroup;)V", "clearExpandState", "Lcom/sputnik/domain/usecases/support/GetFaqUseCase;", "Lcom/sputnik/domain/usecases/support/GetFaq2UseCase;", "Lcom/sputnik/common/mappers/faq/DomainFaqToFaqMapper;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/data/local/PrefManager;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaqViewModel extends BaseViewModel<FaqViewState> {
    private final IConfig config;
    private final DomainFaqToFaqMapper domainNotificationToNotificationMapper;
    private final GetFaq2UseCase getFaq2UseCase;
    private final GetFaqUseCase getFaqUseCase;
    private final PrefManager prefManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaqViewModel(GetFaqUseCase getFaqUseCase, GetFaq2UseCase getFaq2UseCase, DomainFaqToFaqMapper domainNotificationToNotificationMapper, IConfig config, PrefManager prefManager) {
        super(new FaqViewState(null, null, null, null, null, 31, null), "javaClass");
        Intrinsics.checkNotNullParameter(getFaqUseCase, "getFaqUseCase");
        Intrinsics.checkNotNullParameter(getFaq2UseCase, "getFaq2UseCase");
        Intrinsics.checkNotNullParameter(domainNotificationToNotificationMapper, "domainNotificationToNotificationMapper");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.getFaqUseCase = getFaqUseCase;
        this.getFaq2UseCase = getFaq2UseCase;
        this.domainNotificationToNotificationMapper = domainNotificationToNotificationMapper;
        this.config = config;
        this.prefManager = prefManager;
    }

    static /* synthetic */ LiveData getFaq2FromServer$default(FaqViewModel faqViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faqViewModel.prefManager.getCurLocale();
        }
        return faqViewModel.getFaq2FromServer(str);
    }

    private final LiveData<Resource<List<DomainFaqObject>>> getFaq2FromServer(String locale) {
        return FlowLiveDataConversions.asLiveData$default(this.getFaq2UseCase.invoke(locale), null, 0L, 3, null);
    }

    public final void clearExpandState() {
        List<FaqItem.FaqCategory> subcategories;
        FaqViewState currentState = getCurrentState();
        List<FaqItem> faq2 = currentState.getFaq2();
        for (FaqItem faqItem : faq2) {
            if (faqItem instanceof FaqItem.FaqCategory) {
                Iterator<T> it = ((FaqItem.FaqCategory) faqItem).getQuestions().iterator();
                while (it.hasNext()) {
                    ((FaqQuestion) it.next()).setExpanded(false);
                }
            }
            if ((faqItem instanceof FaqItem.FaqGroup) && (subcategories = ((FaqItem.FaqGroup) faqItem).getSubcategories()) != null) {
                Iterator<T> it2 = subcategories.iterator();
                while (it2.hasNext()) {
                    List<FaqQuestion> questions = ((FaqItem.FaqCategory) it2.next()).getQuestions();
                    if (questions != null) {
                        Iterator<T> it3 = questions.iterator();
                        while (it3.hasNext()) {
                            ((FaqQuestion) it3.next()).setExpanded(false);
                        }
                    }
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        FaqViewState faqViewStateCopy$default = FaqViewState.copy$default(currentState, null, null, faq2, null, null, 27, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(faqViewStateCopy$default, this, null), 3, null);
        getState().setValue(faqViewStateCopy$default);
    }

    public final void loadFaq2() {
        FaqViewState faqViewStateCopy$default = FaqViewState.copy$default(getCurrentState(), Resource.Status.LOADING, null, null, null, null, 30, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(faqViewStateCopy$default, this, null), 3, null);
        getState().setValue(faqViewStateCopy$default);
        subscribeOnDataSource(getFaq2FromServer$default(this, null, 1, null), new Function2<Resource<? extends List<? extends DomainFaqObject>>, FaqViewState, FaqViewState>() { // from class: com.sputnik.common.viewmodels.FaqViewModel.loadFaq2.2

            /* compiled from: FaqViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.FaqViewModel$loadFaq2$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ FaqViewState invoke(Resource<? extends List<? extends DomainFaqObject>> resource, FaqViewState faqViewState) {
                return invoke2((Resource<? extends List<DomainFaqObject>>) resource, faqViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FaqViewState invoke2(Resource<? extends List<DomainFaqObject>> data, FaqViewState state) {
                Unit unit;
                String message;
                List listEmptyList;
                Iterator it;
                List listEmptyList2;
                FaqItem faqCategory;
                List listEmptyList3;
                Iterator it2;
                List listEmptyList4;
                Iterator it3;
                String color;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return FaqViewState.copy$default(state, state.getServerState(), null, null, null, null, 30, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        FaqViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        FaqViewModel faqViewModel = FaqViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        faqViewModel.notifySimpleError(error);
                    }
                    return FaqViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, 30, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List<DomainFaqObject> data2 = data.getData();
                if (data2 != null) {
                    List<DomainFaqObject> list = data2;
                    int i2 = 10;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        DomainFaqObject domainFaqObject = (DomainFaqObject) it4.next();
                        if (domainFaqObject.getQuestions() == null) {
                            Integer id = domainFaqObject.getId();
                            String title = domainFaqObject.getTitle();
                            List<DomainFaqObject> subcategories = domainFaqObject.getSubcategories();
                            if (subcategories != null) {
                                List<DomainFaqObject> list2 = subcategories;
                                listEmptyList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, i2));
                                for (DomainFaqObject domainFaqObject2 : list2) {
                                    Integer id2 = domainFaqObject2.getId();
                                    String title2 = domainFaqObject2.getTitle();
                                    List<DomainFaqQuestion> questions = domainFaqObject2.getQuestions();
                                    if (questions != null) {
                                        List<DomainFaqQuestion> list3 = questions;
                                        listEmptyList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, i2));
                                        for (DomainFaqQuestion domainFaqQuestion : list3) {
                                            Long id3 = domainFaqQuestion.getId();
                                            String question = domainFaqQuestion.getQuestion();
                                            String answer = domainFaqQuestion.getAnswer();
                                            String link = domainFaqQuestion.getLink();
                                            DomainFaqQuestion.DomainFaqButton button = domainFaqQuestion.getButton();
                                            Long id4 = button != null ? button.getId() : null;
                                            DomainFaqQuestion.DomainFaqButton button2 = domainFaqQuestion.getButton();
                                            if (button2 != null) {
                                                it3 = it4;
                                                color = button2.getColor();
                                            } else {
                                                it3 = it4;
                                                color = null;
                                            }
                                            DomainFaqQuestion.DomainFaqButton button3 = domainFaqQuestion.getButton();
                                            String title3 = button3 != null ? button3.getTitle() : null;
                                            DomainFaqQuestion.DomainFaqButton button4 = domainFaqQuestion.getButton();
                                            listEmptyList4.add(new FaqQuestion(id3, question, answer, new FaqQuestion.FaqButton(id4, color, title3, button4 != null ? button4.getDeeplink() : null), link, false, 32, null));
                                            it4 = it3;
                                        }
                                        it2 = it4;
                                    } else {
                                        it2 = it4;
                                        listEmptyList4 = CollectionsKt.emptyList();
                                    }
                                    listEmptyList3.add(new FaqItem.FaqCategory(id2, title2, listEmptyList4));
                                    it4 = it2;
                                    i2 = 10;
                                }
                                it = it4;
                            } else {
                                it = it4;
                                listEmptyList3 = CollectionsKt.emptyList();
                            }
                            faqCategory = new FaqItem.FaqGroup(id, title, listEmptyList3);
                        } else {
                            it = it4;
                            Integer id5 = domainFaqObject.getId();
                            String title4 = domainFaqObject.getTitle();
                            List<DomainFaqQuestion> questions2 = domainFaqObject.getQuestions();
                            if (questions2 != null) {
                                List<DomainFaqQuestion> list4 = questions2;
                                listEmptyList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                                for (DomainFaqQuestion domainFaqQuestion2 : list4) {
                                    Long id6 = domainFaqQuestion2.getId();
                                    String question2 = domainFaqQuestion2.getQuestion();
                                    String answer2 = domainFaqQuestion2.getAnswer();
                                    String link2 = domainFaqQuestion2.getLink();
                                    DomainFaqQuestion.DomainFaqButton button5 = domainFaqQuestion2.getButton();
                                    Long id7 = button5 != null ? button5.getId() : null;
                                    DomainFaqQuestion.DomainFaqButton button6 = domainFaqQuestion2.getButton();
                                    String color2 = button6 != null ? button6.getColor() : null;
                                    DomainFaqQuestion.DomainFaqButton button7 = domainFaqQuestion2.getButton();
                                    String title5 = button7 != null ? button7.getTitle() : null;
                                    DomainFaqQuestion.DomainFaqButton button8 = domainFaqQuestion2.getButton();
                                    listEmptyList2.add(new FaqQuestion(id6, question2, answer2, new FaqQuestion.FaqButton(id7, color2, title5, button8 != null ? button8.getDeeplink() : null), link2, false, 32, null));
                                }
                            } else {
                                listEmptyList2 = CollectionsKt.emptyList();
                            }
                            faqCategory = new FaqItem.FaqCategory(id5, title4, listEmptyList2);
                        }
                        arrayList.add(faqCategory);
                        it4 = it;
                        i2 = 10;
                    }
                    listEmptyList = arrayList;
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return FaqViewState.copy$default(state, status, null, listEmptyList, null, null, 26, null);
            }
        });
    }

    public final void logout() {
        FaqViewState faqViewStateCopy$default = FaqViewState.copy$default(getCurrentState(), Resource.Status.NONE, CollectionsKt.emptyList(), null, null, null, 28, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(faqViewStateCopy$default, this, null), 3, null);
        getState().setValue(faqViewStateCopy$default);
    }

    public final void select(FaqItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FaqViewState faqViewStateCopy$default = FaqViewState.copy$default(getCurrentState(), null, null, null, item, null, 23, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(faqViewStateCopy$default, this, null), 3, null);
        getState().setValue(faqViewStateCopy$default);
    }

    public final void selectCategory(FaqItem.FaqGroup item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FaqViewState faqViewStateCopy$default = FaqViewState.copy$default(getCurrentState(), null, null, null, null, item, 15, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(faqViewStateCopy$default, this, null), 3, null);
        getState().setValue(faqViewStateCopy$default);
    }

    public final void loadFaqIfNeeded() {
        if (getCurrentState().getServerState() != Resource.Status.SUCCESS) {
            loadFaq2();
        }
    }
}
