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
package org.hummer.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class WatcherAdapter implements Watcher{

	private ConfigWatcher innerWatcher;
	
	public WatcherAdapter(ConfigWatcher innerWatcher) {
		this.innerWatcher = innerWatcher;
	}


	public void process(WatchedEvent event) {
		WatchEvent evt=new WatchEvent();
		evt.setState(event.getState().getIntValue());
		evt.setType(event.getType().getIntValue());
		evt.setArg(event.getPath());
		innerWatcher.onEvent(evt);
	}

}
