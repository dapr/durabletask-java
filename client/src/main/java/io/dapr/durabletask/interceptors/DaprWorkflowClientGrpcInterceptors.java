/*
 * Copyright 2024 The Dapr Authors
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

package io.dapr.durabletask.interceptors;

import io.grpc.stub.AbstractStub;
import io.opentelemetry.context.Context;

/**
 * Class to be used as part of your service's client stub interceptor.
 * Usage: myClientStub = DaprWorkflowClientGrpcInterceptors.intercept(myClientStub);
 */
public class DaprWorkflowClientGrpcInterceptors {


  /**
   * Instantiates a holder of all gRPC interceptors.
   */
  public DaprWorkflowClientGrpcInterceptors() {

  }



  /**
   * Adds all Dapr interceptors to a gRPC async stub.
   * @param client gRPC client
   * @param <T> async client type
   * @return async client instance with interceptors
   */
  public <T extends AbstractStub<T>> T intercept(final T client) {
    return intercept(client, null);
  }


  /**
   * Adds all Dapr interceptors to a gRPC async stub.
   * @param client gRPC client
   * @param context Reactor context for tracing
   * @param <T> async client type
   * @return async client instance with interceptors
   */
  public <T extends AbstractStub<T>> T intercept(
      final T client,
      final Context context) {
    if (client == null) {
      throw new IllegalArgumentException("client cannot be null");
    }

    return client.withInterceptors(
        new DaprWorkflowTracingInterceptor(context));
  }

}
