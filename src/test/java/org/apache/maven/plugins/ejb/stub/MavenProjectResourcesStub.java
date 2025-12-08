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
package org.apache.maven.plugins.ejb.stub;

import org.apache.maven.model.Resource;

/**
 * Stub
 */
public class MavenProjectResourcesStub extends MavenProjectBuildStub {

    public MavenProjectResourcesStub(String id) throws Exception {
        super(id);
        setupResources();
        setupTestResources();
    }

    private void setupResources() {
        Resource resource = new Resource();

        // see MavenProjectBasicStub for details
        // of getBasedir

        // setup default resources
        resource.setDirectory(getBasedir().getPath() + "/src/main/resources");
        resource.setFiltering(false);
        resource.setTargetPath(null);
        build.addResource(resource);
    }

    private void setupTestResources() {
        Resource resource = new Resource();

        // see MavenProjectBasicStub for details
        // of getBasedir

        // setup default test resources
        resource.setDirectory(getBasedir().getPath() + "/src/test/resources");
        resource.setFiltering(false);
        resource.setTargetPath(null);
        build.addTestResource(resource);
    }
}
