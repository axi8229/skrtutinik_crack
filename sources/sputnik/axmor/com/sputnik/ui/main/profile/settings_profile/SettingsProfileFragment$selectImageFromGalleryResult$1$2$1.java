package sputnik.axmor.com.sputnik.ui.main.profile.settings_profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.google.android.gms.common.Scopes;
import com.sputnik.common.utils.PhotoUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import sputnik.axmor.com.sputnik.SputnikApp;

/* compiled from: SettingsProfileFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$selectImageFromGalleryResult$1$2$1", f = "SettingsProfileFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class SettingsProfileFragment$selectImageFromGalleryResult$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InputStream $imageStream;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingsProfileFragment$selectImageFromGalleryResult$1$2$1(InputStream inputStream, SettingsProfileFragment settingsProfileFragment, Continuation<? super SettingsProfileFragment$selectImageFromGalleryResult$1$2$1> continuation) {
        super(2, continuation);
        this.$imageStream = inputStream;
        this.this$0 = settingsProfileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsProfileFragment$selectImageFromGalleryResult$1$2$1 settingsProfileFragment$selectImageFromGalleryResult$1$2$1 = new SettingsProfileFragment$selectImageFromGalleryResult$1$2$1(this.$imageStream, this.this$0, continuation);
        settingsProfileFragment$selectImageFromGalleryResult$1$2$1.L$0 = obj;
        return settingsProfileFragment$selectImageFromGalleryResult$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsProfileFragment$selectImageFromGalleryResult$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = PhotoUtils.INSTANCE.calculateInSampleSize(options, 100, 100);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.$imageStream, null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmapDecodeStream != null) {
            Boxing.boxBoolean(bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream));
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, "data:image/jpeg;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0), null), 2, null);
        return Unit.INSTANCE;
    }

    /* compiled from: SettingsProfileFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$selectImageFromGalleryResult$1$2$1$1", f = "SettingsProfileFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.SettingsProfileFragment$selectImageFromGalleryResult$1$2$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $encodedString;
        int label;
        final /* synthetic */ SettingsProfileFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SettingsProfileFragment settingsProfileFragment, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = settingsProfileFragment;
            this.$encodedString = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$encodedString, continuation);
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
            SputnikApp.INSTANCE.getAnalyticsService().send(Scopes.PROFILE, "save_change", "photo");
            this.this$0.getProfileViewModel().changeAvatar(this.$encodedString);
            return Unit.INSTANCE;
        }
    }
}
