package com.sputnik.common.localization;

import android.app.Application;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.data.local.PrefManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* compiled from: LocalizationStorage.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJE\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010,\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/sputnik/common/localization/LocalizationStorage;", "Lcom/sputnik/common/localization/ILocalizationStorage;", "Landroid/app/Application;", "context", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Landroid/app/Application;Lcom/sputnik/data/local/PrefManager;Lkotlinx/coroutines/CoroutineScope;)V", "", "locale", "", "deleteOldLocalization", "(Ljava/lang/String;)V", "link", "Ljava/io/File;", "file", "Lkotlin/Function2;", "", "progress", "Lkotlinx/coroutines/Deferred;", "downloadAsync", "(Ljava/lang/String;Ljava/io/File;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localizationFile", "Lcom/sputnik/common/entities/localization/LocalizationLocalModel;", "readData", "(Ljava/io/File;)Lcom/sputnik/common/entities/localization/LocalizationLocalModel;", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "errHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_data", "Lcom/sputnik/common/entities/localization/LocalizationLocalModel;", "getData", "()Lcom/sputnik/common/entities/localization/LocalizationLocalModel;", RemoteMessageConst.DATA, "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalizationStorage implements ILocalizationStorage {
    private LocalizationLocalModel _data;
    private final Application context;
    private final CoroutineExceptionHandler errHandler;
    private final PrefManager prefManager;
    private final CoroutineScope scope;

    public LocalizationStorage(Application context, PrefManager prefManager, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.prefManager = prefManager;
        this.scope = scope;
        Log.e("DAGGER", "LocalizationStorage");
        this.errHandler = new LocalizationStorage$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
    }

    public final Application getContext() {
        return this.context;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final LocalizationLocalModel getData() {
        LocalizationLocalModel localizationLocalModel = this._data;
        if (localizationLocalModel != null) {
            return localizationLocalModel;
        }
        String curLocale = this.prefManager.getCurLocale();
        if (StringsKt.isBlank(curLocale)) {
            curLocale = AndroidConstants.INSTANCE.getPhoneLocale();
        }
        File file = new File(this.context.getFilesDir(), "new_localization_file_" + curLocale);
        deleteOldLocalization(curLocale);
        return readData(file);
    }

    /* compiled from: LocalizationStorage.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.common.localization.LocalizationStorage$downloadAsync$2", f = "LocalizationStorage.kt", l = {63, 69}, m = "invokeSuspend")
    /* renamed from: com.sputnik.common.localization.LocalizationStorage$downloadAsync$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Long>>, Object> {
        final /* synthetic */ File $file;
        final /* synthetic */ String $link;
        final /* synthetic */ Function2<Long, Long, Unit> $progress;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, File file, Function2<? super Long, ? super Long, Unit> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$link = str;
            this.$file = file;
            this.$progress = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$link, this.$file, this.$progress, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Long>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Deferred<Long>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<Long>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CoroutineScope coroutineScope2;
            URL url;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope3, Dispatchers.getIO(), null, new LocalizationStorage$downloadAsync$2$url$1(this.$link, null), 2, null);
                this.L$0 = coroutineScope3;
                this.label = 1;
                Object objAwait = deferredAsync$default.await(this);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope3;
                obj = objAwait;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    URL url2 = (URL) this.L$1;
                    CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope2 = coroutineScope4;
                    url = url2;
                    long contentLengthLong = ((URLConnection) obj).getContentLengthLong();
                    return BuildersKt__Builders_commonKt.async$default(coroutineScope2, Dispatchers.getIO(), null, new LocalizationStorage$downloadAsync$2$bytes$1(url, this.$file, this.$progress, contentLengthLong, null), 2, null);
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            URL url3 = (URL) obj;
            Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new LocalizationStorage$downloadAsync$2$connection$1(url3, null), 2, null);
            this.L$0 = coroutineScope;
            this.L$1 = url3;
            this.label = 2;
            Object objAwait2 = deferredAsync$default2.await(this);
            if (objAwait2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope2 = coroutineScope;
            url = url3;
            obj = objAwait2;
            long contentLengthLong2 = ((URLConnection) obj).getContentLengthLong();
            return BuildersKt__Builders_commonKt.async$default(coroutineScope2, Dispatchers.getIO(), null, new LocalizationStorage$downloadAsync$2$bytes$1(url, this.$file, this.$progress, contentLengthLong2, null), 2, null);
        }
    }

    @Override // com.sputnik.common.localization.ILocalizationStorage
    public Object downloadAsync(String str, File file, Function2<? super Long, ? super Long, Unit> function2, Continuation<? super Deferred<Long>> continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(str, file, function2, null), continuation);
    }

    private final void deleteOldLocalization(String locale) {
        File file = new File(this.context.getFilesDir(), "localization_file_" + locale);
        if (file.exists()) {
            file.delete();
        }
    }

    public LocalizationLocalModel readData(File localizationFile) {
        Intrinsics.checkNotNullParameter(localizationFile, "localizationFile");
        if (!localizationFile.exists()) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(localizationFile), Charsets.UTF_8), 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            try {
                this._data = (LocalizationLocalModel) new Gson().fromJson(text, new TypeToken<LocalizationLocalModel>() { // from class: com.sputnik.common.localization.LocalizationStorage$readData$listType$1
                }.getType());
            } catch (Exception e) {
                Log.e("read error", String.valueOf(e.getMessage()));
            }
            return this._data;
        } finally {
        }
    }
}
