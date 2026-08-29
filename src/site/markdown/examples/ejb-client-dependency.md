---
title: Using the ejb-client as a dependency
author: 
  - Pete Marvin King
date: 2009-04-07
---

<!--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

# Using the ejb-client as a dependency

The EJB Plugin can generate the ejb-client JAR in addition to the primary EJB JAR.

To use the EJB client as a dependency, set the `type` to `ejb-client`.

## Add an EJB dependency

This dependency declaration includes the primary EJB artifact `ejb-project-1.0-SNAPSHOT.jar` in your project's package.

```xml
<project>
  [...]
  <dependencies>
    <dependency>
      <groupId>com.example</groupId>
      <artifactId>ejb-project</artifactId>
      <version>1.0-SNAPSHOT</version>
      <type>ejb</type>
    </dependency>
  </dependencies>
  [...]
</project>
```

## Use the EJB client

This dependency declaration includes the ejb-client artifact `ejb-project-1.0-SNAPSHOT-client.jar` in your project's package.

```xml
<project>
  [...]
  <dependencies>
    <dependency>
      <groupId>com.example</groupId>
      <artifactId>ejb-project</artifactId>
      <version>1.0-SNAPSHOT</version>
      <type>ejb-client</type>
    </dependency>
  </dependencies>
  [...]
</project>
```

You can read more in the [Generating the EJB client](./generating-ejb-client.html) example.