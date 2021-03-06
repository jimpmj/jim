/*
 * Copyright 2014 Jim. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */package com.jim.im.group;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.jim.im.group.config.GroupAopConfig;
import com.jim.im.group.config.GroupDBConfig;
import com.jim.im.group.config.GroupJerseyConfig;
import com.jim.im.group.config.GroupRpcConfig;


/**
 * @version 1.0.0
 * @date 2016年3月29日
 */
@Configurable
@Import({
    PropertyPlaceholderAutoConfiguration.class,
    ServerPropertiesAutoConfiguration.class,
    EmbeddedServletContainerAutoConfiguration.class,
    JerseyAutoConfiguration.class,
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    JmsAutoConfiguration.class,
    AopAutoConfiguration.class,
    
    GroupDBConfig.class,
    GroupJerseyConfig.class,
    GroupRpcConfig.class,
    GroupAopConfig.class
})

@ComponentScan( basePackages = "com.jim.im" )
public class GroupManagerServer {

    public GroupManagerServer() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GroupManagerServer.class, args);
    }

}
