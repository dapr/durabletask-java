/*
 * Copyright 2025 The Dapr Authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
limitations under the License.
*/

package io.dapr.durabletask;

import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TaskOptions with cross-app workflow support.
 */
public class TaskOptionsTest {

    @Test
    void taskOptionsWithAppID() {
        TaskOptions options = new TaskOptions("app1");
        
        assertTrue(options.hasAppID());
        assertEquals("app1", options.getAppID());
        assertFalse(options.hasRetryPolicy());
        assertFalse(options.hasRetryHandler());
    }

    @Test
    void taskOptionsWithRetryPolicyAndAppID() {
        RetryPolicy retryPolicy = new RetryPolicy(3, Duration.ofSeconds(1));
        TaskOptions options = new TaskOptions(retryPolicy, null, "app2");
        
        assertTrue(options.hasAppID());
        assertEquals("app2", options.getAppID());
        assertTrue(options.hasRetryPolicy());
        assertEquals(retryPolicy, options.getRetryPolicy());
        assertFalse(options.hasRetryHandler());
    }

    @Test
    void taskOptionsWithRetryHandlerAndAppID() {
        RetryHandler retryHandler = new RetryHandler() {
            @Override
            public boolean handle(RetryContext context) {
                return context.getLastAttemptNumber() < 2;
            }
        };
        TaskOptions options = new TaskOptions(null, retryHandler, "app3");
        
        assertTrue(options.hasAppID());
        assertEquals("app3", options.getAppID());
        assertFalse(options.hasRetryPolicy());
        assertTrue(options.hasRetryHandler());
        assertEquals(retryHandler, options.getRetryHandler());
    }

    @Test
    void taskOptionsWithoutAppID() {
        TaskOptions options = new TaskOptions(null, null, null);
        
        assertFalse(options.hasAppID());
        assertNull(options.getAppID());
    }

    @Test
    void taskOptionsWithEmptyAppID() {
        TaskOptions options = new TaskOptions("");
        
        assertFalse(options.hasAppID());
        assertEquals("", options.getAppID());
    }

    @Test
    void taskOptionsWithNullAppID() {
        TaskOptions options = new TaskOptions(null, null, null);
        
        assertFalse(options.hasAppID());
        assertNull(options.getAppID());
    }
} 