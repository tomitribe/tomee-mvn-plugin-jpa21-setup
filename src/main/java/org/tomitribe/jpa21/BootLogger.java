/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.tomitribe.jpa21;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Singleton
@Startup
public class BootLogger {
    private static final Logger LOGGER = Logger.getLogger(BootLogger.class.getName());

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void log() {
        final EntityManager hibernateEm = em.unwrap(EntityManager.class);
        LOGGER.info("Unwrapped EM = " + hibernateEm); // FULL JPA 2.1 API
        LOGGER.info("Wrapped EM = " + em); // JPA 2.0 API supporting nested JPA 2.1 (ie things not needing this direct API to be JPA 2.1)
    }
}
