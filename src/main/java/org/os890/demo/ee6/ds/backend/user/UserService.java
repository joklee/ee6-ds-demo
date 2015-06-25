/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.os890.demo.ee6.ds.backend.user;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.os890.demo.ee6.ds.domain.user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Transactional
public class UserService {
    @Inject
    private UserRepository userRepository;

    @Inject
    private SimpleUserCache userCache;

    public boolean isRegistered(String userName) {
        return this.userCache.get(userName) != null || this.userRepository.isRegistered(userName);
    }

    public User findUser(String userName) {
        User result = this.userCache.get(userName);

        if (result == null) {
            result = this.userRepository.findUser(userName);
            this.userCache.put(userName, result);
        }
        return result;
    }

    public User save(User user) {
        User result = this.userRepository.save(user);
        this.userCache.put(user.getUserName(), result);
        return result;
    }
}
