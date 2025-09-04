// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.dapr.durabletask;

/**
 * Interface that provides {@link TaskActivity} implementations with activity context, such as an activity's name and
 * its input.
 */
public interface TaskActivityContext {
    /**
     * Gets the name of the current task activity.
     * @return the name of the current task activity
     */
    String getName();

    /**
     * Gets the deserialized activity input.
     *
     * @param targetType the {@link Class} object associated with {@code T}
     * @param <T> the target type to deserialize the input into
     * @return the deserialized activity input value
     */
    <T> T getInput(Class<T> targetType);


    /**
     * Gets the execution id of the current task activity.
     * @return the execution id of the current task activity
     */
    String getTaskExecutionId();

    /**
     * Gets the task id of the current task activity.
     * @return the task id of the current task activity
     */
    int getTaskId();

    /**
     * Get the task parent trace id for Otel trace propagation.
     * @return the task parent traceId
     *
     */
    String getParentTraceId();
}
