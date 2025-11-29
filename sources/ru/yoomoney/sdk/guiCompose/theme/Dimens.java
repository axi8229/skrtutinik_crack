package ru.yoomoney.sdk.guiCompose.theme;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2Connection;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: Dimens.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bN\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0005\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u0012\b\b\u0002\u0010>\u001a\u00020\u0002\u0012\b\b\u0002\u0010?\u001a\u00020\u0002\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u0012\b\b\u0002\u0010A\u001a\u00020\u0002\u0012\b\b\u0002\u0010B\u001a\u00020\u0002\u0012\b\b\u0002\u0010C\u001a\u00020\u0002\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\b\b\u0002\u0010G\u001a\u00020E\u0012\b\b\u0002\u0010H\u001a\u00020\u0002\u0012\b\b\u0002\u0010I\u001a\u00020\u0002\u0012\b\b\u0002\u0010J\u001a\u00020\u0002\u0012\b\b\u0002\u0010K\u001a\u00020\u0002\u0012\b\b\u0002\u0010L\u001a\u00020\u0002¢\u0006\u0004\bM\u0010NJ\u0010\u0010P\u001a\u00020OHÖ\u0001¢\u0006\u0004\bP\u0010QJ\u0010\u0010S\u001a\u00020RHÖ\u0001¢\u0006\u0004\bS\u0010TJ\u001a\u0010W\u001a\u00020V2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bW\u0010XR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010Y\u001a\u0004\bZ\u0010[R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010Y\u001a\u0004\b\\\u0010[R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010Y\u001a\u0004\b]\u0010[R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010Y\u001a\u0004\b^\u0010[R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010Y\u001a\u0004\b_\u0010[R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010Y\u001a\u0004\b`\u0010[R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010Y\u001a\u0004\ba\u0010[R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010Y\u001a\u0004\bb\u0010[R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010Y\u001a\u0004\bc\u0010[R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010Y\u001a\u0004\bd\u0010[R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010Y\u001a\u0004\be\u0010[R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010Y\u001a\u0004\bf\u0010[R\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010Y\u001a\u0004\bg\u0010[R\u001d\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010Y\u001a\u0004\bh\u0010[R\u001d\u0010\u0011\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010Y\u001a\u0004\bi\u0010[R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010Y\u001a\u0004\bj\u0010[R\u001d\u0010\u0013\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010Y\u001a\u0004\bk\u0010[R\u001d\u0010\u0014\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0014\u0010Y\u001a\u0004\bl\u0010[R\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u0010Y\u001a\u0004\bm\u0010[R\u001d\u0010\u0016\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u0010Y\u001a\u0004\bn\u0010[R\u001d\u0010\u0017\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u0010Y\u001a\u0004\bo\u0010[R\u001d\u0010\u0018\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010Y\u001a\u0004\bp\u0010[R\u001d\u0010\u0019\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010Y\u001a\u0004\bq\u0010[R\u001d\u0010\u001a\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001a\u0010Y\u001a\u0004\br\u0010[R\u001d\u0010\u001b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u0010Y\u001a\u0004\bs\u0010[R\u001d\u0010\u001c\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010Y\u001a\u0004\bt\u0010[R\u001d\u0010\u001d\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010Y\u001a\u0004\bu\u0010[R\u001d\u0010\u001e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u0010Y\u001a\u0004\bv\u0010[R\u001d\u0010\u001f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001f\u0010Y\u001a\u0004\bw\u0010[R\u001d\u0010 \u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b \u0010Y\u001a\u0004\bx\u0010[R\u001d\u0010!\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b!\u0010Y\u001a\u0004\by\u0010[R\u001d\u0010\"\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\"\u0010Y\u001a\u0004\bz\u0010[R\u001d\u0010#\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b#\u0010Y\u001a\u0004\b{\u0010[R\u001d\u0010$\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b$\u0010Y\u001a\u0004\b|\u0010[R\u001d\u0010%\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b%\u0010Y\u001a\u0004\b}\u0010[R\u001d\u0010&\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b&\u0010Y\u001a\u0004\b~\u0010[R\u001d\u0010'\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b'\u0010Y\u001a\u0004\b\u007f\u0010[R\u001e\u0010(\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b(\u0010Y\u001a\u0005\b\u0080\u0001\u0010[R\u001e\u0010)\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b)\u0010Y\u001a\u0005\b\u0081\u0001\u0010[R\u001e\u0010*\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b*\u0010Y\u001a\u0005\b\u0082\u0001\u0010[R\u001e\u0010+\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b+\u0010Y\u001a\u0005\b\u0083\u0001\u0010[R\u001e\u0010,\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b,\u0010Y\u001a\u0005\b\u0084\u0001\u0010[R\u001e\u0010-\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b-\u0010Y\u001a\u0005\b\u0085\u0001\u0010[R\u001e\u0010.\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b.\u0010Y\u001a\u0005\b\u0086\u0001\u0010[R\u001e\u0010/\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b/\u0010Y\u001a\u0005\b\u0087\u0001\u0010[R\u001e\u00100\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b0\u0010Y\u001a\u0005\b\u0088\u0001\u0010[R\u001e\u00101\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b1\u0010Y\u001a\u0005\b\u0089\u0001\u0010[R\u001e\u00102\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b2\u0010Y\u001a\u0005\b\u008a\u0001\u0010[R\u001e\u00103\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b3\u0010Y\u001a\u0005\b\u008b\u0001\u0010[R\u001e\u00104\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b4\u0010Y\u001a\u0005\b\u008c\u0001\u0010[R\u001e\u00105\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b5\u0010Y\u001a\u0005\b\u008d\u0001\u0010[R\u001e\u00106\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b6\u0010Y\u001a\u0005\b\u008e\u0001\u0010[R\u001e\u00107\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b7\u0010Y\u001a\u0005\b\u008f\u0001\u0010[R\u001e\u00108\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b8\u0010Y\u001a\u0005\b\u0090\u0001\u0010[R\u001e\u00109\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b9\u0010Y\u001a\u0005\b\u0091\u0001\u0010[R\u001e\u0010:\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b:\u0010Y\u001a\u0005\b\u0092\u0001\u0010[R\u001e\u0010;\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b;\u0010Y\u001a\u0005\b\u0093\u0001\u0010[R\u001e\u0010<\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b<\u0010Y\u001a\u0005\b\u0094\u0001\u0010[R\u001e\u0010=\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b=\u0010Y\u001a\u0005\b\u0095\u0001\u0010[R\u001e\u0010>\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b>\u0010Y\u001a\u0005\b\u0096\u0001\u0010[R\u001e\u0010?\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b?\u0010Y\u001a\u0005\b\u0097\u0001\u0010[R\u001e\u0010@\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\b@\u0010Y\u001a\u0005\b\u0098\u0001\u0010[R\u001e\u0010A\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bA\u0010Y\u001a\u0005\b\u0099\u0001\u0010[R\u001e\u0010B\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bB\u0010Y\u001a\u0005\b\u009a\u0001\u0010[R\u001e\u0010C\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bC\u0010Y\u001a\u0005\b\u009b\u0001\u0010[R\u001e\u0010D\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bD\u0010Y\u001a\u0005\b\u009c\u0001\u0010[R\u0018\u0010F\u001a\u00020E8\u0006¢\u0006\r\n\u0004\bF\u0010Y\u001a\u0005\b\u009d\u0001\u0010[R\u0018\u0010G\u001a\u00020E8\u0006¢\u0006\r\n\u0004\bG\u0010Y\u001a\u0005\b\u009e\u0001\u0010[R\u001e\u0010H\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bH\u0010Y\u001a\u0005\b\u009f\u0001\u0010[R\u001e\u0010I\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bI\u0010Y\u001a\u0005\b \u0001\u0010[R\u001e\u0010J\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bJ\u0010Y\u001a\u0005\b¡\u0001\u0010[R\u001e\u0010K\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bK\u0010Y\u001a\u0005\b¢\u0001\u0010[R\u001e\u0010L\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\r\n\u0004\bL\u0010Y\u001a\u0005\b£\u0001\u0010[\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¤\u0001"}, d2 = {"Lru/yoomoney/sdk/guiCompose/theme/Dimens;", "", "Landroidx/compose/ui/unit/Dp;", "space3XS", "space2XS", "spaceXS", "spaceS", "spaceM", "spaceL", "spaceXL", "space2XL", "space3XL", "space4XL", "space5XL", "space6XL", "elevationXS", "elevationS", "elevationDefault", "elevationL", "radiusXS", "radiusS", "radiusM", "radiusL", "radiusDialog", "radiusNotice", "radiusInformer", "radiusTip", "radiusBubble", "buttonHeight", "buttonFlatHeight", "buttonProgressSize", "buttonProgressStrokeWidth", "buttonOutlineStrokeWidth", "buttonIconSize", "tagsHeight", "tagsRadius", "tagsStrokeWidth", "imageSizeS", "imageSizeM", "imageSizeL", "imageBadgeSizeS", "imageBadgeSizeM", "avatarDefaultSize", "avatarLargeSize", "avatarBadgeSize", "avatarBadgeOffset", "itemWidth", "iconBottomBarSize", "iconViewMediumSize", "iconViewLargeSize", "iconViewLargeIconSize", "listItemDefaultSize", "listItemLargeSize", "dividerHeight", "progressHeight", "itemListTextView", "headlinePrimaryLargeMinHeight", "headlineSecondaryLargeMinHeight", "headlinePrimaryDefaultMinHeight", "headlineSecondaryDefaultMinHeight", "headlinePrimarySmallMinHeight", "headlineSecondaryLargePaddingTop", "tipHeight", "chipHeight", "chipLargeHeight", "chipStrokeWidth", "chipIconMaxWidth", "ymAlertDialogWidth", "ymAlertDialogHeight", "", "ymAlertDialogWidthProportion", "ymAlertDialogHeightProportion", "tooltipMinWidth", "tooltipMaxWidth", "tooltipArrowWidth", "tooltipArrowHeight", "tooltipMinHorizontalPadding", "<init>", "(FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getSpace3XS-D9Ej5fM", "()F", "getSpace2XS-D9Ej5fM", "getSpaceXS-D9Ej5fM", "getSpaceS-D9Ej5fM", "getSpaceM-D9Ej5fM", "getSpaceL-D9Ej5fM", "getSpaceXL-D9Ej5fM", "getSpace2XL-D9Ej5fM", "getSpace3XL-D9Ej5fM", "getSpace4XL-D9Ej5fM", "getSpace5XL-D9Ej5fM", "getSpace6XL-D9Ej5fM", "getElevationXS-D9Ej5fM", "getElevationS-D9Ej5fM", "getElevationDefault-D9Ej5fM", "getElevationL-D9Ej5fM", "getRadiusXS-D9Ej5fM", "getRadiusS-D9Ej5fM", "getRadiusM-D9Ej5fM", "getRadiusL-D9Ej5fM", "getRadiusDialog-D9Ej5fM", "getRadiusNotice-D9Ej5fM", "getRadiusInformer-D9Ej5fM", "getRadiusTip-D9Ej5fM", "getRadiusBubble-D9Ej5fM", "getButtonHeight-D9Ej5fM", "getButtonFlatHeight-D9Ej5fM", "getButtonProgressSize-D9Ej5fM", "getButtonProgressStrokeWidth-D9Ej5fM", "getButtonOutlineStrokeWidth-D9Ej5fM", "getButtonIconSize-D9Ej5fM", "getTagsHeight-D9Ej5fM", "getTagsRadius-D9Ej5fM", "getTagsStrokeWidth-D9Ej5fM", "getImageSizeS-D9Ej5fM", "getImageSizeM-D9Ej5fM", "getImageSizeL-D9Ej5fM", "getImageBadgeSizeS-D9Ej5fM", "getImageBadgeSizeM-D9Ej5fM", "getAvatarDefaultSize-D9Ej5fM", "getAvatarLargeSize-D9Ej5fM", "getAvatarBadgeSize-D9Ej5fM", "getAvatarBadgeOffset-D9Ej5fM", "getItemWidth-D9Ej5fM", "getIconBottomBarSize-D9Ej5fM", "getIconViewMediumSize-D9Ej5fM", "getIconViewLargeSize-D9Ej5fM", "getIconViewLargeIconSize-D9Ej5fM", "getListItemDefaultSize-D9Ej5fM", "getListItemLargeSize-D9Ej5fM", "getDividerHeight-D9Ej5fM", "getProgressHeight-D9Ej5fM", "getItemListTextView-D9Ej5fM", "getHeadlinePrimaryLargeMinHeight-D9Ej5fM", "getHeadlineSecondaryLargeMinHeight-D9Ej5fM", "getHeadlinePrimaryDefaultMinHeight-D9Ej5fM", "getHeadlineSecondaryDefaultMinHeight-D9Ej5fM", "getHeadlinePrimarySmallMinHeight-D9Ej5fM", "getHeadlineSecondaryLargePaddingTop-D9Ej5fM", "getTipHeight-D9Ej5fM", "getChipHeight-D9Ej5fM", "getChipLargeHeight-D9Ej5fM", "getChipStrokeWidth-D9Ej5fM", "getChipIconMaxWidth-D9Ej5fM", "getYmAlertDialogWidth-D9Ej5fM", "getYmAlertDialogHeight-D9Ej5fM", "getYmAlertDialogWidthProportion", "getYmAlertDialogHeightProportion", "getTooltipMinWidth-D9Ej5fM", "getTooltipMaxWidth-D9Ej5fM", "getTooltipArrowWidth-D9Ej5fM", "getTooltipArrowHeight-D9Ej5fM", "getTooltipMinHorizontalPadding-D9Ej5fM", "guiCompose_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Dimens {
    private final float avatarBadgeOffset;
    private final float avatarBadgeSize;
    private final float avatarDefaultSize;
    private final float avatarLargeSize;
    private final float buttonFlatHeight;
    private final float buttonHeight;
    private final float buttonIconSize;
    private final float buttonOutlineStrokeWidth;
    private final float buttonProgressSize;
    private final float buttonProgressStrokeWidth;
    private final float chipHeight;
    private final float chipIconMaxWidth;
    private final float chipLargeHeight;
    private final float chipStrokeWidth;
    private final float dividerHeight;
    private final float elevationDefault;
    private final float elevationL;
    private final float elevationS;
    private final float elevationXS;
    private final float headlinePrimaryDefaultMinHeight;
    private final float headlinePrimaryLargeMinHeight;
    private final float headlinePrimarySmallMinHeight;
    private final float headlineSecondaryDefaultMinHeight;
    private final float headlineSecondaryLargeMinHeight;
    private final float headlineSecondaryLargePaddingTop;
    private final float iconBottomBarSize;
    private final float iconViewLargeIconSize;
    private final float iconViewLargeSize;
    private final float iconViewMediumSize;
    private final float imageBadgeSizeM;
    private final float imageBadgeSizeS;
    private final float imageSizeL;
    private final float imageSizeM;
    private final float imageSizeS;
    private final float itemListTextView;
    private final float itemWidth;
    private final float listItemDefaultSize;
    private final float listItemLargeSize;
    private final float progressHeight;
    private final float radiusBubble;
    private final float radiusDialog;
    private final float radiusInformer;
    private final float radiusL;
    private final float radiusM;
    private final float radiusNotice;
    private final float radiusS;
    private final float radiusTip;
    private final float radiusXS;
    private final float space2XL;
    private final float space2XS;
    private final float space3XL;
    private final float space3XS;
    private final float space4XL;
    private final float space5XL;
    private final float space6XL;
    private final float spaceL;
    private final float spaceM;
    private final float spaceS;
    private final float spaceXL;
    private final float spaceXS;
    private final float tagsHeight;
    private final float tagsRadius;
    private final float tagsStrokeWidth;
    private final float tipHeight;
    private final float tooltipArrowHeight;
    private final float tooltipArrowWidth;
    private final float tooltipMaxWidth;
    private final float tooltipMinHorizontalPadding;
    private final float tooltipMinWidth;
    private final float ymAlertDialogHeight;
    private final float ymAlertDialogHeightProportion;
    private final float ymAlertDialogWidth;
    private final float ymAlertDialogWidthProportion;

    public /* synthetic */ Dimens(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31, float f32, float f33, float f34, float f35, float f36, float f37, float f38, float f39, float f40, float f41, float f42, float f43, float f44, float f45, float f46, float f47, float f48, float f49, float f50, float f51, float f52, float f53, float f54, float f55, float f56, float f57, float f58, float f59, float f60, float f61, float f62, float f63, float f64, float f65, float f66, float f67, float f68, float f69, float f70, float f71, float f72, float f73, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40, f41, f42, f43, f44, f45, f46, f47, f48, f49, f50, f51, f52, f53, f54, f55, f56, f57, f58, f59, f60, f61, f62, f63, f64, f65, f66, f67, f68, f69, f70, f71, f72, f73);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Dimens)) {
            return false;
        }
        Dimens dimens = (Dimens) other;
        return Dp.m2104equalsimpl0(this.space3XS, dimens.space3XS) && Dp.m2104equalsimpl0(this.space2XS, dimens.space2XS) && Dp.m2104equalsimpl0(this.spaceXS, dimens.spaceXS) && Dp.m2104equalsimpl0(this.spaceS, dimens.spaceS) && Dp.m2104equalsimpl0(this.spaceM, dimens.spaceM) && Dp.m2104equalsimpl0(this.spaceL, dimens.spaceL) && Dp.m2104equalsimpl0(this.spaceXL, dimens.spaceXL) && Dp.m2104equalsimpl0(this.space2XL, dimens.space2XL) && Dp.m2104equalsimpl0(this.space3XL, dimens.space3XL) && Dp.m2104equalsimpl0(this.space4XL, dimens.space4XL) && Dp.m2104equalsimpl0(this.space5XL, dimens.space5XL) && Dp.m2104equalsimpl0(this.space6XL, dimens.space6XL) && Dp.m2104equalsimpl0(this.elevationXS, dimens.elevationXS) && Dp.m2104equalsimpl0(this.elevationS, dimens.elevationS) && Dp.m2104equalsimpl0(this.elevationDefault, dimens.elevationDefault) && Dp.m2104equalsimpl0(this.elevationL, dimens.elevationL) && Dp.m2104equalsimpl0(this.radiusXS, dimens.radiusXS) && Dp.m2104equalsimpl0(this.radiusS, dimens.radiusS) && Dp.m2104equalsimpl0(this.radiusM, dimens.radiusM) && Dp.m2104equalsimpl0(this.radiusL, dimens.radiusL) && Dp.m2104equalsimpl0(this.radiusDialog, dimens.radiusDialog) && Dp.m2104equalsimpl0(this.radiusNotice, dimens.radiusNotice) && Dp.m2104equalsimpl0(this.radiusInformer, dimens.radiusInformer) && Dp.m2104equalsimpl0(this.radiusTip, dimens.radiusTip) && Dp.m2104equalsimpl0(this.radiusBubble, dimens.radiusBubble) && Dp.m2104equalsimpl0(this.buttonHeight, dimens.buttonHeight) && Dp.m2104equalsimpl0(this.buttonFlatHeight, dimens.buttonFlatHeight) && Dp.m2104equalsimpl0(this.buttonProgressSize, dimens.buttonProgressSize) && Dp.m2104equalsimpl0(this.buttonProgressStrokeWidth, dimens.buttonProgressStrokeWidth) && Dp.m2104equalsimpl0(this.buttonOutlineStrokeWidth, dimens.buttonOutlineStrokeWidth) && Dp.m2104equalsimpl0(this.buttonIconSize, dimens.buttonIconSize) && Dp.m2104equalsimpl0(this.tagsHeight, dimens.tagsHeight) && Dp.m2104equalsimpl0(this.tagsRadius, dimens.tagsRadius) && Dp.m2104equalsimpl0(this.tagsStrokeWidth, dimens.tagsStrokeWidth) && Dp.m2104equalsimpl0(this.imageSizeS, dimens.imageSizeS) && Dp.m2104equalsimpl0(this.imageSizeM, dimens.imageSizeM) && Dp.m2104equalsimpl0(this.imageSizeL, dimens.imageSizeL) && Dp.m2104equalsimpl0(this.imageBadgeSizeS, dimens.imageBadgeSizeS) && Dp.m2104equalsimpl0(this.imageBadgeSizeM, dimens.imageBadgeSizeM) && Dp.m2104equalsimpl0(this.avatarDefaultSize, dimens.avatarDefaultSize) && Dp.m2104equalsimpl0(this.avatarLargeSize, dimens.avatarLargeSize) && Dp.m2104equalsimpl0(this.avatarBadgeSize, dimens.avatarBadgeSize) && Dp.m2104equalsimpl0(this.avatarBadgeOffset, dimens.avatarBadgeOffset) && Dp.m2104equalsimpl0(this.itemWidth, dimens.itemWidth) && Dp.m2104equalsimpl0(this.iconBottomBarSize, dimens.iconBottomBarSize) && Dp.m2104equalsimpl0(this.iconViewMediumSize, dimens.iconViewMediumSize) && Dp.m2104equalsimpl0(this.iconViewLargeSize, dimens.iconViewLargeSize) && Dp.m2104equalsimpl0(this.iconViewLargeIconSize, dimens.iconViewLargeIconSize) && Dp.m2104equalsimpl0(this.listItemDefaultSize, dimens.listItemDefaultSize) && Dp.m2104equalsimpl0(this.listItemLargeSize, dimens.listItemLargeSize) && Dp.m2104equalsimpl0(this.dividerHeight, dimens.dividerHeight) && Dp.m2104equalsimpl0(this.progressHeight, dimens.progressHeight) && Dp.m2104equalsimpl0(this.itemListTextView, dimens.itemListTextView) && Dp.m2104equalsimpl0(this.headlinePrimaryLargeMinHeight, dimens.headlinePrimaryLargeMinHeight) && Dp.m2104equalsimpl0(this.headlineSecondaryLargeMinHeight, dimens.headlineSecondaryLargeMinHeight) && Dp.m2104equalsimpl0(this.headlinePrimaryDefaultMinHeight, dimens.headlinePrimaryDefaultMinHeight) && Dp.m2104equalsimpl0(this.headlineSecondaryDefaultMinHeight, dimens.headlineSecondaryDefaultMinHeight) && Dp.m2104equalsimpl0(this.headlinePrimarySmallMinHeight, dimens.headlinePrimarySmallMinHeight) && Dp.m2104equalsimpl0(this.headlineSecondaryLargePaddingTop, dimens.headlineSecondaryLargePaddingTop) && Dp.m2104equalsimpl0(this.tipHeight, dimens.tipHeight) && Dp.m2104equalsimpl0(this.chipHeight, dimens.chipHeight) && Dp.m2104equalsimpl0(this.chipLargeHeight, dimens.chipLargeHeight) && Dp.m2104equalsimpl0(this.chipStrokeWidth, dimens.chipStrokeWidth) && Dp.m2104equalsimpl0(this.chipIconMaxWidth, dimens.chipIconMaxWidth) && Dp.m2104equalsimpl0(this.ymAlertDialogWidth, dimens.ymAlertDialogWidth) && Dp.m2104equalsimpl0(this.ymAlertDialogHeight, dimens.ymAlertDialogHeight) && Float.compare(this.ymAlertDialogWidthProportion, dimens.ymAlertDialogWidthProportion) == 0 && Float.compare(this.ymAlertDialogHeightProportion, dimens.ymAlertDialogHeightProportion) == 0 && Dp.m2104equalsimpl0(this.tooltipMinWidth, dimens.tooltipMinWidth) && Dp.m2104equalsimpl0(this.tooltipMaxWidth, dimens.tooltipMaxWidth) && Dp.m2104equalsimpl0(this.tooltipArrowWidth, dimens.tooltipArrowWidth) && Dp.m2104equalsimpl0(this.tooltipArrowHeight, dimens.tooltipArrowHeight) && Dp.m2104equalsimpl0(this.tooltipMinHorizontalPadding, dimens.tooltipMinHorizontalPadding);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Dp.m2105hashCodeimpl(this.space3XS) * 31) + Dp.m2105hashCodeimpl(this.space2XS)) * 31) + Dp.m2105hashCodeimpl(this.spaceXS)) * 31) + Dp.m2105hashCodeimpl(this.spaceS)) * 31) + Dp.m2105hashCodeimpl(this.spaceM)) * 31) + Dp.m2105hashCodeimpl(this.spaceL)) * 31) + Dp.m2105hashCodeimpl(this.spaceXL)) * 31) + Dp.m2105hashCodeimpl(this.space2XL)) * 31) + Dp.m2105hashCodeimpl(this.space3XL)) * 31) + Dp.m2105hashCodeimpl(this.space4XL)) * 31) + Dp.m2105hashCodeimpl(this.space5XL)) * 31) + Dp.m2105hashCodeimpl(this.space6XL)) * 31) + Dp.m2105hashCodeimpl(this.elevationXS)) * 31) + Dp.m2105hashCodeimpl(this.elevationS)) * 31) + Dp.m2105hashCodeimpl(this.elevationDefault)) * 31) + Dp.m2105hashCodeimpl(this.elevationL)) * 31) + Dp.m2105hashCodeimpl(this.radiusXS)) * 31) + Dp.m2105hashCodeimpl(this.radiusS)) * 31) + Dp.m2105hashCodeimpl(this.radiusM)) * 31) + Dp.m2105hashCodeimpl(this.radiusL)) * 31) + Dp.m2105hashCodeimpl(this.radiusDialog)) * 31) + Dp.m2105hashCodeimpl(this.radiusNotice)) * 31) + Dp.m2105hashCodeimpl(this.radiusInformer)) * 31) + Dp.m2105hashCodeimpl(this.radiusTip)) * 31) + Dp.m2105hashCodeimpl(this.radiusBubble)) * 31) + Dp.m2105hashCodeimpl(this.buttonHeight)) * 31) + Dp.m2105hashCodeimpl(this.buttonFlatHeight)) * 31) + Dp.m2105hashCodeimpl(this.buttonProgressSize)) * 31) + Dp.m2105hashCodeimpl(this.buttonProgressStrokeWidth)) * 31) + Dp.m2105hashCodeimpl(this.buttonOutlineStrokeWidth)) * 31) + Dp.m2105hashCodeimpl(this.buttonIconSize)) * 31) + Dp.m2105hashCodeimpl(this.tagsHeight)) * 31) + Dp.m2105hashCodeimpl(this.tagsRadius)) * 31) + Dp.m2105hashCodeimpl(this.tagsStrokeWidth)) * 31) + Dp.m2105hashCodeimpl(this.imageSizeS)) * 31) + Dp.m2105hashCodeimpl(this.imageSizeM)) * 31) + Dp.m2105hashCodeimpl(this.imageSizeL)) * 31) + Dp.m2105hashCodeimpl(this.imageBadgeSizeS)) * 31) + Dp.m2105hashCodeimpl(this.imageBadgeSizeM)) * 31) + Dp.m2105hashCodeimpl(this.avatarDefaultSize)) * 31) + Dp.m2105hashCodeimpl(this.avatarLargeSize)) * 31) + Dp.m2105hashCodeimpl(this.avatarBadgeSize)) * 31) + Dp.m2105hashCodeimpl(this.avatarBadgeOffset)) * 31) + Dp.m2105hashCodeimpl(this.itemWidth)) * 31) + Dp.m2105hashCodeimpl(this.iconBottomBarSize)) * 31) + Dp.m2105hashCodeimpl(this.iconViewMediumSize)) * 31) + Dp.m2105hashCodeimpl(this.iconViewLargeSize)) * 31) + Dp.m2105hashCodeimpl(this.iconViewLargeIconSize)) * 31) + Dp.m2105hashCodeimpl(this.listItemDefaultSize)) * 31) + Dp.m2105hashCodeimpl(this.listItemLargeSize)) * 31) + Dp.m2105hashCodeimpl(this.dividerHeight)) * 31) + Dp.m2105hashCodeimpl(this.progressHeight)) * 31) + Dp.m2105hashCodeimpl(this.itemListTextView)) * 31) + Dp.m2105hashCodeimpl(this.headlinePrimaryLargeMinHeight)) * 31) + Dp.m2105hashCodeimpl(this.headlineSecondaryLargeMinHeight)) * 31) + Dp.m2105hashCodeimpl(this.headlinePrimaryDefaultMinHeight)) * 31) + Dp.m2105hashCodeimpl(this.headlineSecondaryDefaultMinHeight)) * 31) + Dp.m2105hashCodeimpl(this.headlinePrimarySmallMinHeight)) * 31) + Dp.m2105hashCodeimpl(this.headlineSecondaryLargePaddingTop)) * 31) + Dp.m2105hashCodeimpl(this.tipHeight)) * 31) + Dp.m2105hashCodeimpl(this.chipHeight)) * 31) + Dp.m2105hashCodeimpl(this.chipLargeHeight)) * 31) + Dp.m2105hashCodeimpl(this.chipStrokeWidth)) * 31) + Dp.m2105hashCodeimpl(this.chipIconMaxWidth)) * 31) + Dp.m2105hashCodeimpl(this.ymAlertDialogWidth)) * 31) + Dp.m2105hashCodeimpl(this.ymAlertDialogHeight)) * 31) + Float.hashCode(this.ymAlertDialogWidthProportion)) * 31) + Float.hashCode(this.ymAlertDialogHeightProportion)) * 31) + Dp.m2105hashCodeimpl(this.tooltipMinWidth)) * 31) + Dp.m2105hashCodeimpl(this.tooltipMaxWidth)) * 31) + Dp.m2105hashCodeimpl(this.tooltipArrowWidth)) * 31) + Dp.m2105hashCodeimpl(this.tooltipArrowHeight)) * 31) + Dp.m2105hashCodeimpl(this.tooltipMinHorizontalPadding);
    }

    public String toString() {
        return "Dimens(space3XS=" + Dp.m2106toStringimpl(this.space3XS) + ", space2XS=" + Dp.m2106toStringimpl(this.space2XS) + ", spaceXS=" + Dp.m2106toStringimpl(this.spaceXS) + ", spaceS=" + Dp.m2106toStringimpl(this.spaceS) + ", spaceM=" + Dp.m2106toStringimpl(this.spaceM) + ", spaceL=" + Dp.m2106toStringimpl(this.spaceL) + ", spaceXL=" + Dp.m2106toStringimpl(this.spaceXL) + ", space2XL=" + Dp.m2106toStringimpl(this.space2XL) + ", space3XL=" + Dp.m2106toStringimpl(this.space3XL) + ", space4XL=" + Dp.m2106toStringimpl(this.space4XL) + ", space5XL=" + Dp.m2106toStringimpl(this.space5XL) + ", space6XL=" + Dp.m2106toStringimpl(this.space6XL) + ", elevationXS=" + Dp.m2106toStringimpl(this.elevationXS) + ", elevationS=" + Dp.m2106toStringimpl(this.elevationS) + ", elevationDefault=" + Dp.m2106toStringimpl(this.elevationDefault) + ", elevationL=" + Dp.m2106toStringimpl(this.elevationL) + ", radiusXS=" + Dp.m2106toStringimpl(this.radiusXS) + ", radiusS=" + Dp.m2106toStringimpl(this.radiusS) + ", radiusM=" + Dp.m2106toStringimpl(this.radiusM) + ", radiusL=" + Dp.m2106toStringimpl(this.radiusL) + ", radiusDialog=" + Dp.m2106toStringimpl(this.radiusDialog) + ", radiusNotice=" + Dp.m2106toStringimpl(this.radiusNotice) + ", radiusInformer=" + Dp.m2106toStringimpl(this.radiusInformer) + ", radiusTip=" + Dp.m2106toStringimpl(this.radiusTip) + ", radiusBubble=" + Dp.m2106toStringimpl(this.radiusBubble) + ", buttonHeight=" + Dp.m2106toStringimpl(this.buttonHeight) + ", buttonFlatHeight=" + Dp.m2106toStringimpl(this.buttonFlatHeight) + ", buttonProgressSize=" + Dp.m2106toStringimpl(this.buttonProgressSize) + ", buttonProgressStrokeWidth=" + Dp.m2106toStringimpl(this.buttonProgressStrokeWidth) + ", buttonOutlineStrokeWidth=" + Dp.m2106toStringimpl(this.buttonOutlineStrokeWidth) + ", buttonIconSize=" + Dp.m2106toStringimpl(this.buttonIconSize) + ", tagsHeight=" + Dp.m2106toStringimpl(this.tagsHeight) + ", tagsRadius=" + Dp.m2106toStringimpl(this.tagsRadius) + ", tagsStrokeWidth=" + Dp.m2106toStringimpl(this.tagsStrokeWidth) + ", imageSizeS=" + Dp.m2106toStringimpl(this.imageSizeS) + ", imageSizeM=" + Dp.m2106toStringimpl(this.imageSizeM) + ", imageSizeL=" + Dp.m2106toStringimpl(this.imageSizeL) + ", imageBadgeSizeS=" + Dp.m2106toStringimpl(this.imageBadgeSizeS) + ", imageBadgeSizeM=" + Dp.m2106toStringimpl(this.imageBadgeSizeM) + ", avatarDefaultSize=" + Dp.m2106toStringimpl(this.avatarDefaultSize) + ", avatarLargeSize=" + Dp.m2106toStringimpl(this.avatarLargeSize) + ", avatarBadgeSize=" + Dp.m2106toStringimpl(this.avatarBadgeSize) + ", avatarBadgeOffset=" + Dp.m2106toStringimpl(this.avatarBadgeOffset) + ", itemWidth=" + Dp.m2106toStringimpl(this.itemWidth) + ", iconBottomBarSize=" + Dp.m2106toStringimpl(this.iconBottomBarSize) + ", iconViewMediumSize=" + Dp.m2106toStringimpl(this.iconViewMediumSize) + ", iconViewLargeSize=" + Dp.m2106toStringimpl(this.iconViewLargeSize) + ", iconViewLargeIconSize=" + Dp.m2106toStringimpl(this.iconViewLargeIconSize) + ", listItemDefaultSize=" + Dp.m2106toStringimpl(this.listItemDefaultSize) + ", listItemLargeSize=" + Dp.m2106toStringimpl(this.listItemLargeSize) + ", dividerHeight=" + Dp.m2106toStringimpl(this.dividerHeight) + ", progressHeight=" + Dp.m2106toStringimpl(this.progressHeight) + ", itemListTextView=" + Dp.m2106toStringimpl(this.itemListTextView) + ", headlinePrimaryLargeMinHeight=" + Dp.m2106toStringimpl(this.headlinePrimaryLargeMinHeight) + ", headlineSecondaryLargeMinHeight=" + Dp.m2106toStringimpl(this.headlineSecondaryLargeMinHeight) + ", headlinePrimaryDefaultMinHeight=" + Dp.m2106toStringimpl(this.headlinePrimaryDefaultMinHeight) + ", headlineSecondaryDefaultMinHeight=" + Dp.m2106toStringimpl(this.headlineSecondaryDefaultMinHeight) + ", headlinePrimarySmallMinHeight=" + Dp.m2106toStringimpl(this.headlinePrimarySmallMinHeight) + ", headlineSecondaryLargePaddingTop=" + Dp.m2106toStringimpl(this.headlineSecondaryLargePaddingTop) + ", tipHeight=" + Dp.m2106toStringimpl(this.tipHeight) + ", chipHeight=" + Dp.m2106toStringimpl(this.chipHeight) + ", chipLargeHeight=" + Dp.m2106toStringimpl(this.chipLargeHeight) + ", chipStrokeWidth=" + Dp.m2106toStringimpl(this.chipStrokeWidth) + ", chipIconMaxWidth=" + Dp.m2106toStringimpl(this.chipIconMaxWidth) + ", ymAlertDialogWidth=" + Dp.m2106toStringimpl(this.ymAlertDialogWidth) + ", ymAlertDialogHeight=" + Dp.m2106toStringimpl(this.ymAlertDialogHeight) + ", ymAlertDialogWidthProportion=" + this.ymAlertDialogWidthProportion + ", ymAlertDialogHeightProportion=" + this.ymAlertDialogHeightProportion + ", tooltipMinWidth=" + Dp.m2106toStringimpl(this.tooltipMinWidth) + ", tooltipMaxWidth=" + Dp.m2106toStringimpl(this.tooltipMaxWidth) + ", tooltipArrowWidth=" + Dp.m2106toStringimpl(this.tooltipArrowWidth) + ", tooltipArrowHeight=" + Dp.m2106toStringimpl(this.tooltipArrowHeight) + ", tooltipMinHorizontalPadding=" + Dp.m2106toStringimpl(this.tooltipMinHorizontalPadding) + ")";
    }

    private Dimens(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31, float f32, float f33, float f34, float f35, float f36, float f37, float f38, float f39, float f40, float f41, float f42, float f43, float f44, float f45, float f46, float f47, float f48, float f49, float f50, float f51, float f52, float f53, float f54, float f55, float f56, float f57, float f58, float f59, float f60, float f61, float f62, float f63, float f64, float f65, float f66, float f67, float f68, float f69, float f70, float f71, float f72, float f73) {
        this.space3XS = f;
        this.space2XS = f2;
        this.spaceXS = f3;
        this.spaceS = f4;
        this.spaceM = f5;
        this.spaceL = f6;
        this.spaceXL = f7;
        this.space2XL = f8;
        this.space3XL = f9;
        this.space4XL = f10;
        this.space5XL = f11;
        this.space6XL = f12;
        this.elevationXS = f13;
        this.elevationS = f14;
        this.elevationDefault = f15;
        this.elevationL = f16;
        this.radiusXS = f17;
        this.radiusS = f18;
        this.radiusM = f19;
        this.radiusL = f20;
        this.radiusDialog = f21;
        this.radiusNotice = f22;
        this.radiusInformer = f23;
        this.radiusTip = f24;
        this.radiusBubble = f25;
        this.buttonHeight = f26;
        this.buttonFlatHeight = f27;
        this.buttonProgressSize = f28;
        this.buttonProgressStrokeWidth = f29;
        this.buttonOutlineStrokeWidth = f30;
        this.buttonIconSize = f31;
        this.tagsHeight = f32;
        this.tagsRadius = f33;
        this.tagsStrokeWidth = f34;
        this.imageSizeS = f35;
        this.imageSizeM = f36;
        this.imageSizeL = f37;
        this.imageBadgeSizeS = f38;
        this.imageBadgeSizeM = f39;
        this.avatarDefaultSize = f40;
        this.avatarLargeSize = f41;
        this.avatarBadgeSize = f42;
        this.avatarBadgeOffset = f43;
        this.itemWidth = f44;
        this.iconBottomBarSize = f45;
        this.iconViewMediumSize = f46;
        this.iconViewLargeSize = f47;
        this.iconViewLargeIconSize = f48;
        this.listItemDefaultSize = f49;
        this.listItemLargeSize = f50;
        this.dividerHeight = f51;
        this.progressHeight = f52;
        this.itemListTextView = f53;
        this.headlinePrimaryLargeMinHeight = f54;
        this.headlineSecondaryLargeMinHeight = f55;
        this.headlinePrimaryDefaultMinHeight = f56;
        this.headlineSecondaryDefaultMinHeight = f57;
        this.headlinePrimarySmallMinHeight = f58;
        this.headlineSecondaryLargePaddingTop = f59;
        this.tipHeight = f60;
        this.chipHeight = f61;
        this.chipLargeHeight = f62;
        this.chipStrokeWidth = f63;
        this.chipIconMaxWidth = f64;
        this.ymAlertDialogWidth = f65;
        this.ymAlertDialogHeight = f66;
        this.ymAlertDialogWidthProportion = f67;
        this.ymAlertDialogHeightProportion = f68;
        this.tooltipMinWidth = f69;
        this.tooltipMaxWidth = f70;
        this.tooltipArrowWidth = f71;
        this.tooltipArrowHeight = f72;
        this.tooltipMinHorizontalPadding = f73;
    }

    /* renamed from: getSpace3XS-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpace3XS() {
        return this.space3XS;
    }

    /* renamed from: getSpace2XS-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpace2XS() {
        return this.space2XS;
    }

    /* renamed from: getSpaceXS-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpaceXS() {
        return this.spaceXS;
    }

    /* renamed from: getSpaceS-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpaceS() {
        return this.spaceS;
    }

    /* renamed from: getSpaceM-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpaceM() {
        return this.spaceM;
    }

    /* renamed from: getSpaceL-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpaceL() {
        return this.spaceL;
    }

    /* renamed from: getSpaceXL-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpaceXL() {
        return this.spaceXL;
    }

    /* renamed from: getSpace2XL-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpace2XL() {
        return this.space2XL;
    }

    /* renamed from: getSpace3XL-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpace3XL() {
        return this.space3XL;
    }

    /* renamed from: getSpace4XL-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSpace4XL() {
        return this.space4XL;
    }

    /* renamed from: getElevationS-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevationS() {
        return this.elevationS;
    }

    /* renamed from: getRadiusS-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadiusS() {
        return this.radiusS;
    }

    /* renamed from: getRadiusM-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadiusM() {
        return this.radiusM;
    }

    /* renamed from: getRadiusL-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadiusL() {
        return this.radiusL;
    }

    /* renamed from: getRadiusNotice-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadiusNotice() {
        return this.radiusNotice;
    }

    /* renamed from: getRadiusInformer-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadiusInformer() {
        return this.radiusInformer;
    }

    /* renamed from: getButtonHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getButtonHeight() {
        return this.buttonHeight;
    }

    /* renamed from: getButtonFlatHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getButtonFlatHeight() {
        return this.buttonFlatHeight;
    }

    /* renamed from: getButtonProgressSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getButtonProgressSize() {
        return this.buttonProgressSize;
    }

    /* renamed from: getButtonProgressStrokeWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getButtonProgressStrokeWidth() {
        return this.buttonProgressStrokeWidth;
    }

    /* renamed from: getIconViewMediumSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIconViewMediumSize() {
        return this.iconViewMediumSize;
    }

    /* renamed from: getIconViewLargeSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIconViewLargeSize() {
        return this.iconViewLargeSize;
    }

    /* renamed from: getIconViewLargeIconSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIconViewLargeIconSize() {
        return this.iconViewLargeIconSize;
    }

    /* renamed from: getListItemDefaultSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getListItemDefaultSize() {
        return this.listItemDefaultSize;
    }

    /* renamed from: getListItemLargeSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getListItemLargeSize() {
        return this.listItemLargeSize;
    }

    /* renamed from: getDividerHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDividerHeight() {
        return this.dividerHeight;
    }

    /* renamed from: getChipHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getChipHeight() {
        return this.chipHeight;
    }

    /* renamed from: getChipLargeHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getChipLargeHeight() {
        return this.chipLargeHeight;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Dimens(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31, float f32, float f33, float f34, float f35, float f36, float f37, float f38, float f39, float f40, float f41, float f42, float f43, float f44, float f45, float f46, float f47, float f48, float f49, float f50, float f51, float f52, float f53, float f54, float f55, float f56, float f57, float f58, float f59, float f60, float f61, float f62, float f63, float f64, float f65, float f66, float f67, float f68, float f69, float f70, float f71, float f72, float f73, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        float f74;
        float f75;
        float fM2102constructorimpl;
        float f76;
        int i4;
        float fM2102constructorimpl2;
        int i5;
        float fM2102constructorimpl3;
        float f77;
        float fM2102constructorimpl4;
        float f78;
        float fM2102constructorimpl5;
        float f79;
        float f80;
        float fM2102constructorimpl6;
        float f81;
        float fM2102constructorimpl7;
        float f82;
        float fM2102constructorimpl8;
        float f83;
        float fM2102constructorimpl9;
        float f84;
        float fM2102constructorimpl10;
        float f85;
        float fM2102constructorimpl11;
        float f86;
        float fM2102constructorimpl12;
        float f87;
        float fM2102constructorimpl13;
        float f88;
        float fM2102constructorimpl14;
        float f89;
        float fM2102constructorimpl15;
        float f90;
        float fM2102constructorimpl16;
        float f91;
        float fM2102constructorimpl17;
        float f92;
        float fM2102constructorimpl18;
        float f93;
        float fM2102constructorimpl19;
        float f94;
        float fM2102constructorimpl20;
        float f95;
        float fM2102constructorimpl21;
        float f96;
        float fM2102constructorimpl22;
        float fM2102constructorimpl23 = (i & 1) != 0 ? Dp.m2102constructorimpl(2) : f;
        float fM2102constructorimpl24 = (i & 2) != 0 ? Dp.m2102constructorimpl(4) : f2;
        float fM2102constructorimpl25 = (i & 4) != 0 ? Dp.m2102constructorimpl(8) : f3;
        float fM2102constructorimpl26 = (i & 8) != 0 ? Dp.m2102constructorimpl(12) : f4;
        float fM2102constructorimpl27 = (i & 16) != 0 ? Dp.m2102constructorimpl(16) : f5;
        float fM2102constructorimpl28 = (i & 32) != 0 ? Dp.m2102constructorimpl(20) : f6;
        float fM2102constructorimpl29 = (i & 64) != 0 ? Dp.m2102constructorimpl(24) : f7;
        float fM2102constructorimpl30 = (i & 128) != 0 ? Dp.m2102constructorimpl(32) : f8;
        float fM2102constructorimpl31 = (i & 256) != 0 ? Dp.m2102constructorimpl(40) : f9;
        float fM2102constructorimpl32 = (i & 512) != 0 ? Dp.m2102constructorimpl(48) : f10;
        float fM2102constructorimpl33 = (i & 1024) != 0 ? Dp.m2102constructorimpl(52) : f11;
        float fM2102constructorimpl34 = (i & 2048) != 0 ? Dp.m2102constructorimpl(72) : f12;
        float fM2102constructorimpl35 = (i & 4096) != 0 ? Dp.m2102constructorimpl(2) : f13;
        float fM2102constructorimpl36 = (i & 8192) != 0 ? Dp.m2102constructorimpl(6) : f14;
        float fM2102constructorimpl37 = (i & 16384) != 0 ? Dp.m2102constructorimpl(10) : f15;
        if ((i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0) {
            f74 = fM2102constructorimpl37;
            f75 = fM2102constructorimpl36;
            fM2102constructorimpl = Dp.m2102constructorimpl(20);
        } else {
            f74 = fM2102constructorimpl37;
            f75 = fM2102constructorimpl36;
            fM2102constructorimpl = f16;
        }
        float f97 = fM2102constructorimpl;
        float fM2102constructorimpl38 = (65536 & i) != 0 ? Dp.m2102constructorimpl(4) : f17;
        float fM2102constructorimpl39 = (131072 & i) != 0 ? Dp.m2102constructorimpl(8) : f18;
        float fM2102constructorimpl40 = (262144 & i) != 0 ? Dp.m2102constructorimpl(12) : f19;
        float fM2102constructorimpl41 = (524288 & i) != 0 ? Dp.m2102constructorimpl(16) : f20;
        float fM2102constructorimpl42 = (1048576 & i) != 0 ? Dp.m2102constructorimpl(14) : f21;
        float f98 = fM2102constructorimpl41;
        if ((i & 2097152) != 0) {
            f76 = fM2102constructorimpl42;
            i4 = 20;
            fM2102constructorimpl2 = Dp.m2102constructorimpl(20);
        } else {
            f76 = fM2102constructorimpl42;
            i4 = 20;
            fM2102constructorimpl2 = f22;
        }
        float f99 = fM2102constructorimpl2;
        float fM2102constructorimpl43 = (i & 4194304) != 0 ? Dp.m2102constructorimpl(i4) : f23;
        float fM2102constructorimpl44 = (i & 8388608) != 0 ? Dp.m2102constructorimpl(i4) : f24;
        float fM2102constructorimpl45 = (16777216 & i) != 0 ? Dp.m2102constructorimpl(24) : f25;
        float fM2102constructorimpl46 = (33554432 & i) != 0 ? Dp.m2102constructorimpl(48) : f26;
        float fM2102constructorimpl47 = (67108864 & i) != 0 ? Dp.m2102constructorimpl(40) : f27;
        float fM2102constructorimpl48 = (134217728 & i) != 0 ? Dp.m2102constructorimpl(20) : f28;
        if ((268435456 & i) != 0) {
            i5 = 2;
            fM2102constructorimpl3 = Dp.m2102constructorimpl(2);
        } else {
            i5 = 2;
            fM2102constructorimpl3 = f29;
        }
        float f100 = fM2102constructorimpl3;
        float fM2102constructorimpl49 = (i & 536870912) != 0 ? Dp.m2102constructorimpl(i5) : f30;
        float fM2102constructorimpl50 = (1073741824 & i) != 0 ? Dp.m2102constructorimpl(20) : f31;
        float fM2102constructorimpl51 = (i & Integer.MIN_VALUE) != 0 ? Dp.m2102constructorimpl(24) : f32;
        float fM2102constructorimpl52 = (i2 & 1) != 0 ? Dp.m2102constructorimpl(18) : f33;
        if ((i2 & 2) != 0) {
            f77 = fM2102constructorimpl51;
            fM2102constructorimpl4 = Dp.m2102constructorimpl(1);
        } else {
            f77 = fM2102constructorimpl51;
            fM2102constructorimpl4 = f34;
        }
        if ((i2 & 4) != 0) {
            f78 = fM2102constructorimpl4;
            fM2102constructorimpl5 = Dp.m2102constructorimpl(24);
        } else {
            f78 = fM2102constructorimpl4;
            fM2102constructorimpl5 = f35;
        }
        float f101 = fM2102constructorimpl5;
        float fM2102constructorimpl53 = (i2 & 8) != 0 ? Dp.m2102constructorimpl(40) : f36;
        float fM2102constructorimpl54 = (i2 & 16) != 0 ? Dp.m2102constructorimpl(64) : f37;
        float fM2102constructorimpl55 = (i2 & 32) != 0 ? Dp.m2102constructorimpl(12) : f38;
        if ((i2 & 64) != 0) {
            f79 = fM2102constructorimpl55;
            f80 = fM2102constructorimpl54;
            fM2102constructorimpl6 = Dp.m2102constructorimpl(20);
        } else {
            f79 = fM2102constructorimpl55;
            f80 = fM2102constructorimpl54;
            fM2102constructorimpl6 = f39;
        }
        float f102 = fM2102constructorimpl6;
        float fM2102constructorimpl56 = (i2 & 128) != 0 ? Dp.m2102constructorimpl(40) : f40;
        float fM2102constructorimpl57 = (i2 & 256) != 0 ? Dp.m2102constructorimpl(64) : f41;
        float fM2102constructorimpl58 = (i2 & 512) != 0 ? Dp.m2102constructorimpl(16) : f42;
        float fM2102constructorimpl59 = (i2 & 1024) != 0 ? Dp.m2102constructorimpl(4) : f43;
        float fM2102constructorimpl60 = (i2 & 2048) != 0 ? Dp.m2102constructorimpl(58) : f44;
        float fM2102constructorimpl61 = (i2 & 4096) != 0 ? Dp.m2102constructorimpl(20) : f45;
        float f103 = fM2102constructorimpl57;
        float fM2102constructorimpl62 = (i2 & 8192) != 0 ? Dp.m2102constructorimpl(40) : f46;
        float fM2102constructorimpl63 = (i2 & 16384) != 0 ? Dp.m2102constructorimpl(64) : f47;
        float fM2102constructorimpl64 = (32768 & i2) != 0 ? Dp.m2102constructorimpl(40) : f48;
        float fM2102constructorimpl65 = (65536 & i2) != 0 ? Dp.m2102constructorimpl(56) : f49;
        if ((i2 & 131072) != 0) {
            f81 = fM2102constructorimpl65;
            fM2102constructorimpl7 = Dp.m2102constructorimpl(72);
        } else {
            f81 = fM2102constructorimpl65;
            fM2102constructorimpl7 = f50;
        }
        float f104 = fM2102constructorimpl64;
        if ((i2 & 262144) != 0) {
            f82 = fM2102constructorimpl7;
            fM2102constructorimpl8 = Dp.m2102constructorimpl(1);
        } else {
            f82 = fM2102constructorimpl7;
            fM2102constructorimpl8 = f51;
        }
        float fM2102constructorimpl66 = (524288 & i2) != 0 ? Dp.m2102constructorimpl(2) : f52;
        float f105 = fM2102constructorimpl8;
        if ((i2 & 1048576) != 0) {
            f83 = fM2102constructorimpl66;
            fM2102constructorimpl9 = Dp.m2102constructorimpl(40);
        } else {
            f83 = fM2102constructorimpl66;
            fM2102constructorimpl9 = f53;
        }
        float f106 = fM2102constructorimpl9;
        float fM2102constructorimpl67 = (2097152 & i2) != 0 ? Dp.m2102constructorimpl(64) : f54;
        float fM2102constructorimpl68 = (4194304 & i2) != 0 ? Dp.m2102constructorimpl(56) : f55;
        if ((i2 & 8388608) != 0) {
            f84 = fM2102constructorimpl68;
            fM2102constructorimpl10 = Dp.m2102constructorimpl(48);
        } else {
            f84 = fM2102constructorimpl68;
            fM2102constructorimpl10 = f56;
        }
        if ((i2 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0) {
            f85 = fM2102constructorimpl10;
            fM2102constructorimpl11 = Dp.m2102constructorimpl(34);
        } else {
            f85 = fM2102constructorimpl10;
            fM2102constructorimpl11 = f57;
        }
        if ((i2 & 33554432) != 0) {
            f86 = fM2102constructorimpl11;
            fM2102constructorimpl12 = Dp.m2102constructorimpl(40);
        } else {
            f86 = fM2102constructorimpl11;
            fM2102constructorimpl12 = f58;
        }
        if ((i2 & 67108864) != 0) {
            f87 = fM2102constructorimpl12;
            fM2102constructorimpl13 = Dp.m2102constructorimpl(30);
        } else {
            f87 = fM2102constructorimpl12;
            fM2102constructorimpl13 = f59;
        }
        if ((i2 & 134217728) != 0) {
            f88 = fM2102constructorimpl13;
            fM2102constructorimpl14 = Dp.m2102constructorimpl(64);
        } else {
            f88 = fM2102constructorimpl13;
            fM2102constructorimpl14 = f60;
        }
        if ((i2 & 268435456) != 0) {
            f89 = fM2102constructorimpl14;
            fM2102constructorimpl15 = Dp.m2102constructorimpl(24);
        } else {
            f89 = fM2102constructorimpl14;
            fM2102constructorimpl15 = f61;
        }
        if ((i2 & 536870912) != 0) {
            f90 = fM2102constructorimpl15;
            fM2102constructorimpl16 = Dp.m2102constructorimpl(32);
        } else {
            f90 = fM2102constructorimpl15;
            fM2102constructorimpl16 = f62;
        }
        if ((i2 & pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH) != 0) {
            f91 = fM2102constructorimpl16;
            fM2102constructorimpl17 = Dp.m2102constructorimpl(1);
        } else {
            f91 = fM2102constructorimpl16;
            fM2102constructorimpl17 = f63;
        }
        float fM2102constructorimpl69 = (i2 & Integer.MIN_VALUE) != 0 ? Dp.m2102constructorimpl(pjsip_status_code.PJSIP_SC_RINGING) : f64;
        if ((i3 & 1) != 0) {
            f92 = fM2102constructorimpl69;
            fM2102constructorimpl18 = Dp.m2102constructorimpl(328);
        } else {
            f92 = fM2102constructorimpl69;
            fM2102constructorimpl18 = f65;
        }
        if ((i3 & 2) != 0) {
            f93 = fM2102constructorimpl18;
            fM2102constructorimpl19 = Dp.m2102constructorimpl(512);
        } else {
            f93 = fM2102constructorimpl18;
            fM2102constructorimpl19 = f66;
        }
        float f107 = (i3 & 4) != 0 ? 0.912f : f67;
        float f108 = (i3 & 8) != 0 ? 0.8f : f68;
        if ((i3 & 16) != 0) {
            f94 = fM2102constructorimpl19;
            fM2102constructorimpl20 = Dp.m2102constructorimpl(80);
        } else {
            f94 = fM2102constructorimpl19;
            fM2102constructorimpl20 = f69;
        }
        if ((i3 & 32) != 0) {
            f95 = fM2102constructorimpl20;
            fM2102constructorimpl21 = Dp.m2102constructorimpl(264);
        } else {
            f95 = fM2102constructorimpl20;
            fM2102constructorimpl21 = f70;
        }
        if ((i3 & 64) != 0) {
            f96 = fM2102constructorimpl21;
            fM2102constructorimpl22 = Dp.m2102constructorimpl(11);
        } else {
            f96 = fM2102constructorimpl21;
            fM2102constructorimpl22 = f71;
        }
        this(fM2102constructorimpl23, fM2102constructorimpl24, fM2102constructorimpl25, fM2102constructorimpl26, fM2102constructorimpl27, fM2102constructorimpl28, fM2102constructorimpl29, fM2102constructorimpl30, fM2102constructorimpl31, fM2102constructorimpl32, fM2102constructorimpl33, fM2102constructorimpl34, fM2102constructorimpl35, f75, f74, f97, fM2102constructorimpl38, fM2102constructorimpl39, fM2102constructorimpl40, f98, f76, f99, fM2102constructorimpl43, fM2102constructorimpl44, fM2102constructorimpl45, fM2102constructorimpl46, fM2102constructorimpl47, fM2102constructorimpl48, f100, fM2102constructorimpl49, fM2102constructorimpl50, f77, fM2102constructorimpl52, f78, f101, fM2102constructorimpl53, f80, f79, f102, fM2102constructorimpl56, f103, fM2102constructorimpl58, fM2102constructorimpl59, fM2102constructorimpl60, fM2102constructorimpl61, fM2102constructorimpl62, fM2102constructorimpl63, f104, f81, f82, f105, f83, f106, fM2102constructorimpl67, f84, f85, f86, f87, f88, f89, f90, f91, fM2102constructorimpl17, f92, f93, f94, f107, f108, f95, f96, fM2102constructorimpl22, (i3 & 128) != 0 ? Dp.m2102constructorimpl(6) : f72, (i3 & 256) != 0 ? Dp.m2102constructorimpl(8) : f73, null);
    }
}
