package com.sputnik.data.api;

import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.domain.entities.stories.StoriesSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/* compiled from: StoriesApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJO\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u000f\u001a\u00020\u0010H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sputnik/data/api/StoriesApi;", "", "getOnboardingStories", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/stories/DataStory;", "locale", "", "app", "platform", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStories", "jwt", "set", "Lcom/sputnik/domain/entities/stories/StoriesSet;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/sputnik/domain/entities/stories/StoriesSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StoriesApi {
    @GET("stories/onboarding")
    Object getOnboardingStories(@Query("locale") String str, @Query("app") String str2, @Query("platform") String str3, @Query("version") int i, Continuation<? super Response<List<DataStory>>> continuation);

    @GET("stories")
    Object getStories(@Header("jwt") String str, @Query("locale") String str2, @Query("platform") String str3, @Query("version") int i, @Query("set") StoriesSet storiesSet, Continuation<? super Response<List<DataStory>>> continuation);

    /* compiled from: StoriesApi.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getStories$default(StoriesApi storiesApi, String str, String str2, String str3, int i, StoriesSet storiesSet, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStories");
            }
            if ((i2 & 4) != 0) {
                str3 = "android";
            }
            String str4 = str3;
            if ((i2 & 8) != 0) {
                i = 1;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                storiesSet = StoriesSet.promo;
            }
            return storiesApi.getStories(str, str2, str4, i3, storiesSet, continuation);
        }
    }
}
