package com.sputnik.common.viewmodels;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.utils.FileUtilsKt;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import com.sputnik.domain.entities.prefs.SplashScreen;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$handleProfileSettings$2$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ProfileViewModel$handleProfileSettings$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginState.Session $foundByJwt;
    final /* synthetic */ Integer $index;
    final /* synthetic */ Profile $profile;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$handleProfileSettings$2$1(ProfileViewModel profileViewModel, Profile profile, Integer num, LoginState.Session session, Continuation<? super ProfileViewModel$handleProfileSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
        this.$profile = profile;
        this.$index = num;
        this.$foundByJwt = session;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$handleProfileSettings$2$1 profileViewModel$handleProfileSettings$2$1 = new ProfileViewModel$handleProfileSettings$2$1(this.this$0, this.$profile, this.$index, this.$foundByJwt, continuation);
        profileViewModel$handleProfileSettings$2$1.L$0 = obj;
        return profileViewModel$handleProfileSettings$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$handleProfileSettings$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.ProfileViewModel$handleProfileSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: ProfileViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.viewmodels.ProfileViewModel$handleProfileSettings$2$1$2", f = "ProfileViewModel.kt", l = {619}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.viewmodels.ProfileViewModel$handleProfileSettings$2$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $fileToWrite;
        final /* synthetic */ Integer $index;
        final /* synthetic */ Profile $profile;
        int label;
        final /* synthetic */ ProfileViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Profile profile, File file, ProfileViewModel profileViewModel, Integer num, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$profile = profile;
            this.$fileToWrite = file;
            this.this$0 = profileViewModel;
            this.$index = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$profile, this.$fileToWrite, this.this$0, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String backgroundUrl = this.$profile.getSplashScreen().getBackgroundUrl();
                final File file = this.$fileToWrite;
                final ProfileViewModel profileViewModel = this.this$0;
                final Integer num = this.$index;
                final Profile profile = this.$profile;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.sputnik.common.viewmodels.ProfileViewModel.handleProfileSettings.2.1.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LoginState.Session session;
                        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getPath());
                        FilesKt.readBytes(file);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        PrefManager prefManager = profileViewModel.getPrefManager();
                        LoginState loginState = profileViewModel.getPrefManager().getLoginState();
                        Integer num2 = num;
                        Profile profile2 = profile;
                        ProfileViewModel profileViewModel2 = profileViewModel;
                        try {
                            List<LoginState.Session> sessions = loginState.getSessions();
                            if (sessions != null) {
                                Intrinsics.checkNotNull(num2);
                                session = sessions.get(num2.intValue());
                            } else {
                                session = null;
                            }
                            if (session != null) {
                                session.setProfileSettings(new ProfileSettings(profile2.getRawAddress(), new SplashScreen(profile2.getSplashScreen().getTitle(), profile2.getSplashScreen().getBackgroundUrl(), Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0), Boolean.TRUE), profileViewModel2.getPrefManager().getProfileSettings().getNeedToClearSupportScreen()));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        prefManager.setLoginState(loginState);
                    }
                };
                this.label = 1;
                if (FileUtilsKt.downloadAsync(backgroundUrl, file, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
