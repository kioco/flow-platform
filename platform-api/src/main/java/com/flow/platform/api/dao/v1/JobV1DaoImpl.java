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

package com.flow.platform.api.dao.v1;

import com.flow.platform.api.domain.job.JobKeyV1;
import com.flow.platform.api.domain.job.JobV1;
import com.flow.platform.core.dao.AbstractBaseDao;
import com.flow.platform.core.domain.Pageable;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 */
@Repository(value = "jobV1Dao")
public class JobV1DaoImpl extends AbstractBaseDao<JobKeyV1, JobV1> implements JobV1Dao {

    private final static String DEFAULT_SELECT_COLUMN =
        "select key, category, status, createdAt, updatedAt, createdBy";

    @Override
    protected Class<JobV1> getEntityClass() {
        return JobV1.class;
    }

    @Override
    protected String getKeyName() {
        return "key";
    }

    @Override
    public List<JobV1> listLatestByFlows(Collection<String> flows) {
        return null;
    }

    @Override
    public List<JobV1> listByFlow(String flow, Pageable pageable) {
        return execute(session -> session
            .createQuery(DEFAULT_SELECT_COLUMN + " from JobV1 where key.flow = :flow", JobV1.class)
            .setParameter("flow", flow)
            .list());
    }

    @Override
    public void deleteByFlow(String flow) {

    }
}
