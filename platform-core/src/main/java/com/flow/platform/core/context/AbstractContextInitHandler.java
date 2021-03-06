/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.core.context;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Log4j2
public abstract class AbstractContextInitHandler implements ApplicationListener<ContextRefreshedEvent> {

    public abstract SpringContext getSpringContext();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // init queue consumer
        for (String eventClassName : getSpringContext().getBeanNameByType(ContextEvent.class)) {
            ContextEvent eventClass = (ContextEvent) getSpringContext().getBean(eventClassName);
            eventClass.start();
            log.trace("{} started", eventClassName);
        }
    }
}