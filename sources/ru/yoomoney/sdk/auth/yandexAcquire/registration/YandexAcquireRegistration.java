package ru.yoomoney.sdk.auth.yandexAcquire.registration;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration;", "", "()V", "Action", "BusinessLogic", "CommandProcessor", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireRegistration {
    public static final YandexAcquireRegistration INSTANCE = new YandexAcquireRegistration();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "", "()V", "Confirm", "Fail", "OpenContacts", "OpenEmail", "OpenFaq", "OpenPhone", "RegistrationSuccess", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$Confirm;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$Fail;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenContacts;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenEmail;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenFaq;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenPhone;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$RegistrationSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$Confirm;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Confirm extends Action {
            public static final Confirm INSTANCE = new Confirm();

            private Confirm() {
                super(null);
            }

            public String toString() {
                return "Confirm";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$Fail;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Fail extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fail(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ Fail copy$default(Fail fail, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = fail.failure;
                }
                return fail.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final Fail copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Fail(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fail) && Intrinsics.areEqual(this.failure, ((Fail) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Fail(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenContacts;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenContacts extends Action {
            public static final OpenContacts INSTANCE = new OpenContacts();

            private OpenContacts() {
                super(null);
            }

            public String toString() {
                return "OpenContacts";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenEmail;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenEmail extends Action {
            public static final OpenEmail INSTANCE = new OpenEmail();

            private OpenEmail() {
                super(null);
            }

            public String toString() {
                return "OpenEmail";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenFaq;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenFaq extends Action {
            public static final OpenFaq INSTANCE = new OpenFaq();

            private OpenFaq() {
                super(null);
            }

            public String toString() {
                return "OpenFaq";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$OpenPhone;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenPhone extends Action {
            public static final OpenPhone INSTANCE = new OpenPhone();

            private OpenPhone() {
                super(null);
            }

            public String toString() {
                return "OpenPhone";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action$RegistrationSuccess;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RegistrationSuccess extends Action {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RegistrationSuccess(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ RegistrationSuccess copy$default(RegistrationSuccess registrationSuccess, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = registrationSuccess.process;
                }
                return registrationSuccess.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final RegistrationSuccess copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new RegistrationSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RegistrationSuccess) && Intrinsics.areEqual(this.process, ((RegistrationSuccess) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "RegistrationSuccess(process=" + this.process + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u000024\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0001J9\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H¦\u0002¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$BusinessLogic;", "Lkotlin/Function2;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "invoke", "state", "action", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BusinessLogic extends Function2<State, Action, Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect>> {
        @Override // kotlin.jvm.functions.Function2
        /* synthetic */ Triple<? extends State, ? extends Command<?, ? extends Action>, ? extends Effect> invoke(State state, Action action);

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        Triple<State, Command<?, Action>, Effect> invoke2(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u0005H¦B¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$CommandProcessor;", "", "invoke", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "command", "Lru/yoomoney/sdk/march/Command;", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface CommandProcessor {
        Object invoke(Command<?, ? extends Action> command, Continuation<? super Action> continuation);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "", "()V", "CallPhone", "SendEmail", "ShowContactsDialog", "ShowFAQ", "ShowFailure", "ShowNextStep", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$CallPhone;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$SendEmail;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowContactsDialog;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowFAQ;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$CallPhone;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class CallPhone extends Effect {
            public static final CallPhone INSTANCE = new CallPhone();

            private CallPhone() {
                super(null);
            }

            public String toString() {
                return "CallPhone";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$SendEmail;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class SendEmail extends Effect {
            public static final SendEmail INSTANCE = new SendEmail();

            private SendEmail() {
                super(null);
            }

            public String toString() {
                return "SendEmail";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowContactsDialog;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowContactsDialog extends Effect {
            public static final ShowContactsDialog INSTANCE = new ShowContactsDialog();

            private ShowContactsDialog() {
                super(null);
            }

            public String toString() {
                return "ShowContactsDialog";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowFAQ;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowFAQ extends Effect {
            public static final ShowFAQ INSTANCE = new ShowFAQ();

            private ShowFAQ() {
                super(null);
            }

            public String toString() {
                return "ShowFAQ";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowFailure copy$default(ShowFailure showFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showFailure.failure;
                }
                return showFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowFailure) && Intrinsics.areEqual(this.failure, ((ShowFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "(Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final RegistrationProcess process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(RegistrationProcess process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, RegistrationProcess registrationProcess, int i, Object obj) {
                if ((i & 1) != 0) {
                    registrationProcess = showNextStep.process;
                }
                return showNextStep.copy(registrationProcess);
            }

            /* renamed from: component1, reason: from getter */
            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public final ShowNextStep copy(RegistrationProcess process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.process, ((ShowNextStep) other).process);
            }

            public final RegistrationProcess getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextStep(process=" + this.process + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;", "", "()V", "Content", "Progress", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State$Content;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State$Content;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Content extends State {
            public static final Content INSTANCE = new Content();

            private Content() {
                super(null);
            }

            public String toString() {
                return "Content";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State$Progress;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Progress extends State {
            public static final Progress INSTANCE = new Progress();

            private Progress() {
                super(null);
            }

            public String toString() {
                return "Progress";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private YandexAcquireRegistration() {
    }
}
