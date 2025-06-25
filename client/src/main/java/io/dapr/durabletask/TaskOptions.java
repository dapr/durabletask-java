// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.dapr.durabletask;

/**
 * Options that can be used to control the behavior of orchestrator and activity task execution.
 */
public final class TaskOptions {
    private final RetryPolicy retryPolicy;
    private final RetryHandler retryHandler;
    private final String appID;

    public TaskOptions(RetryPolicy retryPolicy, RetryHandler retryHandler, String appID) {
        this.retryPolicy = retryPolicy;
        this.retryHandler = retryHandler;
        this.appID = appID;
    }

    public TaskOptions(RetryPolicy retryPolicy, RetryHandler retryHandler) {
        this.retryPolicy = retryPolicy;
        this.retryHandler = retryHandler;
        this.appID = null;
    }

    /**
     * Creates a new {@code TaskOptions} object from a {@link RetryPolicy}.
     * @param retryPolicy the retry policy to use in the new {@code TaskOptions} object.
     */
    public TaskOptions(RetryPolicy retryPolicy) {
        this(retryPolicy, null, null);
    }

    /**
     * Creates a new {@code TaskOptions} object from a {@link RetryHandler}.
     * @param retryHandler the retry handler to use in the new {@code TaskOptions} object.
     */
    public TaskOptions(RetryHandler retryHandler) {
        this(null, retryHandler, null);
    }

    /**
     * Creates a new {@code TaskOptions} object with the specified app ID.
     * @param appID the app ID to use for cross-app workflow routing
     */
    public TaskOptions(String appID) {
        this(null, null, appID);
    }

    /**
     * Creates a new {@code TaskOptions} object with the specified retry policy and app ID.
     * @param retryPolicy the retry policy to use
     * @param appID the app ID to use for cross-app workflow routing
     */
    public TaskOptions(RetryPolicy retryPolicy, String appID) {
        this(retryPolicy, null, appID);
    }

    boolean hasRetryPolicy() {
        return this.retryPolicy != null;
    }

    /**
     * Gets the configured {@link RetryPolicy} value or {@code null} if none was configured.
     * @return the configured retry policy
     */
    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    boolean hasRetryHandler() {
        return this.retryHandler != null;
    }

    /**
     * Gets the configured {@link RetryHandler} value or {@code null} if none was configured.
     * @return the configured retry handler.
     */
    public RetryHandler getRetryHandler() {
        return this.retryHandler;
    }

    /**
     * Gets the configured app ID value or {@code null} if none was configured.
     * @return the configured app ID
     */
    public String getAppID() {
        return this.appID;
    }

    boolean hasAppID() {
        return this.appID != null && !this.appID.isEmpty();
    }
}
