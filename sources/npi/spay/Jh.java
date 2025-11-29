package npi.spay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.HelperScenario;
import spay.sdk.domain.model.PayPartsStatus;
import spay.sdk.domain.model.request.CreateOtpSdkRequestBody;
import spay.sdk.domain.model.response.ErrorEntity;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Jh implements InterfaceC1495bg {
    public final Ei a;
    public final Ih b;
    public final C1955u3 c;
    public Vn d;

    public Jh(Ei sPayStorage, Ih sPayDataContract, C1955u3 metricFacade) {
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        this.a = sPayStorage;
        this.b = sPayDataContract;
        this.c = metricFacade;
    }

    public final void a(AbstractC1687j9 abstractC1687j9, long j) {
        AbstractC1855q2 c1656i2;
        boolean z = true;
        if ((abstractC1687j9 instanceof V8) || (abstractC1687j9 instanceof W8)) {
            c1656i2 = new C1656i2(abstractC1687j9, j);
        } else if ((abstractC1687j9 instanceof Y8) || (abstractC1687j9 instanceof Z8)) {
            c1656i2 = new S1("Системная или внутренняя ошибка");
        } else if ((abstractC1687j9 instanceof C1463a9) || (abstractC1687j9 instanceof C1488b9)) {
            c1656i2 = new C1656i2(abstractC1687j9, j);
        } else if ((abstractC1687j9 instanceof C1513c9) || (abstractC1687j9 instanceof C1538d9)) {
            c1656i2 = new S1("Системная или внутренняя ошибка");
        } else {
            if (abstractC1687j9 instanceof C1563e9) {
                c1656i2 = new C1656i2(abstractC1687j9, j);
            } else if ((abstractC1687j9 instanceof C1588f9) || (abstractC1687j9 instanceof C1613g9) || (abstractC1687j9 instanceof C1638h9) || (abstractC1687j9 instanceof C1663i9)) {
                c1656i2 = new S1("Системная или внутренняя ошибка");
            } else {
                if (!(abstractC1687j9 instanceof X8)) {
                    throw new NoWhenBranchMatchedException();
                }
                c1656i2 = new C1656i2(abstractC1687j9, j);
            }
            z = false;
        }
        C1822oj c1822oj = (C1822oj) this.a;
        C1604g0 income = C1604g0.a((C1604g0) c1822oj.b.getValue(), c1656i2, null, z, 2);
        Intrinsics.checkNotNullParameter(income, "income");
        c1822oj.a.setValue(income);
    }

    public final void a(co action) {
        Ei ei;
        AbstractC1855q2 abstractC1855q2;
        C1822oj c1822oj;
        C1604g0 income;
        Ei ei2;
        AbstractC1855q2 abstractC1855q22;
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        W1 w1;
        W1 w12;
        boolean zBooleanValue;
        AbstractC1855q2 c1606g2;
        Boolean bool;
        ListOfCardsResponseBody.PaymentToolInfo.Tool tool;
        Ei ei3;
        AbstractC1855q2 abstractC1855q23;
        Ei ei4;
        AbstractC1855q2 e1;
        AbstractC1855q2 p1;
        AbstractC1855q2 k1;
        C1822oj c1822oj2;
        C1604g0 c1604g0A;
        C1805o2 c1805o2;
        Ei ei5;
        C1705k2 c1705k2;
        Intrinsics.checkNotNullParameter(action, "action");
        Timber.Companion companion = Timber.INSTANCE;
        companion.tag("SPaySdkReducer").d("handling intent: " + action, new Object[0]);
        if (action instanceof ao) {
            ((C1822oj) this.a).a(U1.a);
            return;
        }
        if (action instanceof C2100zn) {
            c1822oj = (C1822oj) this.a;
            C2100zn c2100zn = (C2100zn) action;
            income = C1604g0.a((C1604g0) c1822oj.b.getValue(), new C1730l2(c2100zn.a, c2100zn.b), null, false, 2);
        } else {
            if (!(action instanceof C2050xn)) {
                if (action instanceof C1950tn) {
                    ei = this.a;
                    abstractC1855q2 = C1680j2.a;
                } else if (action instanceof C2000vn) {
                    ei5 = this.a;
                    C2000vn c2000vn = (C2000vn) action;
                    c2000vn.getClass();
                    c1705k2 = new C1705k2(C1775mm.a, c2000vn.a, false, 4);
                } else if (action instanceof C1975un) {
                    ei = this.a;
                    abstractC1855q2 = L1.a;
                } else {
                    if (action instanceof Pn) {
                        Ae ae = ((Pn) action).a;
                        if (ae instanceof C2091ze) {
                            c1805o2 = new C1805o2(new C2091ze(((C2091ze) ae).a));
                        } else {
                            if (ae instanceof C2041xe) {
                                StringBuilder sb = new StringBuilder("SPAY API ERROR : ");
                                C2041xe c2041xe = (C2041xe) ae;
                                sb.append(c2041xe.a);
                                companion.e(sb.toString(), new Object[0]);
                                c1805o2 = new C1805o2(new C2041xe(c2041xe.a));
                            } else {
                                if (!(ae instanceof C2066ye)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                c1805o2 = new C1805o2(new C2066ye(((C2066ye) ae).a));
                            }
                            z = true;
                        }
                        c1822oj2 = (C1822oj) this.a;
                        c1604g0A = C1604g0.a((C1604g0) c1822oj2.b.getValue(), c1805o2, null, z, 2);
                    } else if (action instanceof Mn) {
                        AbstractC1855q2 abstractC1855q24 = ((Mn) action).a;
                        if (!(abstractC1855q24 instanceof S1) && !(abstractC1855q24 instanceof C1581f2) && !(abstractC1855q24 instanceof V1) && !(abstractC1855q24 instanceof K1) && !(abstractC1855q24 instanceof C1755m2)) {
                            return;
                        }
                        c1822oj = (C1822oj) this.a;
                        income = C1604g0.a((C1604g0) c1822oj.b.getValue(), abstractC1855q24, null, true, 2);
                    } else {
                        if (action instanceof C1900rn) {
                            ((C1822oj) this.a).a(new C1531d2(((C1900rn) action).a));
                            return;
                        }
                        if (action instanceof On) {
                            Z6 z6 = ((On) action).a;
                            companion.i("PAY RESULT RESPONSE : " + z6, new Object[0]);
                            if (z6 instanceof W6) {
                                k1 = new K1(((W6) z6).a);
                                z = true;
                            } else if (z6 instanceof X6) {
                                k1 = M1.a;
                            } else {
                                if (!(z6 instanceof Y6)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                k1 = O1.a;
                            }
                            c1822oj2 = (C1822oj) this.a;
                            c1604g0A = C1604g0.a((C1604g0) c1822oj2.b.getValue(), k1, null, z, 2);
                        } else {
                            if (!(action instanceof Kn)) {
                                if (action instanceof C2075yn) {
                                    ei4 = this.a;
                                    e1 = new F1(((C2075yn) action).a);
                                } else if (action instanceof An) {
                                    ei4 = this.a;
                                    e1 = new H1(((An) action).a);
                                } else if (action instanceof Rn) {
                                    ei4 = this.a;
                                    e1 = new E1(((Rn) action).a);
                                } else {
                                    if (action instanceof En) {
                                        En en = (En) action;
                                        a(en.a, en.b);
                                        return;
                                    }
                                    if (action instanceof Cn) {
                                        c1822oj = (C1822oj) this.a;
                                        income = C1604g0.a((C1604g0) c1822oj.b.getValue(), new G1(((Cn) action).a), null, true, 2);
                                    } else {
                                        if (action instanceof Fn) {
                                            ei3 = this.a;
                                            abstractC1855q23 = T1.a;
                                        } else if (action instanceof Ln) {
                                            ei3 = this.a;
                                            abstractC1855q23 = Z1.a;
                                        } else if (action instanceof Zn) {
                                            c1822oj = (C1822oj) this.a;
                                            income = C1604g0.a((C1604g0) c1822oj.b.getValue(), new S1("Не удалось пройти аутентификацию"), null, true, 2);
                                        } else if (action instanceof Gn) {
                                            c1822oj = (C1822oj) this.a;
                                            income = C1604g0.a((C1604g0) c1822oj.b.getValue(), new I1(((Gn) action).a), null, true, 2);
                                        } else {
                                            if (action instanceof In) {
                                                a(((In) action).a, 45000L);
                                                return;
                                            }
                                            if (action instanceof Un) {
                                                ((Un) action).a.invoke();
                                                return;
                                            }
                                            if (action instanceof Tn) {
                                                ((Tn) action).a.invoke();
                                                return;
                                            }
                                            if (action instanceof Vn) {
                                                Vn vn = (Vn) action;
                                                Boolean bool2 = vn.c;
                                                if (bool2 != null && (bool = vn.a) != null && (tool = vn.b) != null) {
                                                    this.d = new Vn(bool, tool, bool2);
                                                }
                                                Ei ei6 = this.a;
                                                Boolean bool3 = vn.a;
                                                if (bool3 == null) {
                                                    Vn vn2 = this.d;
                                                    bool3 = vn2 != null ? vn2.a : null;
                                                    Intrinsics.checkNotNull(bool3);
                                                }
                                                boolean zBooleanValue2 = bool3.booleanValue();
                                                ListOfCardsResponseBody.PaymentToolInfo.Tool tool2 = vn.b;
                                                if (tool2 == null) {
                                                    Vn vn3 = this.d;
                                                    tool2 = vn3 != null ? vn3.b : null;
                                                    Intrinsics.checkNotNull(tool2);
                                                }
                                                Boolean bool4 = vn.c;
                                                if (bool4 != null) {
                                                    zBooleanValue = bool4.booleanValue();
                                                } else {
                                                    Vn vn4 = this.d;
                                                    Boolean bool5 = vn4 != null ? vn4.c : null;
                                                    Intrinsics.checkNotNull(bool5);
                                                    zBooleanValue = bool5.booleanValue();
                                                }
                                                if (zBooleanValue2) {
                                                    if (((Di) this.b).p) {
                                                        ErrorEntity.DoubleOtpCall sPayApiError = ErrorEntity.DoubleOtpCall.INSTANCE;
                                                        Intrinsics.checkNotNullParameter(sPayApiError, "sPayApiError");
                                                    }
                                                    Di di = (Di) this.b;
                                                    di.p = true;
                                                    MerchantDataWithOrderId merchantDataWithOrderId = di.i;
                                                    Intrinsics.checkNotNull(merchantDataWithOrderId);
                                                    c1606g2 = new C1830p2(new Xd(((Di) this.b).p(), new CreateOtpSdkRequestBody(merchantDataWithOrderId.getOrderId(), ((Di) this.b).e(), tool2.getPaymentId())), new Sg(this, tool2, zBooleanValue));
                                                } else {
                                                    PayPartsStatus payPartsStatus = ((Di) this.b).y;
                                                    if (payPartsStatus != PayPartsStatus.ONLY_PARTS_PAY && payPartsStatus != PayPartsStatus.PARTS_START_PAY) {
                                                        c1606g2 = new C1631h2(tool2, zBooleanValue);
                                                    } else {
                                                        c1606g2 = new C1606g2(tool2, zBooleanValue);
                                                    }
                                                }
                                                ((C1822oj) ei6).a(c1606g2);
                                                return;
                                            }
                                            if (action instanceof C1925sn) {
                                                ((C1822oj) this.a).a(new C1531d2(new Y5(new C2097zk(R$string.spay_empty_string, CollectionsKt.emptyList()))));
                                                c1822oj = (C1822oj) this.a;
                                                C1604g0 c1604g0 = (C1604g0) c1822oj.b.getValue();
                                                C1925sn c1925sn = (C1925sn) action;
                                                InterfaceC1850pm interfaceC1850pm = c1925sn.a;
                                                Eg eg = c1925sn.b;
                                                income = C1604g0.a(c1604g0, new D1(interfaceC1850pm, eg, eg != null), null, false, 2);
                                            } else if (action instanceof Jn) {
                                                c1822oj = (C1822oj) this.a;
                                                income = C1604g0.a((C1604g0) c1822oj.b.getValue(), new S1("Системная или внутренняя ошибка"), null, true, 2);
                                            } else {
                                                if (action instanceof Bn) {
                                                    ((C1822oj) this.a).a(new C1481b2(((Bn) action).a));
                                                    return;
                                                }
                                                if (action instanceof Yn) {
                                                    c1822oj = (C1822oj) this.a;
                                                    income = C1604g0.a((C1604g0) c1822oj.b.getValue(), R1.a, null, true, 2);
                                                } else {
                                                    if (!(action instanceof Nn)) {
                                                        if (action instanceof Qn) {
                                                            Qn qn = (Qn) action;
                                                            if (qn.a instanceof Ia) {
                                                                c1955u3 = this.c;
                                                                c1560e6 = new C1560e6(EnumC1875qm.RS_FAIL_REVOKE_TOKEN_SDK, EnumC1877r0.PROFILE_VIEW, C0.RS_GOOD, null, null, null, null, 120);
                                                            } else {
                                                                c1955u3 = this.c;
                                                                c1560e6 = new C1560e6(EnumC1875qm.RS_GOOD_REVOKE_TOKEN_SDK, EnumC1877r0.PROFILE_VIEW, C0.RS_GOOD, null, null, null, null, 120);
                                                            }
                                                            c1955u3.a(c1560e6);
                                                            qn.a.a().invoke();
                                                            return;
                                                        }
                                                        if (Intrinsics.areEqual(action, Sn.a)) {
                                                            ei2 = this.a;
                                                            abstractC1855q22 = C1780n2.a;
                                                        } else if (action instanceof Hn) {
                                                            ei2 = this.a;
                                                            abstractC1855q22 = X1.a;
                                                        } else if (action instanceof Wn) {
                                                            c1822oj = (C1822oj) this.a;
                                                            C1604g0 c1604g02 = (C1604g0) c1822oj.b.getValue();
                                                            ((Wn) action).getClass();
                                                            income = C1604g0.a(c1604g02, null, null, false, 3);
                                                        } else {
                                                            if (action instanceof bo) {
                                                                ((C1822oj) this.a).a(new Y1(((bo) action).a));
                                                                return;
                                                            }
                                                            if (action instanceof Dn) {
                                                                ((Di) this.b).z = HelperScenario.BNPL;
                                                                ei = this.a;
                                                                abstractC1855q2 = C1680j2.a;
                                                            } else {
                                                                if (action instanceof C2025wn) {
                                                                    ((C1822oj) this.a).a(C1.a);
                                                                    return;
                                                                }
                                                                if (action instanceof Xn) {
                                                                    Ih ih = this.b;
                                                                    String id = ((Xn) action).a;
                                                                    Di di2 = (Di) ih;
                                                                    di2.getClass();
                                                                    Intrinsics.checkNotNullParameter(id, "id");
                                                                    di2.B.setValue(id);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        ((C1822oj) ei2).a(abstractC1855q22);
                                                        return;
                                                    }
                                                    Zi zi = ((Nn) action).a;
                                                    if (zi instanceof Wi) {
                                                        w12 = new W1(J8.b);
                                                    } else {
                                                        if (zi instanceof Xi) {
                                                            w1 = new W1(new K8(((Xi) zi).a));
                                                        } else if (zi instanceof Yi) {
                                                            w1 = new W1(new L8(((Yi) zi).a));
                                                        } else if (zi instanceof Vi) {
                                                            w1 = new W1(new H8(((Vi) zi).a));
                                                        } else {
                                                            if (!(zi instanceof Ui)) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            w1 = new W1(new I8(((Ui) zi).a));
                                                        }
                                                        w12 = w1;
                                                    }
                                                    c1822oj = (C1822oj) this.a;
                                                    C1604g0 c1604g03 = (C1604g0) c1822oj.b.getValue();
                                                    M8 m8 = w12.a;
                                                    income = C1604g0.a(c1604g03, w12, null, (m8 instanceof I8) || (m8 instanceof H8), 2);
                                                }
                                            }
                                        }
                                        ((C1822oj) ei3).a(abstractC1855q23);
                                        return;
                                    }
                                }
                                ((C1822oj) ei4).a(e1);
                                return;
                            }
                            AbstractC1727l abstractC1727l = ((Kn) action).a;
                            if (abstractC1727l instanceof C1677j) {
                                p1 = N1.a;
                            } else {
                                if (!(abstractC1727l instanceof C1702k)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                p1 = new P1(((C1702k) abstractC1727l).a);
                                z = true;
                            }
                            c1822oj = (C1822oj) this.a;
                            income = C1604g0.a((C1604g0) c1822oj.b.getValue(), p1, null, z, 2);
                        }
                    }
                    C1604g0 c1604g04 = c1604g0A;
                    c1822oj = c1822oj2;
                    income = c1604g04;
                }
                ((C1822oj) ei).a(abstractC1855q2);
                return;
            }
            ei5 = this.a;
            C2050xn c2050xn = (C2050xn) action;
            c1705k2 = new C1705k2(c2050xn.a, null, c2050xn.b, 2);
            ((C1822oj) ei5).a(c1705k2);
            return;
        }
        Intrinsics.checkNotNullParameter(income, "income");
        c1822oj.a.setValue(income);
    }
}
