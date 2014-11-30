/*
 * Copyright 2014 Dream.Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hummer.api.event;

import io.netty.channel.Channel;

import org.hummer.api.RpcRequest;

import com.lmax.disruptor.EventFactory;

public class RequestEvent {

	private RpcRequest request;
	private Channel channel;

	public RpcRequest getRequest() {
		return request;
	}

	public void setRequest(RpcRequest request) {
		this.request = request;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public static final EventFactory<RequestEvent> EVENT_FACTORY = new EventFactory<RequestEvent>() {
		public RequestEvent newInstance() {
			return new RequestEvent();
		}
	};

}
