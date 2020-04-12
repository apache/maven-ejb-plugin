package org.apache.maven.plugins.ejb;

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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.Test;

import com.google.inject.internal.util.Lists;

public class IncludesExcludesTest
{

    @Test
    public void emptyListsShouldResultInZeroSizeResults()
    {
        IncludesExcludes ie = new IncludesExcludes( Collections.<String>emptyList(), Collections.<String>emptyList(),
                                                    Collections.<String>emptyList(), Collections.<String>emptyList() );

        assertThat( ie.resultingIncludes() ).isEqualTo( new String[0] );
        assertThat( ie.resultingExcludes() ).isEqualTo( new String[0] );
    }

    @Test
    public void nullForIncludesShouldResultInZeroSizeResults()
    {
        IncludesExcludes ie = new IncludesExcludes( null, Collections.<String>emptyList(),
                                                    Collections.<String>emptyList(), Collections.<String>emptyList() );

        assertThat( ie.resultingIncludes() ).isEqualTo( new String[0] );
        assertThat( ie.resultingExcludes() ).isEqualTo( new String[0] );
    }

    @Test
    public void nullForExcludesShouldResultInZeroSizeResults()
    {
        IncludesExcludes ie = new IncludesExcludes( Collections.<String>emptyList(), null,
                                                    Collections.<String>emptyList(), Collections.<String>emptyList() );

        assertThat( ie.resultingIncludes() ).isEqualTo( new String[0] );
        assertThat( ie.resultingExcludes() ).isEqualTo( new String[0] );
    }

    @Test
    public void nonNullForDefaultExcludesShouldResultInExcludesWithDefaultExcludes()
    {
        IncludesExcludes ie = new IncludesExcludes( null, null, Collections.<String>emptyList(),
                                                    Lists.newArrayList( "**/package.html" ) );

        assertThat( ie.resultingIncludes() ).isEqualTo( new String[0] );
        assertThat( ie.resultingExcludes() ).isEqualTo( new String[] { "**/package.html" } );
    }

    @Test
    public void nonNullForDefaultIncludesShouldResultInIncludesWithDefaultIncludes()
    {
        IncludesExcludes ie = new IncludesExcludes( null, null, Lists.newArrayList( "**/package.html" ),
                                                    Collections.<String>emptyList() );

        assertThat( ie.resultingIncludes() ).isEqualTo( new String[] { "**/package.html" } );
        assertThat( ie.resultingExcludes() ).isEqualTo( new String[0] );
    }

}
