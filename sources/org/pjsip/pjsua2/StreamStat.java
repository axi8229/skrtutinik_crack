package org.pjsip.pjsua2;

/* loaded from: classes4.dex */
public class StreamStat {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StreamStat(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StreamStat streamStat) {
        if (streamStat == null) {
            return 0L;
        }
        return streamStat.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    pjsua2JNI.delete_StreamStat(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRtcp(RtcpStat rtcpStat) {
        pjsua2JNI.StreamStat_rtcp_set(this.swigCPtr, this, RtcpStat.getCPtr(rtcpStat), rtcpStat);
    }

    public RtcpStat getRtcp() {
        long jStreamStat_rtcp_get = pjsua2JNI.StreamStat_rtcp_get(this.swigCPtr, this);
        if (jStreamStat_rtcp_get == 0) {
            return null;
        }
        return new RtcpStat(jStreamStat_rtcp_get, false);
    }

    public void setJbuf(JbufState jbufState) {
        pjsua2JNI.StreamStat_jbuf_set(this.swigCPtr, this, JbufState.getCPtr(jbufState), jbufState);
    }

    public JbufState getJbuf() {
        long jStreamStat_jbuf_get = pjsua2JNI.StreamStat_jbuf_get(this.swigCPtr, this);
        if (jStreamStat_jbuf_get == 0) {
            return null;
        }
        return new JbufState(jStreamStat_jbuf_get, false);
    }

    public StreamStat() {
        this(pjsua2JNI.new_StreamStat(), true);
    }
}
