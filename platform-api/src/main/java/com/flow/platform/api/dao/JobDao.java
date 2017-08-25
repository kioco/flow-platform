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

package com.flow.platform.api.dao;

import com.flow.platform.api.domain.job.Job;
import com.flow.platform.api.domain.node.NodeStatus;
import com.flow.platform.core.dao.BaseDao;
import java.math.BigInteger;
import java.util.List;

/**
 * @author yh@firim
 */
public interface JobDao extends BaseDao<BigInteger, Job> {

    List<Job> list(List<String> sessionId, NodeStatus nodeStatus);

    /**
     * get latest job by flow path
     *
     * @return List<Job>
     */
    List<Job> listLatest(List<String> nodePaths);

    /**
     * get jobs from nodeName
     */
    List<Job> list(String nodeName);

    /**
     * get job from node name and number
     */
    Job get(String flowName, Integer number);

    /**
     * get max number
     */
    Integer maxBuildNumber(String flowName);

}
