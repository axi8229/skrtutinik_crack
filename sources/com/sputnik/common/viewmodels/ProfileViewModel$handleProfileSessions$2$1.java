package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.profile.Profile;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$handleProfileSessions$2$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ProfileViewModel$handleProfileSessions$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $index;
    final /* synthetic */ Profile $profile;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$handleProfileSessions$2$1(Profile profile, ProfileViewModel profileViewModel, Integer num, Continuation<? super ProfileViewModel$handleProfileSessions$2$1> continuation) {
        super(2, continuation);
        this.$profile = profile;
        this.this$0 = profileViewModel;
        this.$index = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$handleProfileSessions$2$1 profileViewModel$handleProfileSessions$2$1 = new ProfileViewModel$handleProfileSessions$2$1(this.$profile, this.this$0, this.$index, continuation);
        profileViewModel$handleProfileSessions$2$1.L$0 = obj;
        return profileViewModel$handleProfileSessions$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$handleProfileSessions$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws SocketException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        throw new SocketException();
    }
}
