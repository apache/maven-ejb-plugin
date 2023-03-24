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

import java.io.File;
import java.util.Collections;
import java.util.Properties;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.model.Model;
import org.apache.maven.model.Profile;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.PlexusTestCase;
import org.codehaus.plexus.util.FileUtils;

/**
 * Stub
 */
public class MavenProjectBasicStub extends MavenProject {
    protected String identifier;

    protected String testRootDir;

    protected Properties properties;

    protected String description;

    protected ModelStub model;

    protected File file;

    protected DefaultArtifact artifact;

    public MavenProjectBasicStub(String id) throws Exception {
        // most values are hardcoded to have a controlled environment
        super(new ModelStub());

        model = (ModelStub) super.getModel();
        properties = new Properties();
        identifier = id;

        artifact = new DefaultArtifact(getGroupId(), getArtifactId(), getVersion(), "compile", "jar", "", null);

        // set isolated root directory
        testRootDir = PlexusTestCase.getBasedir() + "/target/test-classes/unit/test-dir/" + identifier;

        if (!FileUtils.fileExists(testRootDir)) {
            FileUtils.mkdir(testRootDir);
        }

        // this is ugly but needed to ensure that the copy constructor
        // works correctly
        initializeParentFields();
    }

    public String getName() {
        return "Test Project " + identifier;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public Model getModel() {
        return model;
    }

    public String getDescription() {
        if (description == null) {
            return "this is a test project";
        } else {
            return description;
        }
    }

    public File getBasedir() {
        // create an isolated environment
        // see setupTestEnvironment for details
        return new File(testRootDir);
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public String getGroupId() {
        String groupId = getModel().getGroupId();
        if ((groupId == null) && (getModel().getParent() != null)) {
            groupId = getModel().getParent().getGroupId();
        }
        return groupId;
    }

    public String getArtifactId() {
        return getModel().getArtifactId();
    }

    public String getPackaging() {
        return "ejb";
    }

    public String getVersion() {
        return identifier;
    }

    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

    public Properties getProperties() {
        return properties;
    }

    // to prevent the MavenProject copy constructor from blowing up
    private void initializeParentFields() {
        // the pom should be located in the isolated dummy root
        super.setFile(new File(getBasedir(), "pom.xml"));
        super.setDependencyArtifacts(Collections.<Artifact>emptySet());
        super.setArtifacts(Collections.<Artifact>emptySet());
        super.setExtensionArtifacts(Collections.<Artifact>emptySet());
        super.setRemoteArtifactRepositories(Collections.<ArtifactRepository>emptyList());
        super.setPluginArtifactRepositories(Collections.<ArtifactRepository>emptyList());
        super.setCollectedProjects(Collections.<MavenProject>emptyList());
        super.setActiveProfiles(Collections.<Profile>emptyList());
        super.setOriginalModel(null);
        super.setExecutionProject(this);
        super.setArtifact(artifact);
    }
}
