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
package org.apache.maven.plugins.ejb;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:khmarbaise@apache.org">Karl Heinz Marbaise</a>
 */
public class IncludesExcludes {
    private List<String> includes;

    private List<String> defaultIncludes;

    private List<String> excludes;

    private List<String> defaultExcludes;

    public IncludesExcludes(
            List<String> includes, List<String> excludes, List<String> defaultIncludes, List<String> defaultExcludes) {
        this.includes = makeNonNullList(includes);
        this.excludes = makeNonNullList(excludes);
        this.defaultIncludes = makeNonNullList(defaultIncludes);
        this.defaultExcludes = makeNonNullList(defaultExcludes);
    }

    public String[] resultingIncludes() {
        return resultingXcludes(includes, defaultIncludes);
    }

    public String[] resultingExcludes() {
        return resultingXcludes(excludes, defaultExcludes);
    }

    private static String[] resultingXcludes(List<String> currentXcludes, List<String> defaultXcludes) {
        if (currentXcludes.isEmpty()) {
            return defaultXcludes.toArray(new String[0]);
        } else {
            return currentXcludes.toArray(new String[0]);
        }
    }

    private List<String> makeNonNullList(List<String> in) {
        if (in == null) {
            return Collections.<String>emptyList();
        } else {
            return in;
        }
    }
}
