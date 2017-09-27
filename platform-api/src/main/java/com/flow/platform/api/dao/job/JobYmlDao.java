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
package com.flow.platform.api.dao.job;

import com.flow.platform.api.domain.job.JobYml;
import com.flow.platform.core.dao.BaseDao;
import java.math.BigInteger;
import java.util.List;

/**
 * @author lhl
 */
public interface JobYmlDao extends BaseDao<BigInteger, JobYml> {

    /**
     * delete jobYml by jobIds
     *
     * @param jobIds jobIds
     */
    void deleteList(List<BigInteger> jobIds);

}
