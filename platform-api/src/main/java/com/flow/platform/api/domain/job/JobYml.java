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

package com.flow.platform.api.domain.job;

import java.math.BigInteger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yh@firim
 */
@EqualsAndHashCode(of = {"jobId"})
public class JobYml {

    @Getter
    @Setter
    private BigInteger jobId;

    @Getter
    @Setter
    private String file;

    @Getter
    @Setter
    private String createdBy;

    public JobYml(BigInteger jobId, String file) {
        this.jobId = jobId;
        this.file = file;
    }

    public JobYml() {
    }
}
