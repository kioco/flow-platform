/*
 * Copyright 2018 fir.im
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

package com.flow.platform.api.service.v1;

import com.flow.platform.api.domain.v1.JobKey;
import com.flow.platform.domain.v1.Cmd;
import com.flow.platform.tree.Node;
import java.util.Base64;
import org.springframework.stereotype.Component;

/**
 * @author yang
 */
@Component
public class CmdManagerImpl implements CmdManager {

    private final static String CMD_ID_SPLITTER = "@";

    @Override
    public String getId(JobKey key, Node node) {
        String source = key.getId() + CMD_ID_SPLITTER + node.getPath().toString();
        return Base64.getEncoder().encodeToString(source.getBytes());
    }

    @Override
    public Cmd create(JobKey key, Node node, String token) {
        // trans node to cmd
        Cmd cmd = new Cmd();
        cmd.setId(getId(key, node));
        cmd.setTimeout(1800);
        cmd.setContent(node.getContent());
        cmd.setWorkDir("/tmp");

        // set meta data
        cmd.getMeta().put(META_JOB_KEY, key.getId());
        cmd.getMeta().put(META_JOB_NODE_PATH, node.getPath().toString());
        cmd.getMeta().put(META_AGENT_TOKEN, token);

        return cmd;
    }
}