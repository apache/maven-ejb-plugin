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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EjbHelperTest {

    @Test
    void validClassifier() {
        assertTrue(EjbHelper.isClassifierValid("anton"));
    }

    @Test
    void anOtherValidClassifier() {
        assertTrue(EjbHelper.isClassifierValid("jdk15"));
    }

    @Test
    void moreValidClassifier() {
        assertTrue(EjbHelper.isClassifierValid("client-classifier"));
    }

    @Test
    void isClassifierValidShouldReturnFalseIfClassifierIsPrefixedByDash() {
        assertFalse(EjbHelper.isClassifierValid("-anton"));
    }

    @Test
    void isClassifierValidShouldReturnFalseIfClassifierIsNull() {
        assertFalse(EjbHelper.isClassifierValid(null));
    }

    @Test
    void hasClassifierShouldReturnFalseForNull() {
        assertFalse(EjbHelper.hasClassifier(null));
    }

    @Test
    void hasClassifierShouldReturnFalseForEmptyString() {
        assertFalse(EjbHelper.hasClassifier(""));
    }

    @Test
    void hasClassifierShouldReturnTrueForNonEmptyString() {
        assertTrue(EjbHelper.hasClassifier("x"));
    }

    @Test
    void getJarFileNameShouldReturnFileNameWithoutClassifier() {
        assertEquals(EjbHelper.getJarFile(new File("base"), "test", null), new File("base/test.jar"));
    }

    @Test
    void getJarFileNameShouldReturnFileNameWithClassifier() {
        assertEquals(EjbHelper.getJarFile(new File("base"), "test", "alpha"), new File("base/test-alpha.jar"));
    }
}
