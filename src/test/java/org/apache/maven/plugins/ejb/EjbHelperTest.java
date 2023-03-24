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

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class EjbHelperTest {

    @Test
    public void validClassifier() {
        Assert.assertTrue(EjbHelper.isClassifierValid("anton"));
    }

    @Test
    public void anOtherValidClassifier() {
        Assert.assertTrue(EjbHelper.isClassifierValid("jdk15"));
    }

    @Test
    public void moreValidClassifier() {
        Assert.assertTrue(EjbHelper.isClassifierValid("client-classifier"));
    }

    @Test
    public void isClassifierValidShouldReturnFalseIfClassifierIsPrefixedByDash() {
        Assert.assertFalse(EjbHelper.isClassifierValid("-anton"));
    }

    @Test
    public void isClassifierValidShouldReturnFalseIfClassifierIsNull() {
        Assert.assertFalse(EjbHelper.isClassifierValid(null));
    }

    @Test
    public void hasClassifierShouldReturnFalseForNull() {
        Assert.assertFalse(EjbHelper.hasClassifier(null));
    }

    @Test
    public void hasClassifierShouldReturnFalseForEmptyString() {
        Assert.assertFalse(EjbHelper.hasClassifier(""));
    }

    @Test
    public void hasClassifierShouldReturnTrueForNonEmptyString() {
        Assert.assertTrue(EjbHelper.hasClassifier("x"));
    }

    @Test
    public void getJarFileNameShouldReturnFileNameWithoutClassifier() {
        Assert.assertEquals(EjbHelper.getJarFile(new File("base"), "test", null), new File("base/test.jar"));
    }

    @Test
    public void getJarFileNameShouldReturnFileNameWithClassifier() {
        Assert.assertEquals(EjbHelper.getJarFile(new File("base"), "test", "alpha"), new File("base/test-alpha.jar"));
    }
}
