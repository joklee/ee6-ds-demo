/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.os890.demo.ee6.ds.backend.test;

import javax.inject.Inject;

import junit.framework.Assert;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.os890.demo.ee6.ds.backend.user.UserService;
import org.os890.demo.ee6.ds.domain.user.User;

@RunWith(CdiTestRunner.class)
public class UserServiceTest {

    private @Inject UserService userService;


    @Test
    public void testUserService() {
        User nixda = userService.findUser("nixda");
        Assert.assertNull(nixda);

    }
}
