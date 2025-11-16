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

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IncludesExcludesTest {

    @Test
    public void emptyListsShouldResultInZeroSizeResults() {
        IncludesExcludes ie = new IncludesExcludes(
                Collections.emptyList(), Collections.<String>emptyList(),
                Collections.emptyList(), Collections.<String>emptyList());

        assertArrayEquals(new String[0], ie.resultingIncludes());
        assertArrayEquals(new String[0], ie.resultingExcludes());
    }

    @Test
    public void nullForIncludesShouldResultInZeroSizeResults() {
        IncludesExcludes ie = new IncludesExcludes(
                null,
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList());

        assertArrayEquals(new String[0], ie.resultingIncludes());
        assertArrayEquals(new String[0], ie.resultingExcludes());
    }

    @Test
    public void nullForExcludesShouldResultInZeroSizeResults() {
        IncludesExcludes ie = new IncludesExcludes(
                Collections.emptyList(),
                null,
                Collections.emptyList(),
                Collections.emptyList());

        assertArrayEquals(new String[0], ie.resultingIncludes());
        assertArrayEquals(new String[0], ie.resultingExcludes());
    }

    @Test
    public void nonNullForDefaultExcludesShouldResultInExcludesWithDefaultExcludes() {
        IncludesExcludes ie =
                new IncludesExcludes(null, null, Collections.emptyList(), Arrays.asList("**/package.html"));

        assertArrayEquals(new String[0], ie.resultingIncludes());
        assertArrayEquals(new String[] {"**/package.html"}, ie.resultingExcludes());
    }

    @Test
    public void nonNullForDefaultIncludesShouldResultInIncludesWithDefaultIncludes() {
        IncludesExcludes ie =
                new IncludesExcludes(null, null, Arrays.asList("**/package.html"), Collections.emptyList());

        assertArrayEquals(new String[] {"**/package.html"}, ie.resultingIncludes());
        assertArrayEquals(new String[0], ie.resultingExcludes());
    }

    @Test
    public void nonNullIncludesShouldResultInTheSameIncludes() {
        IncludesExcludes ie = new IncludesExcludes(
                Arrays.asList("**/package.html"), null,
                Arrays.asList("**/site.html"), null);

        assertArrayEquals(new String[] {"**/package.html"}, ie.resultingIncludes());
    }

    @Test
    public void nonNullExcludesShouldResultInTheSameExcludes() {
        IncludesExcludes ie = new IncludesExcludes(
                null, Arrays.asList("**/package.html"),
                null, Arrays.asList("**/site.html"));

        assertArrayEquals(new String[] {"**/package.html"}, ie.resultingExcludes());
    }
}
