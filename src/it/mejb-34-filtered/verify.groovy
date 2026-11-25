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

import java.util.jar.*
import java.util.zip.ZipEntry

File file = new File(basedir, "target/mejb-34-filtered-1.0.jar")
System.out.println("Checking for existence of " + file)
assert file.isFile() : "FAILURE! Missing JAR file"

JarFile jarFile = new JarFile( file )

ZipEntry zipEntry = jarFile.getEntry( "META-INF/ejb-jar.xml" )
assert zipEntry != null : "FAILURE! Missing META-INF/ejb-jar.xml in the JAR file"

InputStream is = jarFile.getInputStream( zipEntry )
String contents = is.getText( 'UTF-8' )
int index = contents.indexOf( "myKey" )
assert index < 0 : "FAILURE! The key 'myKey' has not been replaced during filtering"
index = contents.indexOf( "myValue" )
assert index >= 0 : "FAILURE! The value 'myValue' has not been injected during filtering"
is.close()

jarFile.close()

return true
