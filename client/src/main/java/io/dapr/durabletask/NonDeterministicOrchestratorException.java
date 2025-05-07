// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.dapr.durabletask;

final class NonDeterministicOrchestratorException extends RuntimeException {
    public NonDeterministicOrchestratorException(String message) {
        super(message);
    }
}
