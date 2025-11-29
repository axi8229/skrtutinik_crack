package com.axmor.axvoip.mojo.core.sip;

import android.util.Log;
import com.axmor.ash.toolset.service.CompositeContext;
import com.axmor.ash.toolset.utils.AshAssert;
import com.axmor.ash.toolset.utils.Lambda$FactoryCode1;
import com.axmor.ash.toolset.utils.StreamCompat;
import com.axmor.axvoip.mojo.core.sip.AccountSession;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccount;
import com.axmor.axvoip.mojo.pjm.facade.PjmAccountRegConfig;
import com.axmor.axvoip.mojo.pjm.facade.PjmCall;
import com.axmor.axvoip.mojo.pjm.facade.PjmCallHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.NonNull;
import org.pjsip.pjsua2.AccountConfig;

/* loaded from: classes.dex */
final class AccountSessionManager implements AccountSession {

    @NonNull
    private final PjmAccount account;

    @NonNull
    private final CompositeContext context;
    private final Object $lock = new Object[0];
    private final HashMap<Integer, CallSessionManager> callsMap = new HashMap<>();
    private final CopyOnWriteArrayList<CallSessionManager> callsList = new CopyOnWriteArrayList<>();
    private final PjmAccount.AccountListener accountListener = new PjmAccount.AccountListener() { // from class: com.axmor.axvoip.mojo.core.sip.AccountSessionManager.1
        @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount.AccountListener
        public void onIncomingCall(PjmCall pjmCall) {
            Log.d("qeqweq", "onIncomingCall::");
            AccountSessionManager.this.createCall(pjmCall);
        }

        @Override // com.axmor.axvoip.mojo.pjm.facade.PjmAccount.AccountListener
        public void onCallCompleted(PjmCall pjmCall) {
            Log.d("qeqweq", "onCallCompleted::");
            AccountSessionManager.this.destroyCall(pjmCall.getCallId());
        }
    };

    public AccountSessionManager(@NonNull CompositeContext compositeContext, @NonNull PjmAccount pjmAccount) {
        if (compositeContext == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (pjmAccount == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        this.context = compositeContext;
        this.account = pjmAccount;
    }

    private boolean isAlive() {
        boolean zIsAlive;
        synchronized (this.$lock) {
            zIsAlive = this.account.isAlive();
        }
        return zIsAlive;
    }

    final void register(@NonNull AccountConfig accountConfig, @NonNull PjmAccount.RegistrationListener registrationListener) {
        synchronized (this.$lock) {
            try {
                if (accountConfig == null) {
                    throw new NullPointerException("accountConfig is marked non-null but is null");
                }
                if (registrationListener == null) {
                    throw new NullPointerException("registrationListener is marked non-null but is null");
                }
                AshAssert.aTrue(isAlive());
                this.account.register(new PjmAccountRegConfig(accountConfig, registrationListener, this.accountListener));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void destroy() {
        synchronized (this.$lock) {
            this.account.shutdown();
        }
    }

    @Override // com.axmor.axvoip.mojo.core.sip.AccountSession
    public final CallSession getCallSession(@NonNull PjmCallHandle pjmCallHandle) {
        CallSessionManager callSessionManager;
        synchronized (this.$lock) {
            try {
                if (pjmCallHandle == null) {
                    throw new NullPointerException("handle is marked non-null but is null");
                }
                callSessionManager = this.callsMap.get(Integer.valueOf(pjmCallHandle.getCallId()));
            } catch (Throwable th) {
                throw th;
            }
        }
        return callSessionManager;
    }

    @Override // com.axmor.axvoip.mojo.core.sip.AccountSession
    public final List<PjmCallHandle> getActiveCalls() {
        ArrayList<PjmCallHandle> arrayListBuildHandles;
        synchronized (this.$lock) {
            AshAssert.aTrue(isAlive());
            arrayListBuildHandles = buildHandles();
        }
        return arrayListBuildHandles;
    }

    private ArrayList<PjmCallHandle> buildHandles() {
        ArrayList list = StreamCompat.toList(StreamCompat.select(this.callsList, new Lambda$FactoryCode1() { // from class: com.axmor.axvoip.mojo.core.sip.AccountSessionManager$$ExternalSyntheticLambda0
            @Override // com.axmor.ash.toolset.utils.Lambda$FactoryCode1
            public final Object produce(Object obj) {
                return ((CallSessionManager) obj).getHandle();
            }
        }));
        Collections.sort(list, new Comparator() { // from class: com.axmor.axvoip.mojo.core.sip.AccountSessionManager$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AccountSessionManager.lambda$buildHandles$0((PjmCallHandle) obj, (PjmCallHandle) obj2);
            }
        });
        ArrayList<PjmCallHandle> arrayList = new ArrayList<>(list.size());
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            PjmCallHandle pjmCallHandle = (PjmCallHandle) it.next();
            if (pjmCallHandle.isAlive()) {
                arrayList.add(i, pjmCallHandle);
                i++;
            } else {
                arrayList.add(pjmCallHandle);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$buildHandles$0(PjmCallHandle pjmCallHandle, PjmCallHandle pjmCallHandle2) {
        long timestamp = pjmCallHandle.getTimestamp();
        long timestamp2 = pjmCallHandle2.getTimestamp();
        if (timestamp > timestamp2) {
            return -1;
        }
        return timestamp < timestamp2 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCall(@NonNull PjmCall pjmCall) {
        synchronized (this.$lock) {
            try {
                if (pjmCall == null) {
                    throw new NullPointerException("call is marked non-null but is null");
                }
                AshAssert.aTrue(pjmCall.getCallId() >= 0);
                AshAssert.aFalse(this.callsMap.containsKey(Integer.valueOf(pjmCall.getCallId())));
                if (this.callsMap.containsKey(Integer.valueOf(pjmCall.getCallId()))) {
                    destroyCall(pjmCall.getCallId());
                }
                CallSessionManager callSessionManager = new CallSessionManager(this.context, pjmCall);
                this.callsList.add(callSessionManager);
                this.callsMap.put(Integer.valueOf(pjmCall.getCallId()), callSessionManager);
                this.context.eventBus().post(new AccountSession.CallCreatedEvent(pjmCall.getHandle()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyCall(int i) {
        synchronized (this.$lock) {
            try {
                CallSessionManager callSessionManagerRemove = this.callsMap.remove(Integer.valueOf(i));
                AshAssert.aNonNull(callSessionManagerRemove);
                if (callSessionManagerRemove == null) {
                    return;
                }
                this.callsList.remove(callSessionManagerRemove);
                callSessionManagerRemove.destroy();
                this.context.eventBus().post(new AccountSession.CallCompletedEvent(callSessionManagerRemove.getHandle()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
