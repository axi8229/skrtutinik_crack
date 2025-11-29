package ru.yoomoney.sdk.march;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* compiled from: Code.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0099\u0006\u0010!\u001a\u00020\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\u00020\u00042&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00052N\u0010\n\u001aJ\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\bj\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002`\t2,\u0010\f\u001a(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b2©\u0001\u0010\u0011\u001a¤\u0001\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\u000f\u0012\u0004\u0012\u00028\u0000\u0012L\u0012J\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\bj\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002`\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r2x\u0010\u0013\u001at\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012*\u0012(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r2\u0085\u0001\u0010\u0017\u001a\u0080\u0001\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182,\u0010\u001a\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\u00182\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"\u001aó\u0006\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020(\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010$\u001a\u00020#2&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00052N\u0010\n\u001aJ\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\bj\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002`\t2,\u0010\f\u001a(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b2\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u00100\b2«\u0001\b\u0002\u0010\u0011\u001a¤\u0001\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\u000f\u0012\u0004\u0012\u00028\u0000\u0012L\u0012J\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\bj\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002`\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r2z\b\u0002\u0010\u0013\u001at\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012*\u0012(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r2\u0087\u0001\b\u0002\u0010\u0017\u001a\u0080\u0001\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00142\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182.\b\u0002\u0010\u001a\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\u00182\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u00182\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u0015¢\u0006\u0004\b)\u0010*\u001aå\u0002\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020(\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010$\u001a\u00020#20\u0010\u0007\u001a,\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,0\u00162R\u0010.\u001aN\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020+\u00122\u00120\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,0\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`-0\u00162\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u00100\b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u00162\b\b\u0002\u00100\u001a\u00020/2\u001a\b\u0002\u00101\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020+¢\u0006\u0004\b)\u00102\u001aÃ\u0001\u00104\u001a\u000203\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010$\u001a\u00020#2&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u000528\u0010\n\u001a4\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00050\b2,\u0010\f\u001a(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b¢\u0006\u0004\b4\u00105\u001a9\u0010:\u001a\u00020\u0010\"\u0004\b\u0000\u00106*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u00108\u001a\u0002072\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0004\b:\u0010;\u001a\u0085\u0001\u0010:\u001a\u00020\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020(2\u0006\u00108\u001a\u0002072\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u00162\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00100\u00162\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0004\b:\u0010?¨\u0006@"}, d2 = {"", "STATE", "ACTION", "EFFECT", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "initial", "Lkotlin/Function2;", "Lru/yoomoney/sdk/march/BusinessLogic;", "businessLogic", "Lkotlin/coroutines/Continuation;", "commandProcessor", "Lkotlin/Function5;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "", "businessLogicExecutionStrategy", "", "commandProcessorExecutionStrategy", "Lkotlin/Function6;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/Function1;", "businessLogicResultDeliveryStrategy", "Lkotlinx/coroutines/channels/Channel;", "actions", "businessLogicOutput", "commands", "effects", "exceptions", "sendState", "businessLogicDispatcher", "commandExecutorDispatcher", "launchRuntime", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/Triple;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function6;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "", "featureName", "log", "Landroidx/lifecycle/MutableLiveData;", "states", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "RuntimeViewModel", "(Ljava/lang/String;Lkotlin/Triple;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function6;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Landroidx/lifecycle/MutableLiveData;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/march/RuntimeViewModelDependencies;", "Lru/yoomoney/sdk/march/Out;", "Lru/yoomoney/sdk/march/Logic;", "logic", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "mainCoroutineDispatcher", "runtimeViewModelDependencies", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/channels/Channel;Landroidx/lifecycle/MutableLiveData;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/MainCoroutineDispatcher;Lru/yoomoney/sdk/march/RuntimeViewModelDependencies;)Lru/yoomoney/sdk/march/RuntimeViewModel;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "RuntimeViewModelFactory", "(Ljava/lang/String;Lkotlin/Triple;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/ViewModelProvider$Factory;", "E", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "onElement", "observe", "(Lkotlinx/coroutines/channels/ReceiveChannel;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "onState", "onEffect", "onFail", "(Lru/yoomoney/sdk/march/RuntimeViewModel;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "march_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeKt {

    /* compiled from: Code.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "ACTION", "EFFECT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CodeKt$launchRuntime$1", f = "Code.kt", l = {77}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$launchRuntime$1, reason: invalid class name and case insensitive filesystem */
    static final class C25591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<ACTION> $actions;
        final /* synthetic */ Function2<STATE, ACTION, Triple<STATE, Command<?, ACTION>, EFFECT>> $businessLogic;
        final /* synthetic */ Function5<ReceiveChannel<? extends ACTION>, SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, STATE, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Continuation<? super Unit>, Object> $businessLogicExecutionStrategy;
        final /* synthetic */ Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> $businessLogicOutput;
        final /* synthetic */ Triple<STATE, Command<?, ACTION>, EFFECT> $initial;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25591(Function5<? super ReceiveChannel<? extends ACTION>, ? super SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super STATE, ? super Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super Continuation<? super Unit>, ? extends Object> function5, Channel<ACTION> channel, Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> channel2, Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT> triple, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> function2, Continuation<? super C25591> continuation) {
            super(2, continuation);
            this.$businessLogicExecutionStrategy = function5;
            this.$actions = channel;
            this.$businessLogicOutput = channel2;
            this.$initial = triple;
            this.$businessLogic = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25591(this.$businessLogicExecutionStrategy, this.$actions, this.$businessLogicOutput, this.$initial, this.$businessLogic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function5<ReceiveChannel<? extends ACTION>, SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, STATE, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Continuation<? super Unit>, Object> function5 = this.$businessLogicExecutionStrategy;
                ReceiveChannel receiveChannel = this.$actions;
                ReceiveChannel receiveChannel2 = this.$businessLogicOutput;
                Object first = this.$initial.getFirst();
                Function function = this.$businessLogic;
                this.label = 1;
                if (function5.invoke(receiveChannel, receiveChannel2, first, function, this) == coroutine_suspended) {
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

    public static final <STATE, ACTION, EFFECT> void launchRuntime(CoroutineScope coroutineScope, Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT> initial, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> businessLogic, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object> commandProcessor, Function5<? super ReceiveChannel<? extends ACTION>, ? super SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super STATE, ? super Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super Continuation<? super Unit>, ? extends Object> businessLogicExecutionStrategy, Function5<? super ReceiveChannel<? extends Command<?, ? extends ACTION>>, ? super SendChannel<? super ACTION>, ? super SendChannel<? super Throwable>, ? super Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> commandProcessorExecutionStrategy, Function6<? super CoroutineDispatcher, ? super ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super Function1<? super STATE, Unit>, ? super SendChannel<? super EFFECT>, ? super SendChannel<? super Command<?, ? extends ACTION>>, ? super Continuation<? super Unit>, ? extends Object> businessLogicResultDeliveryStrategy, Channel<ACTION> actions, Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> businessLogicOutput, Channel<Command<?, ACTION>> commands, Channel<EFFECT> effects, Channel<Throwable> exceptions, Function1<? super STATE, Unit> sendState, CoroutineDispatcher businessLogicDispatcher, CoroutineDispatcher commandExecutorDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        Intrinsics.checkNotNullParameter(commandProcessor, "commandProcessor");
        Intrinsics.checkNotNullParameter(businessLogicExecutionStrategy, "businessLogicExecutionStrategy");
        Intrinsics.checkNotNullParameter(commandProcessorExecutionStrategy, "commandProcessorExecutionStrategy");
        Intrinsics.checkNotNullParameter(businessLogicResultDeliveryStrategy, "businessLogicResultDeliveryStrategy");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(businessLogicOutput, "businessLogicOutput");
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(effects, "effects");
        Intrinsics.checkNotNullParameter(exceptions, "exceptions");
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(businessLogicDispatcher, "businessLogicDispatcher");
        Intrinsics.checkNotNullParameter(commandExecutorDispatcher, "commandExecutorDispatcher");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, businessLogicDispatcher, null, new C25591(businessLogicExecutionStrategy, actions, businessLogicOutput, initial, businessLogic, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, commandExecutorDispatcher, null, new AnonymousClass2(commandProcessorExecutionStrategy, commands, actions, exceptions, commandProcessor, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C25603(businessLogicResultDeliveryStrategy, businessLogicDispatcher, businessLogicOutput, sendState, effects, commands, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C25614(businessLogicOutput, initial, null), 3, null);
    }

    /* compiled from: Code.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "ACTION", "EFFECT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CodeKt$launchRuntime$2", f = "Code.kt", l = {80}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$launchRuntime$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<ACTION> $actions;
        final /* synthetic */ Function2<Command<?, ? extends ACTION>, Continuation<? super ACTION>, Object> $commandProcessor;
        final /* synthetic */ Function5<ReceiveChannel<? extends Command<?, ? extends ACTION>>, SendChannel<? super ACTION>, SendChannel<? super Throwable>, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, Continuation<? super Unit>, Object> $commandProcessorExecutionStrategy;
        final /* synthetic */ Channel<Command<?, ACTION>> $commands;
        final /* synthetic */ Channel<Throwable> $exceptions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function5<? super ReceiveChannel<? extends Command<?, ? extends ACTION>>, ? super SendChannel<? super ACTION>, ? super SendChannel<? super Throwable>, ? super Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> function5, Channel<Command<?, ACTION>> channel, Channel<ACTION> channel2, Channel<Throwable> channel3, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$commandProcessorExecutionStrategy = function5;
            this.$commands = channel;
            this.$actions = channel2;
            this.$exceptions = channel3;
            this.$commandProcessor = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$commandProcessorExecutionStrategy, this.$commands, this.$actions, this.$exceptions, this.$commandProcessor, continuation);
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
                Function5<ReceiveChannel<? extends Command<?, ? extends ACTION>>, SendChannel<? super ACTION>, SendChannel<? super Throwable>, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, Continuation<? super Unit>, Object> function5 = this.$commandProcessorExecutionStrategy;
                ReceiveChannel receiveChannel = this.$commands;
                ReceiveChannel receiveChannel2 = this.$actions;
                SendChannel<? super Throwable> sendChannel = this.$exceptions;
                Function function = this.$commandProcessor;
                this.label = 1;
                if (function5.invoke(receiveChannel, receiveChannel2, sendChannel, function, this) == coroutine_suspended) {
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

    /* compiled from: Code.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "ACTION", "EFFECT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CodeKt$launchRuntime$3", f = "Code.kt", l = {83}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$launchRuntime$3, reason: invalid class name and case insensitive filesystem */
    static final class C25603 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineDispatcher $businessLogicDispatcher;
        final /* synthetic */ Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> $businessLogicOutput;
        final /* synthetic */ Function6<CoroutineDispatcher, ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Function1<? super STATE, Unit>, SendChannel<? super EFFECT>, SendChannel<? super Command<?, ? extends ACTION>>, Continuation<? super Unit>, Object> $businessLogicResultDeliveryStrategy;
        final /* synthetic */ Channel<Command<?, ACTION>> $commands;
        final /* synthetic */ Channel<EFFECT> $effects;
        final /* synthetic */ Function1<STATE, Unit> $sendState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25603(Function6<? super CoroutineDispatcher, ? super ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super Function1<? super STATE, Unit>, ? super SendChannel<? super EFFECT>, ? super SendChannel<? super Command<?, ? extends ACTION>>, ? super Continuation<? super Unit>, ? extends Object> function6, CoroutineDispatcher coroutineDispatcher, Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> channel, Function1<? super STATE, Unit> function1, Channel<EFFECT> channel2, Channel<Command<?, ACTION>> channel3, Continuation<? super C25603> continuation) {
            super(2, continuation);
            this.$businessLogicResultDeliveryStrategy = function6;
            this.$businessLogicDispatcher = coroutineDispatcher;
            this.$businessLogicOutput = channel;
            this.$sendState = function1;
            this.$effects = channel2;
            this.$commands = channel3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25603(this.$businessLogicResultDeliveryStrategy, this.$businessLogicDispatcher, this.$businessLogicOutput, this.$sendState, this.$effects, this.$commands, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25603) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function6<CoroutineDispatcher, ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Function1<? super STATE, Unit>, SendChannel<? super EFFECT>, SendChannel<? super Command<?, ? extends ACTION>>, Continuation<? super Unit>, Object> function6 = this.$businessLogicResultDeliveryStrategy;
                CoroutineDispatcher coroutineDispatcher = this.$businessLogicDispatcher;
                ReceiveChannel receiveChannel = this.$businessLogicOutput;
                Function function = this.$sendState;
                ReceiveChannel receiveChannel2 = this.$effects;
                ReceiveChannel receiveChannel3 = this.$commands;
                this.label = 1;
                if (function6.invoke(coroutineDispatcher, receiveChannel, function, receiveChannel2, receiveChannel3, this) == coroutine_suspended) {
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

    /* compiled from: Code.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "ACTION", "EFFECT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CodeKt$launchRuntime$4", f = "Code.kt", l = {85}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$launchRuntime$4, reason: invalid class name and case insensitive filesystem */
    static final class C25614 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> $businessLogicOutput;
        final /* synthetic */ Triple<STATE, Command<?, ACTION>, EFFECT> $initial;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25614(Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> channel, Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT> triple, Continuation<? super C25614> continuation) {
            super(2, continuation);
            this.$businessLogicOutput = channel;
            this.$initial = triple;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25614(this.$businessLogicOutput, this.$initial, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25614) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendChannel sendChannel = this.$businessLogicOutput;
                Object obj2 = this.$initial;
                this.label = 1;
                if (sendChannel.send(obj2, this) == coroutine_suspended) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RuntimeViewModel RuntimeViewModel$default(String str, Triple triple, Function2 function2, Function2 function22, Function2 function23, Function5 function5, Function5 function52, Function6 function6, Channel channel, Channel channel2, Channel channel3, MutableLiveData mutableLiveData, Channel channel4, Channel channel5, Function1 function1, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, Object obj) {
        Function2 function2Log = (i & 16) != 0 ? Defaults.INSTANCE.log(str) : function23;
        Function5 function5BusinessLogicExecutionStrategy = (i & 32) != 0 ? Defaults.INSTANCE.businessLogicExecutionStrategy() : function5;
        Function5 function5CommandProcessorExecutionStrategy = (i & 64) != 0 ? Defaults.INSTANCE.commandProcessorExecutionStrategy() : function52;
        Function6 function6BusinessLogicResultDeliveryStrategy = (i & 128) != 0 ? Defaults.INSTANCE.businessLogicResultDeliveryStrategy() : function6;
        Channel channelActionsChannel = (i & 256) != 0 ? Defaults.INSTANCE.actionsChannel(function2Log) : channel;
        Channel channelBusinessLogicOutput = (i & 512) != 0 ? Defaults.INSTANCE.businessLogicOutput() : channel2;
        Channel channelCommandsChannel = (i & 1024) != 0 ? Defaults.INSTANCE.commandsChannel(function2Log) : channel3;
        MutableLiveData mutableLiveData2 = (i & 2048) != 0 ? new MutableLiveData() : mutableLiveData;
        return RuntimeViewModel(str, triple, function2, function22, function2Log, function5BusinessLogicExecutionStrategy, function5CommandProcessorExecutionStrategy, function6BusinessLogicResultDeliveryStrategy, channelActionsChannel, channelBusinessLogicOutput, channelCommandsChannel, mutableLiveData2, (i & 4096) != 0 ? Defaults.INSTANCE.effectsChannel(function2Log) : channel4, (i & 8192) != 0 ? Defaults.INSTANCE.exceptionChannel(function2Log) : channel5, (i & 16384) != 0 ? Defaults.INSTANCE.sendState(new AnonymousClass1(mutableLiveData2), function2Log) : function1, (32768 & i) != 0 ? Dispatchers.getDefault() : coroutineDispatcher, (i & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    /* compiled from: Code.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$RuntimeViewModel$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass1(Object obj) {
            super(1, obj, MutableLiveData.class, "setValue", "setValue(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m3499invoke(obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m3499invoke(Object obj) {
            ((MutableLiveData) this.receiver).setValue(obj);
        }
    }

    public static final <STATE, ACTION, EFFECT> RuntimeViewModel<STATE, ACTION, EFFECT> RuntimeViewModel(String featureName, Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT> initial, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> businessLogic, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object> commandProcessor, Function2<? super String, Object, Unit> log, Function5<? super ReceiveChannel<? extends ACTION>, ? super SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super STATE, ? super Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super Continuation<? super Unit>, ? extends Object> businessLogicExecutionStrategy, Function5<? super ReceiveChannel<? extends Command<?, ? extends ACTION>>, ? super SendChannel<? super ACTION>, ? super SendChannel<? super Throwable>, ? super Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> commandProcessorExecutionStrategy, Function6<? super CoroutineDispatcher, ? super ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super Function1<? super STATE, Unit>, ? super SendChannel<? super EFFECT>, ? super SendChannel<? super Command<?, ? extends ACTION>>, ? super Continuation<? super Unit>, ? extends Object> businessLogicResultDeliveryStrategy, Channel<ACTION> actions, Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> businessLogicOutput, Channel<Command<?, ACTION>> commands, MutableLiveData<STATE> states, Channel<EFFECT> effects, Channel<Throwable> exceptions, Function1<? super STATE, Unit> sendState, CoroutineDispatcher businessLogicDispatcher, CoroutineDispatcher commandExecutorDispatcher) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        Intrinsics.checkNotNullParameter(commandProcessor, "commandProcessor");
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(businessLogicExecutionStrategy, "businessLogicExecutionStrategy");
        Intrinsics.checkNotNullParameter(commandProcessorExecutionStrategy, "commandProcessorExecutionStrategy");
        Intrinsics.checkNotNullParameter(businessLogicResultDeliveryStrategy, "businessLogicResultDeliveryStrategy");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(businessLogicOutput, "businessLogicOutput");
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(effects, "effects");
        Intrinsics.checkNotNullParameter(exceptions, "exceptions");
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(businessLogicDispatcher, "businessLogicDispatcher");
        Intrinsics.checkNotNullParameter(commandExecutorDispatcher, "commandExecutorDispatcher");
        RuntimeViewModel<STATE, ACTION, EFFECT> runtimeViewModel = new RuntimeViewModel<>(states, effects, exceptions, actions);
        launchRuntime(ViewModelKt.getViewModelScope(runtimeViewModel), initial, businessLogic, commandProcessor, businessLogicExecutionStrategy, commandProcessorExecutionStrategy, businessLogicResultDeliveryStrategy, actions, businessLogicOutput, commands, effects, exceptions, sendState, businessLogicDispatcher, commandExecutorDispatcher);
        return runtimeViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RuntimeViewModel RuntimeViewModel$default(String str, Function1 function1, Function1 function12, Function2 function2, Channel channel, MutableLiveData mutableLiveData, Channel channel2, Channel channel3, Function1 function13, MainCoroutineDispatcher mainCoroutineDispatcher, RuntimeViewModelDependencies runtimeViewModelDependencies, int i, Object obj) {
        Function2 function2Log = (i & 8) != 0 ? Defaults.INSTANCE.log(str) : function2;
        Channel channelActionsChannel = (i & 16) != 0 ? Defaults.INSTANCE.actionsChannel(function2Log) : channel;
        MutableLiveData mutableLiveData2 = (i & 32) != 0 ? new MutableLiveData() : mutableLiveData;
        Channel channelEffectsChannel = (i & 64) != 0 ? Defaults.INSTANCE.effectsChannel(function2Log) : channel2;
        Channel channelExceptionChannel = (i & 128) != 0 ? Defaults.INSTANCE.exceptionChannel(function2Log) : channel3;
        Function1 function1SendState = (i & 256) != 0 ? Defaults.INSTANCE.sendState(new AnonymousClass3(mutableLiveData2), function2Log) : function13;
        MainCoroutineDispatcher main = (i & 512) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher;
        return RuntimeViewModel(str, function1, function12, function2Log, channelActionsChannel, mutableLiveData2, channelEffectsChannel, channelExceptionChannel, function1SendState, main, (i & 1024) != 0 ? new RuntimeViewModelDependencies(CoreKt.androidShowState(main, function1SendState, channelActionsChannel), CoreKt.showEffect(channelEffectsChannel), new AnonymousClass4(channelActionsChannel, null)) : runtimeViewModelDependencies);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Code.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$RuntimeViewModel$3, reason: invalid class name */
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass3(Object obj) {
            super(1, obj, MutableLiveData.class, "setValue", "setValue(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m3500invoke(obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m3500invoke(Object obj) {
            ((MutableLiveData) this.receiver).setValue(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Code.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0003\"\b\b\u0002\u0010\u0004*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "ACTION", "STATE", "", "EFFECT"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CodeKt$RuntimeViewModel$4", f = "Code.kt", l = {157}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$RuntimeViewModel$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements Function1 {
        final /* synthetic */ Channel $actions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Channel channel, Continuation continuation) {
            super(1, continuation);
            this.$actions = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(this.$actions, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel channel = this.$actions;
                this.label = 1;
                obj = channel.receive(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public static final <STATE, ACTION, EFFECT> RuntimeViewModel<STATE, ACTION, EFFECT> RuntimeViewModel(String featureName, Function1<? super RuntimeViewModelDependencies<STATE, ACTION, EFFECT>, ? extends Out<? extends STATE, ? extends ACTION>> initial, Function1<? super RuntimeViewModelDependencies<STATE, ACTION, EFFECT>, ? extends Function2<? super STATE, ? super ACTION, ? extends Out<? extends STATE, ? extends ACTION>>> logic, Function2<? super String, Object, Unit> log, Channel<ACTION> actions, MutableLiveData<STATE> states, Channel<EFFECT> effects, Channel<Throwable> exceptions, Function1<? super STATE, Unit> sendState, MainCoroutineDispatcher mainCoroutineDispatcher, RuntimeViewModelDependencies<STATE, ACTION, EFFECT> runtimeViewModelDependencies) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(effects, "effects");
        Intrinsics.checkNotNullParameter(exceptions, "exceptions");
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(mainCoroutineDispatcher, "mainCoroutineDispatcher");
        Intrinsics.checkNotNullParameter(runtimeViewModelDependencies, "runtimeViewModelDependencies");
        RuntimeViewModel<STATE, ACTION, EFFECT> runtimeViewModel = new RuntimeViewModel<>(states, effects, exceptions, actions);
        CoreKt.launchRuntime$default(CoroutineScopeKt.plus(ViewModelKt.getViewModelScope(runtimeViewModel), Dispatchers.getDefault()), initial.invoke(runtimeViewModelDependencies), logic.invoke(runtimeViewModelDependencies), actions, null, 8, null);
        return runtimeViewModel;
    }

    public static final <STATE, ACTION, EFFECT> ViewModelProvider.Factory RuntimeViewModelFactory(final String featureName, final Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT> initial, final Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> businessLogic, final Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object> commandProcessor) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        Intrinsics.checkNotNullParameter(commandProcessor, "commandProcessor");
        return new ViewModelProvider.Factory() { // from class: ru.yoomoney.sdk.march.CodeKt.RuntimeViewModelFactory.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> modelClass) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                if (!Intrinsics.areEqual(modelClass, RuntimeViewModel.class)) {
                    throw new IllegalStateException(("Can't create " + modelClass.getName() + ". Only ViewModels of type " + RuntimeViewModel.class.getName() + " can be created").toString());
                }
                RuntimeViewModel runtimeViewModelRuntimeViewModel$default = CodeKt.RuntimeViewModel$default(featureName, initial, businessLogic, commandProcessor, null, null, null, null, null, null, null, null, null, null, null, null, null, 131056, null);
                Intrinsics.checkNotNull(runtimeViewModelRuntimeViewModel$default, "null cannot be cast to non-null type T of ru.yoomoney.sdk.march.CodeKt.RuntimeViewModelFactory.<no name provided>.create");
                return runtimeViewModelRuntimeViewModel$default;
            }
        };
    }

    /* compiled from: Code.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CodeKt$observe$1", f = "Code.kt", l = {245}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CodeKt$observe$1, reason: invalid class name and case insensitive filesystem */
    static final class C25621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<E, Unit> $onElement;
        final /* synthetic */ ReceiveChannel<E> $this_observe;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25621(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super C25621> continuation) {
            super(2, continuation);
            this.$this_observe = receiveChannel;
            this.$onElement = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25621(this.$this_observe, this.$onElement, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r4.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L30
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                kotlinx.coroutines.channels.ReceiveChannel<E> r5 = r4.$this_observe
                kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
                r1 = r5
            L25:
                r4.L$0 = r1
                r4.label = r2
                java.lang.Object r5 = r1.hasNext(r4)
                if (r5 != r0) goto L30
                return r0
            L30:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L42
                java.lang.Object r5 = r1.next()
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r3 = r4.$onElement
                r3.invoke(r5)
                goto L25
            L42:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.march.CodeKt.C25621.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <E> void observe(ReceiveChannel<? extends E> receiveChannel, LifecycleOwner lifecycleOwner, Function1<? super E, Unit> onElement) {
        Intrinsics.checkNotNullParameter(receiveChannel, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(onElement, "onElement");
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenResumed(new C25621(receiveChannel, onElement, null));
    }

    public static final <STATE, ACTION, EFFECT> void observe(RuntimeViewModel<STATE, ACTION, EFFECT> runtimeViewModel, LifecycleOwner lifecycleOwner, final Function1<? super STATE, Unit> onState, Function1<? super EFFECT, Unit> onEffect, Function1<? super Throwable, Unit> onFail) {
        Intrinsics.checkNotNullParameter(runtimeViewModel, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(onState, "onState");
        Intrinsics.checkNotNullParameter(onEffect, "onEffect");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        runtimeViewModel.getStates().observe(lifecycleOwner, new Observer() { // from class: ru.yoomoney.sdk.march.CodeKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CodeKt.observe$lambda$5(onState, obj);
            }
        });
        observe(runtimeViewModel.getEffects(), lifecycleOwner, onEffect);
        observe(runtimeViewModel.getExceptions(), lifecycleOwner, onFail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe$lambda$5(Function1 onState, Object obj) {
        Intrinsics.checkNotNullParameter(onState, "$onState");
        if (obj != null) {
            onState.invoke(obj);
        }
    }
}
