package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 ³\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004³\u0002´\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0012\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J@\u00102\u001a\u00020\u0019*\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101JH\u00106\u001a\u00020\u0019*\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105JH\u00108\u001a\u00020\u0019*\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00105J\u0013\u00109\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b9\u0010:J\"\u0010@\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\"\u0010B\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010?J*\u0010G\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ'\u0010G\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00002\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\tH\u0002¢\u0006\u0004\bG\u0010KJ\u001f\u0010M\u001a\u00020\u00192\u0006\u0010L\u001a\u00020H2\u0006\u0010J\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010NJ\u001a\u0010Q\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010T\u001a\u0004\u0018\u00010\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\r\u0010U\u001a\u00020\t¢\u0006\u0004\bU\u0010VJ\u000f\u0010Y\u001a\u00020\u0019H\u0010¢\u0006\u0004\bW\u0010XJ\u000f\u0010Z\u001a\u00020\u0019H&¢\u0006\u0004\bZ\u0010XJ\u001f\u0010^\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020[H\u0014¢\u0006\u0004\b^\u0010_J\u000f\u0010a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b`\u0010XJ\r\u0010b\u001a\u00020\u0019¢\u0006\u0004\bb\u0010XJ8\u0010e\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0014ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ*\u0010e\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\u001bH\u0014ø\u0001\u0000¢\u0006\u0004\bc\u0010gJ\r\u0010h\u001a\u00020\u0019¢\u0006\u0004\bh\u0010XJ@\u0010j\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\u0010f\u001a\u0004\u0018\u00010\u001bø\u0001\u0000¢\u0006\u0004\bi\u0010\u001eJ\u001f\u0010k\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bk\u0010$J!\u0010l\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\bl\u0010$J\r\u0010m\u001a\u00020\u0019¢\u0006\u0004\bm\u0010XJ-\u0010o\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\b\u0002\u0010n\u001a\u00020\t¢\u0006\u0004\bo\u0010pJ8\u0010s\u001a\u00020\u00192\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\bq\u0010rJ:\u0010u\u001a\u00020\u00192\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\bt\u0010rJ\r\u0010w\u001a\u00020v¢\u0006\u0004\bw\u0010xJ\u001a\u0010{\u001a\u00020*2\u0006\u0010y\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bz\u0010PJ\u001a\u0010~\u001a\u00020*2\u0006\u0010|\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b}\u0010PJ\u001c\u0010\u0081\u0001\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010PJ'\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J/\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020*2\u0006\u0010D\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J&\u0010\u008b\u0001\u001a\u00020\u00192\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0006\u0010=\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001d\u0010\u008e\u0001\u001a\u00020\u00192\u0006\u0010=\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J#\u0010\u008f\u0001\u001a\u00020v2\u0007\u0010\u0082\u0001\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\tH\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001c\u0010\u0092\u0001\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010PJ'\u0010\u0095\u0001\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*2\b\b\u0002\u0010D\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J'\u0010\u0097\u0001\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*2\b\b\u0002\u0010D\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0094\u0001J$\u0010\u009a\u0001\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001H\u0004¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u009c\u0001\u0010XJ\u000f\u0010\u009d\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u009d\u0001\u0010XJ-\u0010¡\u0001\u001a\u00020\u00192\u0006\u0010L\u001a\u00020H2\u0006\u0010J\u001a\u00020\t2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\tH\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001d\u0010¤\u0001\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0004ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001d\u0010¦\u0001\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0004ø\u0001\u0000¢\u0006\u0006\b¥\u0001\u0010£\u0001J\u0011\u0010§\u0001\u001a\u00020\u0019H\u0016¢\u0006\u0005\b§\u0001\u0010XJ\u0011\u0010¨\u0001\u001a\u00020\u0019H\u0016¢\u0006\u0005\b¨\u0001\u0010XJ\u001b\u0010¬\u0001\u001a\u00020\u00002\u0007\u0010©\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J\u000f\u0010\u00ad\u0001\u001a\u00020\t¢\u0006\u0005\b\u00ad\u0001\u0010VJ\u001f\u0010±\u0001\u001a\u00030®\u00012\b\u0010¯\u0001\u001a\u00030®\u0001H\u0004ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010PJ'\u0010´\u0001\u001a\u00020\u00152\u0006\u0010+\u001a\u00020*2\b\u0010¯\u0001\u001a\u00030®\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b²\u0001\u0010³\u0001R\u001d\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0006\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R'\u0010¸\u0001\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0005\bº\u0001\u0010V\"\u0005\b»\u0001\u0010'R'\u0010¼\u0001\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b¼\u0001\u0010¹\u0001\u001a\u0005\b½\u0001\u0010V\"\u0005\b¾\u0001\u0010'R+\u0010¿\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R+\u0010Å\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010À\u0001\u001a\u0006\bÆ\u0001\u0010Â\u0001\"\u0006\bÇ\u0001\u0010Ä\u0001R\u0019\u0010È\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010¹\u0001R\u0019\u0010É\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010¹\u0001RD\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0015\u0010Ê\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00178\u0004@BX\u0084\u000e¢\u0006\u000f\n\u0005\b\u001a\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u001a\u0010Ï\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0019\u0010Ô\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001c\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R)\u0010Û\u0001\u001a\u0012\u0012\u0005\u0012\u00030Ú\u0001\u0012\u0004\u0012\u00020[\u0018\u00010Ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R6\u0010\u0014\u001a\u00020\u00132\u0007\u0010Ê\u0001\u001a\u00020\u00138\u0016@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b\u0014\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R0\u0010\u0016\u001a\u00020\u00152\u0007\u0010Ê\u0001\u001a\u00020\u00158\u0006@DX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0016\u0010Õ\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R\u001b\u0010æ\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001c\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R3\u0010ì\u0001\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00190ë\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\bì\u0001\u0010í\u0001\u0012\u0005\bî\u0001\u0010XR\u001e\u0010ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R)\u0010ò\u0001\u001a\u00020\t2\u0007\u0010Ê\u0001\u001a\u00020\t8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\bò\u0001\u0010¹\u0001\u001a\u0005\bó\u0001\u0010VR.\u0010f\u001a\u0005\u0018\u00010ô\u00012\n\u0010Ê\u0001\u001a\u0005\u0018\u00010ô\u00018\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\bf\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010ø\u0001R\u0018\u0010ü\u0001\u001a\u00030ù\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bú\u0001\u0010û\u0001R\u0017\u0010ÿ\u0001\u001a\u00020\u000b8&X¦\u0004¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R\u0018\u0010\u0082\u0002\u001a\u00030Ñ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0017\u0010\u0084\u0002\u001a\u00020\u00158VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0083\u0002\u0010ã\u0001R\u0017\u0010\u0086\u0002\u001a\u00020\u00158VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010ã\u0001R\u0019\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0017\u0010\u008c\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001b\u0010\u008f\u0002\u001a\u00030\u008d\u00028Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b\u008e\u0002\u0010ß\u0001R\u0018\u0010\u0093\u0002\u001a\u00030\u0090\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002R\u0019\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0094\u0002\u0010\u0088\u0002R\u0016\u0010\u0097\u0002\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0002\u0010VR\u0016\u0010\u0098\u0002\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0098\u0002\u0010VR,\u0010\u009e\u0002\u001a\u00030Ö\u00012\b\u0010\u0099\u0002\u001a\u00030Ö\u00018P@PX\u0090\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R0\u0010¤\u0002\u001a\u0005\u0018\u00010\u009f\u00022\n\u0010Ê\u0001\u001a\u0005\u0018\u00010\u009f\u00028&@dX¦\u000e¢\u0006\u0010\u001a\u0006\b \u0002\u0010¡\u0002\"\u0006\b¢\u0002\u0010£\u0002R\u001a\u0010¨\u0002\u001a\u0005\u0018\u00010¥\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¦\u0002\u0010§\u0002R\u0016\u0010ª\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\b©\u0002\u0010\u008b\u0002R\u0017\u0010\u00ad\u0002\u001a\u00020H8DX\u0084\u0004¢\u0006\b\u001a\u0006\b«\u0002\u0010¬\u0002R\u001e\u0010°\u0002\u001a\u00030®\u00028@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b¯\u0002\u0010ß\u0001R\u0016\u0010±\u0002\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b±\u0002\u0010VR\u001b\u0010¯\u0001\u001a\u00030®\u00018Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b²\u0002\u0010ß\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006µ\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "", "includeTail", "Landroidx/compose/ui/Modifier$Node;", "headNode", "(Z)Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/NodeKind;", "type", "hasNode-H91voCI", "(I)Z", "hasNode", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "layerBlock", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "explicitLayer", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "graphicsLayer", "drawContainedDrawModifiers", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "invokeOnLayoutChange", "updateLayerParameters", "(Z)V", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestSource", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "isTouchEvent", "isInLayer", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hit", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "hitNear", "speculativeHit-JHbHoSQ", "speculativeHit", "toCoordinator", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/node/NodeCoordinator;", "ancestor", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transformToAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformFromAncestor-EL8BTi8", "transformFromAncestor", "offset", "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "ancestorToLocal", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "clipBounds", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/geometry/MutableRect;Z)V", "bounds", "fromParentRect", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "offsetFromEdge-MK-Hz9U", "(J)J", "offsetFromEdge", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "head", "isTransparent", "()Z", "replace$ui_release", "()V", "replace", "ensureLookaheadDelegateCreated", "", "width", "height", "onMeasureResultChanged", "(II)V", "onCoordinatesUsed$ui_release", "onCoordinatesUsed", "onMeasured", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "releaseLayer", "placeSelfApparentToRealOffset-MLgxB_4", "placeSelfApparentToRealOffset", "draw", "performDraw", "onPlaced", "forceUpdateLayerParameters", "updateLayerBlock", "(Lkotlin/jvm/functions/Function1;Z)V", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTest", "hitTestChild-YqVAtuI", "hitTestChild", "Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "relativeToScreen", "screenToLocal-MK-Hz9U", "screenToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "windowToLocal", "relativeToLocal", "localToWindow-MK-Hz9U", "localToWindow", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFrom", "transformToScreen-58bKbWc", "([F)V", "transformToScreen", "localBoundingBoxOf", "(Landroidx/compose/ui/layout/LayoutCoordinates;Z)Landroidx/compose/ui/geometry/Rect;", "localToRoot-MK-Hz9U", "localToRoot", "toParentPosition-8S9VItk", "(JZ)J", "toParentPosition", "fromParentPosition-8S9VItk", "fromParentPosition", "Landroidx/compose/ui/graphics/Paint;", "paint", "drawBorder", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Paint;)V", "onLayoutNodeAttach", "onRelease", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "(Landroidx/compose/ui/geometry/MutableRect;ZZ)V", "rectInParent", "withinLayerBounds-k-4lQ0M", "(J)Z", "withinLayerBounds", "isPointerInBounds-k-4lQ0M", "isPointerInBounds", "invalidateLayer", "onLayoutModifierNodeChanged", "other", "findCommonAncestor$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)Landroidx/compose/ui/node/NodeCoordinator;", "findCommonAncestor", "shouldSharePointerInputWithSiblings", "Landroidx/compose/ui/geometry/Size;", "minimumTouchTargetSize", "calculateMinimumTouchTargetPadding-E7KxVPU", "calculateMinimumTouchTargetPadding", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "distanceInMinimumTouchTarget", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "forcePlaceWithLookaheadOffset", "Z", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "forceMeasureWithLookaheadConstraints", "getForceMeasureWithLookaheadConstraints$ui_release", "setForceMeasureWithLookaheadConstraints$ui_release", "wrapped", "Landroidx/compose/ui/node/NodeCoordinator;", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "released", "isClipping", "<set-?>", "Lkotlin/jvm/functions/Function1;", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/Density;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastLayerAlpha", "F", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "", "Landroidx/compose/ui/layout/AlignmentLine;", "oldAlignmentLines", "Ljava/util/Map;", "J", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "getZIndex", "()F", "setZIndex", "(F)V", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "Lkotlin/Function2;", "drawBlock", "Lkotlin/jvm/functions/Function2;", "getDrawBlock$annotations", "Lkotlin/Function0;", "invalidateParentLayer", "Lkotlin/jvm/functions/Function0;", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "density", "getFontScale", "fontScale", "getParent", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "size", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "getChild", "child", "getHasMeasureResult", "hasMeasureResult", "isAttached", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureResult", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "lookaheadDelegate", "", "getParentData", "()Ljava/lang/Object;", "parentData", "getParentLayoutCoordinates", "parentLayoutCoordinates", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "rectCache", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "lastMeasurementConstraints", "isValidOwnerScope", "getMinimumTouchTargetSize-NH-jbRc", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            if (nodeCoordinator.isValidOwnerScope()) {
                LayerPositionalProperties layerPositionalProperties = nodeCoordinator.layerPositionalProperties;
                if (layerPositionalProperties != null) {
                    NodeCoordinator.tmpLayerPositionalProperties.copyFrom(layerPositionalProperties);
                    NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                    if (NodeCoordinator.tmpLayerPositionalProperties.hasSameValuesAs(layerPositionalProperties)) {
                        return;
                    }
                    LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                    LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                    if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                        if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                            LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                        }
                        layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    Owner owner = layoutNode.getOwner();
                    if (owner != null) {
                        owner.requestOnPositionedCallback(layoutNode);
                        return;
                    }
                    return;
                }
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator nodeCoordinator) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m1031constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo1549entityTypeOLwlOKw() {
            return NodeKind.m1552constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            int iM1552constructorimpl = NodeKind.m1552constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != 0) {
                if (!(node instanceof PointerInputModifierNode)) {
                    if ((node.getKindSet() & iM1552constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                        Modifier.Node delegate = node.getDelegate();
                        int i = 0;
                        node = node;
                        while (delegate != null) {
                            if ((delegate.getKindSet() & iM1552constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    node = delegate;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node != 0) {
                                        mutableVector.add(node);
                                        node = 0;
                                    }
                                    mutableVector.add(delegate);
                                }
                            }
                            delegate = delegate.getChild();
                            node = node;
                        }
                        if (i == 1) {
                        }
                    }
                } else if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                    return true;
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo1548childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            layoutNode.m1480hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo1549entityTypeOLwlOKw() {
            return NodeKind.m1552constructorimpl(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration collapsedSemantics$ui_release = parentLayoutNode.getCollapsedSemantics$ui_release();
            boolean z = false;
            if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI */
        public void mo1548childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            layoutNode.m1481hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.INSTANCE.m2145getZeronOccac();
    private final Function2<Canvas, GraphicsLayer, Unit> drawBlock = new Function2<Canvas, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas, GraphicsLayer graphicsLayer) {
            invoke2(canvas, graphicsLayer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final Canvas canvas, final GraphicsLayer graphicsLayer) {
            if (this.this$0.getLayoutNode().isPlaced()) {
                OwnerSnapshotObserver snapshotObserver = this.this$0.getSnapshotObserver();
                NodeCoordinator nodeCoordinator = this.this$0;
                Function1 function1 = NodeCoordinator.onCommitAffectingLayer;
                final NodeCoordinator nodeCoordinator2 = this.this$0;
                snapshotObserver.observeReads$ui_release(nodeCoordinator, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1.1
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
                        nodeCoordinator2.drawContainedDrawModifiers(canvas, graphicsLayer);
                    }
                });
                this.this$0.lastLayerDrawingWasSkipped = false;
                return;
            }
            this.this$0.lastLayerDrawingWasSkipped = true;
        }
    };
    private final Function0<Unit> invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
            NodeCoordinator wrappedBy = this.this$0.getWrappedBy();
            if (wrappedBy != null) {
                wrappedBy.invalidateLayer();
            }
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI */
        void mo1548childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo1549entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public abstract void ensureLookaheadDelegateCreated();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean z) {
        this.forcePlaceWithLookaheadOffset = z;
    }

    /* renamed from: getForceMeasureWithLookaheadConstraints$ui_release, reason: from getter */
    public final boolean getForceMeasureWithLookaheadConstraints() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean z) {
        this.forceMeasureWithLookaheadConstraints = z;
    }

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        Modifier.Node nodeM1541headH91voCI = m1541headH91voCI(NodeKind.m1552constructorimpl(4));
        if (nodeM1541headH91voCI == null) {
            performDraw(canvas, graphicsLayer);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m1490draweZhPAX0$ui_release(canvas, IntSizeKt.m2162toSizeozmzZPI(mo1422getSizeYbymL2g()), this, nodeM1541headH91voCI, graphicsLayer);
        }
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m1553getIncludeSelfInTraversalH91voCI(NodeKind.m1552constructorimpl(16)));
        if (nodeHeadNode != null && nodeHeadNode.getIsAttached()) {
            int iM1552constructorimpl = NodeKind.m1552constructorimpl(16);
            if (!nodeHeadNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = nodeHeadNode.getNode();
            if ((node.getAggregateChildKindSet() & iM1552constructorimpl) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & iM1552constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = node;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (!(delegatingNodePop instanceof PointerInputModifierNode)) {
                                if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet() & iM1552constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    mutableVector.add(delegatingNodePop);
                                                    delegatingNodePop = 0;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else if (((PointerInputModifierNode) delegatingNodePop).sharePointerInputWithSiblings()) {
                                return true;
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getChild();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    public final void onMeasured() {
        Modifier.Node parent;
        if (m1527hasNodeH91voCI(NodeKind.m1552constructorimpl(128))) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int iM1552constructorimpl = NodeKind.m1552constructorimpl(128);
                boolean zM1553getIncludeSelfInTraversalH91voCI = NodeKindKt.m1553getIncludeSelfInTraversalH91voCI(iM1552constructorimpl);
                if (zM1553getIncludeSelfInTraversalH91voCI) {
                    parent = getTail();
                } else {
                    parent = getTail().getParent();
                    if (parent == null) {
                    }
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                }
                for (Modifier.Node nodeHeadNode = headNode(zM1553getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM1552constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                    if ((nodeHeadNode.getKindSet() & iM1552constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        DelegatingNode delegatingNodePop = nodeHeadNode;
                        while (delegatingNodePop != 0) {
                            if (!(delegatingNodePop instanceof LayoutAwareModifierNode)) {
                                if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet() & iM1552constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    mutableVector.add(delegatingNodePop);
                                                    delegatingNodePop = 0;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                ((LayoutAwareModifierNode) delegatingNodePop).mo220onRemeasuredozmzZPI(getMeasuredSize());
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if (nodeHeadNode == parent) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            } catch (Throwable th) {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void onPlaced() {
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(128);
        boolean zM1553getIncludeSelfInTraversalH91voCI = NodeKindKt.m1553getIncludeSelfInTraversalH91voCI(iM1552constructorimpl);
        Modifier.Node tail = getTail();
        if (!zM1553getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM1553getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM1552constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & iM1552constructorimpl) != 0) {
                DelegatingNode delegatingNodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (delegatingNodePop != 0) {
                    if (!(delegatingNodePop instanceof LayoutAwareModifierNode)) {
                        if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM1552constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            mutableVector.add(delegatingNodePop);
                                            delegatingNodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                    } else {
                        ((LayoutAwareModifierNode) delegatingNodePop).onPlaced(this);
                    }
                    delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null && (tail = nodeCoordinator.getTail()) != null) {
                return tail.getChild();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    /* renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m1527hasNodeH91voCI(int type) {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m1553getIncludeSelfInTraversalH91voCI(type));
        return nodeHeadNode != null && DelegatableNodeKt.m1465has64DMado(nodeHeadNode, type);
    }

    /* renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m1541headH91voCI(int type) {
        boolean zM1553getIncludeSelfInTraversalH91voCI = NodeKindKt.m1553getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM1553getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM1553getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo1422getSizeYbymL2g() {
        return getMeasuredSize();
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        GraphicsLayer graphicsLayer = this.explicitLayer;
        if (graphicsLayer != null) {
            mo1441placeAtf8xVGno(getPosition(), this.zIndex, graphicsLayer);
        } else {
            mo1421placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.get$w() != measureResult2.get$w() || measureResult.get$h() != measureResult2.get$h()) {
                onMeasureResultChanged(measureResult.get$w(), measureResult.get$h());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && measureResult.getAlignmentLines().isEmpty()) || Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            Map linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(measureResult.getAlignmentLines());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    protected void onMeasureResultChanged(int width, int height) {
        NodeCoordinator nodeCoordinator;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo1558resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else if (getLayoutNode().isPlaced() && (nodeCoordinator = this.wrappedBy) != null) {
            nodeCoordinator.invalidateLayer();
        }
        m1442setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        if (this.layerBlock != null) {
            updateLayerParameters(false);
        }
        int iM1552constructorimpl = NodeKind.m1552constructorimpl(4);
        boolean zM1553getIncludeSelfInTraversalH91voCI = NodeKindKt.m1553getIncludeSelfInTraversalH91voCI(iM1552constructorimpl);
        Modifier.Node tail = getTail();
        if (zM1553getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node nodeHeadNode = headNode(zM1553getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM1552constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                if ((nodeHeadNode.getKindSet() & iM1552constructorimpl) != 0) {
                    DelegatingNode delegatingNodePop = nodeHeadNode;
                    MutableVector mutableVector = null;
                    while (delegatingNodePop != 0) {
                        if (delegatingNodePop instanceof DrawModifierNode) {
                            ((DrawModifierNode) delegatingNodePop).onMeasureResultChanged();
                        } else if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM1552constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            mutableVector.add(delegatingNodePop);
                                            delegatingNodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    break;
                }
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m1545setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes().m1520hasH91voCI$ui_release(NodeKind.m1552constructorimpl(64))) {
            return null;
        }
        getTail();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        for (Modifier.Node tail = getLayoutNode().getNodes().getTail(); tail != null; tail = tail.getParent()) {
            if ((NodeKind.m1552constructorimpl(64) & tail.getKindSet()) != 0) {
                int iM1552constructorimpl = NodeKind.m1552constructorimpl(64);
                MutableVector mutableVector = null;
                DelegatingNode delegatingNodePop = tail;
                while (delegatingNodePop != 0) {
                    if (!(delegatingNodePop instanceof ParentDataModifierNode)) {
                        if ((delegatingNodePop.getKindSet() & iM1552constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM1552constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            mutableVector.add(delegatingNodePop);
                                            delegatingNodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                    } else {
                        ref$ObjectRef.element = ((ParentDataModifierNode) delegatingNodePop).modifyParentData(getLayoutNode().getDensity(), ref$ObjectRef.element);
                    }
                    delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return ref$ObjectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m1539getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    protected void mo1421placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m1531placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, layerBlock, null);
            return;
        }
        m1531placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    protected void mo1441placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        if (this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            m1531placeSelfMLgxB_4(lookaheadDelegate.getPosition(), zIndex, null, layer);
            return;
        }
        m1531placeSelfMLgxB_4(position, zIndex, null, layer);
    }

    /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m1531placeSelfMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            if (!(layerBlock == null)) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != explicitLayer) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
                this.explicitLayer = explicitLayer;
            }
            if (this.layer == null) {
                OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this.drawBlock, this.invalidateParentLayer, explicitLayer);
                ownedLayerCreateLayer.mo1558resizeozmzZPI(getMeasuredSize());
                ownedLayerCreateLayer.mo1557movegyyYBs(position);
                this.layer = ownedLayerCreateLayer;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
                updateLayerBlock$default(this, null, false, 2, null);
            }
            updateLayerBlock$default(this, layerBlock, false, 2, null);
        }
        if (!IntOffset.m2137equalsimpl0(getPosition(), position)) {
            m1545setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo1557movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
        if (getIsPlacingForAlignment()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public final void releaseLayer() {
        if (this.layer != null) {
            if (this.explicitLayer != null) {
                this.explicitLayer = null;
            }
            updateLayerBlock$default(this, null, false, 2, null);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), false, 1, null);
        }
    }

    /* renamed from: placeSelfApparentToRealOffset-MLgxB_4, reason: not valid java name */
    public final void m1544placeSelfApparentToRealOffsetMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        m1531placeSelfMLgxB_4(IntOffset.m2142plusqkQi6aY(position, getApparentToRealOffset()), zIndex, layerBlock, layer);
    }

    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas, graphicsLayer);
            return;
        }
        float fM2138getXimpl = IntOffset.m2138getXimpl(getPosition());
        float fM2139getYimpl = IntOffset.m2139getYimpl(getPosition());
        canvas.translate(fM2138getXimpl, fM2139getYimpl);
        drawContainedDrawModifiers(canvas, graphicsLayer);
        canvas.translate(-fM2138getXimpl, -fM2139getYimpl);
    }

    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas, graphicsLayer);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        if (!(layerBlock == null || this.explicitLayer == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode layoutNode = getLayoutNode();
        boolean z = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && layerBlock != null) {
            this.layerBlock = layerBlock;
            if (this.layer != null) {
                if (z) {
                    updateLayerParameters$default(this, false, 1, null);
                    return;
                }
                return;
            }
            OwnedLayer ownedLayerCreateLayer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), this.drawBlock, this.invalidateParentLayer, null, 4, null);
            ownedLayerCreateLayer$default.mo1558resizeozmzZPI(getMeasuredSize());
            ownedLayerCreateLayer$default.mo1557movegyyYBs(getPosition());
            this.layer = ownedLayerCreateLayer$default;
            updateLayerParameters$default(this, false, 1, null);
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        this.layerBlock = null;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner = layoutNode.getOwner()) != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        if (this.explicitLayer != null) {
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
                throw new KotlinNothingValueException();
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
            reusableGraphicsLayerScope.m1074setSizeuvyYCjk(IntSizeKt.m2162toSizeozmzZPI(mo1422getSizeYbymL2g()));
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator.updateLayerParameters.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    function1.invoke(NodeCoordinator.graphicsLayerScope);
                    NodeCoordinator.graphicsLayerScope.updateOutline$ui_release();
                }
            });
            LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                layerPositionalProperties = new LayerPositionalProperties();
                this.layerPositionalProperties = layerPositionalProperties;
            }
            layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
            ownedLayer.updateLayerProperties(reusableGraphicsLayerScope);
            this.isClipping = reusableGraphicsLayerScope.getClip();
            this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
            if (!invokeOnLayoutChange || (owner = getLayoutNode().getOwner()) == null) {
                return;
            }
            owner.onLayoutChange(getLayoutNode());
            return;
        }
        if (this.layerBlock == null) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m1540getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo255toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo1484getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final void m1542hitTestYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Modifier.Node nodeM1541headH91voCI = m1541headH91voCI(hitTestSource.mo1549entityTypeOLwlOKw());
        if (!m1547withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float fM1537distanceInMinimumTouchTargettz77jQw = m1537distanceInMinimumTouchTargettz77jQw(pointerPosition, m1540getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(fM1537distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM1537distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(fM1537distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m1529hitNearJHbHoSQ(nodeM1541headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, fM1537distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (nodeM1541headH91voCI == null) {
            mo1472hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m1543isPointerInBoundsk4lQ0M(pointerPosition)) {
            m1528hit1hIXUjU(nodeM1541headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float fM1537distanceInMinimumTouchTargettz77jQw2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m1537distanceInMinimumTouchTargettz77jQw(pointerPosition, m1540getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(fM1537distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(fM1537distanceInMinimumTouchTargettz77jQw2)) {
            if (hitTestResult.isHitInMinimumTouchTargetBetter(fM1537distanceInMinimumTouchTargettz77jQw2, isInLayer)) {
                m1529hitNearJHbHoSQ(nodeM1541headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM1537distanceInMinimumTouchTargettz77jQw2);
                return;
            }
        }
        m1532speculativeHitJHbHoSQ(nodeM1541headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM1537distanceInMinimumTouchTargettz77jQw2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU, reason: not valid java name */
    public final void m1528hit1hIXUjU(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2) {
        if (node == null) {
            mo1472hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(node, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
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
                    this.this$0.m1528hit1hIXUjU(NodeCoordinatorKt.m1551nextUntilhw7D004(node, hitTestSource.mo1549entityTypeOLwlOKw(), NodeKind.m1552constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final void m1529hitNearJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo1472hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
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
                    this.this$0.m1529hitNearJHbHoSQ(NodeCoordinatorKt.m1551nextUntilhw7D004(node, hitTestSource.mo1549entityTypeOLwlOKw(), NodeKind.m1552constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final void m1532speculativeHitJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo1472hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m1532speculativeHitJHbHoSQ(NodeCoordinatorKt.m1551nextUntilhw7D004(node, hitTestSource.mo1549entityTypeOLwlOKw(), NodeKind.m1552constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        } else {
            hitTestResult.speculativeHit(node, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
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
                    this.this$0.m1532speculativeHitJHbHoSQ(NodeCoordinatorKt.m1551nextUntilhw7D004(node, hitTestSource.mo1549entityTypeOLwlOKw(), NodeKind.m1552constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public void mo1472hitTestChildYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m1542hitTestYqVAtuI(hitTestSource, m1526fromParentPosition8S9VItk$default(nodeCoordinator, pointerPosition, false, 2, null), hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long jM1536calculateMinimumTouchTargetPaddingE7KxVPU = m1536calculateMinimumTouchTargetPaddingE7KxVPU(m1540getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m878getWidthimpl(jM1536calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m876getHeightimpl(jM1536calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m878getWidthimpl(jM1536calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m876getHeightimpl(jM1536calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != layoutCoordinatesFindRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo1427screenToLocalMKHz9U(long relativeToScreen) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return mo1423localPositionOfR5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(getLayoutNode()).mo1385screenToLocalMKHz9U(relativeToScreen));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo1430windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo1423localPositionOfR5De75A(layoutCoordinatesFindRootCoordinates, Offset.m846minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo1560calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo1426localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo1561calculatePositionInWindowMKHz9U(mo1425localToRootMKHz9U(relativeToLocal));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo1423localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo1424localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-S_NoaFU */
    public long mo1424localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            ((LookaheadLayoutCoordinates) sourceCoordinates).getCoordinator().onCoordinatesUsed$ui_release();
            return Offset.m850unaryMinusF1C5BW0(sourceCoordinates.mo1424localPositionOfS_NoaFU(this, Offset.m850unaryMinusF1C5BW0(relativeToSource), includeMotionFrameOfReference));
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            relativeToSource = coordinator.m1546toParentPosition8S9VItk(relativeToSource, includeMotionFrameOfReference);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m1525ancestorToLocalS_NoaFU(nodeCoordinatorFindCommonAncestor$ui_release, relativeToSource, includeMotionFrameOfReference);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo1428transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m1036resetimpl(matrix);
        coordinator.m1535transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
        m1534transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformToScreen-58bKbWc */
    public void mo1429transformToScreen58bKbWc(float[] matrix) {
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        m1535transformToAncestorEL8BTi8(toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this)), matrix);
        ownerRequireOwner.mo1383localToScreen58bKbWc(matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m1535transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator nodeCoordinator = this;
        while (!Intrinsics.areEqual(nodeCoordinator, ancestor)) {
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                ownedLayer.mo1559transform58bKbWc(matrix);
            }
            if (!IntOffset.m2137equalsimpl0(nodeCoordinator.getPosition(), IntOffset.INSTANCE.m2145getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m1036resetimpl(fArr);
                Matrix.m1045translateimpl$default(fArr, IntOffset.m2138getXimpl(r1), IntOffset.m2139getYimpl(r1), 0.0f, 4, null);
                Matrix.m1042timesAssign58bKbWc(matrix, fArr);
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m1534transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (Intrinsics.areEqual(ancestor, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator);
        nodeCoordinator.m1534transformFromAncestorEL8BTi8(ancestor, matrix);
        if (!IntOffset.m2137equalsimpl0(getPosition(), IntOffset.INSTANCE.m2145getZeronOccac())) {
            float[] fArr = tmpMatrix;
            Matrix.m1036resetimpl(fArr);
            Matrix.m1045translateimpl$default(fArr, -IntOffset.m2138getXimpl(getPosition()), -IntOffset.m2139getYimpl(getPosition()), 0.0f, 4, null);
            Matrix.m1042timesAssign58bKbWc(matrix, fArr);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo1554inverseTransform58bKbWc(matrix);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!sourceCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + sourceCoordinates + " is not attached!");
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m2156getWidthimpl(sourceCoordinates.mo1422getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m2155getHeightimpl(sourceCoordinates.mo1422getSizeYbymL2g()));
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            rectInParent$ui_release$default(coordinator, rectCache, clipBounds, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-S_NoaFU, reason: not valid java name */
    private final long m1525ancestorToLocalS_NoaFU(NodeCoordinator ancestor, long offset, boolean includeMotionFrameOfReference) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator == null || Intrinsics.areEqual(ancestor, nodeCoordinator)) {
            return m1538fromParentPosition8S9VItk(offset, includeMotionFrameOfReference);
        }
        return m1538fromParentPosition8S9VItk(nodeCoordinator.m1525ancestorToLocalS_NoaFU(ancestor, offset, includeMotionFrameOfReference), includeMotionFrameOfReference);
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo1425localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        long jM1533toParentPosition8S9VItk$default = relativeToLocal;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            jM1533toParentPosition8S9VItk$default = m1533toParentPosition8S9VItk$default(nodeCoordinator, jM1533toParentPosition8S9VItk$default, false, 2, null);
        }
        return jM1533toParentPosition8S9VItk$default;
    }

    /* renamed from: toParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m1533toParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m1546toParentPosition8S9VItk(j, z);
    }

    /* renamed from: toParentPosition-8S9VItk, reason: not valid java name */
    public long m1546toParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo1556mapOffset8S9VItk(position, false);
        }
        return (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) ? IntOffsetKt.m2147plusNvtHpc(position, getPosition()) : position;
    }

    /* renamed from: fromParentPosition-8S9VItk$default, reason: not valid java name */
    public static /* synthetic */ long m1526fromParentPosition8S9VItk$default(NodeCoordinator nodeCoordinator, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return nodeCoordinator.m1538fromParentPosition8S9VItk(j, z);
    }

    /* renamed from: fromParentPosition-8S9VItk, reason: not valid java name */
    public long m1538fromParentPosition8S9VItk(long position, boolean includeMotionFrameOfReference) {
        if (includeMotionFrameOfReference || !getIsPlacedUnderMotionFrameOfReference()) {
            position = IntOffsetKt.m2146minusNvtHpc(position, getPosition());
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo1556mapOffset8S9VItk(position, true) : position;
    }

    protected final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m2156getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m2155getHeightimpl(getMeasuredSize()) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long jM1540getMinimumTouchTargetSizeNHjbRc = m1540getMinimumTouchTargetSizeNHjbRc();
                    float fM878getWidthimpl = Size.m878getWidthimpl(jM1540getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM876getHeightimpl = Size.m876getHeightimpl(jM1540getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-fM878getWidthimpl, -fM876getHeightimpl, IntSize.m2156getWidthimpl(mo1422getSizeYbymL2g()) + fM878getWidthimpl, IntSize.m2155getHeightimpl(mo1422getSizeYbymL2g()) + fM876getHeightimpl);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m2156getWidthimpl(mo1422getSizeYbymL2g()), IntSize.m2155getHeightimpl(mo1422getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float fM2138getXimpl = IntOffset.m2138getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + fM2138getXimpl);
        bounds.setRight(bounds.getRight() + fM2138getXimpl);
        float fM2139getYimpl = IntOffset.m2139getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + fM2139getYimpl);
        bounds.setBottom(bounds.getBottom() + fM2139getYimpl);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float fM2138getXimpl = IntOffset.m2138getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - fM2138getXimpl);
        bounds.setRight(bounds.getRight() - fM2138getXimpl);
        float fM2139getYimpl = IntOffset.m2139getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - fM2139getYimpl);
        bounds.setBottom(bounds.getBottom() - fM2139getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m2156getWidthimpl(mo1422getSizeYbymL2g()), IntSize.m2155getHeightimpl(mo1422getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m1547withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m855isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo1555isInLayerk4lQ0M(pointerPosition);
    }

    /* renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m1543isPointerInBoundsk4lQ0M(long pointerPosition) {
        float fM842getXimpl = Offset.m842getXimpl(pointerPosition);
        float fM843getYimpl = Offset.m843getYimpl(pointerPosition);
        return fM842getXimpl >= 0.0f && fM843getYimpl >= 0.0f && fM842getXimpl < ((float) getMeasuredWidth()) && fM843getYimpl < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        LayoutNode layoutNode = other.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            int iM1552constructorimpl = NodeKind.m1552constructorimpl(2);
            if (!tail2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent = tail2.getNode().getParent(); parent != null; parent = parent.getParent()) {
                if ((parent.getKindSet() & iM1552constructorimpl) != 0 && parent == tail) {
                    return other;
                }
            }
            return this;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return layoutNode2 == getLayoutNode() ? this : layoutNode == other.getLayoutNode() ? other : layoutNode.getInnerCoordinator$ui_release();
    }

    /* renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m1530offsetFromEdgeMKHz9U(long pointerPosition) {
        float fM842getXimpl = Offset.m842getXimpl(pointerPosition);
        float fMax = Math.max(0.0f, fM842getXimpl < 0.0f ? -fM842getXimpl : fM842getXimpl - getMeasuredWidth());
        float fM843getYimpl = Offset.m843getYimpl(pointerPosition);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM843getYimpl < 0.0f ? -fM843getYimpl : fM843getYimpl - getMeasuredHeight()));
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m1536calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m878getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m876getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight()) / 2.0f));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m1537distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m878getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m876getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM1536calculateMinimumTouchTargetPaddingE7KxVPU = m1536calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float fM878getWidthimpl = Size.m878getWidthimpl(jM1536calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM876getHeightimpl = Size.m876getHeightimpl(jM1536calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM1530offsetFromEdgeMKHz9U = m1530offsetFromEdgeMKHz9U(pointerPosition);
        if ((fM878getWidthimpl > 0.0f || fM876getHeightimpl > 0.0f) && Offset.m842getXimpl(jM1530offsetFromEdgeMKHz9U) <= fM878getWidthimpl && Offset.m843getYimpl(jM1530offsetFromEdgeMKHz9U) <= fM876getHeightimpl) {
            return Offset.m841getDistanceSquaredimpl(jM1530offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}
