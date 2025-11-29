package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request error;
    private RequestCoordinator.RequestState errorState;
    private final RequestCoordinator parent;
    private volatile Request primary;
    private RequestCoordinator.RequestState primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.primary = request;
        this.error = request2;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.primaryState = requestState2;
                    this.primary.begin();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.primaryState = requestState;
                this.primary.clear();
                if (this.errorState != requestState) {
                    this.errorState = requestState;
                    this.error.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.primaryState = RequestCoordinator.RequestState.PAUSED;
                    this.primary.pause();
                }
                if (this.errorState == requestState2) {
                    this.errorState = RequestCoordinator.RequestState.PAUSED;
                    this.error.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                z = requestState == requestState2 || this.errorState == requestState2;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                z = requestState == requestState2 || this.errorState == requestState2;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z = requestState == requestState2 && this.errorState == requestState2;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        return this.primary.isEquivalentTo(errorRequestCoordinator.primary) && this.error.isEquivalentTo(errorRequestCoordinator.error);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = parentCanSetImage() && isValidRequest(request);
            } finally {
            }
        }
        return z;
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = parentCanNotifyStatusChanged() && isValidRequest(request);
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = parentCanNotifyCleared() && isValidRequest(request);
            } finally {
            }
        }
        return z;
    }

    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean isValidRequest(Request request) {
        return request.equals(this.primary) || (this.primaryState == RequestCoordinator.RequestState.FAILED && request.equals(this.error));
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = this.primary.isAnyResourceSet() || this.error.isAnyResourceSet();
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        synchronized (this.requestLock) {
            try {
                if (request.equals(this.primary)) {
                    this.primaryState = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.error)) {
                    this.errorState = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.parent;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestSuccess(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.requestLock) {
            try {
                if (!request.equals(this.error)) {
                    this.primaryState = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator.RequestState requestState = this.errorState;
                    RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState != requestState2) {
                        this.errorState = requestState2;
                        this.error.begin();
                    }
                    return;
                }
                this.errorState = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.parent;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestFailed(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator requestCoordinator = this.parent;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }
}
