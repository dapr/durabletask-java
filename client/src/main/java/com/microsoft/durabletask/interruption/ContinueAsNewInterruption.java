package io.dapr.durabletask.interruption;

import io.dapr.durabletask.TaskOrchestrationContext;

/**
 * Control flow {@code Throwable} class for orchestrator when invoke {@link TaskOrchestrationContext#continueAsNew}.
 * This {@code Throwable} must never be caught by user
 * code.
 * <p>
 * {@code ContinueAsNewInterruption} is thrown when an orchestrator calls {@link TaskOrchestrationContext#continueAsNew}.
 * Catching {@code ContinueAsNewInterruption} in user code could prevent the orchestration from saving
 * state and scheduling new tasks, resulting in the orchestration getting stuck.
 */
public class ContinueAsNewInterruption extends RuntimeException {
    public ContinueAsNewInterruption(String message) {
        super(message);
    }
}
